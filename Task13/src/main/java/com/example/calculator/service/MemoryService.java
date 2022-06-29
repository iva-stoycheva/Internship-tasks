package com.example.calculator.service;

import com.example.calculator.entity.Memory;
import com.example.calculator.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoryService {
    @Autowired
    MemoryRepository repository;

    public Memory getNumberById(Long id) {
        return repository.findById(id).get();
    }

    public void save(Memory memory) {
        repository.save(memory);
    }
}
