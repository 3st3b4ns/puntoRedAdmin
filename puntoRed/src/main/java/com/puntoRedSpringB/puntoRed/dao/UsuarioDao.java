package com.puntoRedSpringB.puntoRed.dao;

import com.puntoRedSpringB.puntoRed.models.Recarga;
import com.puntoRedSpringB.puntoRed.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(long id);

    void registrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);
}
