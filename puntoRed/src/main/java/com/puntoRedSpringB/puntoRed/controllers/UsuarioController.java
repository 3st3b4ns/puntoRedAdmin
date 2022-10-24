package com.puntoRedSpringB.puntoRed.controllers;

import com.puntoRedSpringB.puntoRed.dao.UsuarioDao;
import com.puntoRedSpringB.puntoRed.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UsuarioController {

    @Value("{sping.external.service.base-url}")
    private String basePath;


    private final RestTemplate restTemplate;

    @Autowired
    public UsuarioController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuario() {
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

       usuarioDao.registrar(usuario);
    }


    @RequestMapping(value = "editar")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setUsername("lucas");
        usuario.setApellido("lucas");
        usuario.setEmail("lucas");
        usuario.setTelefono("lucas");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable long id) {
       usuarioDao.eliminar(id);
    }

}
