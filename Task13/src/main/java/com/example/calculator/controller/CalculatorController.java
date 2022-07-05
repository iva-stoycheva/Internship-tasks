package com.example.calculator.controller;

import com.example.calculator.dto.MemoryDTO;
import com.example.calculator.entity.Memory;
import com.example.calculator.repository.MemoryRepository;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class CalculatorController {

    @Autowired
    private MemoryRepository repository;

    @PostMapping("/number")
    private double saveNumber(@RequestBody Memory memory) {
        repository.save(memory);
        return memory.getResult();
    }

    @GetMapping("/number/{id}")
    private Memory getNumber(@PathVariable("id") Long id) {
        return repository.findById(id).get();
    }

    @PutMapping("/number/{id}")
    private Double operate(@PathVariable("id") Long id, @RequestBody MemoryDTO change) {
        Memory memory = repository.findById(id).get();
        if (change.operation.equals("+")) {
            memory.setResult(memory.getResult() + change.value);
        }
        else if(change.operation.equals("-")) {
            memory.setResult(memory.getResult() - change.value);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        repository.save(memory);
        return memory.getResult();
    }

    @PostMapping(value = "/expression/{id}", consumes = "text/plain")
    public double calculateExpression(@PathVariable("id") long id, @RequestBody String mathExpression) {
        Optional<Memory> number = repository.findById(id);
        Memory memory = number.orElseGet(() -> {
            Memory mem = new Memory();
            mem.setId(id);
            repository.save(mem);
            return repository.findById(id).get();
        });

        String leftSide = mathExpression.substring(0, mathExpression.indexOf("="));
        String rightSide = mathExpression.substring(mathExpression.indexOf("="));
        if (leftSide.contains("M")) {
            leftSide = leftSide.replace("M", String.valueOf(memory.getResult()));
        }
        Expression expression = new ExpressionBuilder(leftSide).build();
        double resultLeft = expression.evaluate();
        if (!rightSide.contains("?")) {
            memoryCalculationUpdate(resultLeft, rightSide, memory);
            repository.save(memory);
        }
        return resultLeft;
    }

    private void memoryCalculationUpdate(double resultLeftSide, String rightExpression, Memory memory) {
        if (rightExpression.contains("M+")) {
            memory.setResult(memory.getResult() + resultLeftSide);
        } else if (rightExpression.contains("M-")) {
            memory.setResult(memory.getResult() - (resultLeftSide));
        } else {
            memory.setResult(resultLeftSide);
        }
    }
}

