package com.MovieBeta.MovieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusDTO {

    @JsonProperty("status_id")
    private int statusId;

    @JsonProperty("status_name")
    private String statusName;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
