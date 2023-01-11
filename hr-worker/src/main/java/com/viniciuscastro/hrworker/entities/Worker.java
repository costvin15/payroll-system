package com.viniciuscastro.hrworker.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "tb_worker")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 70)
    private String name;

    private Double daily_Income;
}
