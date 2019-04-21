package com.sarahhospital.patientservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthCheck {

    @ResponseBody
    @GetMapping("/health")
    public String health(){
        return "alive";
    }

}
