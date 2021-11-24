package com.MovieBeta.MovieBookingSystem.daos;

import com.MovieBeta.MovieBookingSystem.enteties.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface MovieDao extends JpaRepository<Movie,Integer> {


    public List<Movie> findByMovieName(String movieName);
    public List<Movie> findByMovieNameAndDuration(String name,int duration);
    List<Movie> findByReleaseDateBetween(LocalDateTime start,LocalDateTime end);
    public List<Movie> findByDurationGreaterThanEqual(int duration);
    List<Movie> findByReleaseDateAfter(LocalDateTime releaseDate);
    List<Movie> findByMovieNameContaining(String movieName);
    List<Movie> findByMovieNameIgnoreCase(String movieName);
}
