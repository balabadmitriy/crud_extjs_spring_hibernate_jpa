package com.camera.of.city.mvc.controller;


import com.camera.of.city.mvc.service.ServiceCamera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class CameraController {

    @Autowired
    private ServiceCamera serviceCamera;

    @RequestMapping(name = "/add",method = RequestMethod.POST)
    public @ResponseBody
    String  add(HttpServletRequest request) {
        try {
            serviceCamera.insert(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "DataBases data changed";
    }


}
