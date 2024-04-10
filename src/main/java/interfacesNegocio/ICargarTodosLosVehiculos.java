/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesNegocio;

import Utilidades.VehiculosPlacasDTO;
import java.util.List;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface ICargarTodosLosVehiculos {
       /**
     * Carga la información de todos los vehículos disponibles.
     * 
     * @return Una lista de objetos VehiculosPlacasDTO que representan la información de todos los vehículos cargados.
     */
      public List<VehiculosPlacasDTO> cargarTodosLosVehiculos();
}
