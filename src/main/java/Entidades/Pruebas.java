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
 * @author RAUL EDUARDO GOMEZ
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.mycompany_Proyecto2BDA_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = emFactory.createEntityManager();
        // Crear una instancia de Calendar y configurarla con la fecha de nacimiento deseada
        Calendar fechaNacimiento = Calendar.getInstance();
        // Suponiendo que deseas configurar la fecha de nacimiento como el 1 de enero de 1990
        fechaNacimiento.set(1990, Calendar.JANUARY, 1);

        Persona persona = new Persona(
                false, // discapacitado
                fechaNacimiento, // fecha_nacimiento
                "1234567890", // telefono
                "RFC123456", // rfc
                "Juan", // nombres
                "Pérez", // apellido_paterno
                "Gómez", // apellido_materno
                "CURP12345" // curp
        );

        // Iniciar una transacción
        entityManager.getTransaction().begin();

        // Persistir la entidad Persona
        entityManager.persist(persona);

        // Completar la transacción
        entityManager.getTransaction().commit();

        // Cerrar el EntityManager
        entityManager.close();
        emFactory.close();

    }

}
