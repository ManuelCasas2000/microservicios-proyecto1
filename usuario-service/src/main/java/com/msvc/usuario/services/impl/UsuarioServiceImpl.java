package com.msvc.usuario.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msvc.usuario.entities.Calificacion;
import com.msvc.usuario.entities.Hotel;
import com.msvc.usuario.entities.Usuario;
import com.msvc.usuario.exceptions.ResourceNotFoundException;
import com.msvc.usuario.external.services.HotelService;
import com.msvc.usuario.repositories.UsuarioRepository;
import com.msvc.usuario.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HotelService hotelService;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        String randomUsuario = UUID.randomUUID().toString();
        usuario.setUsuarioId(randomUsuario);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(String usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id: " + usuarioId));
            
        // Obtengo Calificaciones por usuario a través de Eureka
        // Calificacion[] calificacionDelUsuario = restTemplate.getForObject("http://localhost:8083/calificaciones/usuarios/" + usuario.getUsuarioId(),Calificacion[].class);
        Calificacion[] calificacionDelUsuario = restTemplate.getForObject("http://CALIFICACION-SERVICE/calificaciones/usuarios/" + usuario.getUsuarioId(),Calificacion[].class);
        logger.info("UsuarioServiceImpl -> getUsuario: " + calificacionDelUsuario);
        
        List<Calificacion> calificaciones = Arrays.stream(calificacionDelUsuario).collect(Collectors.toList());

        List<Calificacion> listaCalificaciones = calificaciones.stream().map(calificacion -> {
            System.out.println(calificacion.getHotelId());
            // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hoteles/" + calificacion.getHotelId(), Hotel.class);
            
            // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hoteles/" + calificacion.getHotelId(), Hotel.class);
            // Hotel hotel = forEntity.getBody();
            // logger.info("UsuarioServiceImpl -> getUsuario: Respuesta por código de estado: {}", forEntity.getStatusCode());
            
            Hotel hotel = hotelService.getHotel(calificacion.getHotelId());
            
            calificacion.setHotel(hotel);
            return calificacion;

        }).collect(Collectors.toList());

        usuario.setCalificaciones(listaCalificaciones);

        return usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id: " + usuarioId));
    }


}
