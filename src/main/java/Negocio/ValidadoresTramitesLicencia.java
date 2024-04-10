/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Interfaces.IConexionBD;
import Persistencia.TramiteLicenciasDAO;
import Utilidades.TramitesDTO;
import criptografia.EncriptadorAESConverter;
import interfacesNegocio.IValidadoresTramites;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 * Esta clase implementa la interfaz IValidadoresTramites para proporcionar validaciones
 * específicas para los trámites de licencia.
 */
public class ValidadoresTramitesLicencia implements IValidadoresTramites
{
    /**
     * El EntityManager utilizado para operaciones en la base de datos.
     */
    private final EntityManager entityManager;
    
    /**
     * La interfaz para establecer la conexión a la base de datos.
     */
    IConexionBD conexion;
    
    /**
     * El objeto DAO para manejar las operaciones de TramiteLicencia en la base de datos.
     */
    TramiteLicenciasDAO tlDAO;
            
            
           
    
    /**
     * Construye un nuevo ValidadoresTramitesLicencia con el EntityManager y la conexión especificados.
     *
     * @param entityManager El EntityManager que se utilizará para operaciones en la base de datos.
     * @param conexion La interfaz para establecer la conexión a la base de datos.
     */
    public ValidadoresTramitesLicencia(EntityManager entityManager, IConexionBD conexion) 
    {
        this.entityManager = entityManager;
        this.conexion = conexion;
        this.tlDAO = new TramiteLicenciasDAO(this.conexion.crearConexion());
    }
    
    /**
     * Carga los trámites asociados con un nombre completo de persona.
     *
     * @param nombreCompleto El nombre completo de la persona para la cual cargar los trámites.
     * @return Una lista de trámites asociados con el nombre completo especificado.
     */
    @Override
    public List<TramitesDTO> cargarTramitesByNombre(String nombreCompleto)
    {
       
        if(tlDAO.cargarTramitesByNombre(nombreCompleto) == null)
            JOptionPane.showMessageDialog(null, "No existen tramites asociados con esta persona.");
        else
            return tlDAO.cargarTramitesByNombre(nombreCompleto);
        
        return null;
    }
    
    /**
     * Carga los trámites registrados en un período de tiempo especificado.
     *
     * @param periodoInicio La fecha de inicio del período.
     * @param periodoFin La fecha de fin del período.
     * @return Una lista de trámites registrados en el período de tiempo especificado.
     */
    @Override
    public List<TramitesDTO> cargarTramitesInPeriod(Calendar periodoInicio, Calendar periodoFin)
    {
        if(tlDAO.cargarTramitesInPeriod(periodoInicio, periodoFin) == null)
            JOptionPane.showMessageDialog(null, "No hay tramites registrados en este periodo de tiempo.");
        else
            return tlDAO.cargarTramitesInPeriod(periodoInicio, periodoFin);
        
        return null;
    }
    
    /**
     * Carga los trámites asociados con un nombre completo de persona y registrados en un período de tiempo especificado.
     *
     * @param nombreCompleto El nombre completo de la persona para la cual cargar los trámites.
     * @param periodoInicio La fecha de inicio del período.
     * @param periodoFin La fecha de fin del período.
     * @return Una lista de trámites asociados con el nombre completo y período especificados.
     */
    @Override
    public List<TramitesDTO> cargarTramitesByNombreInPeriod(String nombreCompleto, Calendar periodoInicio, Calendar periodoFin)
    {
        
        if(tlDAO.cargarTramitesByNombreInPeriod(nombreCompleto, periodoInicio, periodoFin) == null)
            JOptionPane.showMessageDialog(null, "No existen tramites asociados con esta persona o no hay tramites registrados en este periodo de tiempo.");
        else
            return tlDAO.cargarTramitesByNombreInPeriod(nombreCompleto, periodoInicio, periodoFin);
        
        return null;
    }
    
    /**
     * Carga todos los trámites registrados en la base de datos.
     *
     * @return Una lista de todos los trámites registrados en la base de datos.
     */
    @Override
    public List<TramitesDTO> cargarTodosTramites()
    {
        if(tlDAO.cargarTodosTramites() == null)
            JOptionPane.showMessageDialog(null, "No existen tramites registrados.");
        else
            return tlDAO.cargarTodosTramites();
        
        return null;
    }
}
