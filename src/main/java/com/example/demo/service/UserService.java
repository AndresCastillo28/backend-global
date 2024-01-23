package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.entity.UserEntity;

public interface UserService {

    UserEntity save(UserRequestDTO userEntity);
}
