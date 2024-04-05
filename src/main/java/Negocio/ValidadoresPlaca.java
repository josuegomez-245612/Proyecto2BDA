/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Placa;
import Entidades.Vehiculo;
import Interfaces.IConexionBD;
import Persistencia.ConexionBD;
import Persistencia.PlacasDAO;
import Persistencia.TramitePlacasDAO;
import interfacesNegocio.IRegistrarPlacas;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSUE GOMEZ
 */
public class ValidadoresPlaca implements IRegistrarPlacas{
    private final EntityManager entityManager;
IConexionBD conexion;
  TramitePlacasDAO placas;
  PlacasDAO placa;

    public ValidadoresPlaca(IConexionBD conexion,EntityManager entityManager) {
        this.entityManager = entityManager;
        this.conexion = conexion;
        placas = new TramitePlacasDAO(conexion.crearConexion());
        placa = new PlacasDAO(conexion.crearConexion());
        
    }
  
    @Override
    public void RegistrarPlacaNuevo( Placa p,Vehiculo v) {
   if(placa.validarExistenciaPlaca(p.getSeriePlacas())== true){
     JOptionPane.showMessageDialog(null, "ERROR: Este auto ya está registrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
   }else if(placa.validarExistenciaPlaca(p.getSeriePlacas())== false){
       placas.nuevoTramite(p);
   }
   }

  
}
