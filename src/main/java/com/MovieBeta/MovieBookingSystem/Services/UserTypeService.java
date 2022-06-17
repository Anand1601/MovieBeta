package com.MovieBeta.MovieBookingSystem.Services;

import com.MovieBeta.MovieBookingSystem.enteties.UserType;
import com.MovieBeta.MovieBookingSystem.exceptions.UserTypeDetailsNotFoundException;

import java.util.List;

public interface UserTypeService {
    public UserType acceptUserType(UserType userType);
    public UserType getUserTypeDetails(int id) throws UserTypeDetailsNotFoundException;
    public UserType getUserTypeDetailsFromUserTypeName(String userType) throws UserTypeDetailsNotFoundException;
    public void deleteUserType(int id) throws  UserTypeDetailsNotFoundException;
    public List<UserType> getAllUserTypeDetails();
}
