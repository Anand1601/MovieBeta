package com.MovieBeta.MovieBookingSystem.dao;

import com.MovieBeta.MovieBookingSystem.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {
 public Optional<User> findByUserName(String username);
}
