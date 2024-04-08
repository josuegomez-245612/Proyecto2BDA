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
    
    void crearTramite(TramiteLicencia tramite);
    
    List<TramitesDTO> cargarTramites(Long idPersona);
     
    List<TramitesDTO> cargarTramites(ParametrosConsultaTramites parametros);
      
    List<TramitesDTO> cargarTodosTramites();
    
    List<TramitesDTO> cargarTramitesByNombre(String nombreCompleto);
    
    List<TramitesDTO> cargarTramitesByNombreInPeriod(String nombreCompleto, Calendar periodoInicio, Calendar periodoFin);
}
