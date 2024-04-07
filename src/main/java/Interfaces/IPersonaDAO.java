package Interfaces;

import Entidades.Persona;
import Persistencia.PersistenciaException;
import Utilidades.ParametrosBusquedaPersonas;
import java.util.List;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface IPersonaDAO 
{
    
     Persona getPersonaByCurp(String nombre) throws PersistenciaException;
 List <Persona> consultarPersonas(ParametrosBusquedaPersonas parametros);
  boolean consultarLicenciaVigentePersona(String rfc);
  boolean insercionMasivaPersonas();
   boolean validarMayoriaEdadPersona(String rfc);
    public List<Persona> cargarTodasPersonas();
   
}
