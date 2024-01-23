package com.example.demo.serviceImpl;

import com.example.demo.dao.TypeTransportRepository;
import com.example.demo.entity.TypeTransport;
import com.example.demo.service.TypeTransportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TypeTransportServiceImpl implements TypeTransportService {

    private final TypeTransportRepository typeTransportRepository;

    @Override
    public List<TypeTransport> findAll() {
        return typeTransportRepository.findAll();
    }
}
