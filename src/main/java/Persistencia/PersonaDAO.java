package Persistencia;

import Entidades.Persona;
import Entidades.Vehiculo;
import Interfaces.IPersonaDAO;
import Utilidades.VehiculosPlacasDTO;
import java.util.ArrayList;
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
        String jpql = "SELECT p.discapacitado, a FROM TramitePlacas tp "
                + "INNER JOIN tp.placa p "
                + "INNER JOIN p.automovil a "
                + "WHERE p.fechaRecepcion IS NULL";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList) 
        {
//            persona.add(new Persona((String)objects[0], (Vehiculo)objects[1]));
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
