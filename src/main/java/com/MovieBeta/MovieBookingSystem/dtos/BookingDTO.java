package com.MovieBeta.MovieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class BookingDTO {

    @JsonProperty("booking_id")
      private int bookingId;

@JsonProperty("booking_date")
 private LocalDateTime bookingDate;

@JsonProperty("no_of_seats")
private int noOfSeats;

@JsonProperty("user_id")
private int userId;

@JsonProperty("movie_theatre_id")
private int movieTheatreId;


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieTheatreId() {
        return movieTheatreId;
    }

    public void setMovieTheatreId(int movieTheatreId) {
        this.movieTheatreId = movieTheatreId;
    }
}
