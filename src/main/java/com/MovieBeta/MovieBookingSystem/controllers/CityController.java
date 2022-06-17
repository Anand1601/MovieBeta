package com.MovieBeta.MovieBookingSystem.controllers;

import com.MovieBeta.MovieBookingSystem.Services.CityService;
import com.MovieBeta.MovieBookingSystem.dtos.CityDTO;
import com.MovieBeta.MovieBookingSystem.enteties.City;
import com.MovieBeta.MovieBookingSystem.exceptions.CityDetailsNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cities")
public class CityController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CityController.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CityService cityService;


    @PostMapping
    /*
     * add a new city to DB
     * POST 127.0.0.1.:8081/mbs/v1/cities
     * */
    public ResponseEntity addCity(@RequestBody CityDTO cityDTO ){
        City city =  cityService.acceptCityDetails(modelMapper.map(cityDTO,City.class));
        CityDTO response = modelMapper.map(city, CityDTO.class);

return new ResponseEntity(response, HttpStatus.CREATED);
    }

    /*
     * add multiple cities to DB
     * POST 127.0.0.1.:8081/mbs/v1/cities/list
     * */
    @PostMapping("/list")
public ResponseEntity acceptMultipleCityDetails(@RequestBody List<CityDTO> cityDTOList){
        List<CityDTO> response = new ArrayList<>();

        for (CityDTO city:cityDTOList)
    {
    City cityResponse = cityService.acceptCityDetails(modelMapper.map(city,City.class));
    response.add(modelMapper.map(cityResponse,CityDTO.class));
    }

        return new ResponseEntity(response,HttpStatus.CREATED);
}

    /*
    * update a city Details
    * PUT 127.0.0.1.:8081/mbs/v1/cities
    * */
    @PutMapping("/{city_id}")
    public ResponseEntity updateCityDetails(@RequestBody CityDTO cityDTO, @PathVariable(name="city_id") int city_id) throws CityDetailsNotFoundException {
        City cityRequest= modelMapper.map(cityDTO, City.class);
        City cityResponse = cityService.updateCityDetails(city_id,cityRequest);
        return new ResponseEntity(modelMapper.map(cityResponse,CityDTO.class),HttpStatus.OK);
    }



    /*
    * get city details base on city id
    * GET 127.0.0.1.:8081/mbs/v1/cities/{city_id}
    * */
   @GetMapping("/{city_id}")
    public ResponseEntity getCityDetailsById(@PathVariable("city_id") int cityId) throws CityDetailsNotFoundException {
       City savedCity = cityService.getCityDetails(cityId);
      CityDTO cityResponse = modelMapper.map(savedCity,CityDTO.class);
      return new ResponseEntity(cityResponse,HttpStatus.OK);


   }


    /*
    * delete a city by given id
    * DELETE 127.0.0.1.:8081/mbs/v1/cities/{city_id}
    * */
    @DeleteMapping("/{city_id}")
    public ResponseEntity deleteCityById(@PathVariable("city_id") int cityId) throws CityDetailsNotFoundException {
        cityService.deleteCity(cityId);
        return new ResponseEntity("DELETED",HttpStatus.OK);
    }
    

  /*
    * get all cities
    * Get 127.0.0.1.:8081/mbs/v1/cities
    * */
    @GetMapping
    public ResponseEntity getAllCity(){
        List<City> cities = cityService.getAllCityDetails();
        List<CityDTO> response = new ArrayList<>();

        for(City city:cities) {
           CityDTO cityDTO = modelMapper.map(city,CityDTO.class);
           response.add(cityDTO);

        }
        return new ResponseEntity(response,HttpStatus.OK);
    }

}
