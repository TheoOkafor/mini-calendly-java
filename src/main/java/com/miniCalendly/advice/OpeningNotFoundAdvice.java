package com.miniCalendly.advice;

import com.miniCalendly.exceptions.OpeningNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OpeningNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(OpeningNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundAdvice(OpeningNotFoundException ex) {
        return ex.getMessage();
    }
}
