package com.msvc.calificacion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.calificacion.entities.Calificacion;
import com.msvc.calificacion.repositories.CalificacionRespository;
import com.msvc.calificacion.services.CalificacionService;

@Service
public class CalifcacionServiceImpl implements CalificacionService{

    @Autowired
    private CalificacionRespository calificacionRespository;

    @Override
    public Calificacion create(Calificacion calificacion) {
        return calificacionRespository.save(calificacion);
    }

    @Override
    public List<Calificacion> getCalificaciones() {
        return calificacionRespository.findAll();
    }

    @Override
    public List<Calificacion> getCalificacionByUsuarioId(String usuarioId) {
        return calificacionRespository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Calificacion> getCalificacionesByHotelId(String hotelId) {
        return calificacionRespository.findByHotelId(hotelId);
    }

}
