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
    public void crearTramite(TramiteLicencia tramite);
       
    /**
     * Carga los trámites de licencia asociados a una persona por su identificador.
     * 
     * @param idPersona El identificador de la persona.
     * @return Una lista de objetos TramitesDTO que representan los trámites de licencia de la persona.
     */
    public List<TramitesDTO> cargarTramites(Long idPersona);
       
    /**
     * Carga trámites de licencia utilizando parámetros específicos.
     * 
     * @param parametros Los parámetros de consulta para cargar los trámites.
     * @return Una lista de objetos TramitesDTO que cumplen con los criterios de búsqueda.
     */
    public List<TramitesDTO> cargarTramites(ParametrosConsultaTramites parametros);
      /**
     * Carga todos los trámites de licencia disponibles en el sistema.
     * 
     * @return Una lista de objetos TramitesDTO que representan todos los trámites de licencia disponibles.
     */
    public List<TramitesDTO> cargarTodosTramites();
    
    /**
     * Carga trámites de licencia por nombre de una persona durante un periodo de tiempo.
     * 
     * @param nombreCompleto Nombre completo de la persona asociada con los tramites a cargar.
     * @return Una lista de objetos TramitesDTO que cumplen con los criterios de búsqueda.
     */
    public List<TramitesDTO> cargarTramitesByNombre(String nombreCompleto);
    
    /**
     * Carga trámites de licencia durante un periodo de tiempo.
     * 
     * @param periodoInicio  Periodo minimo de tramites a cargar.
     * @param periodoFin Periodo maximo de tramites a cargar.
     * @return Una lista de objetos TramitesDTO que cumplen con los criterios de búsqueda.
     */
    public List<TramitesDTO> cargarTramitesInPeriod(Calendar periodoInicio, Calendar periodoFin);
    
    /**
     * Carga trámites de licencia por nombre de una persona durante un periodo de tiempo.
     * 
     * @param nombreCompleto Nombre completo de la persona asociada con los tramites a cargar.
     * @param periodoInicio  Periodo minimo de tramites a cargar.
     * @param periodoFin Periodo maximo de tramites a cargar.
     * @return Una lista de objetos TramitesDTO que cumplen con los criterios de búsqueda.
     */
    public List<TramitesDTO> cargarTramitesByNombreInPeriod(String nombreCompleto, Calendar periodoInicio, Calendar periodoFin);
}
