package com.MovieBeta.MovieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieTheatreDTO {

    @JsonProperty("movieTheatreId")
    private int movieTheatreId;

    @JsonProperty("movie_id")
    private int  movieId;

    @JsonProperty("theatre_id")
    private int theatreId;

    public int getMovieTheatreId() {
        return movieTheatreId;
    }

    public void setMovieTheatreId(int movieTheatreId) {
        this.movieTheatreId = movieTheatreId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }
}
