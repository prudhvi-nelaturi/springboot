package com.javaTest.springboot_sample.controller;



import com.javaTest.springboot_sample.dto.customerDTO;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.javaTest.springboot_sample.service.customerService;

@RestController
@RequestMapping("api/v1/customers")
public class sampleController {

    @Autowired
    private customerService customerService;


    @GetMapping("/welcome")
    @ResponseStatus(HttpStatus.OK)
    public String welcome(){
        return ("Hello, welcome to the spring app");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long createCustomer(@RequestBody customerDTO customerDto){
        if(customerDto.getCustomer_address() == null){
            customerDto.setCustomer_address("defaultAddress");
        }
        if(customerDto.getOther_customer_data() == null){
            customerDto.setOther_customer_data("defaultOther_Cust_data");
        }

        if(customerDto.getName() == null || customerDto.getName().isEmpty()){
            throw new InvalidRequestStateException("The name is either not entered or empty string");
        }
        if(customerDto.getIndustry() == null || customerDto.getIndustry().isEmpty()){
            throw new InvalidRequestStateException("Please enter the Industry.");
        }
        if(customerDto.getCompany_size() <= 0){
            throw new InvalidRequestStateException("Company size is either less than 0 or not given");
        }
        if(customerDto.getCustomer_address() == null || customerDto.getCustomer_address().isEmpty()){
            throw new InvalidRequestStateException("Please enter the address.");
        }
        if(customerDto.getCustomer_phone_number() == null || customerDto.getCustomer_phone_number().isEmpty()){
            throw new InvalidRequestStateException("Please enter the phone number.");
        }
//        if (customerService.isEmailExists(customerDto.getCustomer_email())) {
//            throw new InvalidRequestStateException("The email ID already exists in the database.");
//        }
        return customerService.createCustomer(customerDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<customerDTO> updateCustomer(@PathVariable long id, @RequestBody customerDTO customerDTO){
        return ResponseEntity.ok(customerService.updateCustomer(id, customerDTO));

    }




}
