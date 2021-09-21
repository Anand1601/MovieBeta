package com.MovieBeta.MovieBookingSystem.exceptionHandlers;

import com.MovieBeta.MovieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.MovieBeta.MovieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler(value = UserDetailsNotFoundException.class)
    public ResponseEntity handleUserNotFoundException() {

        LOGGER.error("Exception happened, user id not found");
        return new ResponseEntity("No user found with given userId", HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(value = UserNameAlreadyExistsException.class)
    public ResponseEntity handleUserNameAlreadyExistsException() {

        LOGGER.error("Exception happened, user name already exists");
        return new ResponseEntity("This user name is already taken", HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(value = UserTypeDetailsNotFoundException.class)
    public ResponseEntity handleUserTypeNotFoundException() {

        LOGGER.error("Exception happened, user type not found");
        return new ResponseEntity("No user type found with given userId", HttpStatus.BAD_REQUEST);

    }


}
