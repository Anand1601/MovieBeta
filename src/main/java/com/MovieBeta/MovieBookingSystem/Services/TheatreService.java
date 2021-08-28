package com.MovieBeta.MovieBookingSystem.Services;

import com.MovieBeta.MovieBookingSystem.enteties.Theatre;
import com.MovieBeta.MovieBookingSystem.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface TheatreService {

    public Theatre acceptTheatre(Theatre theatre);
    public Theatre getTheatreDetails(int id) throws TheatreDetailsNotFoundException;
    public Theatre updateTheatreDetails(int id, Theatre theatre) throws TheatreDetailsNotFoundException;
    public boolean deleteTheatre(int id) throws  TheatreDetailsNotFoundException;
    public List<Theatre> getAllTheatreDetails();
}
