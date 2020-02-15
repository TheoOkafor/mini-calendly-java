package com.miniCalendly.controller;

import com.miniCalendly.exceptions.OpeningNotFoundException;
import com.miniCalendly.model.Opening;
import com.miniCalendly.repository.OpeningRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OpeningController {
    private final OpeningRepository repository;

    OpeningController(OpeningRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/openings")
    List<Opening> all() {
        return repository.findAll();
    }

    @PostMapping("/openings")
    Opening newOpening(@RequestBody Opening newOpening) {
        return repository.save(newOpening);
    }

    // Single item
    @GetMapping("/openings/{id}")
    Opening one(@PathVariable Long id) {
        Opening opening = repository.findById(id)
                .orElseThrow(() -> new OpeningNotFoundException(id));
        return opening;
    }

}
