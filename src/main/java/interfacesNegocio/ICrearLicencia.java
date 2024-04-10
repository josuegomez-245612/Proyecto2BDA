/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesNegocio;

import Entidades.Persona;
import Persistencia.TramiteLicenciasDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface ICrearLicencia {
    
    /**
     *
     * @param persona
     * @param vigenciaLicencia
     * @param costoLicencia
     */
    public void crearLicencia(Persona persona,Integer vigenciaLicencia,Integer costoLicencia);
}
