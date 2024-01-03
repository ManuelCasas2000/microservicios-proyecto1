package com.msvc.hotel.hotelservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.hotel.hotelservice.entities.Hotel;
import com.msvc.hotel.hotelservice.services.HotelService;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> guardarHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> listarHoteles() {
        return ResponseEntity.ok(hotelService.getAll());
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> obtenerHotel(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.get(hotelId));
    }

}
