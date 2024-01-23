package com.example.demo.rest;

import com.example.demo.dto.request.CustomerRequestDTO;
import com.example.demo.entity.Customer;
import com.example.demo.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/v1/customers")
public interface CustomerRest {

    @PostMapping
    ResponseEntity<ApiResponse<Customer>> save(@Valid @RequestBody(required = true) CustomerRequestDTO customerRequestDTO);
}
