package com.viniciuscastro.hruser.controllers;

import com.viniciuscastro.hruser.entities.User;
import com.viniciuscastro.hruser.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
    private UserRepository repository;

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = repository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User user = repository.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
