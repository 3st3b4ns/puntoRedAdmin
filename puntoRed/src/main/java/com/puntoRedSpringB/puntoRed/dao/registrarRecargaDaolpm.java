package com.puntoRedSpringB.puntoRed.dao;

import com.puntoRedSpringB.puntoRed.models.RegistroRecarga;
import com.puntoRedSpringB.puntoRed.models.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class registrarRecargaDaolpm implements registroRecargaDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<RegistroRecarga> getRegistroRecarga() {
        String query = "FROM RegistroRecarga";
        System.out.println(query);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(RegistroRecarga registroRecarga) {
        entityManager.merge(registroRecarga);
    }

}
