package com.msvc.hotel.hotelservice.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sataffs")
public class StaffController {

    public ResponseEntity<List<String>> listarStaffs() {
        List<String> staffs = Arrays.asList("Manuel","Marta","Eva","Natalia");
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }
}
