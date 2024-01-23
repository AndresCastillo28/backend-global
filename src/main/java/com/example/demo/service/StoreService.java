package com.example.demo.service;

import com.example.demo.dto.request.StoreRequestDTO;
import com.example.demo.entity.Store;

import java.util.List;

public interface StoreService {
    Store save(StoreRequestDTO storeRequestDTO);

    Store findById(int id);

    List<Store> findAll();
}
