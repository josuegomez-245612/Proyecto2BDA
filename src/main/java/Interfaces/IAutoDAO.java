/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Utilidades.VehiculosPlacasDTO;
import java.util.List;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface IAutoDAO {
   
    /**
     * Carga todos los vehículos disponibles en el sistema.
     * 
     * @return Una lista de objetos VehiculosPlacasDTO que contienen información de cada vehículo.
     */
    List<VehiculosPlacasDTO> cargarTodosLosVehiculos();

    /**
     * Este método regresa una lista de autos con su placa más reciente a partir
     * de una serie de placas.
     * @param placas Representa la serie de placas a ser utilizada para la búsqueda.
     * @return Regresa una lista de autos con su placa más reciente.
     */
    List<VehiculosPlacasDTO> cargarVehiculo(String placas);
}
