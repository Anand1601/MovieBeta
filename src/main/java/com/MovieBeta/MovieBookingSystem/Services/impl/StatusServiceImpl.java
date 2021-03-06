package com.MovieBeta.MovieBookingSystem.Services.impl;

import com.MovieBeta.MovieBookingSystem.Services.StatusService;
import com.MovieBeta.MovieBookingSystem.daos.StatusDao;
import com.MovieBeta.MovieBookingSystem.enteties.Status;
import com.MovieBeta.MovieBookingSystem.exceptions.StatusDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    public StatusDao statusDao;

    @Override
    public Status acceptStatusDetails(Status status) {
        return statusDao.save(status);
    }

    @Override
    public Status getStatusDetails(int id) throws StatusDetailsNotFoundException {
        return statusDao.findById(id).orElseThrow(()->new StatusDetailsNotFoundException("status details not found with the id:"+id));
    }

    @Override
    public Status getStatusDetailsByStatusName(String statusName) throws StatusDetailsNotFoundException {
        Status status = statusDao.findByStatusName(statusName);
if(status== null) {
    throw new StatusDetailsNotFoundException("Status not found for stausName:"+statusName);
}
        return status;
    }

    @Override
    public void deleteStatus(int id) throws StatusDetailsNotFoundException {
        Status status=getStatusDetails(id);
        statusDao.delete(status);
    }

    @Override
    public List<Status> getAllStatusDetails() {
        return statusDao.findAll();
    }
}
