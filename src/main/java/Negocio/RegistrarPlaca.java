/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Placa;
import Entidades.Vehiculo;
import Persistencia.PlacasDAO;
import Persistencia.TramitePlacasDAO;
import interfacesNegocio.IRegistrarPlacas;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSUE GOMEZ
 */
public class RegistrarPlaca implements IRegistrarPlacas{

  
    @Override
    public void RegistrarPlacaNuevo(TramitePlacasDAO placas ,PlacasDAO placa, Placa p,Vehiculo v) {
   if(placa.validarExistenciaPlaca(p.getSeriePlacas())== true){
     JOptionPane.showMessageDialog(null, "ERROR: Este auto ya está registrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
   }else if(placa.validarExistenciaPlaca(p.getSeriePlacas())== false){
       placas.nuevoTramite(p);
   }
   }

  
}
