/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JOSUE GOMEZ
 */

public class ConexionBD implements IConexionBD{
  private final String PERSISTENCE_UNIT_NAME;
  
    /**
     *
     * @param PERSISTENCE_UNIT_NAME
     */
    public ConexionBD(String PERSISTENCE_UNIT_NAME) {
        this.PERSISTENCE_UNIT_NAME = PERSISTENCE_UNIT_NAME;
    }
      /**
     * Crea una conexión con la base de datos y devuelve un objeto EntityManager.
     * 
     * @return Un objeto EntityManager que representa la conexión con la base de datos.
     */
    @Override
    public EntityManager crearConexion() {
       EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }

}
