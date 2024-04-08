/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidades.Placa;
import Utilidades.ParametrosConsultaTramites;
import Utilidades.TramitesDTO;
import java.util.List;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface ITramitePlacasDAO {
   
    /**
     * Crea un nuevo trámite de placas de vehículo.
     * 
     * @param placa La placa de vehículo para la cual se realizará el trámite.
     */
    void nuevoTramite(Placa placa);
    
      /**
     * Carga los trámites de placas de vehículo asociados a una persona por su identificador.
     * 
     * @param idPersona El identificador de la persona.
     * @return Una lista de objetos TramitesDTO que representan los trámites de placas de vehículo de la persona.
     */
    List<TramitesDTO> cargarTramites(Long idPersona);
    
    /**
     * Carga trámites de placas de vehículo utilizando parámetros específicos.
     * 
     * @param parametros Los parámetros de consulta para cargar los trámites.
     * @return Una lista de objetos TramitesDTO que cumplen con los criterios de búsqueda.
     */
    List<TramitesDTO> cargarTramites(ParametrosConsultaTramites parametros);
    
     /**
     * Carga todos los trámites de placas de vehículo disponibles en el sistema.
     * 
     * @return Una lista de objetos TramitesDTO que representan todos los trámites de placas de vehículo disponibles.
     */
    List<TramitesDTO> cargarTodosTramites();
}
