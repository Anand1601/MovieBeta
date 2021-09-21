package com.MovieBeta.MovieBookingSystem.exceptionHandlers;

import com.MovieBeta.MovieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class TheatreExceptionHandler {


    private static final Logger LOGGER = LoggerFactory.getLogger(TheatreExceptionHandler.class);

    @ExceptionHandler(value = TheatreDetailsNotFoundException.class)
    public ResponseEntity handleTheatreNotFoundException() {

        LOGGER.error("Exception happened, Theatre id not found");
        return new ResponseEntity("No Theatre found with given TheatreId", HttpStatus.BAD_REQUEST);

    }

}
