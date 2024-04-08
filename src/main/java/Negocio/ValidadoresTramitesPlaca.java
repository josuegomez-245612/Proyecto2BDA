/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Interfaces.IConexionBD;
import Persistencia.TramitePlacasDAO;
import Utilidades.TramitesDTO;
import interfacesNegocio.IValidadoresTramites;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryzen 5
 */
public class ValidadoresTramitesPlaca implements IValidadoresTramites
{
    private final EntityManager entityManager;
    IConexionBD conexion;
    TramitePlacasDAO pDAO;
    
    public ValidadoresTramitesPlaca(EntityManager entityManager, IConexionBD conexion) 
    {
        this.entityManager = entityManager;
        this.conexion = conexion;
        this.pDAO = new TramitePlacasDAO(this.conexion.crearConexion());
    }
    
    @Override
    public List<TramitesDTO> cargarTramitesByNombre(String nombreCompleto)
    {
        if(pDAO.cargarTramitesByNombre(nombreCompleto) == null)
            JOptionPane.showMessageDialog(null, "No existen tramites asociados con esta persona.");
        else
            return pDAO.cargarTramitesByNombre(nombreCompleto);
        
        return null;
    }
    
    @Override
    public List<TramitesDTO> cargarTramitesInPeriod(Calendar periodoInicio, Calendar periodoFin)
    {
        if(pDAO.cargarTramitesInPeriod(periodoInicio, periodoFin) == null)
            JOptionPane.showMessageDialog(null, "No hay tramites registrados en este periodo de tiempo.");
        else
            return pDAO.cargarTramitesInPeriod(periodoInicio, periodoFin);
        
        return null;
    }
    
    @Override
    public List<TramitesDTO> cargarTramitesByNombreInPeriod(String nombreCompleto, Calendar periodoInicio, Calendar periodoFin)
    {
        if(pDAO.cargarTramitesByNombreInPeriod(nombreCompleto, periodoInicio, periodoFin) == null)
            JOptionPane.showMessageDialog(null, "No existen tramites asociados con esta persona o no hay tramites registrados en este periodo de tiempo.");
        else
            return pDAO.cargarTramitesByNombreInPeriod(nombreCompleto, periodoInicio, periodoFin);
        
        return null;
    }
    
    @Override
    public List<TramitesDTO> cargarTodosTramites()
    {
        if(pDAO.cargarTodosTramites() == null)
            JOptionPane.showMessageDialog(null, "No existen tramites registrados.");
        else
            return pDAO.cargarTodosTramites();
        
        return null;
    }
}
