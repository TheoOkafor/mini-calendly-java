package com.miniCalendly.controller;

import com.miniCalendly.exceptions.UserNotFoundException;
import com.miniCalendly.model.User;
import com.miniCalendly.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return user;
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
            .map(User -> {
                User.setUsername(newUser.getUsername());
                User.setName(newUser.getName());
                return repository.save(User);
            })
            .orElseGet(() -> {
                newUser.setId(id);
                return repository.save(newUser);
            });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
