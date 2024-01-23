package com.example.demo.service;

import com.example.demo.dto.request.CustomerRequestDTO;
import com.example.demo.entity.Customer;

public interface CustomerService {

    Customer save(CustomerRequestDTO customerRequestDTO);

    Customer findById(int id);
}
