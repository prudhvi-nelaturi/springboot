package com.javaTest.springboot_sample.controller;



import com.javaTest.springboot_sample.dto.customerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public long createCustomer(@RequestBody customerDTO customerDto){
        if(customerDto.getCustomer_address() == null){
            customerDto.setCustomer_address("defaultAddress");
        }
        if(customerDto.getOther_customer_data() == null){
            customerDto.setOther_customer_data("defaultOther_Cust_data");
        }
//        if(customerDto.getName() == null){
//            throw new RuntimeException("Please enter Name");
//        }
        return customerService.createCustomer(customerDto);
    }



}
