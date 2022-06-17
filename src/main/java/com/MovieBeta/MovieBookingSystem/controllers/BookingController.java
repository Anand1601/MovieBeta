package com.MovieBeta.MovieBookingSystem.controllers;

import com.MovieBeta.MovieBookingSystem.Services.BookingService;
import com.MovieBeta.MovieBookingSystem.Services.impl.BookingServiceImpl;
import com.MovieBeta.MovieBookingSystem.dtos.BookingDTO;
import com.MovieBeta.MovieBookingSystem.enteties.Booking;
import com.MovieBeta.MovieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.util.DtoToEntity;
import com.MovieBeta.MovieBookingSystem.util.EntityToDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
   private BookingService bookingService;

    @Autowired
    private ModelMapper modelMapper ;

    @Autowired
    private DtoToEntity dtoToEntity;
    @Autowired
    private EntityToDto entityToDto;

    //bookTicket

   @PostMapping
    public ResponseEntity bookTheTicket(BookingDTO bookingDTO) throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {

       Booking booking1 = dtoToEntity.bookigDTOEntityToBookingEntity(bookingDTO);
       System.out.println(booking1);
       Booking booking = bookingService.acceptBookingDetails(dtoToEntity.bookigDTOEntityToBookingEntity(bookingDTO));
        BookingDTO response = entityToDto.bookingEntityToBookingDTOEntity(booking);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

/*    //cancel the booking
@DeleteMapping("/booking_id")
    public ResponseEntity deleteBookingById(@PathVariable("booking_id") int bookingId) throws BookingDetailsNotFoundException {

        boolean booking = bookingService.deleteBooking(bookingId);


}*/

//getBookingById


    //getAllBookings
    @GetMapping
    public ResponseEntity getAllBooking(){
        List<Booking> bookings = bookingService.getAllBookingDetails();
        List<BookingDTO> responses = new ArrayList<>();
        for (Booking booking: bookings) {
            responses.add(entityToDto.bookingEntityToBookingDTOEntity(booking));
        }
        return new ResponseEntity(responses,HttpStatus.OK);
    }

    

}
