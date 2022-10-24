package com.puntoRedSpringB.puntoRed.controllers;

import com.puntoRedSpringB.puntoRed.dao.registroRecargaDao;
import com.puntoRedSpringB.puntoRed.models.RegistroRecarga;
import com.puntoRedSpringB.puntoRed.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegistroRecargaController
{

    @Autowired
    private registroRecargaDao registroRecargaDao;

    @RequestMapping(value = "api/registrorecarga", method = RequestMethod.GET)
    public List<RegistroRecarga> getRegistroRecarga() {
        System.out.println("si entra");
        return registroRecargaDao.getRegistroRecarga();
    }

    @RequestMapping(value = "api/registrorecarga", method = RequestMethod.POST)
    public void registrarRecarga(@RequestBody RegistroRecarga registroRecarga) {
         registroRecargaDao.registrar(registroRecarga);
    }

    @RequestMapping(value = "editarR")
    public RegistroRecarga editarR() {
        RegistroRecarga registroRecarga = new RegistroRecarga();
        registroRecarga.setPhonenumber("12313");
        registroRecarga.setSupplier("4165");
        registroRecarga.setTransaccion("lucas");
        registroRecarga.setAmount("165");
        return registroRecarga;
    }

}
