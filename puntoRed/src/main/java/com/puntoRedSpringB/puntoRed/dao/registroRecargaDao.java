package com.puntoRedSpringB.puntoRed.dao;

import com.puntoRedSpringB.puntoRed.models.RegistroRecarga;
import com.puntoRedSpringB.puntoRed.models.Usuario;

import java.util.List;

public interface registroRecargaDao {


    List<RegistroRecarga> getRegistroRecarga();

    void registrar(RegistroRecarga registroRecarga);
}
