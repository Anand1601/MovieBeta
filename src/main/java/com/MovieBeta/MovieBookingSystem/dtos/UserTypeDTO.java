package com.MovieBeta.MovieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserTypeDTO {

    @JsonProperty("user_type_id")
 private int userTypeId;
    @JsonProperty("user_type_name")
 private String userTypeName;
}
