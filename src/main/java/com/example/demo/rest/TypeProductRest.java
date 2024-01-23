package com.example.demo.rest;

import com.example.demo.dto.request.TypeProductRequestDTO;
import com.example.demo.entity.TypeProduct;
import com.example.demo.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1/types-products")
public interface TypeProductRest {

    @PostMapping
    ResponseEntity<ApiResponse<TypeProduct>> save(@Valid @RequestBody(required = true) TypeProductRequestDTO typeProductRequestDTO);

    @GetMapping
    ResponseEntity<ApiResponse<List<TypeProduct>>> findAll();
}
