package com.miniCalendly.exceptions;

public class OpeningNotFoundException extends RuntimeException {
    public OpeningNotFoundException(Long id) {
        super("Could not find opening " + id);
    }
}
