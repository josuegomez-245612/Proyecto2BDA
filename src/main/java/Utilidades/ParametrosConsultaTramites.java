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
    
    
    public ParametrosConsultaTramites(LocalDate fechaInicio, LocalDate fechaFin, String nombrePersona) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombrePersona = nombrePersona;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

  
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

   
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
}
