/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;

/**
 * Esta clase representa un DTO (Data Transfer Object) para almacenar
 * información de trámites.
 */
public class TramitesDTO {

    /**
     * El identificador único del trámite.
     */
    private Long id;

    /**
     * El costo del trámite.
     */
    private Integer costoTramite;

    /**
     * La fecha de expedición del trámite.
     */
    private Calendar fechaExpedicion;

    /**
     * La fecha de expedición del trámite en formato SQL.
     */
    private Date sqlFechaExpedicion;

    /**
     * El tipo de trámite.
     */
    private String tipoTramite;

    /**
     * Los nombres de la persona asociada al trámite.
     */
    private String nombrePersona;

    /**
     * Los apellidos de la persona asociada al trámite.
     */
    private String apellidoPersona;

    /**
     * Constructor que inicializa un TramitesDTO con ciertos atributos.
     * @param costoTramite
     * @param fechaExpedicion
     * @param nombrePersona
     * @param tipoTramite
     * @param apellidoPersona
     */
    public TramitesDTO(Integer costoTramite, Calendar fechaExpedicion, String tipoTramite, String nombrePersona, String apellidoPersona) {
        this.costoTramite = costoTramite;
        this.fechaExpedicion = fechaExpedicion;
        this.tipoTramite = tipoTramite;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }

    /**
     * Constructor que inicializa un TramitesDTO con ciertos atributos.
     * @param costoTramite
     * @param fechaExpedicion
     * @param nombrePersona
     * @param tipoTramite
     */
    public TramitesDTO(Integer costoTramite, Calendar fechaExpedicion, String tipoTramite, String nombrePersona) {
        this.costoTramite = costoTramite;
        this.fechaExpedicion = fechaExpedicion;
        this.sqlFechaExpedicion = new Date(fechaExpedicion.getTimeInMillis());
        this.tipoTramite = tipoTramite;
        this.nombrePersona = nombrePersona;
    }

    /**
     * Constructor que inicializa un TramitesDTO con ciertos atributos.
     * @param id
     * @param tipoTramite
     * @param costoTramite
     * @param fechaExpedicion
     * @param nombrePersona
     * @param apellidoPersona
     */
    public TramitesDTO(Long id, Integer costoTramite, Calendar fechaExpedicion, String tipoTramite, String nombrePersona, String apellidoPersona) {
        this.id = id;
        this.costoTramite = costoTramite;
        this.fechaExpedicion = fechaExpedicion;
        this.tipoTramite = tipoTramite;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }

    /**
     * Obtiene el costo del trámite.
     *
     * @return El costo del trámite.
     */
    public Integer getCostoTramite() {
        return costoTramite;
    }

    /**
     * Establece el costo del trámite.
     *
     * @param costoTramite El costo del trámite a establecer.
     */
    public void setCostoTramite(Integer costoTramite) {
        this.costoTramite = costoTramite;
    }

    /**
     * Obtiene la fecha de expedición del trámite.
     *
     * @return La fecha de expedición del trámite.
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Establece la fecha de expedición del trámite.
     *
     * @param fechaExpedicion La fecha de expedición del trámite a establecer.
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     *
     * @return
     */
    public Date getSqlFechaExpedicion() {
        return sqlFechaExpedicion;
    }

    /**
     *
     * @param sqlFechaExpedicion
     */
    public void setSqlFechaExpedicion(Date sqlFechaExpedicion) {
        this.sqlFechaExpedicion = sqlFechaExpedicion;
    }
    
    

    /**
     * Obtiene el tipo de trámite.
     *
     * @return El tipo de trámite.
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Establece el tipo de trámite.
     *
     * @param tipoTramite El tipo de trámite a establecer.
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     * Obtiene el nombre de la persona asociada al trámite.
     *
     * @return El nombre de la persona asociada al trámite.
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     * Establece el nombre de la persona asociada al trámite.
     *
     * @param nombrePersona El nombre de la persona a establecer.
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    /**
     * Obtiene el apellido de la persona asociada al trámite.
     *
     * @return El apellido de la persona asociada al trámite.
     */
    public String getApellidoPersona() {
        return apellidoPersona;
    }

    /**
     * Establece el apellido de la persona asociada al trámite.
     *
     * @param apellidoPersona El apellido de la persona a establecer.
     */
    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    /**
     * Calcula el código hash del objeto.
     *
     * @return El código hash del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara este objeto con otro para verificar si son iguales.
     *
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TramitesDTO other = (TramitesDTO) obj;
        return Objects.equals(this.id, other.id);
    }

}
