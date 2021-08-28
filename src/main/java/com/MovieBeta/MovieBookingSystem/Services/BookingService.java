package com.MovieBeta.MovieBookingSystem.Services;

import com.MovieBeta.MovieBookingSystem.enteties.Booking;
import com.MovieBeta.MovieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.MoiveTheatreDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.UserDetailsNotFoundException;

import java.util.List;

public interface BookingService {

    public Booking acceptBookingDetails(Booking booking)
            throws MoiveTheatreDetailsNotFoundException,
            UserDetailsNotFoundException, MovieTheatreDetailsNotFoundException;
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException;
    public List<Booking> getAllBookingDetails();
}
