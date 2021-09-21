package com.MovieBeta.MovieBookingSystem.controllers;

import com.MovieBeta.MovieBookingSystem.Services.CityService;
import com.MovieBeta.MovieBookingSystem.Services.impl.CityServiceImpl;
import com.MovieBeta.MovieBookingSystem.dtos.CityDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CityController.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CityService cityService;




}
