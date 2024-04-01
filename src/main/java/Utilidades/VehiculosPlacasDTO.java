/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Entidades.Vehiculo;

/**
 *
 * @author JOSUE GOMEZ
 */
public class VehiculosPlacasDTO {
       
    /**
     * Placas del auto
     */
    private String placas;
    
    /**
     * Objeto Auto que contiene la información del auto
     */
    private Vehiculo vehiculo;

    /**
     * Constructor por defecto
     */
    public VehiculosPlacasDTO() {
    }

    /**
     * Constructor que inicializa los parámetros con sus atributos
     * @param placas Placas del auto
     * @param vehiculo Vehiculo
     */
    public VehiculosPlacasDTO(String placas, Vehiculo vehiculo) {
        this.placas = placas;
        this.vehiculo = vehiculo;
    }

    /**
     * Método que regresa las placas del auto
     * @return String con las placas del auto
     */
    public String getPlacas() {
        return placas;
    }

    /**
     * Setter de las placas del auto
     * @param placas Placas a settear
     */
    public void setPlacas(String placas) {
        this.placas = placas;
    }

    /**
     * Método que regresa el auto
     * @return Objeto Auto que representa al auto
     */
    public Vehiculo getAutomovil() {
        return vehiculo;
    }

    /**
     * Setter para el auto
     * @param vehiculo
     */
    public void setAutomovil(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
