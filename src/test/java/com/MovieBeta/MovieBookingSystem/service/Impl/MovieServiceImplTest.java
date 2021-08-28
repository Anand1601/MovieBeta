package com.MovieBeta.MovieBookingSystem.service.Impl;



import com.MovieBeta.MovieBookingSystem.enteties.Movie;
import com.MovieBeta.MovieBookingSystem.enteties.Status;
import com.MovieBeta.MovieBookingSystem.Services.impl.MovieServiceImpl;
import com.MovieBeta.MovieBookingSystem.Services.impl.StatusServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
public class MovieServiceImplTest {

  @Autowired
 private MovieServiceImpl movieService;

  @Autowired
   private StatusServiceImpl statusService;

Movie movie;



@BeforeEach
public void beforeTest(){
    movie = new Movie();
    movie.setMovieName("Name1");
    movie.setMovieDescription("Desc1");
    movie.setCoverPhotoUrl("cov_url");
    movie.setReleaseDate(LocalDateTime.of(2018,10,5,6,0));
    movie.setDuration(200);
    Status status=new Status();
    status.setStatusName("RELEASED");
   statusService.acceptStatusDetails(status);
    movie.setStatus(status);
        movie.setTrailerUrl("T_url");


}


    //test acceptMovieDetails
  @Test
    public void testAcceptMovieDetails(){
       //check if it save the movie or not
     Movie savedMovie = movieService.acceptMovieDetails(movie);
      Assertions.assertNotNull(savedMovie);
      //Assertions.assertNotNull(savedMovie.getMovieId());
    }

    //test getMovieDetails
    @Test
    public void testGetMovieDetails(){

    }

    //test updateMovieDetails

    //test deleteMovie

}
