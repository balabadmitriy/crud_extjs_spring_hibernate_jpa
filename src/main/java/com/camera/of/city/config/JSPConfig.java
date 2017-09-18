package com.camera.of.city.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class JSPConfig {

    @Bean
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver view = new InternalResourceViewResolver();
        view.setPrefix("/WEB-INF/pages/");
        view.setSuffix(".jsp");
        return view;
    }

}
