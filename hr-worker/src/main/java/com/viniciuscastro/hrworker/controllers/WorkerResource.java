package com.viniciuscastro.hrworker.controllers;

import com.viniciuscastro.hrworker.entities.Worker;
import com.viniciuscastro.hrworker.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("workers")
@AllArgsConstructor
public class WorkerResource {
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = workerRepository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        Optional<Worker> worker = workerRepository.findById(id);
        return worker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
