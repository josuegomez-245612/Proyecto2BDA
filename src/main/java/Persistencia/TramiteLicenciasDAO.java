/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Persona;
import Entidades.TramiteLicencia;
import Interfaces.ITramiteLicenciasDAO;
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
 * Esta clase representa un Objeto de Acceso a Datos (DAO) para gestionar entidades TramiteLicencia.
 * Proporciona métodos para crear y cargar entidades TramiteLicencia desde la base de datos.
 */
public class TramiteLicenciasDAO implements ITramiteLicenciasDAO 
{
    /**
     * El EntityManager utilizado para operaciones en la base de datos.
     */
    private final EntityManager entityManager;
    
    /**
     * Construye un nuevo TramiteLicenciasDAO con el EntityManager especificado.
     *
     * @param entityManager El EntityManager que se utilizará para operaciones en la base de datos.
     */
    public TramiteLicenciasDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Construye un nuevo TramiteLicenciasDAO con un EntityManager nulo.
     */
    public TramiteLicenciasDAO() {
     this.entityManager = null;
    }
 
 
    /**
     * Crea una nueva entidad TramiteLicencia en la base de datos.
     *
     * @param tramite La entidad TramiteLicencia que se va a crear.
     */
    @Override
    public void crearTramite(TramiteLicencia tramite) {
       
        entityManager.getTransaction().begin();
        entityManager.persist(tramite);
        entityManager.getTransaction().commit();
        
    }

    
    /**
     * Carga entidades TramitesDTO asociadas con un idPersona dado desde la base de datos.
     *
     * @param idPersona El id de la persona para la cual cargar los trámites.
     * @return Una lista de entidades TramitesDTO asociadas con el idPersona especificado.
     */
    @Override
    public List<TramitesDTO> cargarTramites(Long idPersona) {
       List<TramitesDTO> lista = new ArrayList<>();
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion FROM TramiteLicencia tl "
                + "INNER JOIN tl.persona p WHERE p.id = :id";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("id", idPersona);

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Licencia", (String) tramite[0], (String) tramite[1]));
        }
        return lista;
      
    }
    
    /**
     * Carga entidades TramitesDTO asociadas con un nombre completo de persona desde la base de datos.
     *
     * @param nombreCompleto El nombre completo de la persona para la cual cargar los trámites.
     * @return Una lista de entidades TramitesDTO asociadas con el nombre completo especificado.
     */
    @Override
    public List<TramitesDTO> cargarTramitesByNombre(String nombreCompleto) {
        List<TramitesDTO> lista = new ArrayList<>();
        
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        Persona persona = personaDAO.getPersonaByNombreCompleto(nombreCompleto);
        
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion  4 - apellidoMaterno
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, p.apellido_materno FROM TramiteLicencia tl "
                + "INNER JOIN tl.persona p WHERE p.id = :id";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("id", persona.getId());

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Licencia", (String)tramite[0] + " " + tramite[1] + " " + tramite[4]));
        }
        return lista;
    }
    
    
    /**
     * Carga entidades TramitesDTO asociadas con un período de tiempo desde la base de datos.
     *
     * @param periodoInicio La fecha de inicio del período.
     * @param periodoFin La fecha de fin del período.
     * @return Una lista de entidades TramitesDTO asociadas con el período especificado.
     */
    @Override
    public List<TramitesDTO> cargarTramitesInPeriod(Calendar periodoInicio, Calendar periodoFin) {
        List<TramitesDTO> lista = new ArrayList<>();
        
        Date sqlPeriodoInicio = new Date(periodoInicio.getTimeInMillis());
        Date sqlPeriodoFin = new Date(periodoFin.getTimeInMillis());
        
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion  4 - apellidoMaterno
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, p.apellido_materno FROM TramiteLicencia tl "
                + "INNER JOIN tl.persona p WHERE tl.fechaExpedicion >= :periodo_inicio AND tl.fechaExpedicion <= :periodo_fin";


        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("periodo_inicio", sqlPeriodoInicio);
        query.setParameter("periodo_fin", sqlPeriodoFin);

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Licencia", (String) tramite[0] + " " + tramite[1] + " " + tramite[4]));
        }
        return lista;
    }
    
    /**
     * Carga entidades TramitesDTO asociadas con un nombre completo de persona y un período de tiempo desde la base de datos.
     *
     * @param nombreCompleto El nombre completo de la persona para la cual cargar los trámites.
     * @param periodoInicio La fecha de inicio del período.
     * @param periodoFin La fecha de fin del período.
     * @return Una lista de entidades TramitesDTO asociadas con el nombre completo y período especificados.
     */
    @Override
    public List<TramitesDTO> cargarTramitesByNombreInPeriod(String nombreCompleto, Calendar periodoInicio, Calendar periodoFin) {
        List<TramitesDTO> lista = new ArrayList<>();
        
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        Persona persona = personaDAO.getPersonaByNombreCompleto(nombreCompleto);
        
        Date sqlPeriodoInicio = new Date(periodoInicio.getTimeInMillis());
        Date sqlPeriodoFin = new Date(periodoFin.getTimeInMillis());
        
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion  4 - apellidoMaterno
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, p.apellido_materno FROM TramiteLicencia tl "
                + "INNER JOIN tl.persona p WHERE p.id = :id AND tl.fechaExpedicion >= :periodo_inicio AND tl.fechaExpedicion <= :periodo_fin";


        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("id", persona.getId());
        query.setParameter("periodo_inicio", sqlPeriodoInicio);
        query.setParameter("periodo_fin", sqlPeriodoFin);

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Licencia", (String) tramite[0] + " " + tramite[1] + " " + tramite[4]));
        }
        return lista;
    }

    
    /**
     * Carga entidades TramitesDTO asociadas con los parámetros de consulta especificados desde la base de datos.
     *
     * @param parametros Los parámetros de consulta para los trámites.
     * @return Una lista de entidades TramitesDTO que coinciden con los parámetros de consulta.
     */
    @Override
    public List<TramitesDTO> cargarTramites(ParametrosConsultaTramites parametros) {
      Set<TramitesDTO> consultaFiltros = new HashSet<>();
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion  4 - idTramite  5 - apellidoMaterno

        if (parametros.getFechaInicio() != null && parametros.getFechaFin() != null) {
            Calendar fechaInicio = Calendar.getInstance();
            Calendar fechaFin = Calendar.getInstance();
            fechaInicio.set(parametros.getFechaInicio().getYear(), parametros.getFechaInicio().getMonthValue() - 1, parametros.getFechaInicio().getDayOfMonth());
            fechaFin.set(parametros.getFechaFin().getYear(), parametros.getFechaFin().getMonthValue() - 1, parametros.getFechaFin().getDayOfMonth());

            List<TramitesDTO> listaFecha = new ArrayList<>();
            String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, tl.id FROM TramiteLicencia tl "
                    + "INNER JOIN tl.persona p WHERE tl.fechaExpedicion >= :inicio AND tl.fechaExpedicion <= :fin";

            TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
            query.setParameter("inicio", fechaInicio);
            query.setParameter("fin", fechaFin);

            List<Object[]> resultados = query.getResultList();
            for (Object[] tramite : resultados) {
                listaFecha.add(new TramitesDTO((Long) tramite[4], (Integer) tramite[2], (Calendar) tramite[3], "Licencia", (String) tramite[0], (String) tramite[1]));
            }
            Set<TramitesDTO> consultaFiltroFecha = new HashSet<>(listaFecha);
            consultaFiltros.addAll(consultaFiltroFecha);
        }
        if (!parametros.getNombrePersona().equalsIgnoreCase("Ingrese su Nombre") && !parametros.getNombrePersona().isBlank()) {
            List<TramitesDTO> listaNombresSimilares = new ArrayList<>();
            String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, tl.id, p.apellido_materno FROM TramiteLicencia tl "
                    + "INNER JOIN tl.persona p";

            TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

            List<Object[]> resultados = query.getResultList();
            for (Object[] tramite : resultados) {
                TramitesDTO tramiteIteracion = new TramitesDTO((Long) tramite[4], (Integer) tramite[2], (Calendar) tramite[3], "Licencia", (String) tramite[0], (String) tramite[1]);
                String nombreCompleto = tramiteIteracion.getNombrePersona() + " " + tramiteIteracion.getApellidoPersona() + " " + (String) tramite[5];
                if ((nombreCompleto.toUpperCase()).contains(parametros.getNombrePersona().toUpperCase().trim())) {
                    listaNombresSimilares.add(tramiteIteracion);
                }
            }
            Set<TramitesDTO> consultaFiltroNombre = new HashSet<>(listaNombresSimilares);
            consultaFiltros.addAll(consultaFiltroNombre);
        }

        List<TramitesDTO> tramitesEncontrados = new ArrayList<>(consultaFiltros);
        return tramitesEncontrados;
    }

    
    /**
     * Carga todas las entidades TramitesDTO desde la base de datos.
     *
     * @return Una lista de todas las entidades TramitesDTO en la base de datos.
     */
    @Override
    public List<TramitesDTO> cargarTodosTramites() {
         List<TramitesDTO> lista = new ArrayList<>();
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion FROM TramiteLicencia tl "
                + "INNER JOIN tl.persona p";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Licencia", (String) tramite[0], (String) tramite[1]));
        }
        return lista;
    }
   
  
}
