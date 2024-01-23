package com.example.demo.serviceImpl;

import com.example.demo.dao.TypeProductRepository;
import com.example.demo.dao.TypeTransportRepository;
import com.example.demo.dto.request.TypeProductRequestDTO;
import com.example.demo.entity.TypeProduct;
import com.example.demo.entity.TypeTransport;
import com.example.demo.service.TypeProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeProductServiceImpl implements TypeProductService {
    private final TypeProductRepository typeProductRepository;
    private final TypeTransportRepository typeTransportRepository;

    @Override
    @Transactional
    public TypeProduct save(TypeProductRequestDTO typeProductRequestDTO) {
        TypeProduct typeProduct = converToTypeProduct(typeProductRequestDTO);
        return typeProductRepository.save(typeProduct);
    }

    @Override
    public TypeProduct findById(int id) {
        Optional<TypeProduct> typeProductOptional = typeProductRepository.findById(id);
        if (typeProductOptional.isPresent()) {
            return typeProductOptional.get();
        } else {
            throw new EntityNotFoundException("TypeProduct no encontrado con ID: " + id);
        }
    }

    @Override
    public List<TypeProduct> findAll() {
        return typeProductRepository.findAll();
    }


    public TypeProduct converToTypeProduct(TypeProductRequestDTO typeProductRequestDTO) {
        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setName(typeProductRequestDTO.getName());

        Optional<TypeTransport> typeTransport = typeTransportRepository.findById(typeProductRequestDTO.getTypeTransport());

        if (typeTransport.isPresent()) {
            typeProduct.setTypeTransport(typeTransport.get());
        } else {
            throw new EntityNotFoundException("TypeTransport no encontrado con ID: " + typeProductRequestDTO.getTypeTransport());
        }

        return typeProduct;
    }

}
