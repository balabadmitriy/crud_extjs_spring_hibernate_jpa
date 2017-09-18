package com.camera.of.city.mvc.controller;

import com.camera.of.city.mvc.service.ServicePhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/photo/*")
public class PhotoController {

    @Autowired
    private ServicePhoto servicePhoto;

    @RequestMapping(name = "/get",method = RequestMethod.GET)
    public @ResponseBody
    void get(@RequestParam Long idDevice, HttpServletResponse response){
        servicePhoto.getPhoto(response,idDevice);
    }

}
