package com.camera.of.city.mvc.service;

import com.camera.of.city.mvc.dao.impl.PhotoDAO;
import com.camera.of.city.mvc.domain.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static org.apache.commons.io.FileUtils.getFile;

@Service
public class ServicePhoto {

    @Autowired
    private PhotoDAO photoDAO;

    public HttpServletResponse getPhoto(HttpServletResponse response,Long idDevice)  {
        String  application_format;
        Photo photo = photoDAO.searchPhoto(idDevice.toString()).get(0);
        String url = photo.getUrl();

        File file = getFile(photo.getUrl());
        InputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        application_format = url.substring(url.lastIndexOf(".")+1);

        response.setContentType("image/"+application_format);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        try {
            FileCopyUtils.copy(in, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
