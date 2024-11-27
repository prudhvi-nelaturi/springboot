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
        dto.setStatus(customer.getStatus());

        return dto;
    }

    public customer toEntity(customerDTO dto){
        customer customer = new customer();

        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setIndustry(dto.getIndustry());
        customer.setCompany_size(dto.getCompany_size());
        customer.setCustomer_email(dto.getCustomer_email());
        customer.setCustomer_phone_number(dto.getCustomer_phone_number());
        customer.setCustomer_address(dto.getCustomer_address());
        customer.setOther_customer_data(dto.getOther_customer_data());
        customer.setStatus(dto.getStatus());

        return customer;
    }
}
