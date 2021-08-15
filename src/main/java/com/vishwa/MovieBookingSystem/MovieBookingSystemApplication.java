package com.vishwa.MovieBookingSystem;

import com.sun.istack.NotNull;
import com.vishwa.MovieBookingSystem.Services.MovieService;
import com.vishwa.MovieBookingSystem.dao.MovieDao;
import com.vishwa.MovieBookingSystem.dao.StatusDao;
import com.vishwa.MovieBookingSystem.enteties.Movie;
import com.vishwa.MovieBookingSystem.enteties.Status;
import com.vishwa.MovieBookingSystem.exceptions.MovieDetailNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class  MovieBookingSystemApplication {

	public static void main(String[] args) {
		/*
		return type of  SpringApplication.run(MovieBookingSystemApplication.class, args);
		is application context
		 */

		ApplicationContext ctx= SpringApplication.run(MovieBookingSystemApplication.class, args);
		System.out.println("Hello spring");

	}

}
