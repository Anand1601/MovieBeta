package com.MovieBeta.MovieBookingSystem.controllers;

import com.MovieBeta.MovieBookingSystem.Services.MovieService;
import com.MovieBeta.MovieBookingSystem.Services.StatusService;
import com.MovieBeta.MovieBookingSystem.dtos.MovieDTO;
import com.MovieBeta.MovieBookingSystem.enteties.Movie;
import com.MovieBeta.MovieBookingSystem.enteties.Status;
import com.MovieBeta.MovieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.StatusDetailsNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MovieService movieService;
    @Autowired
    private StatusService statusService;


    /*
     * Get all movies
     * GET 127.0.0.1.:8081/mbs/v1/movies
     * */
    @GetMapping
    public ResponseEntity getAllMovies() {
        List<Movie> movies = movieService.getAllMoviesDetails();

        List<MovieDTO> movieDTOS = new ArrayList<>();

        for (Movie movie : movies) {
            movieDTOS.add(modelMapper.map(movie,MovieDTO.class));
        }

        return new ResponseEntity(movieDTOS, HttpStatus.OK);

    }

    /*
     * Get Movie on the base of id
     * GET 127.0.0.1:8081/mbs/v1/movies/id
     * */
    @GetMapping("/{Id}")
    public ResponseEntity getMovieBasedOnId(@PathVariable(name = "Id") int movieId) throws MovieDetailsNotFoundException {
        Movie movie = movieService.getMovieDetails(movieId);
        MovieDTO movieDTO = convertToMovieDTO(movie);
        return new ResponseEntity(movieDTO, HttpStatus.OK);
    }

    /*
     * Creating new movie
     *POST 127.0.0.1:8081/mbs/v1/movies
     * */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMovie(@RequestBody MovieDTO movieDTO) throws StatusDetailsNotFoundException {

        Movie movie = modelMapper.map(movieDTO, Movie.class);
        Status status = statusService.getStatusDetails(movieDTO.getStatus_id());
        movie.setStatus(status);
        Movie savedMovie = movieService.acceptMovieDetails(movie);
        MovieDTO responseBody = modelMapper.map(savedMovie, MovieDTO.class);
        return new ResponseEntity(responseBody, HttpStatus.CREATED);
    }

    /*
     * to update an already existing movie
     * PUT 127.0.0.1:8081/mbs/v1/movies/{movieId}
     * */
    @PutMapping(value = "/{movieId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMovieDetails(@RequestBody MovieDTO movieDTO,
                                             @PathVariable(name = "movieId") int movieId) throws MovieDetailsNotFoundException {
        Movie storedMovie = movieService.getMovieDetails(movieId);

        Movie movieTOBeUpdated = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieService.updateMovieDetails(movieId, movieTOBeUpdated);

        return new ResponseEntity(modelMapper.map(savedMovie, MovieDTO.class), HttpStatus.ACCEPTED);


    }

    /*
     * to delete existing movie
     * DELETE 127.0.0.1:8081/mbs/v1/movies/{movieId}
     * */
    @DeleteMapping(value = "/{movieId}")
    public ResponseEntity deleteMovie(@PathVariable(name = "movieId") int id) throws MovieDetailsNotFoundException {
        movieService.deleteMovie(id);
        return new ResponseEntity("DELETED", HttpStatus.OK);
    }


    private MovieDTO convertToMovieDTO(Movie movie) {
        return modelMapper.map(movie, MovieDTO.class);

    }


}

