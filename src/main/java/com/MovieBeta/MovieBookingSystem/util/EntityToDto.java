package com.MovieBeta.MovieBookingSystem.util;

import com.MovieBeta.MovieBookingSystem.dtos.BookingDTO;
import com.MovieBeta.MovieBookingSystem.enteties.Booking;
import org.springframework.stereotype.Component;

@Component
public class EntityToDto {

    public BookingDTO bookingEntityToBookingDTOEntity(Booking booking){
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setNoOfSeats(booking.getNoOfSeats());
        bookingDTO.setUserId(booking.getUser().getUserId());
        bookingDTO.setMovieTheatreId(booking.getMovieTheatre().getMovieTheatreId());
       return bookingDTO;
    }

}
