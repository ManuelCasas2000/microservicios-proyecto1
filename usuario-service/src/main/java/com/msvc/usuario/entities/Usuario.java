package com.msvc.usuario.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario { 

    @Id
    @Column(name="id")
    private String usuarioId;
    
    @Column(name="nombre", length= 20)
    private String nombre;
    
    @Column(name="email")
    private String email;

    @Column(name="informacion")
    private String informacion;

    @Transient // Esto indica que esta lista no está en BBDD
    private List<Calificacion> calificaciones = new ArrayList<>();
}
