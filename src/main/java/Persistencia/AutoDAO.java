/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Vehiculo;
import Interfaces.IAutoDAO;
import Utilidades.VehiculosPlacasDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JOSUE GOMEZ
 */
public class AutoDAO implements IAutoDAO {
 
    private final EntityManager entityManager;

    public AutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public AutoDAO() {
        this.entityManager = null;
    }

     /**
     * Carga todos los vehículos disponibles en el sistema.
     * 
     * @return Una lista de objetos VehiculosPlacasDTO que contienen información de cada vehículo.
     */
    @Override
    public List<VehiculosPlacasDTO> cargarTodosLosVehiculos() {
        List<VehiculosPlacasDTO> lista = new ArrayList<>();
        String jpql = "SELECT p.seriePlacas, a FROM TramitePlacas tp "
                + "INNER JOIN tp.placa p "
                + "INNER JOIN p.vehiculo a "
                + "WHERE p.fechaRecepcion IS NULL";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList) {
            lista.add(new VehiculosPlacasDTO((String)objects[0], (Vehiculo)objects[1]));
        }
        return lista;
    }
    
    /**
     * Este método regresa una lista de autos con su placa más reciente a partir
     * de una serie de placas.
     * @param placas Representa la serie de placas a ser utilizada para la búsqueda.
     * @return Regresa una lista de autos con su placa más reciente.
     */
    @Override
    public List<VehiculosPlacasDTO> cargarVehiculo(String placas) {
        List<VehiculosPlacasDTO> lista = new ArrayList<>();
        String jpql = "SELECT p.seriePlacas, a FROM TramitePlacas tp "
                + "INNER JOIN tp.placa p "
                + "INNER JOIN p.vehiculo a "
                + "WHERE p.fechaRecepcion IS NULL AND p.seriePlacas = :placa";
        
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("placa", placas);
        query.setMaxResults(1);
        
        List<Object[]> resultado = query.getResultList();
        
        for (Object[] object : resultado) {
            lista.add(new VehiculosPlacasDTO((String)object[0], (Vehiculo)object[1]));
        }
        
        return lista;
    }
    
    
}
