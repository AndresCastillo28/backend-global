package com.example.demo.serviceImpl;

import com.example.demo.dao.ScopeLevelRepository;
import com.example.demo.entity.ScopeLevel;
import com.example.demo.service.ScopeLevelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScopeLevelServiceImpl implements ScopeLevelService {

    private final ScopeLevelRepository scopeLevelRepository;
    @Override
    public List<ScopeLevel> findAll() {
        return scopeLevelRepository.findAll();
    }
}
