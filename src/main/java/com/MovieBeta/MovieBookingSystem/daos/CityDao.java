package com.MovieBeta.MovieBookingSystem.daos;

import com.MovieBeta.MovieBookingSystem.enteties.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
  public City findByCityName(String cityName);

}
