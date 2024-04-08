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
 * Esta clase proporciona métodos para acceder y manipular datos relacionados
 * con los trámites de placas.
 */
public class TramitePlacasDAO implements ITramitePlacasDAO {

    /**
     * El administrador de entidades que gestiona las operaciones de
     * persistencia.
     */
    private final EntityManager entityManager;

    /**
     * Constructor que inicializa el TramitePlacasDAO con un EntityManager
     * proporcionado.
     *
     * @param entityManager El EntityManager para utilizar en las operaciones de
     * base de datos.
     */
    public TramitePlacasDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Constructor por defecto que inicializa el TramitePlacasDAO con un
     * EntityManager nulo. Se recomienda utilizar el constructor con parámetros
     * siempre que sea posible.
     */
    public TramitePlacasDAO() {
        this.entityManager = null;
    }

    /**
     * Registra un nuevo trámite de placas en la base de datos.
     *
     * @param placa El objeto Placa que representa el trámite de placas a
     * registrar.
     */
    @Override
    public void nuevoTramite(Placa placa) {
        entityManager.getTransaction().begin();
        if (placa.getTramitePlacas().getCosto() == 1500) {
            entityManager.persist(placa.getVehiculo());
        }
        entityManager.persist(placa);
        entityManager.getTransaction().commit();
    }

    /**
     * Carga los trámites de placas asociados a una persona específica.
     *
     * @param idPersona El ID de la persona cuyos trámites se desean cargar.
     * @return Una lista de objetos TramitesDTO que representan los trámites de
     * placas cargados.
     */
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

    /**
     * Carga los trámites de placas asociados a una persona específica por su
     * nombre.
     *
     * @param nombreCompleto El nombre completo de la persona cuyos trámites se
     * desean cargar.
     * @return Una lista de objetos TramitesDTO que representan los trámites de
     * placas cargados.
     */
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
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0] + " " + tramite[1] + " " + tramite[4]));
        }
        return lista;
    }

    /**
     * Carga los trámites de placas asociados a una persona específica dentro de
     * un período de tiempo.
     *
     * @param nombreCompleto El nombre completo de la persona cuyos trámites se
     * desean cargar.
     * @param periodoInicio La fecha de inicio del período.
     * @param periodoFin La fecha de fin del período.
     * @return Una lista de objetos TramitesDTO que representan los trámites de
     * placas cargados.
     */
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

    /**
     * Carga todos los trámites de placas registrados dentro de un período de
     * tiempo.
     *
     * @param periodoInicio La fecha de inicio del período.
     * @param periodoFin La fecha de fin del período.
     * @return Una lista de objetos TramitesDTO que representan los trámites de
     * placas cargados.
     */
    @Override
    public List<TramitesDTO> cargarTramitesInPeriod(Calendar periodoInicio, Calendar periodoFin) {
        List<TramitesDTO> lista = new ArrayList<>();

        Date sqlPeriodoInicio = new Date(periodoInicio.getTimeInMillis());
        Date sqlPeriodoFin = new Date(periodoFin.getTimeInMillis());

        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion  4 - apellidoMaterno
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, p.apellido_materno FROM TramitePlacas tl "
                + "INNER JOIN tl.persona p WHERE tl.fechaExpedicion >= :periodo_inicio AND tl.fechaExpedicion <= :periodo_fin";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("periodo_inicio", sqlPeriodoInicio);
        query.setParameter("periodo_fin", sqlPeriodoFin);

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0] + " " + tramite[1] + " " + tramite[4]));
        }
        return lista;
    }

    /**
     * Carga los trámites de placas que cumplen con ciertos parámetros de
     * consulta.
     *
     * @param parametros Los parámetros de consulta para filtrar los trámites de
     * placas.
     * @return Una lista de objetos TramitesDTO que representan los trámites de
     * placas cargados.
     */
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

    /**
     * Carga todos los trámites de placas registrados.
     *
     * @return Una lista de objetos TramitesDTO que representan los trámites de
     * placas cargados.
     */
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
