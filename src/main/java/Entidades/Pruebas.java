/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Entidades;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JOSUE GOMEZ
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.mycompany_Proyecto2BDA_jar_1.0-SNAPSHOTPU");
    EntityManager entityManager = emFactory.createEntityManager();
    
    // Begin transaction
    entityManager.getTransaction().begin();

    // Create Persona entity
    Calendar fechaNacimiento = Calendar.getInstance();
    fechaNacimiento.set(1990, Calendar.JANUARY, 1);

    Persona persona = new Persona(
            false,
            fechaNacimiento,
            "1234567890",
            "RFC123456",
            "Juan",
            "Pérez",
            "Gómez",
            "CURP12345"
    );
     //public Vehiculo(Long id, String modelo, String tipoVehiculo, String color, String numSerie, String linea, String marca, boolean nuevo)
    Vehiculo v = new Vehiculo("Fiesta","Auto","Rojo","123456","2024","Nissan",true);
    Licencia l = new Licencia(3);
     //public TramiteLicencia(Licencia licencia, int costo, Calendar fechaExpedicion, Persona persona) 
TramiteLicencia tl = new TramiteLicencia(l,1100,fechaNacimiento,persona);
//  public TramitePlacas(int costo, Calendar fechaExpedicion, Persona persona)
TramitePlacas tp = new TramitePlacas(1500,fechaNacimiento,persona);

// public Placa(TramitePlacas tramitePlacas, String seriePlacas, Vehiculo vehiculo)
Placa p = new Placa(1L,tp,"123",v);

tp.setPlaca(p);

    // Persist Persona entity
    entityManager.persist(persona);
    entityManager.persist(v);


    // Create Tramite entity
    Tramite tramite = new Tramite(1500, Calendar.getInstance(), persona);

    // Persist Tramite entity
    entityManager.persist(tramite);
    entityManager.persist(tl);
   entityManager.persist(tp);
    // Commit transaction
    entityManager.getTransaction().commit();

    // Close EntityManager
    entityManager.close();
    emFactory.close();
}
}