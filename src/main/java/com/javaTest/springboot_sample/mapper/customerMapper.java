package com.javaTest.springboot_sample.mapper;

import org.springframework.stereotype.Component;
import com.javaTest.springboot_sample.dto.customerDTO;
import com.javaTest.springboot_sample.entity.customer;


@Component
public class customerMapper {

    public customerDTO toDto(customer customer){
        customerDTO dto = new customerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setIndustry(customer.getIndustry());
        dto.setCompany_size(customer.getCompany_size());
        dto.setCustomer_email(customer.getCustomer_email());
        dto.setCustomer_phone_number(customer.getCustomer_phone_number());
        dto.setCustomer_address(customer.getCustomer_address());
        dto.setOther_customer_data(customer.getOther_customer_data());

        return dto;
    }

    public customer toEntity(customerDTO dto){
        customer cust = new customer();

        cust.setId(dto.getId());
        cust.setName(dto.getName());
        cust.setIndustry(dto.getIndustry());
        cust.setCompany_size(dto.getCompany_size());
        cust.setCustomer_email(dto.getCustomer_email());
        cust.setCustomer_phone_number(dto.getCustomer_phone_number());
        cust.setCustomer_address(dto.getCustomer_address());
        cust.setOther_customer_data(dto.getOther_customer_data());

        return cust;
    }
}
