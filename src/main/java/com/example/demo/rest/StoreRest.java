package com.example.demo.rest;

import com.example.demo.dto.request.StoreRequestDTO;
import com.example.demo.entity.Store;
import com.example.demo.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1/stores")
public interface StoreRest {

    @PostMapping
    ResponseEntity<ApiResponse<Store>> save(@Valid @RequestBody(required = true)StoreRequestDTO storeRequestDTO);

    @GetMapping
    ResponseEntity<ApiResponse<List<Store>>> findAll();
}
