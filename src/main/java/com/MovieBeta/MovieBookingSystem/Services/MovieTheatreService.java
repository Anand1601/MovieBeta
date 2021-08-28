package com.MovieBeta.MovieBookingSystem.Services;

import com.MovieBeta.MovieBookingSystem.enteties.MovieTheatre;
import com.MovieBeta.MovieBookingSystem.exceptions.MoiveTheatreDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieDetailNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface MovieTheatreService {
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieDetailNotFoundException, MoiveTheatreDetailsNotFoundException, TheatreDetailsNotFoundException;
    public  MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException;
    public boolean deleteMovieTheatre(int id) throws  MovieTheatreDetailsNotFoundException;
    public List<MovieTheatre> getMovieTheatreDetails();
}
