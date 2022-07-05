package com.example.calculator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Memory {
    @Id
    @GeneratedValue
    private Long id;

    private Double result;

    public Long getId() {
        return id;
    }

    public Double getResult() {
        return result;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
