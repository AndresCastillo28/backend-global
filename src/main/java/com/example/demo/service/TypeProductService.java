package com.example.demo.service;

import com.example.demo.dto.request.TypeProductRequestDTO;
import com.example.demo.entity.TypeProduct;

import java.util.List;

public interface TypeProductService {

    TypeProduct save(TypeProductRequestDTO typeProductRequestDTO);

    TypeProduct findById(int id);

    List<TypeProduct> findAll();
}
