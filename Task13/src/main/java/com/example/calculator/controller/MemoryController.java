package com.example.calculator.controller;

import com.example.calculator.entity.Memory;
import com.example.calculator.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemoryController {
    @Autowired
    MemoryService service;

    @PostMapping("/number")
    private Double saveNumber(@RequestBody Memory memory) {
        service.save(memory);
        return memory.getNumber();
    }

    @GetMapping("/number/{id}")
    private Memory getNumber(@PathVariable("id") Long id) {
        return service.getNumberById(id);
    }

    @GetMapping("/add/number/{id}")
    private Double add(@PathVariable("id") Long id) {
        return service.getNumberById(id).getNumber() + 10;
    }

    @GetMapping("/subtract/number/{id}")
    private Double subtract(@PathVariable("id") Long id) {
        return service.getNumberById(id).getNumber() - 3;
    }
}
