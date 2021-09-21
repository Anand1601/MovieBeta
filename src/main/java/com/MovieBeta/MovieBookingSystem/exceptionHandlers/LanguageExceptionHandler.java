package com.MovieBeta.MovieBookingSystem.exceptionHandlers;

import com.MovieBeta.MovieBookingSystem.exceptions.LanguageDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LanguageExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageExceptionHandler.class);

    @ExceptionHandler(value = LanguageDetailsNotFoundException.class)
    public ResponseEntity handleLanguageNotFoundException() {

        LOGGER.error("Exception happened, Language id not found");
        return new ResponseEntity("Language not found with given LanguageId", HttpStatus.BAD_REQUEST);

    }
}
