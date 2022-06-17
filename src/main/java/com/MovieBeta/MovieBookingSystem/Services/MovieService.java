package com.MovieBeta.MovieBookingSystem.Services;


import com.MovieBeta.MovieBookingSystem.enteties.Movie;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieDetailsNotFoundException;

import java.util.List;


public interface MovieService {

    Movie acceptMovieDetails(Movie movie);


    Movie getMovieDetails(int id) throws MovieDetailsNotFoundException;

    Movie updateMovieDetails(int id,Movie movie) throws MovieDetailsNotFoundException;

    void deleteMovie(int id)throws MovieDetailsNotFoundException;

    List<Movie> getAllMoviesDetails();




}
