package com.msvc.calificacion.services;

import java.util.List;


import com.msvc.calificacion.entities.Calificacion;


public interface CalificacionService {

    Calificacion create(Calificacion calificacion);
    List<Calificacion> getCalificaciones();
    List<Calificacion> getCalificacionByUsuarioId(String usuarioId);
    List<Calificacion> getCalificacionesByHotelId(String hotelId);
}
