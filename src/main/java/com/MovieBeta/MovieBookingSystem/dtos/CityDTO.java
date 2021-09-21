package com.MovieBeta.MovieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityDTO {

    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("city_id")
    private int cityId;

}
