package com.MovieBeta.MovieBookingSystem.Services.impl;

import com.MovieBeta.MovieBookingSystem.Services.MovieService;
import com.MovieBeta.MovieBookingSystem.daos.MovieDao;
import com.MovieBeta.MovieBookingSystem.enteties.Movie;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException {

        return movieDao.findById(id).orElseThrow(() -> new MovieDetailsNotFoundException("Movie not found for id" + id));
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException {
        //to update movie first get the movie
        Movie savedMovie = getMovieDetails(id);

        //read the attribute from the movie object and update it in savedMovie
        if (isNotNullOrZero(movie.getMovieName()))
            savedMovie.setMovieName(movie.getMovieName());

        //update movieDescription
        if (isNotNullOrZero(movie.getMovieDescription()))
            savedMovie.setMovieDescription(movie.getMovieDescription());

        //update movieDuration
        if (isNotNullOrZero(movie.getDuration()))
            savedMovie.setDuration(movie.getDuration());

        //update coverPhoto
        if (isNotNullOrZero(movie.getCoverPhotoUrl()))
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());

        //update released date
        if (isNotNullOrZero(movie.getReleaseDate()))
            savedMovie.setReleaseDate(movie.getReleaseDate());
        //update status
        if (isNotNullOrZero(movie.getStatus()))
            savedMovie.setStatus(movie.getStatus());

        //trailer
        if (isNotNullOrZero(movie.getTrailerUrl()))
            savedMovie.setTrailerUrl(movie.getTrailerUrl());

        return movieDao.save(savedMovie);
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

    @Override
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException {
        Movie savedMovie = getMovieDetails(id);
        movieDao.delete(savedMovie);
        return true;
    }

    @Override
    public List<Movie> getAllMoviesDetails() {
        return movieDao.findAll();
    }
}
