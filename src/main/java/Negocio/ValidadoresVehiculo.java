/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Interfaces.IConexionBD;
import Persistencia.AutoDAO;
import Persistencia.PlacasDAO;
import Persistencia.TramitePlacasDAO;
import Utilidades.VehiculosPlacasDTO;
import interfacesNegocio.IValidadoresVehiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSUE GOMEZ
 */
public class ValidadoresVehiculo implements IValidadoresVehiculo{
 private final EntityManager entityManager;
IConexionBD conexion;
  AutoDAO aDAO;

    public ValidadoresVehiculo(EntityManager entityManager, IConexionBD conexion) {
        this.entityManager = entityManager;
        this.conexion = conexion;
        this.aDAO = new AutoDAO(conexion.crearConexion());
    }

    @Override
    public List<VehiculosPlacasDTO> cargarTodosLosVehiculos() {
      if(aDAO.cargarTodosLosVehiculos() == null){
          JOptionPane.showMessageDialog(null, "No tiene vehiculos existentes.");
      }else{
         return aDAO.cargarTodosLosVehiculos();
      }
     return null;
    }

    @Override
    public List<VehiculosPlacasDTO> cargarVehiculo(String placas) {
        if(aDAO.cargarVehiculo(placas)==null){
            JOptionPane.showMessageDialog(null, "El vehiculo no se encontró.");
        }else{
            return aDAO.cargarVehiculo(placas);
        }
     return null;
    }
    
}
