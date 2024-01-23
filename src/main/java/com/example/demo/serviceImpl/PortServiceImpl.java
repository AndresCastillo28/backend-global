package com.example.demo.serviceImpl;

import com.example.demo.dao.PortRepository;
import com.example.demo.entity.Port;
import com.example.demo.service.PortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortServiceImpl implements PortService {

    private final PortRepository portRepository;

    @Override
    public List<Port> findAll() {
        return portRepository.findAll();
    }
}
