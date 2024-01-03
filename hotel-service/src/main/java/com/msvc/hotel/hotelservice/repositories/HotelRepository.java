package com.msvc.hotel.hotelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msvc.hotel.hotelservice.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
