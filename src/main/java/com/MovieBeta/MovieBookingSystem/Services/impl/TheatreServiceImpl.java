package com.MovieBeta.MovieBookingSystem.Services.impl;

import com.MovieBeta.MovieBookingSystem.Services.TheatreService;
import com.MovieBeta.MovieBookingSystem.daos.TheatreDao;
import com.MovieBeta.MovieBookingSystem.enteties.Theatre;
import com.MovieBeta.MovieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    public TheatreDao theatreDao;

    @Override
    public Theatre acceptTheatre(Theatre theatre) {
        return theatreDao.save(theatre);
    }

    @Override
    public Theatre getTheatreDetails(int id) throws TheatreDetailsNotFoundException {
return theatreDao.findById(id).orElseThrow(()->new TheatreDetailsNotFoundException("Theatre not found with id:"+id));
    }

    @Override
    public Theatre updateTheatreDetails(int id, Theatre theatre) throws TheatreDetailsNotFoundException {
            Theatre savedTheatre = getTheatreDetails(id);

            //name
            if(isNotNullOrZero(theatre.getTheatreName()))
                savedTheatre.setTheatreName(theatre.getTheatreName());

            //city
        if(isNotNullOrZero(theatre.getCity()))
            savedTheatre.setCity(theatre.getCity());

        //ticket price
        if(isNotNullOrZero(theatre.getTicketPrice()))
            savedTheatre.setTicketPrice(theatre.getTicketPrice());
        return theatreDao.save(savedTheatre);
    }

    @Override
    public void deleteTheatre(int id) throws TheatreDetailsNotFoundException {
        Theatre savedTheatre=getTheatreDetails(id);
        theatreDao.delete(savedTheatre);
    }

    @Override
    public List<Theatre> getAllTheatreDetails() {
        return theatreDao.findAll();
    }

    public boolean isNotNullOrZero(Object obj)
    {
        return obj!=null;
    }
}
