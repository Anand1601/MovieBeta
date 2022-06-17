package com.MovieBeta.MovieBookingSystem.Services;

import com.MovieBeta.MovieBookingSystem.enteties.Status;
import com.MovieBeta.MovieBookingSystem.exceptions.StatusDetailsNotFoundException;

import java.util.List;

public interface StatusService {
    public Status acceptStatusDetails(Status status);
    public Status getStatusDetails(int id) throws StatusDetailsNotFoundException;
    public Status getStatusDetailsByStatusName(String statusName) throws  StatusDetailsNotFoundException;
    public void deleteStatus(int id) throws StatusDetailsNotFoundException;
    public List<Status> getAllStatusDetails();

}
