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
public interface ICargarVehiculo {
   
    /**
     * Carga la información de un vehículo específico identificado por sus placas.
     * 
     * @param placas Las placas del vehículo a cargar.
     * @return Una lista de objetos VehiculosPlacasDTO que representan la información del vehículo cargado.
     */
      public List<VehiculosPlacasDTO> cargarVehiculo(String placas);
}
