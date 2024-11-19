package com.javaTest.springboot_sample.service.impl;


import com.javaTest.springboot_sample.dto.customerDTO;
import com.javaTest.springboot_sample.entity.customer;
import com.javaTest.springboot_sample.service.customerService;
import com.javaTest.springboot_sample.repository.customerRepository;
import com.javaTest.springboot_sample.mapper.customerMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerServiceImpl implements customerService {

    @Autowired
    private customerRepository customerRepository;

    @Autowired
    private customerMapper customerMapper;

    @Override
    public customerDTO createCustomer(customerDTO customerDTO){
        customer customer = customerMapper.toEntity(customerDTO);
        return customerMapper.toDto(customerRepository.save(customer));

    }
}
