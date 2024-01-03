package com.msvc.calificacion.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msvc.calificacion.entities.Calificacion;

public interface CalificacionRespository extends MongoRepository<Calificacion,String>{

    List<Calificacion> findByUsuarioId(String usuarioId);
    List<Calificacion> findByHotelId(String hotelId);

}
