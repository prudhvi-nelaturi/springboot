package com.javaTest.springboot_sample.service.impl;


import com.javaTest.springboot_sample.dto.customerDTO;
import com.javaTest.springboot_sample.entity.customer;
import com.javaTest.springboot_sample.service.customerService;
import com.javaTest.springboot_sample.repository.customerRepository;
import com.javaTest.springboot_sample.mapper.customerMapper;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class customerServiceImpl implements customerService {

    @Autowired
    private customerRepository customerRepository;

    @Autowired
    private customerMapper customerMapper;

//    public customerServiceImpl(customerRepository customerRepository){
//        this.customerRepository = customerRepository;
//    }

    @Override
    public long createCustomer(customerDTO customerDTO){
        customer customer = customerMapper.toEntity(customerDTO);
        customerDTO result = customerMapper.toDto(customerRepository.save(customer));
        return result.getId();

    }

//    @Override
//    public boolean existsByEmail(String email) {
//        return customerRepository.
//    }

    @Override
    public customerDTO updateCustomer(long id, customerDTO customerDTO) {

        customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with ID " + id + " not found in the Database"));
//        System.out.println(customer.toString().isEmpty());
        if (!customer.toString().isEmpty()) {
            if (customerDTO.getName() != null) {
                customer.setName(customerDTO.getName());
            }
            if(customerDTO.getIndustry() != null){
                customer.setIndustry(customerDTO.getIndustry());
            }
            if(customerDTO.getCustomer_email() != null){
                customer.setCustomer_email(customerDTO.getCustomer_email());
            }
            if(customerDTO.getCustomer_address() != null){
                customer.setCustomer_address(customerDTO.getCustomer_address());
            }
            if(customerDTO.getCustomer_phone_number() != null){
                customer.setCustomer_phone_number(customerDTO.getCustomer_phone_number());
            }
            if(customerDTO.getCompany_size() > 0){
                customer.setCompany_size(customerDTO.getCompany_size());
            }
            if(customerDTO.getOther_customer_data() != null){
                customer.setOther_customer_data(customerDTO.getOther_customer_data());
            }
            if(customerDTO.getStatus() != null){
                customer.setStatus(customerDTO.getStatus());
            }
            System.out.println(customer.getName());


        }
        return customerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public String statusToggle(long id, String status){
        customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with ID " + id + " not found in the Database"));
        if (!status.equalsIgnoreCase("enabled") && !status.equalsIgnoreCase("disabled")) {
            throw new IllegalArgumentException("Invalid status value: " + status);
        }
        else{
            customer.setStatus(status);
        }


        customerRepository.save(customer);
        return "Customer details " +status+ " successfully";

    }

    @Override
    public Map<String, Object> searchCustomers(String name, String customer_email, String industry, Integer company_size,
                                               String customer_phone_number, String status, String customer_address,
                                               int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        System.out.println(name);
        Page<customer> customersPage = customerRepository.searchCustomers(
                name, customer_email, industry, company_size, customer_phone_number, status, customer_address, pageable);

        List<customerDTO> results = customersPage.getContent().stream()
                .map(customerMapper::toDto)
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("total_count", customersPage.getTotalElements());
        response.put("page_count", customersPage.getTotalPages());
        response.put("current_page", page);
        response.put("results", results);

        return response;
    }

    @Override
    public Map<String, Object> findCustomers(){

        Map<String, Object> result = new HashMap<>();



        return result;
    }
}










































