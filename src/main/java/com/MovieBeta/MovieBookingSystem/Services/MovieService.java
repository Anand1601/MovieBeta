package com.MovieBeta.MovieBookingSystem.Services;



import com.MovieBeta.MovieBookingSystem.dtos.MovieDTO;
import com.MovieBeta.MovieBookingSystem.enteties.Movie;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieDetailsNotFoundException;

import java.util.List;


public interface MovieService {

    Movie acceptMovieDetails(Movie movie);


    Movie getMovieDetails(int id) throws MovieDetailsNotFoundException;

    Movie updateMovieDetails(int id,Movie movie) throws MovieDetailsNotFoundException;

    boolean deleteMovie(int id)throws MovieDetailsNotFoundException;

    List<Movie> getAllMoviesDetails();




}
