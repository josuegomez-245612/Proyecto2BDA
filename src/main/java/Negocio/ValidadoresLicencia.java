/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidades.Licencia;
import Entidades.Persona;
import Entidades.TramiteLicencia;
import Interfaces.IConexionBD;
import Persistencia.TramiteLicenciasDAO;
import interfacesNegocio.IValidadoresLicencia;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Esta clase implementa la interfaz IValidadoresLicencia y proporciona métodos
 * para validar y crear licencias.
 */
public class ValidadoresLicencia implements IValidadoresLicencia {

    /**
     * El administrador de entidades que gestiona las operaciones de
     * persistencia.
     */
    private final EntityManager entityManager;
    /**
     * La instancia de la interfaz IConexionBD para establecer la conexión con
     * la base de datos.
     */
    IConexionBD conexionn;
    /**
     * El objeto TramiteLicenciasDAO utilizado para acceder a los datos de los
     * trámites de licencias.
     */
    TramiteLicenciasDAO tlDAO;

    /**
     * Constructor que inicializa los ValidadoresLicencia con una instancia de
     * IConexionBD y un EntityManager.
     *
     * @param conexion La instancia de IConexionBD para establecer la conexión
     * con la base de datos.
     * @param entityManager El EntityManager para utilizar en las operaciones de
     * base de datos.
     */
    public ValidadoresLicencia(IConexionBD conexion, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.conexionn = conexion;
        this.tlDAO = new TramiteLicenciasDAO(conexionn.crearConexion());
    }

    /**
     * Crea una nueva licencia para una persona especificada, con una vigencia y
     * costo dados.
     *
     * @param persona La persona para la cual se va a crear la licencia.
     * @param vigenciaLicencia La vigencia de la licencia a crear.
     * @param costoLicencia El costo asociado a la licencia.
     */
    @Override
    public void crearLicencia(Persona persona, Integer vigenciaLicencia, Integer costoLicencia) {
        persona = entityManager.find(Persona.class, persona.getId());
        if (persona != null) {
            Licencia licencia = new Licencia(vigenciaLicencia);
            TramiteLicencia tramite = new TramiteLicencia(licencia, costoLicencia, new GregorianCalendar(), persona);

            tlDAO.crearTramite(tramite);

            JOptionPane.showMessageDialog(null, "Se ha tramitado la licencia correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo tramitar la licencia");
        }
    }
}
