package com.MovieBeta.MovieBookingSystem.daos;

import com.MovieBeta.MovieBookingSystem.enteties.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking,Integer> {


}
