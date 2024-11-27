package com.javaTest.springboot_sample.service;

import com.javaTest.springboot_sample.dto.customerDTO;

import java.util.Map;

public interface customerService {

    long createCustomer(customerDTO customerDTO);
//    boolean existsByEmail(String email);
    customerDTO updateCustomer(long id, customerDTO customerDTO);
    String statusToggle(long id, String status);
    Map<String, Object> searchCustomers(
            String name, String customer_email, String industry, Integer company_size,
            String customer_phone_number, String status, String customer_address, int page, int limit);

    Map<String, Object> findCustomers();
}
