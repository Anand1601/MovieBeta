package com.MovieBeta.MovieBookingSystem.exceptionHandlers;

import com.MovieBeta.MovieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieTheatreExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieTheatreExceptionHandler.class);

    @ExceptionHandler(value = MovieTheatreDetailsNotFoundException.class)
    public ResponseEntity handleMovieTheatreNotFoundException(){

        LOGGER.error("Exception happened, movieTheatre id not found");
        return new ResponseEntity("No movieTheatre found with given MovieTheatreId", HttpStatus.BAD_REQUEST);
    }

}
