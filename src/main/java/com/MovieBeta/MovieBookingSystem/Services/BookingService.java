package com.MovieBeta.MovieBookingSystem.Services;

import com.MovieBeta.MovieBookingSystem.enteties.Booking;
import com.MovieBeta.MovieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.UserDetailsNotFoundException;

import java.util.List;

public interface BookingService {

    public Booking acceptBookingDetails(Booking booking)
            throws MovieTheatreDetailsNotFoundException,
            UserDetailsNotFoundException, MovieTheatreDetailsNotFoundException;
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
    public void deleteBooking(int id) throws BookingDetailsNotFoundException;
    public List<Booking> getAllBookingDetails();
}
