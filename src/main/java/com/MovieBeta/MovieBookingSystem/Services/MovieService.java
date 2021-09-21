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

        default MovieDTO convertToMovieDTO(Movie movie){
        MovieDTO movieDTO =new MovieDTO();
        movieDTO.setMovieId(movie.getMovieId());
        movieDTO.setMovieName(movie.getMovieName());
        movieDTO.setMovieDescription(movie.getMovieDescription());
        movieDTO.setDuration(movie.getDuration());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        movieDTO.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        movieDTO.setStatus_id(movie.getStatus().getStatusId());
        movieDTO.setTrailerUrl(movie.getTrailerUrl());

        return movieDTO;
    }

}
