/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Interfaces.IConexionBD;
import Persistencia.TramitePlacasDAO;
import Utilidades.TramitesDTO;
import criptografia.EncriptadorAESConverter;
import interfacesNegocio.IValidadoresTramites;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Esta clase implementa la interfaz IValidadoresTramites y proporciona métodos
 * para validar y cargar trámites de placas.
 */
public class ValidadoresTramitesPlaca implements IValidadoresTramites {

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
     * El objeto TramitePlacasDAO utilizado para acceder a los datos de los
     * trámites de placas.
     */
    TramitePlacasDAO pDAO;
 
    /**
     * Constructor que inicializa los ValidadoresTramitesPlaca con un
     * EntityManager y una instancia de IConexionBD.
     *
     * @param entityManager El EntityManager para utilizar en las operaciones de
     * base de datos.
     * @param conexion La instancia de IConexionBD para establecer la conexión
     * con la base de datos.
     */
    public ValidadoresTramitesPlaca(EntityManager entityManager, IConexionBD conexion) {
        this.entityManager = entityManager;
        this.conexion = conexion;
        this.pDAO = new TramitePlacasDAO(this.conexion.crearConexion());
    }

    /**
     * Carga los trámites de placas asociados a un nombre de persona específico.
     *
     * @param nombreCompleto El nombre completo de la persona cuyos trámites se
     * desean cargar.
     * @return Una lista de objetos TramitesDTO que representan los trámites de
     * placas cargados.
     */
    @Override
    public List<TramitesDTO> cargarTramitesByNombre(String nombreCompleto) {
         
        if (pDAO.cargarTramitesByNombre(nombreCompleto) == null) {
            JOptionPane.showMessageDialog(null, "No existen tramites asociados con esta persona.");
        } else {
            
            return pDAO.cargarTramitesByNombre(nombreCompleto);
        }

        return null;
    }

    /**
     * Carga todos los trámites de placas registrados dentro de un período de
     * tiempo.
     *
     * @param periodoInicio La fecha de inicio del período.
     * @param periodoFin La fecha de fin del período.
     * @return Una lista de objetos TramitesDTO que representan los trámites de
     * placas cargados.
     */
    @Override
    public List<TramitesDTO> cargarTramitesInPeriod(Calendar periodoInicio, Calendar periodoFin) {
        if (pDAO.cargarTramitesInPeriod(periodoInicio, periodoFin) == null) {
            JOptionPane.showMessageDialog(null, "No hay tramites registrados en este periodo de tiempo.");
        } else {
            return pDAO.cargarTramitesInPeriod(periodoInicio, periodoFin);
        }

        return null;
    }

    /**
     * Carga los trámites de placas asociados a un nombre de persona específico
     * dentro de un período de tiempo.
     *
     * @param nombreCompleto El nombre completo de la persona cuyos trámites se
     * desean cargar.
     * @param periodoInicio La fecha de inicio del período.
     * @param periodoFin La fecha de fin del período.
     * @return Una lista de objetos TramitesDTO que representan los trámites de
     * placas cargados.
     */
    @Override
    public List<TramitesDTO> cargarTramitesByNombreInPeriod(String nombreCompleto, Calendar periodoInicio, Calendar periodoFin) {
     
        if (pDAO.cargarTramitesByNombreInPeriod(nombreCompleto, periodoInicio, periodoFin) == null) {
            JOptionPane.showMessageDialog(null, "No existen tramites asociados con esta persona o no hay tramites registrados en este periodo de tiempo.");
        } else {
            return pDAO.cargarTramitesByNombreInPeriod(nombreCompleto, periodoInicio, periodoFin);
        }

        return null;
    }

    /**
     * Carga todos los trámites de placas registrados.
     *
     * @return Una lista de objetos TramitesDTO que representan los trámites de
     * placas cargados.
     */
    @Override
    public List<TramitesDTO> cargarTodosTramites() {
        if (pDAO.cargarTodosTramites() == null) {
            JOptionPane.showMessageDialog(null, "No existen tramites registrados.");
        } else {
            return pDAO.cargarTodosTramites();
        }

        return null;
    }
}
