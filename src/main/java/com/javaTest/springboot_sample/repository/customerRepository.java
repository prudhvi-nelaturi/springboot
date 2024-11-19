package com.javaTest.springboot_sample.repository;

import com.javaTest.springboot_sample.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<customer, Long> {

}
