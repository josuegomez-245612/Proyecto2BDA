/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Persona;
import Interfaces.IConexionBD;
import Persistencia.PersistenciaException;
import Persistencia.PersonaDAO;
import Persistencia.PlacasDAO;
import Persistencia.TramitePlacasDAO;
import Utilidades.ParametrosBusquedaPersonas;
import java.util.List;
import interfacesNegocio.IValidadoresPersona;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Esta clase implementa la interfaz IValidadoresPersona y proporciona métodos
 * para validar y manipular datos de personas.
 */
public class ValidadoresPersona implements IValidadoresPersona {

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
     * El objeto PersonaDAO utilizado para acceder a los datos de las personas
     * en la base de datos.
     */
    PersonaDAO pDAO;

    /**
     * Constructor que inicializa los ValidadoresPersona con una instancia de
     * IConexionBD y un EntityManager.
     *
     * @param entityManager El EntityManager para utilizar en las operaciones de
     * base de datos.
     * @param conexion La instancia de IConexionBD para establecer la conexión
     * con la base de datos.
     */
    public ValidadoresPersona(EntityManager entityManager, IConexionBD conexion) {
        this.entityManager = entityManager;
        this.conexion = conexion;
        this.pDAO = new PersonaDAO(conexion.crearConexion());
    }

    /**
     * Busca una persona por su CURP.
     *
     * @param CURP El CURP de la persona a buscar.
     * @return La persona encontrada, o null si no se encuentra.
     */
    @Override
    public Persona encontrarPersonaPorCurp(String CURP) {

        try {
            return pDAO.getPersonaByCurp(CURP);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ValidadoresPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     * Realiza una inserción masiva de personas.
     */
    @Override
    public void insercionMasivaPersonas() {
        if (pDAO.insercionMasivaPersonas() == false) {
            JOptionPane.showMessageDialog(null, "La insercion masiva ya fue realizada.");
        } else {
            pDAO.insercionMasivaPersonas();
            JOptionPane.showMessageDialog(null, "Se han agregado los clientes con exito");
        }
    }

    /**
     * Consulta personas con parámetros de búsqueda especificados.
     *
     * @param parametros Los parámetros de búsqueda para filtrar las personas.
     * @return Una lista de personas que cumplen con los criterios de búsqueda.
     */
    @Override
    public List<Persona> consultarPersonas(ParametrosBusquedaPersonas parametros) {
        return pDAO.consultarPersonas(parametros);
    }

    /**
     * Verifica si una persona tiene una licencia vigente.
     *
     * @param CURP El CURP de la persona a verificar.
     * @return true si la persona tiene una licencia vigente, false de lo
     * contrario.
     */
    @Override
    public boolean consultarLicenciaVigentePersona(String CURP) {
        return pDAO.consultarLicenciaVigentePersona(CURP);
    }

    /**
     * Valida si una persona es mayor de edad a partir de su CURP.
     *
     * @param CURP El CURP de la persona a verificar.
     * @return true si la persona es mayor de edad, false de lo contrario.
     */
    @Override
    public boolean validarMayoriaEdadPersona(String CURP) {
        return pDAO.validarMayoriaEdadPersona(CURP);
    }

    /**
     * Carga todas las personas registradas en la base de datos.
     *
     * @return Una lista de todas las personas registradas.
     */
    @Override
    public List<Persona> cargarTodasPersonas() {
        if (pDAO.cargarTodasPersonas() == null) {
            JOptionPane.showMessageDialog(null, "No existen registros para consultar.");
        } else {
            return pDAO.cargarTodasPersonas();
        }
        return null;
    }

}
