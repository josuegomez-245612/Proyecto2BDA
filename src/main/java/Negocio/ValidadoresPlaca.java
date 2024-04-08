/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Placa;
import Entidades.Vehiculo;
import Interfaces.IConexionBD;
import Persistencia.PlacasDAO;
import Persistencia.TramitePlacasDAO;
import interfacesNegocio.IRegistrarPlacas;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Esta clase implementa la interfaz IRegistrarPlacas para proporcionar operaciones
 * de validación y registro de placas de vehículos.
 */
public class ValidadoresPlaca implements IRegistrarPlacas {

    /**
     * El EntityManager utilizado para operaciones en la base de datos.
     */
    private final EntityManager entityManager;
    
    /**
     * La interfaz para establecer la conexión a la base de datos.
     */
    IConexionBD conexion;
    
    /**
     * El objeto DAO para manejar las operaciones de TramitePlacas en la base de datos.
     */
    TramitePlacasDAO placas;
    
    /**
     * El objeto DAO para manejar las operaciones de Placas en la base de datos.
     */
    PlacasDAO placa;

    /**
     * Construye un nuevo ValidadoresPlaca con la conexión y el EntityManager especificados.
     *
     * @param conexion La interfaz para establecer la conexión a la base de datos.
     * @param entityManager El EntityManager que se utilizará para operaciones en la base de datos.
     */
    public ValidadoresPlaca(IConexionBD conexion, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.conexion = conexion;
        placas = new TramitePlacasDAO(conexion.crearConexion());
        placa = new PlacasDAO(conexion.crearConexion());

    }

    /**
     * Registra una nueva placa de vehículo y su correspondiente tramite.
     *
     * @param p La placa de vehículo a registrar.
     * @param v El vehículo asociado a la placa.
     */
    @Override
    public void RegistrarPlacaNuevo(Placa p, Vehiculo v) {
        if (placa.validarExistenciaPlaca(p.getSeriePlacas()) == true) {
            JOptionPane.showMessageDialog(null, "ERROR: Este auto ya está registrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (placa.validarExistenciaPlaca(p.getSeriePlacas()) == false) {
            placas.nuevoTramite(p);
        }
    }

    /**
     * Valida si una placa de vehículo ya existe en la base de datos.
     *
     * @param seriePlacas La serie de la placa a validar.
     * @return true si la placa ya existe, false en caso contrario.
     */
    @Override
    public boolean validarExistenciaPlaca(String seriePlacas) {
        return placa.validarExistenciaPlaca(seriePlacas);
    }

    /**
     * Obtiene la información de una placa de vehículo.
     *
     * @param seriePlacas La serie de la placa a obtener.
     * @return La placa de vehículo correspondiente a la serie especificada.
     */
    @Override
    public Placa obtenerPlaca(String seriePlacas) {
        if (placa.obtenerPlaca(seriePlacas) == null) {
            JOptionPane.showMessageDialog(null, "La placa no existe.");
        } else {
            return placa.obtenerPlaca(seriePlacas);
        }
        return null;

    }

    /**
     * Deshabilita una placa de vehículo en la base de datos.
     *
     * @param p La placa de vehículo a deshabilitar.
     */
    @Override
    public void DeshabilitarPlacaAuto(Placa p) {
        placa.DeshabilitarPlacaAuto(p);
    }
}
