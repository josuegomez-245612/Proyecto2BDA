/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesNegocio;

import Entidades.Placa;
import Entidades.Vehiculo;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface IRegistrarPlacas extends IValidarExistenciaPlaca,IObtenerPlacas,IDeshabilitarPlacasAuto{
    
    
    public void RegistrarPlacaNuevo(Placa p, Vehiculo v);
    
    
}
