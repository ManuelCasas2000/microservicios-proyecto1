package com.msvc.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msvc.usuario.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String>{

}
