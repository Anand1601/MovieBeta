package com.vishwa.MovieBookingSystem.Services.impl;

import com.vishwa.MovieBookingSystem.Services.BookingService;
import com.vishwa.MovieBookingSystem.Services.MovieTheatreService;
import com.vishwa.MovieBookingSystem.Services.UserService;
import com.vishwa.MovieBookingSystem.dao.BookingDao;
import com.vishwa.MovieBookingSystem.enteties.Booking;
import com.vishwa.MovieBookingSystem.enteties.MovieTheatre;
import com.vishwa.MovieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.vishwa.MovieBookingSystem.exceptions.MoiveTheatreDetailsNotFoundException;
import com.vishwa.MovieBookingSystem.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {
/*
    @Autowired
    public MovieTheatreService movieTheatreService;
*/

    @Autowired
    public UserService userService;

    @Autowired
    public BookingDao bookingDao;



    @Override
    public Booking acceptBookingDetails(Booking booking) throws MoiveTheatreDetailsNotFoundException, UserDetailsNotFoundException {
      return null;
    }

    @Override
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException {
        return null;
    }

    @Override
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException {
        return false;
    }

    @Override
    public List<Booking> getAllBookingDetails() {
        return null;
    }
}
