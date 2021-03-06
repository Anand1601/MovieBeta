package com.MovieBeta.MovieBookingSystem.Services.impl;

import com.MovieBeta.MovieBookingSystem.Services.CityService;
import com.MovieBeta.MovieBookingSystem.daos.CityDao;
import com.MovieBeta.MovieBookingSystem.enteties.City;
import com.MovieBeta.MovieBookingSystem.exceptions.CityDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityServiceImpl implements CityService {


    @Autowired
    CityDao cityDao;

    @Override
    public City acceptCityDetails(City city) {
        return cityDao.save(city);
    }

    @Override
    public List<City> acceptMultipleCityDetails(List<City> cities) {
        return cityDao.saveAll(cities);
    }

    @Override
    public City updateCityDetails(int id, City city) throws CityDetailsNotFoundException {
        City savedCity = getCityDetails(id);
        savedCity.setCityName(city.getCityName());
        acceptCityDetails(savedCity);
        return savedCity;
    }

    @Override
    public City getCityDetails(int id) throws CityDetailsNotFoundException {
        return cityDao.findById(id).orElseThrow(()->new CityDetailsNotFoundException("City not found by id:"+id));
    }

    @Override
    public City getCityDetailsByCityName(String cityName) throws CityDetailsNotFoundException {
City savedCity= cityDao.findByCityName(cityName);
if(savedCity==null)
{
    throw new CityDetailsNotFoundException("city not found for cityName:"+cityName);
}
return savedCity;
    }

    @Override
    public void deleteCity(int id) throws CityDetailsNotFoundException {
        City savedCity=getCityDetails(id);
cityDao.delete(savedCity);

    }

    @Override
    public List<City> getAllCityDetails() {
        return cityDao.findAll();
    }
}
