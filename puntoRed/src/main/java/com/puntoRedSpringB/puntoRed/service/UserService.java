package com.puntoRedSpringB.puntoRed.service;

import com.puntoRedSpringB.puntoRed.models.Recarga;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("{sping.external.service.base-url}")
    private String basePath;

    private final RestTemplate restTemplate;


    public void saveRecarga(Recarga user){
        restTemplate.postForObject(basePath, user, Recarga.class);

    }
}
