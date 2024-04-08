/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidades.Placa;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface IPlacasDAO {
   
    /**
     * Valida la existencia de una placa en el sistema.
     * 
     * @param seriePlacas La serie de placas a validar.
     * @return true si la placa existe en el sistema, false en caso contrario.
     */
    boolean validarExistenciaPlaca(String seriePlacas);
       
    /**
     * Deshabilita una placa de auto en el sistema.
     * 
     * @param placa La placa de auto a deshabilitar.
     */
    void DeshabilitarPlacaAuto(Placa placa);
    
   /**
     * Obtiene una placa de auto por su serie.
     * 
     * @param seriePlacas La serie de placas a buscar.
     * @return La placa de auto correspondiente a la serie especificada.
     */
    Placa obtenerPlaca(String seriePlacas);
}
