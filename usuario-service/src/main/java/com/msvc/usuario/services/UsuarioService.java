package com.msvc.usuario.services;

import java.util.List;

import com.msvc.usuario.entities.Usuario;

public interface UsuarioService {

    Usuario saveUsuario(Usuario usuario);
    List<Usuario> getAllUsuarios();
    Usuario getUsuario(String usuarioId);

}
