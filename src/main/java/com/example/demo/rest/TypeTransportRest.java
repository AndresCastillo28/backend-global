package com.example.demo.rest;

import com.example.demo.entity.TypeTransport;
import com.example.demo.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1/types-transport")
public interface TypeTransportRest {

    @GetMapping
    ResponseEntity<ApiResponse<List<TypeTransport>>> finAll();
}
