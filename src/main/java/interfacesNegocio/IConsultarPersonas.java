/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesNegocio;

import Entidades.Persona;
import Utilidades.ParametrosBusquedaPersonas;
import java.util.List;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface IConsultarPersonas {
    
    /**
     *
     * @param parametros
     * @return
     */
    public List<Persona> consultarPersonas(ParametrosBusquedaPersonas parametros);
}
