package Persistencia;

import Entidades.Persona;
import Interfaces.IPersonaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JOSUE GOMEZ
 */
public class PersonaDAO implements IPersonaDAO
{
    
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Persona> getAllPersonas() throws PersistenciaException
    {
        List<Persona> personas = new ArrayList<>();
        //0 - dsicapacitado  1 - fechaNacimiento  2 - telefono  3 - rfc  4 - nombres  5 - apellidoPaterno  6 - apellidoMaterno  7 - curp
        String jpql = "SELECT p.discapacitado, tl.fecha_nacimiento, p.telefono, p.rfc, p.nombres, p.apellidoPaterno, p.apellidoMaterno, p.curp, FROM Persona p ";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList) 
        {
            personas.add(new Persona((boolean)objects[0], (Calendar)objects[1], (String)objects[2], (String)objects[3],
                    (String)objects[4], (String)objects[5], (String)objects[1], (String)objects[1]));
        }
        return personas;
    }
    
    @Override
    public Persona getPersonaByCurp(String curp) throws PersistenciaException
    {
        String jpql = "SELECT p FROM Persona p WHERE p.curp = :curp";

        TypedQuery<Persona> query = entityManager.createQuery(jpql, Persona.class);
        query.setParameter("curp", curp);
        query.setMaxResults(1);
        
        List<Persona> lista = query.getResultList();
        
        return lista.isEmpty() ? null : lista.get(0);
    }
//    @Override
//    public void addPersona(Persona persona) throws PersistenciaException;
//    @Override
//    public void updatePersona(Persona persona) throws PersistenciaException;
//    @Override
//    public void deletePersona(int personaID) throws PersistenciaException;
}
