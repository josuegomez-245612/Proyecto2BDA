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
   
    boolean validarExistenciaPlaca(String seriePlacas);
    
    void DeshabilitarPlacaAuto(Placa placa);
    
   
    Placa obtenerPlaca(String seriePlacas);
}
