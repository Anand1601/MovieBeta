package com.MovieBeta.MovieBookingSystem.exceptionHandlers;

import com.MovieBeta.MovieBookingSystem.exceptions.CityDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityExceptionHandler.class);

    @ExceptionHandler(value = CityDetailsNotFoundException.class)
    public ResponseEntity handleCityNotFoundException() {

        LOGGER.error("Exception happened, movie id not found");
        return new ResponseEntity("No movie found with given movieId", HttpStatus.BAD_REQUEST);

    }
}
