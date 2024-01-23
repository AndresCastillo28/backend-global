package com.example.demo.rest;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/v1/users")
public interface UserRest {

    @PostMapping
    ResponseEntity<ApiResponse<UserEntity>> save(@Valid @RequestBody(required = true) UserRequestDTO userRequestDTO);
}
