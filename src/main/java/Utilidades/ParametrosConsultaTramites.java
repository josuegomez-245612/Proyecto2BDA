/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.time.LocalDate;

/**
 *
 * @author JOSUE GOMEZ
 */
public class ParametrosConsultaTramites {
      
    /**
     * Fecha de inicio de un trámite
     */
    private LocalDate fechaInicio;
    /**
     * Fecha de fin de un trámite
     */
    private LocalDate fechaFin;
    /**
     * nombre de la persona del trámite
     */
    private String nombrePersona;
    
    /**
     *
     * @param fechaInicio
     * @param fechaFin
     * @param nombrePersona
     */
    public ParametrosConsultaTramites(LocalDate fechaInicio, LocalDate fechaFin, String nombrePersona) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombrePersona = nombrePersona;
    }

    /**
     *
     * @return
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * @param fechaInicio
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *
     * @return
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     *
     * @param fechaFin
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     *
     * @return
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     *
     * @param nombrePersona
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
}
