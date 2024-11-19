package com.javaTest.springboot_sample.entity;

import jakarta.persistence.*;
import lombok.Data;


//@Table(name="customers")
@Entity
@Data
public class customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    private String industry;
    private int company_size;
    private String customer_email;
    private int customer_phone_number;
    private String customer_address;
    private String other_customer_data;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getCompany_size() {
        return company_size;
    }

    public void setCompany_size(int company_size) {
        this.company_size = company_size;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public int getCustomer_phone_number() {
        return customer_phone_number;
    }

    public void setCustomer_phone_number(int customer_phone_number) {
        this.customer_phone_number = customer_phone_number;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getOther_customer_data() {
        return other_customer_data;
    }

    public void setOther_customer_data(String other_customer_data) {
        this.other_customer_data = other_customer_data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
