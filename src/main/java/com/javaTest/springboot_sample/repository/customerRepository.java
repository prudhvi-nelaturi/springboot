package com.javaTest.springboot_sample.repository;

import com.javaTest.springboot_sample.entity.customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<customer, Long> {
    @Query("SELECT c FROM customer c WHERE " +
            "(:name IS NULL OR c.name LIKE %:name%) AND " +
            "(:industry IS NULL OR c.industry = :industry) AND " +
            "(:company_size IS NULL OR c.company_size = :company_size) AND " +
            "(:customer_email IS NULL OR c.customer_email LIKE %:customer_email%) AND " +
            "(:customer_phone_number IS NULL OR c.customer_phone_number = :customer_phone_number) AND " +
            "(:customer_address IS NULL OR c.customer_address LIKE %:customer_address%) AND " +
            "(:status IS NULL OR c.status = :status)")
    Page<customer> searchCustomers(
            @Param("name") String name,
            @Param("customer_email") String customer_email,
            @Param("industry") String industry,
            @Param("company_size") Integer company_size,
            @Param("customer_phone_number") String customer_phone_number,
            @Param("status") String status,
            @Param("customer_address") String customer_address,
            Pageable pageable
    );

}

