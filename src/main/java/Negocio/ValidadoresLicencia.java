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
 *
 * @author JOSUE GOMEZ
 */
public class ValidadoresLicencia implements IValidadoresLicencia{
private final EntityManager entityManager;
    IConexionBD conexionn;
TramiteLicenciasDAO tlDAO;
    public ValidadoresLicencia(IConexionBD conexion,EntityManager entityManager) {
        this.entityManager=entityManager;
        this.conexionn = conexion;
        this.tlDAO = new TramiteLicenciasDAO(conexionn.crearConexion());
        
    }
    
    
    
    
    @Override
    public void crearLicencia(Persona persona, Integer vigenciaLicencia,Integer costoLicencia) {
        persona = entityManager.find(Persona.class, persona.getId());
        if (persona != null) {
            Licencia licencia = new Licencia(vigenciaLicencia);
            TramiteLicencia tramite = new TramiteLicencia(licencia, costoLicencia , new GregorianCalendar(), persona);
            
            tlDAO.crearTramite(tramite);
            
            JOptionPane.showMessageDialog(null, "Se ha tramitado la licencia correctamente");
        } else {
         JOptionPane.showMessageDialog(null, "No se pudo tramitar la licencia");
        }
      
    }
    
}
