package com.MovieBeta.MovieBookingSystem;

import com.MovieBeta.MovieBookingSystem.Services.InitService;
import com.MovieBeta.MovieBookingSystem.Services.StatusService;
import com.MovieBeta.MovieBookingSystem.Services.impl.StatusServiceImpl;
import com.MovieBeta.MovieBookingSystem.enteties.Status;
import com.MovieBeta.MovieBookingSystem.exceptions.StatusDetailsNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class  MovieBookingSystemApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieBookingSystemApplication.class);

	public static void main(String[] args) throws StatusDetailsNotFoundException {


		ApplicationContext ctx= SpringApplication.run(MovieBookingSystemApplication.class, args);


		System.out.println("hello spring");


	}




	@Bean
	CommandLineRunner init(InitService initService){
		return args -> {
			initService.init();
		};
	}


	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}


}
