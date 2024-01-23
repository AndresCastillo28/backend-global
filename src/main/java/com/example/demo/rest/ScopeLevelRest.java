package com.example.demo.rest;

import com.example.demo.entity.ScopeLevel;
import com.example.demo.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1/scope-levels")
public interface ScopeLevelRest {

    @GetMapping
    ResponseEntity<ApiResponse<List<ScopeLevel>>> findAll();
}
