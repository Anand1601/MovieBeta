package com.MovieBeta.MovieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TheatreDTO {

    @JsonProperty("theatre_id")
    private int theatreId;

    @JsonProperty("theatre_name")
private String theatreName;

    @JsonProperty("ticket_price")
private float ticketPrice ;

    @JsonProperty("city_id")
private int cityId;

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
