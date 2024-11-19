package com.javaTest.springboot_sample.controller;



import com.javaTest.springboot_sample.dto.customerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.javaTest.springboot_sample.service.customerService;

@RestController
@RequestMapping("api/v1/customers")
public class sampleController {

    @Autowired
    private customerService customerService;


    @GetMapping("/welcome")
    public String welcome(){
        return "Hello, welcome to the spring app";
    }

    @PostMapping
    public customerDTO createCustomer(@RequestBody customerDTO customerDto){
        return customerService.createCustomer(customerDto);
    }



}
