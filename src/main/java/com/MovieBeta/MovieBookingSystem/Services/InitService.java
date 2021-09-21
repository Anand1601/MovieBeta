package com.MovieBeta.MovieBookingSystem.Services;

//to initialize data in all the tables of DB

import com.MovieBeta.MovieBookingSystem.exceptions.*;

public interface InitService {

    //This method when called will initialize the data in the DB
    public void init() throws UserTypeDetailsNotFoundException, UserNameAlreadyExistsException, MovieDetailsNotFoundException, TheatreDetailsNotFoundException, UserDetailsNotFoundException, MovieTheatreDetailsNotFoundException;

}
