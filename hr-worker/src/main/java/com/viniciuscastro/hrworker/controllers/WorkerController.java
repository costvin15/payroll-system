package com.viniciuscastro.hrworker.controllers;

import com.viniciuscastro.hrworker.entities.Worker;
import com.viniciuscastro.hrworker.repositories.WorkerRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("workers")
@RequiredArgsConstructor
public class WorkerController {
    @NonNull
    private WorkerRepository workerRepository;
    @Value("${test.config}")
    private String testConfig;
    private final Logger logger = LoggerFactory.getLogger(WorkerController.class);

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

    @GetMapping("configs")
    public ResponseEntity<Void> getConfigurations() {
        logger.info("Configuration: " + testConfig);
        return ResponseEntity.noContent().build();
    }
}
