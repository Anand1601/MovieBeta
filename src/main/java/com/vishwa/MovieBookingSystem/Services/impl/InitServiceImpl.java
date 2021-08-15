package com.vishwa.MovieBookingSystem.Services.impl;

import com.vishwa.MovieBookingSystem.Services.InitService;
import com.vishwa.MovieBookingSystem.dao.*;
import com.vishwa.MovieBookingSystem.enteties.City;
import com.vishwa.MovieBookingSystem.enteties.MovieTheatre;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class InitServiceImpl implements InitService {

    @Autowired
  private  CityDao cityDao;

    @Autowired
   private UserTypeDao userTypeDao;

    @Autowired
    private StatusDao statusDao;

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TheatreDao theatreDao;

    @Autowired
    private MovieTheatre movieTheatre;

    @Autowired
    private BookingDao bookingDao;

    @Override
    public void init() {
        /*
        * write the logic to store data inside the database in different tables
        * */

        /*
        * add cities
        * */

        List<City> cities=new ArrayList<>();

        //add user types

        //add statuses

        //add Movies

        //add users

        //add theatres

        //add MovieTheatre

        //add

    }
}
