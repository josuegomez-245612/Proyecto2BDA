package Persistencia;

import Entidades.Persona;
import Entidades.TramiteLicencia;
import Interfaces.IPersonaDAO;
import Utilidades.ParametrosBusquedaPersonas;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author JOSUE GOMEZ
 */
public class PersonaDAO implements IPersonaDAO {

    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public PersonaDAO() {
        this.entityManager = null;
    }

    @Override
    public List<Persona> getAllPersonas() throws PersistenciaException {
        List<Persona> personas = new ArrayList<>();
        //0 - dsicapacitado  1 - fechaNacimiento  2 - telefono  3 - rfc  4 - nombres  5 - apellidoPaterno  6 - apellidoMaterno  7 - curp
        String jpql = "SELECT p.discapacitado, tl.fecha_nacimiento, p.telefono, p.rfc, p.nombres, p.apellidoPaterno, p.apellidoMaterno, p.curp, FROM Persona p ";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList) {
            personas.add(new Persona((boolean) objects[0], (Calendar) objects[1], (String) objects[2], (String) objects[3],
                    (String) objects[4], (String) objects[5], (String) objects[1], (String) objects[1]));
        }
        return personas;
    }

    @Override
    public Persona getPersonaByCurp(String curp) throws PersistenciaException {
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

    @Override
    public List<Persona> consultarPersonas(ParametrosBusquedaPersonas parametros) {
        String nombre = parametros.getNombre(), curp = parametros.getCURP();
        LocalDate fecha = parametros.getFecha();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> personaRoot = criteriaQuery.from(Persona.class);

        List<Predicate> filtros = new LinkedList<>();

        if (!curp.equalsIgnoreCase("Ingrese su CURP") && !curp.isBlank()) {
            filtros.add(criteriaBuilder.like(personaRoot.get("curp"), curp + "%"));
        }
        if (fecha != null) {
            Calendar fechaActual = Calendar.getInstance();
            fechaActual.set(fecha.getYear(), fecha.getMonthValue() - 1, fecha.getDayOfMonth());
            filtros.add(criteriaBuilder.equal(personaRoot.get("fecha_nacimiento"), fechaActual));
        }

        criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.or((filtros.toArray(new Predicate[0]))));

        TypedQuery<Persona> query = entityManager.createQuery(criteriaQuery);

        Set<Persona> queryFechaRFC = new HashSet<>(query.getResultList());

        if (!nombre.equalsIgnoreCase("Ingrese su Nombre") && !nombre.isBlank()) {
            List<Persona> personasNombreSimilar = new ArrayList<>();
            List<Persona> registroPersonas = this.cargarTodasPersonas();
            for (Persona registroPersona : registroPersonas) {
                String nombreCompleto = registroPersona.getNombres() + " " + registroPersona.getApellido_paterno() + " " + registroPersona.getApellido_materno();
                if ((nombreCompleto.toUpperCase()).contains(nombre.toUpperCase().trim())) {
                    personasNombreSimilar.add(registroPersona);
                }
            }
            Set<Persona> queryNombresSimilares = new HashSet<>(personasNombreSimilar);
            queryFechaRFC.addAll(queryNombresSimilares);
            List<Persona> personasEncontradas = new ArrayList<>(queryFechaRFC);
            return personasEncontradas;
        }
        return query.getResultList();
    }

    @Override
    public boolean consultarLicenciaVigentePersona(String rfc) {
        String jpql = "SELECT tl FROM TramiteLicencia tl "
                + "INNER JOIN tl.persona ps "
                + "INNER JOIN tl.licencia lc "
                + "WHERE ps.rfc = :rfc ORDER BY tl.fechaExpedicion DESC";

        TypedQuery<TramiteLicencia> query = entityManager.createQuery(jpql, TramiteLicencia.class);
        query.setParameter("rfc", rfc);
        query.setMaxResults(1);

        List<TramiteLicencia> tramites = query.getResultList();

        if (tramites.isEmpty()) {
            return false;
        } else {
            TramiteLicencia tramite = tramites.get(0);
            Calendar fechaVigencia = tramite.getFechaExpedicion();
            fechaVigencia.add(Calendar.YEAR, tramite.getLicencia().getVigencia());

            GregorianCalendar actual = new GregorianCalendar();

            return !actual.after(fechaVigencia);
        }
    }

    @Override
    public boolean insercionMasivaPersonas() {
        if (cargarTodasPersonas().size() >= 15) {
            return false;
        } else {
            String[] nombres = {"Ana", "Luis", "Miguel", "Sofia", "Diego", "Valentina", "Jorge", "Gabriela", "Roberto", "Maria", "Carmen", "Juan", "Carla", "Francisco", "Alejandra", "Pablo", "Lucia", "Andres", "Mariana", "Fernando"};
            String[] apellidosPaternos = {"Garcia", "Gonzalez", "Hernandez", "Martinez", "Lopez", "Perez", "Gomez", "Diaz", "Ruiz", "Flores", "Ramirez", "Sanchez", "Torres", "Reyes", "Mendoza", "Castro", "Ortiz", "Chavez", "Vargas", "Aguilar"};
            String[] apellidosMaternos = {"Ramirez", "Hernandez", "Garcia", "Torres", "Martinez", "Sanchez", "Gonzalez", "Castillo", "Fernandez", "Chavez", "Gomez", "Mendoza", "Perez", "Diaz", "Herrera", "Vazquez", "Ramos", "Lopez", "Soto", "Sosa"};
            String[] rfcs = {"ABC12345678901", "DEF23456789012", "GHI34567890123", "JKL45678901234", "MNO56789012345", "PQR67890123456", "STU78901234567", "VWX89012345678", "YZA90123456789", "BCD01234567890", "EFG12345678901", "HIJ23456789012", "KLM34567890123", "NOP45678901234", "QRS56789012345", "TUV67890123456", "WXY78901234567", "ZAB89012345678", "CDE90123456789", "FGH01234567890"};
            String[] telefonos = {"6441100001", "6441200002", "6441300003", "6441400004", "6441500005", "6441600006", "6441700007", "6441800008", "6441900009", "6442100010", "6442200011", "6442300012", "6442400013", "6442500014", "6442600015", "6442700016", "6442800017", "6442900018", "6443100019", "6443200020"};
            String[] curps = {"ABC123456789AB","DEF234567890DE","GHI345678901GH","JKL456789012JK","MNO567890123MN","PQR678901234PQ","STU789012345ST","VWX890123456VW","YZA901234567YZ","BCD012345678BC","EFG123456789EF","HIJ234567890HI","KLM345678901KL","NOP456789012NO","QRS567890123QR","TUV678901234TU","WXY789012345WX","ZAB890123456ZA", "CDE901234567CD","FGH012345678FG"};
            GregorianCalendar[] fechasDeNacimiento = new GregorianCalendar[20];
            
            fechasDeNacimiento[0] = new GregorianCalendar(1990, 3, 22);
            fechasDeNacimiento[1] = new GregorianCalendar(1985, 11, 10);
            fechasDeNacimiento[2] = new GregorianCalendar(1992, 8, 5);
            fechasDeNacimiento[3] = new GregorianCalendar(1988, 5, 28);
            fechasDeNacimiento[4] = new GregorianCalendar(1995, 0, 15);
            fechasDeNacimiento[5] = new GregorianCalendar(1991, 10, 2);
            fechasDeNacimiento[6] = new GregorianCalendar(1997, 6, 18);
            fechasDeNacimiento[7] = new GregorianCalendar(1984, 2, 30);
            fechasDeNacimiento[8] = new GregorianCalendar(1993, 4, 8);
            fechasDeNacimiento[9] = new GregorianCalendar(1999, 1, 14);

            fechasDeNacimiento[10] = new GregorianCalendar(2006, 7, 1);
            fechasDeNacimiento[11] = new GregorianCalendar(2002, 3, 11);
            fechasDeNacimiento[12] = new GregorianCalendar(2009, 11, 24);
            fechasDeNacimiento[13] = new GregorianCalendar(2010, 6, 7);
            fechasDeNacimiento[14] = new GregorianCalendar(2012, 1, 16);
            fechasDeNacimiento[15] = new GregorianCalendar(2014, 8, 28);
            fechasDeNacimiento[16] = new GregorianCalendar(2015, 4, 10);
            fechasDeNacimiento[17] = new GregorianCalendar(2016, 2, 2);
            fechasDeNacimiento[18] = new GregorianCalendar(2017, 9, 19);
            fechasDeNacimiento[19] = new GregorianCalendar(2018, 7, 3);

            entityManager.getTransaction().begin();
            for (int i = 0; i < 20; i++) {
                boolean discapacitado = (i % 2 == 0 ? false : true);
                // public Persona(boolean discapacitado, Calendar fecha_nacimiento, String telefono, String rfc, String nombres, String apellido_paterno, String apellido_materno, String curp)
                Persona persona = new Persona(discapacitado, fechasDeNacimiento[i], telefonos[i], rfcs[i], nombres[i], apellidosPaternos[i], apellidosMaternos[i],curps[i]);
                entityManager.persist(persona);
            }
            entityManager.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean validarMayoriaEdadPersona(String CURP) {
       Persona persona = null;
        try {
            persona = this.getPersonaByCurp(CURP);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar fechaNacimiento = persona.getFecha_nacimiento();
        
        if (persona != null) {
            Calendar fechaCumpleMayoriaEdad = Calendar.getInstance();
            fechaCumpleMayoriaEdad.setTime(fechaNacimiento.getTime());
            fechaCumpleMayoriaEdad.add(Calendar.YEAR, 18);
            
            Calendar fechaActual = Calendar.getInstance();
            
            return !fechaActual.before(fechaCumpleMayoriaEdad);
        } else {
            System.out.println("Error al buscar la persona");
            return false;
        }
    }

    @Override
    public List<Persona> cargarTodasPersonas() {
        String query = "SELECT p FROM Persona as p";
        TypedQuery<Persona> result = entityManager.createQuery(query, Persona.class);
        List<Persona> listPersonas = result.getResultList();
        return listPersonas;
    }
}
