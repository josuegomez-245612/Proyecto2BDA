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
import interfacesNegocio.IValidadoresPersona;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSUE GOMEZ
 */
public class ValidadoresPersona implements IValidadoresPersona {

    private final EntityManager entityManager;
    IConexionBD conexion;
    PersonaDAO pDAO;

    public ValidadoresPersona(EntityManager entityManager, IConexionBD conexion) {
        this.entityManager = entityManager;
        this.conexion = conexion;
        this.pDAO = new PersonaDAO(conexion.crearConexion());
    }

    @Override
    public Persona encontrarPersonaPorCurp(String CURP) {
       
        try {
            if (pDAO.getPersonaByCurp(CURP) != null) {
                JOptionPane.showMessageDialog(null, "ERROR: la persona ya está registrada.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    return pDAO.getPersonaByCurp(CURP);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(ValidadoresPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(ValidadoresPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return null;

    }

    @Override
    public void insercionMasivaPersonas() {
       if(pDAO.insercionMasivaPersonas() == false){
           JOptionPane.showMessageDialog(null, "La insercion masiva ya fue realizada.");
       }else{
           pDAO.insercionMasivaPersonas();
            JOptionPane.showMessageDialog(null, "Se han agregado los clientes con exito");
       }
    }

    @Override
    public void cargarTodasPersonas() {
        if(pDAO.cargarTodasPersonas() == null){
            JOptionPane.showMessageDialog(null, "No existen registros para consultar.");
        }
        else{
            pDAO.cargarTodasPersonas();
        }
    }

   
    

}
