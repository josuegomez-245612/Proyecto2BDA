/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Persona;
import Entidades.Placa;
import Interfaces.ITramitePlacasDAO;
import Utilidades.ParametrosConsultaTramites;
import Utilidades.TramitesDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JOSUE GOMEZ
 */
public class TramitePlacasDAO implements ITramitePlacasDAO {

    private final EntityManager entityManager;

    public TramitePlacasDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public TramitePlacasDAO() {
        this.entityManager = null;
    }

    @Override
    public void nuevoTramite(Placa placa) {
        entityManager.getTransaction().begin();
        if (placa.getTramitePlacas().getCosto() == 1500) {
            entityManager.persist(placa.getVehiculo());
        }
        entityManager.persist(placa);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<TramitesDTO> cargarTramites(Long idPersona) {
        List<TramitesDTO> lista = new ArrayList<>();
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion FROM TramitePlacas tl "
                + "INNER JOIN tl.persona p";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0], (String) tramite[1]));
        }
        return lista;
    }
    
    @Override
    public List<TramitesDTO> cargarTramitesByNombre(String nombreCompleto) {
        List<TramitesDTO> lista = new ArrayList<>();
        
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        Persona persona = personaDAO.getPersonaByNombreCompleto(nombreCompleto);
        
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion  4 - apellidoMaterno
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, p.apellido_materno FROM TramitePlacas tl "
                + "INNER JOIN tl.persona p WHERE p.id = :id";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("id", persona.getId());

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Placa", (String)tramite[0] + " " + tramite[1] + " " + tramite[4]));
        }
        return lista;
    }
    
    @Override
    public List<TramitesDTO> cargarTramitesByNombreInPeriod(String nombreCompleto, Calendar periodoInicio, Calendar periodoFin) {
        List<TramitesDTO> lista = new ArrayList<>();
        
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        Persona persona = personaDAO.getPersonaByNombreCompleto(nombreCompleto);
        
        Date sqlPeriodoInicio = new Date(periodoInicio.getTimeInMillis());
        Date sqlPeriodoFin = new Date(periodoFin.getTimeInMillis());
        
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion  4 - apellidoMaterno
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, p.apellido_materno FROM TramitePlacas tl "
                + "INNER JOIN tl.persona p WHERE p.id = :id AND tl.fechaExpedicion >= :periodo_inicio AND tl.fechaExpedicion <= :periodo_fin";


        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("id", persona.getId());
        query.setParameter("periodo_inicio", sqlPeriodoInicio);
        query.setParameter("periodo_fin", sqlPeriodoFin);

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0] + " " + tramite[1] + " " + tramite[4]));
        }
        return lista;
    }

    @Override
    public List<TramitesDTO> cargarTramites(ParametrosConsultaTramites parametros) {
          /*
       0 = nombres 
       1 = apellidoPaterno 
       2 = costo  
       3 = fechaExpedicion 
       4 = idTramite 
        5 = apellidoMaterno
         */
        Set<TramitesDTO> consultaFiltros = new HashSet<>();

        if (parametros.getFechaInicio() != null && parametros.getFechaFin() != null) {
            Calendar fechaInicio = Calendar.getInstance();
            Calendar fechaFin = Calendar.getInstance();
            fechaInicio.set(parametros.getFechaInicio().getYear(), parametros.getFechaInicio().getMonthValue() - 1, parametros.getFechaInicio().getDayOfMonth());
            fechaFin.set(parametros.getFechaFin().getYear(), parametros.getFechaFin().getMonthValue() - 1, parametros.getFechaFin().getDayOfMonth());

            List<TramitesDTO> listaFecha = new ArrayList<>();
            String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, tl.id FROM TramitePlacas tl "
                    + "INNER JOIN tl.persona p WHERE tl.fechaExpedicion >= :inicio AND tl.fechaExpedicion <= :fin";

            TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
            query.setParameter("inicio", fechaInicio);
            query.setParameter("fin", fechaFin);

            List<Object[]> resultados = query.getResultList();
            for (Object[] tramite : resultados) {
                listaFecha.add(new TramitesDTO((Long) tramite[4], (Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0], (String) tramite[1]));
            }
            Set<TramitesDTO> consultaFiltroFecha = new HashSet<>(listaFecha);
            consultaFiltros.addAll(consultaFiltroFecha);
        }
        if (!parametros.getNombrePersona().equalsIgnoreCase("Ingrese su Nombre") && !parametros.getNombrePersona().isBlank()) {
            List<TramitesDTO> listaNombresSimilares = new ArrayList<>();
            String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, tl.id, p.apellido_materno FROM TramitePlacas tl "
                    + "INNER JOIN tl.persona p";

            TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

            List<Object[]> resultados = query.getResultList();
            for (Object[] tramite : resultados) {
                TramitesDTO tramiteIteracion = new TramitesDTO((Long) tramite[4], (Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0], (String) tramite[1]);
                String nombreCompleto = tramiteIteracion.getNombrePersona() + " " + tramiteIteracion.getApellidoPersona() + " " + (String) tramite[5];
                if ((nombreCompleto.toUpperCase()).contains(parametros.getNombrePersona().toUpperCase().trim())) {
                    listaNombresSimilares.add(tramiteIteracion);
                }
            }
            Set<TramitesDTO> consultaFiltroNombre = new HashSet<>(listaNombresSimilares);
            consultaFiltros.addAll(consultaFiltroNombre);
        }
        return null;

    }

    @Override
    public List<TramitesDTO> cargarTodosTramites() {
        /*
         0 = nombres  
         1 = apellidoPaterno 
         2 = costo 
         3 = fechaExpedicion
         */
        List<TramitesDTO> lista = new ArrayList<>();

        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion FROM TramitePlacas tl "
                + "INNER JOIN tl.persona p";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0], (String) tramite[1]));
        }
        return lista;
    }
}
