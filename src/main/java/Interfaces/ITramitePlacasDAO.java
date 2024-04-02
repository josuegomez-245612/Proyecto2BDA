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
   
    void nuevoTramite(Placa placa);
    
  
    List<TramitesDTO> cargarTramites(Long idPersona);
    
   
    List<TramitesDTO> cargarTramites(ParametrosConsultaTramites parametros);
    
    
    List<TramitesDTO> cargarTodosTramites();
}
