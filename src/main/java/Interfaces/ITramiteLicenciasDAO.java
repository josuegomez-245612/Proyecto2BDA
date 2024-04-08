/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidades.TramiteLicencia;
import Utilidades.ParametrosConsultaTramites;
import Utilidades.TramitesDTO;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface ITramiteLicenciasDAO 
{
     /**
     * Crea un nuevo trámite de licencia.
     * 
     * @param tramite El trámite de licencia a crear.
     */
    void crearTramite(TramiteLicencia tramite);
       
    /**
     * Carga los trámites de licencia asociados a una persona por su identificador.
     * 
     * @param idPersona El identificador de la persona.
     * @return Una lista de objetos TramitesDTO que representan los trámites de licencia de la persona.
     */
    List<TramitesDTO> cargarTramites(Long idPersona);
       
    /**
     * Carga trámites de licencia utilizando parámetros específicos.
     * 
     * @param parametros Los parámetros de consulta para cargar los trámites.
     * @return Una lista de objetos TramitesDTO que cumplen con los criterios de búsqueda.
     */
    List<TramitesDTO> cargarTramites(ParametrosConsultaTramites parametros);
      /**
     * Carga todos los trámites de licencia disponibles en el sistema.
     * 
     * @return Una lista de objetos TramitesDTO que representan todos los trámites de licencia disponibles.
     */
    List<TramitesDTO> cargarTodosTramites();
    
    List<TramitesDTO> cargarTramitesByNombre(String nombreCompleto);
    
    List<TramitesDTO> cargarTramitesByNombreInPeriod(String nombreCompleto, Calendar periodoInicio, Calendar periodoFin);
}
