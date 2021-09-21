package com.MovieBeta.MovieBookingSystem.exceptionHandlers;

import com.MovieBeta.MovieBookingSystem.exceptions.StatusDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class StatusExceptionHandler {


    private static final Logger LOGGER = LoggerFactory.getLogger(StatusExceptionHandler.class);

    @ExceptionHandler(value = StatusDetailsNotFoundException.class)
    public ResponseEntity handleMovieNotFoundException() {

        LOGGER.error("Exception happened, theatre id not found");
        return new ResponseEntity("No theatre found with given theatreId", HttpStatus.BAD_REQUEST);

    }

}
