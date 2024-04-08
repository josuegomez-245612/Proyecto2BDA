/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import javax.persistence.EntityManager;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface IConexionBD {
     
    /**
     * Crea una conexión con la base de datos y devuelve un objeto EntityManager.
     * 
     * @return Un objeto EntityManager que representa la conexión con la base de datos.
     */
    EntityManager crearConexion();
}
