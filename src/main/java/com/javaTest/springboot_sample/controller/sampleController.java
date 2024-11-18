package com.javaTest.springboot_sample.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Hello, welcome to the spring app";
    }

}
