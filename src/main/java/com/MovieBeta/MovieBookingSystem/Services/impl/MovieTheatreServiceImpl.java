package com.MovieBeta.MovieBookingSystem.Services.impl;

import com.MovieBeta.MovieBookingSystem.Services.MovieService;
import com.MovieBeta.MovieBookingSystem.Services.MovieTheatreService;
import com.MovieBeta.MovieBookingSystem.Services.TheatreService;
import com.MovieBeta.MovieBookingSystem.daos.MovieTheatreDao;
import com.MovieBeta.MovieBookingSystem.enteties.MovieTheatre;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTheatreServiceImpl implements MovieTheatreService {

    @Autowired
    private MovieTheatreDao movieTheatreDao;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieService movieService;



    @Override
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre)
            throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {
        movieService.getMovieDetails(movieTheatre.getMovie().getMovieId());
      theatreService.getTheatreDetails(movieTheatre.getTheatre().getTheatreId());
        return movieTheatreDao.save(movieTheatre);
    }

    @Override
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException {
        return movieTheatreDao.findById(id).orElseThrow(()->new MovieTheatreDetailsNotFoundException("movieTheatre not found by the id"+id));
    }

    @Override
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException {
        MovieTheatre savedMovieTheatre=getMovieTheatreDetails(id);
        movieTheatreDao.delete(savedMovieTheatre);
    return true;
    }

    @Override
    public List<MovieTheatre> getMovieTheatreDetails() {
        return movieTheatreDao.findAll();
    }
}
