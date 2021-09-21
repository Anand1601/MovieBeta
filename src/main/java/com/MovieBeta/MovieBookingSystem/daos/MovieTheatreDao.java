package com.MovieBeta.MovieBookingSystem.daos;

import com.MovieBeta.MovieBookingSystem.enteties.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheatreDao extends JpaRepository<MovieTheatre,Integer> {
}
