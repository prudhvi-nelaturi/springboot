package com.javaTest.springboot_sample.dto;

import lombok.Data;

@Data
public class customerDTO {

    private long id;

    private String name;


    private String industry;
    private int company_size;
    private String customer_email;
    private int customer_phone_number;
    private String customer_address;
    private String other_customer_data;

}
