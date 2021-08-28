package com.MovieBeta.MovieBookingSystem.Services;



import com.MovieBeta.MovieBookingSystem.enteties.Movie;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieDetailNotFoundException;

import java.util.List;


public interface MovieService {

    Movie acceptMovieDetails(Movie movie);


    Movie getMovieDetails(int id) throws MovieDetailNotFoundException;

    Movie updateMovieDetails(int id,Movie movie) throws MovieDetailNotFoundException;

    boolean deleteMovie(int id)throws MovieDetailNotFoundException;

    List<Movie> getAllMoviesDetails();

}
