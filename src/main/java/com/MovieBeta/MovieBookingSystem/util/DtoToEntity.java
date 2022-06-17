package com.MovieBeta.MovieBookingSystem.util;

import com.MovieBeta.MovieBookingSystem.Services.BookingService;
import com.MovieBeta.MovieBookingSystem.Services.MovieTheatreService;
import com.MovieBeta.MovieBookingSystem.Services.UserService;
import com.MovieBeta.MovieBookingSystem.dtos.BookingDTO;
import com.MovieBeta.MovieBookingSystem.enteties.Booking;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DtoToEntity {


    @Autowired
    BookingService bookingService;

    @Autowired
    MovieTheatreService movieTheatreService;

    @Autowired
    UserService userService;

    public Booking bookigDTOEntityToBookingEntity(BookingDTO bookingDTO) throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
        Booking booking = new Booking();
        booking.setMovieTheatre(movieTheatreService.getMovieTheatreDetails(bookingDTO.getMovieTheatreId()));
        booking.setBookingId(bookingDTO.getBookingId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setUser(userService.getUserDetails(bookingDTO.getUserId()));
        booking.setNoOfSeats(bookingDTO.getNoOfSeats());
        return booking;
    }

}
