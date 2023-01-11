package com.viniciuscastro.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable {
    private Long id;
    private String name;
    private Double daily_Income;
}
