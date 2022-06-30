package com.example.calculator.controller;

import com.example.calculator.dto.MemoryDTO;
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

    @PutMapping("/number/{id}")
    private Double operate(@PathVariable("id") Long id, @RequestBody MemoryDTO change) {
        Memory memory = service.getNumberById(id);
        if (change.operation.equals("+")) {
            memory.setNumber(memory.getNumber() + change.value);
        }
        else if(change.operation.equals("-")) {
            memory.setNumber(memory.getNumber() - change.value);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        service.save(memory);
        return memory.getNumber();
    }
}
