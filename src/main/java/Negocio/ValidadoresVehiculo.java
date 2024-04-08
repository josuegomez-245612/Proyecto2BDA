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
 * Esta clase implementa la interfaz IValidadoresVehiculo y proporciona métodos
 * para validar y manipular datos de vehículos.
 */
public class ValidadoresVehiculo implements IValidadoresVehiculo {

    /**
     * El administrador de entidades que gestiona las operaciones de
     * persistencia.
     */
    private final EntityManager entityManager;
    /**
     * La instancia de la interfaz IConexionBD para establecer la conexión con
     * la base de datos.
     */
    IConexionBD conexion;
    /**
     * El objeto AutoDAO utilizado para acceder a los datos de los vehículos en
     * la base de datos.
     */
    AutoDAO aDAO;

    /**
     * Constructor que inicializa los ValidadoresVehiculo con una instancia de
     * IConexionBD y un EntityManager.
     *
     * @param entityManager El EntityManager para utilizar en las operaciones de
     * base de datos.
     * @param conexion La instancia de IConexionBD para establecer la conexión
     * con la base de datos.
     */
    public ValidadoresVehiculo(EntityManager entityManager, IConexionBD conexion) {
        this.entityManager = entityManager;
        this.conexion = conexion;
        this.aDAO = new AutoDAO(conexion.crearConexion());
    }

    /**
     * Carga todos los vehículos registrados en la base de datos.
     *
     * @return Una lista de todos los vehículos registrados.
     */
    @Override
    public List<VehiculosPlacasDTO> cargarTodosLosVehiculos() {
        if (aDAO.cargarTodosLosVehiculos() == null) {
            JOptionPane.showMessageDialog(null, "No tiene vehiculos existentes.");
        } else {
            return aDAO.cargarTodosLosVehiculos();
        }
        return null;
    }

    /**
     * Carga un vehículo específico por su placa.
     *
     * @param placas La placa del vehículo a buscar.
     * @return Una lista de información sobre el vehículo encontrado.
     */
    @Override
    public List<VehiculosPlacasDTO> cargarVehiculo(String placas) {
        if (aDAO.cargarVehiculo(placas) == null) {
            JOptionPane.showMessageDialog(null, "El vehiculo no se encontró.");
        } else {
            return aDAO.cargarVehiculo(placas);
        }
        return null;
    }

}
