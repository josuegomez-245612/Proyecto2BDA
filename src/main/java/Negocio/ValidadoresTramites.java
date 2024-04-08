/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Interfaces.IConexionBD;
import Persistencia.TramiteLicenciasDAO;
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
public class ValidadoresTramites implements IValidadoresTramites
{
    private final EntityManager entityManager;
    IConexionBD conexion;
    TramiteLicenciasDAO tlDAO;
    
    public ValidadoresTramites(EntityManager entityManager, IConexionBD conexion) 
    {
        this.entityManager = entityManager;
        this.conexion = conexion;
        this.tlDAO = new TramiteLicenciasDAO(this.conexion.crearConexion());
    }
    
    @Override
    public List<TramitesDTO> cargarTramitesByNombre(String nombreCompleto)
    {
        if(tlDAO.cargarTramitesByNombre(nombreCompleto) == null)
            JOptionPane.showMessageDialog(null, "No existen tramites asociados con esta persona.");
        else
            return tlDAO.cargarTramitesByNombre(nombreCompleto);
        
        return null;
    }
    
    @Override
    public List<TramitesDTO> cargarTramitesByNombreInPeriod(String nombreCompleto, Calendar periodoInicio, Calendar periodoFin)
    {
        if(tlDAO.cargarTramitesByNombreInPeriod(nombreCompleto, periodoInicio, periodoFin) == null)
            JOptionPane.showMessageDialog(null, "No existen tramites asociados con esta persona o no hay tramites registrados en este periodo de tiempo.");
        else
            return tlDAO.cargarTramitesByNombreInPeriod(nombreCompleto, periodoInicio, periodoFin);
        
        return null;
    }
    
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
