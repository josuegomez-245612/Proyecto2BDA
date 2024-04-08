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
      /**
     * Obtiene una persona por su CURP.
     * 
     * @param nombre El CURP de la persona a buscar.
     * @return Un objeto Persona que corresponde al CURP especificado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
     Persona getPersonaByCurp(String nombre) throws PersistenciaException;
     
     /**
      * Consulta personas utilizando parámetros específicos.
      * 
      * @param parametros Los parámetros de búsqueda para consultar personas.
      * @return Una lista de personas que cumplen con los criterios de búsqueda.
      */
 List <Persona> consultarPersonas(ParametrosBusquedaPersonas parametros);
   /**
      * Verifica si una persona tiene licencia vigente.
      * 
      * @param CURP El CURP de la persona a verificar.
      * @return true si la persona tiene licencia vigente, false en caso contrario.
      */
  boolean consultarLicenciaVigentePersona(String CURP);
    
     /**
      * Realiza una inserción masiva de personas en la base de datos.
      * 
      * @return true si la inserción masiva fue exitosa, false en caso contrario.
      */
  boolean insercionMasivaPersonas();
     /**
      * Valida si una persona es mayor de edad.
      * 
      * @param CURP El CURP de la persona a verificar.
      * @return true si la persona es mayor de edad, false en caso contrario.
      */
   boolean validarMayoriaEdadPersona(String CURP);
  
   /**
      * Carga todas las personas almacenadas en la base de datos.
      * 
      * @return Una lista de todas las personas almacenadas en la base de datos.
      */
    public List<Persona> cargarTodasPersonas();
      
     /**
      * Obtiene un objeto Persona por su nombre.
      * 
      * @param nombre El nombre de la persona a buscar.
      * @return Un objeto Persona que corresponde al nombre especificado.
      */
    public Persona getPersonaByNombre(String nombre);
   
}
