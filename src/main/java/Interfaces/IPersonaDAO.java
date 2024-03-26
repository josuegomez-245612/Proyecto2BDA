package Interfaces;

import Entidades.Persona;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface IPersonaDAO 
{
    public List<Persona> getAllPersonas() throws PersistenciaException;
    public Persona getPersonaByNombre(String nombre) throws PersistenciaException;
    public void addPersona(Persona persona) throws PersistenciaException;
    public void updatePersona(Persona persona) throws PersistenciaException;
    public void deletePersona(int personaID) throws PersistenciaException;
}
