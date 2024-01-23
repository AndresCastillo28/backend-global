package com.example.demo.serviceImpl;

import com.example.demo.dao.ScopeLevelRepository;
import com.example.demo.dao.StoreRepository;
import com.example.demo.dto.request.StoreRequestDTO;
import com.example.demo.entity.ScopeLevel;
import com.example.demo.entity.Store;
import com.example.demo.service.StoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final ScopeLevelRepository scopeLevelRepository;

    @Override
    @Transactional
    public Store save(StoreRequestDTO storeRequestDTO) {
        return storeRepository.save(convertToStore(storeRequestDTO));
    }

    @Override
    public Store findById(int id) {
        Optional<Store> store = storeRepository.findById(id);
        if (store.isPresent()) {
            return store.get();
        } else {
            throw new EntityNotFoundException("Customer no encontrado con ID: " + id);
        }
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store convertToStore(StoreRequestDTO storeRequestDTO) {
        Store store = new Store();
        store.setName(storeRequestDTO.getName());

        Optional<ScopeLevel> scopeLevel = scopeLevelRepository.findById(storeRequestDTO.getScopeLevel());

        if (!scopeLevel.isPresent()) {
            throw new EntityNotFoundException("ScopeLevel no encontrado con ID: " + storeRequestDTO.getScopeLevel());
        }

        store.setScopeLevel(scopeLevel.get());
        return store;
    }


}
