package com.MovieBeta.MovieBookingSystem.Services;

import com.MovieBeta.MovieBookingSystem.enteties.User;
import com.MovieBeta.MovieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.MovieBeta.MovieBookingSystem.exceptions.UserTypeDetailsNotFoundException;

public interface UserService {

     User acceptUserDetails(User user) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;


    public User getUserDetails(int id )throws UserDetailsNotFoundException;


    public User getUserDetailsByUserName(String username)throws UserDetailsNotFoundException;

    public User updateUserDetails(int id ,User user)throws UserDetailsNotFoundException,UserNameAlreadyExistsException,UserTypeDetailsNotFoundException;
    public void deleteUser(int id) throws UserDetailsNotFoundException;
}
