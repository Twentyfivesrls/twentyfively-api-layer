package com.twentyfive.twentyfivelyapilayer.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class TestController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
