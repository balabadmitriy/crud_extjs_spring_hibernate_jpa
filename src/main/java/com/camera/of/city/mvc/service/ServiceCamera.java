package com.camera.of.city.mvc.service;

import com.camera.of.city.mvc.dao.AbstractDAO;
import com.camera.of.city.mvc.dao.impl.CameraDAO;
import com.camera.of.city.mvc.dao.impl.PhotoDAO;
import com.camera.of.city.mvc.domain.Address;
import com.camera.of.city.mvc.domain.Camera;
import com.camera.of.city.mvc.domain.Photo;
import com.camera.of.city.mvc.exception.PhotoDontSendException;
import org.apache.commons.io.IOUtils;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ServiceCamera {

    @Autowired
    private CameraDAO cameraDAO;

    @Autowired
    private PhotoDAO photoDAO;

    @Autowired
    private AbstractDAO<Address> addressDAO;

    // Путь прописан на сервере в Tomcat
    @Resource(mappedName = "fileStorage/basePath")
    private String path;

    public boolean insert(HttpServletRequest request) throws IOException {
//        Camera camera = Converting.convertCameraDtoToCamera(new CameraDTO());
        byte[] img = getBytesImg(request);
        String idDevice = request.getHeader("Device-ID");
        Camera cam = cameraDAO.getIdDevice(Long.parseLong(idDevice));
        if (cam != null) {
            boolean flag = img(img,cam);
            if (flag)
                return true;
            return false;
        }else return false;

    }

    private byte[] getBytesImg(HttpServletRequest request) {
        byte[] result;
        try {

            result = IOUtils.toByteArray(request.getInputStream());
        } catch (IOException e) {
            throw new PhotoDontSendException("Фото не было передано с камер");
        }
        return result;
    }

    private boolean img(byte[] arr, Camera camera) {
        String tikaExt  =  new Tika().detect(arr);
        String extension = ".".concat(tikaExt.substring(tikaExt.lastIndexOf("/")+1));
        String separator = determineSeparator();
        String filePath = path.concat(separator).concat(String.valueOf(camera.getIdDevice()))
                .concat(extension);
        Photo photo = new Photo();
        photo.setUrl(filePath);

        photo.setCamera(camera);
       if (!photoDAO.update(photo)) {
           photoDAO.save(photo);
       }

        try ( FileOutputStream fis = new FileOutputStream(filePath)){
            fis.write(arr);
            fis.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String  determineSeparator() {
        String oc = System.getProperty("os.name").toLowerCase();
        if (oc.equals("win"))
            return "\\";
        else
            return "/";
    }
}
