/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.time.LocalDate;

/**
 * Clase que contiene los parámetros de busqueda de una persona
 * @author JOSUE GOMEZ
 */
public class ParametrosBusquedaPersonas {
    
    /**
     * CURP de la persona
     */
    private String CURP;
    /**
     * Nombre de la persona
     */
    private String nombre; 
    /**
     * Fecha de nacimiento de la persona
     */
    private LocalDate fecha;

    /**
     * Constructor sobrecargado que inicializa los parámetros con los atributos
     * @param CURP CURP de la persona
     * @param nombre Nombre de la persona
     * @param fecha  Fecha de nacimiento de la persona
     */
    public ParametrosBusquedaPersonas(String CURP, String nombre, LocalDate fecha) {
        this.CURP = CURP;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    /**
     * Getter del RFC de persona
     * @return String con rfc de persona
     */
    public String getCURP() {
        return CURP;
    }

    /**
     * Setter del rfc de persona
     * @param CURP nuevo a settear
     */
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    /**
     * Getter del nombre de la persona
     * @return String con el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre de la persona
     * @param nombre Nombre de la persona a settear
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * getter de fecha de nacimiento de la persona
     * @return LocalDate de la fecha de nacimiento de la persona
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Setter de la fecha de nacimiento de la persona
     * @param fecha Fecha a settear nacimiento de la persona
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}
