package com.miniCalendly.controller;

import com.miniCalendly.exceptions.BookingNotFoundException;
import com.miniCalendly.exceptions.OpeningNotFoundException;
import com.miniCalendly.model.Booking;
import com.miniCalendly.model.Opening;
import com.miniCalendly.repository.BookingRepository;
import com.miniCalendly.repository.OpeningRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    private final BookingRepository repository;
    private final OpeningRepository openingRepo;

    BookingController(BookingRepository repository, OpeningRepository openingRepo) {
        this.repository = repository;
        this.openingRepo = openingRepo;
    }

    // Aggregate root

    @GetMapping("/bookings")
    List<Booking> all() {
        return repository.findAll();
    }

    @GetMapping("user/{userId}/bookings")
    List<Booking> allByUser(@PathVariable Long userId) {
        return repository.findAllByUserId(userId);
    }

    @PostMapping("/bookings")
    Booking newBooking(@RequestBody Booking newBooking) {
        List<Opening> mentorsOpenings = openingRepo.findAllByOwner(newBooking.getMentorId());
        Opening opening = null;
        // check whether the opening exists from this mentor
        for (Opening mentorsOpening: mentorsOpenings) {
            if(mentorsOpening.getDate_time().equals(newBooking.getDate_time())) {
                opening = mentorsOpening;
            }
        }
        if(opening != null) {
            return repository.save(newBooking);
        } else {
            throw new OpeningNotFoundException(null);
        }
    }

    // Single item
    @GetMapping("/bookings/{id}")
    Booking one(@PathVariable Long id) {
        Booking booking = repository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException(id));
        return booking;
    }
}
