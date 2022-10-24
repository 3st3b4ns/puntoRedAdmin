package com.puntoRedSpringB.puntoRed.controllers;


import com.puntoRedSpringB.puntoRed.dao.UsuarioDao;
import com.puntoRedSpringB.puntoRed.dao.registroRecargaDao;
import com.puntoRedSpringB.puntoRed.models.Recarga;
import com.puntoRedSpringB.puntoRed.models.RegistroRecarga;
import com.puntoRedSpringB.puntoRed.models.Usuario;
import com.puntoRedSpringB.puntoRed.service.UserService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/recarga", method = RequestMethod.POST)
public class RecargaController {

private final UserService userService;


    @Autowired
    private UsuarioDao usuarioDao;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public String saveRecarga(@RequestBody final Usuario user, @RequestHeader Map<String, String> mapValues){
         System.out.println(mapValues);

             if (usuarioDao.verificarCredenciales(user)) {
                 return "ok";
             }
        return "success";
    }

}
