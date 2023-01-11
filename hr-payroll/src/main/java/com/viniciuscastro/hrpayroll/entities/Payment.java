package com.viniciuscastro.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private String name;
    private Double dailyIncome;
    private Integer days;

    public Double getTotal() {
        return dailyIncome * days;
    }
}
