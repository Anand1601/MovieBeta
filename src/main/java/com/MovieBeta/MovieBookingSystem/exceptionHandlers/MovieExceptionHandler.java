package com.MovieBeta.MovieBookingSystem.exceptionHandlers;

import com.MovieBeta.MovieBookingSystem.exceptions.MovieDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieExceptionHandler.class);

    @ExceptionHandler(value = MovieDetailsNotFoundException.class)
    public ResponseEntity handleMovieNotFoundException() {

        LOGGER.error("Exception happened, movie id not found");
        return new ResponseEntity("No movie found with given movieId", HttpStatus.BAD_REQUEST);

    }


}
