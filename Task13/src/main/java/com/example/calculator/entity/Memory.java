package com.example.calculator.entity;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
public class Memory {
    @Id
    @GeneratedValue
    private Long id;

    private Double number;

    public Long getId() {
        return id;
    }

    public Double getNumber() {
        return number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Memory() {
    }

    public Memory(Double number) {
        this.number = number;
    }

    public Memory(Long id, Double number) {
        this.id = id;
        this.number = number;
    }
}
