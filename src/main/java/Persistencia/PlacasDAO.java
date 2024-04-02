/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Placa;
import Interfaces.IPlacasDAO;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JOSUE GOMEZ
 */
public class PlacasDAO implements IPlacasDAO{
private final EntityManager entityManager;

public PlacasDAO(EntityManager entityManager){
    this.entityManager = entityManager;
}


    @Override
    public boolean validarExistenciaPlaca(String seriePlacas) {
          String jpql = "SELECT p FROM Placa p WHERE p.seriePlacas = :serie";

        TypedQuery<Placa> query = entityManager.createQuery(jpql, Placa.class);
        query.setParameter("serie", seriePlacas);
        query.setMaxResults(1);

        List<Placa> placas = query.getResultList();
        return !placas.isEmpty();
    }

    @Override
    public void DeshabilitarPlacaAuto(Placa placa) {
          entityManager.getTransaction().begin();
        
        placa.setFechaRecepcion(new GregorianCalendar());
        entityManager.persist(placa);
        
        entityManager.getTransaction().commit();
    }

    @Override
    public Placa obtenerPlaca(String seriePlacas) {
        String jpql = "SELECT p FROM Placa p WHERE p.seriePlacas = :serie";

        TypedQuery<Placa> query = entityManager.createQuery(jpql, Placa.class);
        query.setParameter("serie", seriePlacas);
        query.setMaxResults(1);
        
        List<Placa> lista = query.getResultList();
        
        return lista.isEmpty() ? null : lista.get(0);
    }
    
}
