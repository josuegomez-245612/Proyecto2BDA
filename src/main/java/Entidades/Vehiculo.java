package Entidades;

import java.util.List;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JOSUE GOMEZ
 */

/**
 * Esta entidad representa vehiculos con sus respectivos atributos.
 */
@Entity
@Table(name = "Vehiculos")
public class Vehiculo implements Serializable {

    /**
     * Identificador único del vehículo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehiculo_id")
    private Long id;

    /**
     * Modelo del vehículo.
     */
    @Column(name = "modelo", nullable = false, length = 20)
    private String modelo;
    
    /**
     * Tipo de vehículo (por ejemplo, coche, moto, camión, etc.).
     */
    @Column(name = "tipoVehiculo", nullable = false, length = 20)
    private String tipoVehiculo;
    
    /**
     * Color del vehículo.
     */
    @Column(name = "color", nullable = false, length = 40)
    private String color;
    
    /**
     * Número de serie del vehículo.
     */
    @Column(name = "numSerie", nullable = false, length = 20)
    private String numSerie;
    
    /**
     * Línea del vehículo.
     */
    @Column(name = "linea", nullable = false, length = 40)
    private String linea;
    
    /**
     * Marca del vehículo.
     */
    @Column(name = "marca", nullable = false, length = 40)
    private String marca;
    
    /**
     * Indica si el vehículo es nuevo o no.
     */
    @Column(name = "nuevo", nullable = false)
    private boolean nuevo;

    /**
     * Lista de placas asociadas al vehículo.
     */
    @OneToMany(mappedBy = "vehiculo", cascade = {CascadeType.PERSIST})
    private List<Placa> placas;
    /**
     * Constructor de la clase Vehiculo.
     * 
     * @param id Identificador único del vehículo.
     * @param modelo Modelo del vehículo.
     * @param tipoVehiculo Tipo de vehículo.
     * @param color Color del vehículo.
     * @param numSerie Número de serie del vehículo.
     * @param linea Línea del vehículo.
     * @param marca Marca del vehículo.
     * @param nuevo Indica si el vehículo es nuevo o no.
     */
    public Vehiculo(Long id, String modelo, String tipoVehiculo, String color, String numSerie, String linea, String marca, boolean nuevo) {
        this.id = id;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = nuevo;
    }

   /**
     * Constructor de la clase Vehiculo para un vehículo nuevo.
     * 
     * @param modelo Modelo del vehículo.
     * @param tipoVehiculo Tipo de vehículo.
     * @param color Color del vehículo.
     * @param numSerie Número de serie del vehículo.
     * @param linea Línea del vehículo.
     * @param marca Marca del vehículo.
     */
    public Vehiculo(String modelo, String tipoVehiculo, String color, String numSerie, String linea, String marca) {
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = true;
    }

    public Vehiculo() {
    }

    public Vehiculo(Long id) {
        this.id = id;
    }

    /**
     * Constructor de la clase Vehiculo.
     * 
     * @param modelo Modelo del vehículo.
     * @param tipoVehiculo Tipo de vehículo.
     * @param color Color del vehículo.
     * @param numSerie Número de serie del vehículo.
     * @param linea Línea del vehículo.
     * @param marca Marca del vehículo.
     * @param nuevo Indica si el vehículo es nuevo o no.
     */
    public Vehiculo(String modelo, String tipoVehiculo, String color, String numSerie, String linea, String marca, boolean nuevo) {
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = nuevo;
    }
 /**
     * Constructor de la clase Vehiculo para un vehículo usado.
     * 
     * @param modelo Modelo del vehículo.
     * @param color Color del vehículo.
     * @param numSerie Número de serie del vehículo.
     * @param linea Línea del vehículo.
     * @param marca Marca del vehículo.
     * @param nuevo Indica si el vehículo es nuevo o no.
     */
    public Vehiculo(String modelo, String color, String numSerie, String linea, String marca, boolean nuevo) {
        this.modelo = modelo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = nuevo;
    }
     /**
     * Obtiene el identificador único del vehículo.
     * 
     * @return Identificador único del vehículo.
     */
    public Long getId() {
        return id;
    }
    
  /**
     * Establece el identificador único del vehículo.
     * 
     * @param id Identificador único del vehículo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el modelo del vehículo.
     * 
     * @return Modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     * 
     * @param modelo Modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el tipo de vehículo.
     * 
     * @return Tipo de vehículo.
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Establece el tipo de vehículo.
     * 
     * @param tipoVehiculo Tipo de vehículo.
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Obtiene el color del vehículo.
     * 
     * @return Color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     * 
     * @param color Color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el número de serie del vehículo.
     * 
     * @return Número de serie del vehículo.
     */
    public String getNumSerie() {
        return numSerie;
    }

    /**
     * Establece el número de serie del vehículo.
     * 
     * @param numSerie Número de serie del vehículo.
     */
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    /**
     * Obtiene la línea del vehículo.
     * 
     * @return Línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del vehículo.
     * 
     * @param linea Línea del vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene la marca del vehículo.
     * 
     * @return Marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     * 
     * @param marca Marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Indica si el vehículo es nuevo.
     * 
     * @return true si el vehículo es nuevo, false en caso contrario.
     */
    public boolean isNuevo() {
        return nuevo;
    }
    
    /**
     * Establece si el vehiculo es nuevo.
     * 
     * @param nuevo
     */
    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Auto{" + "id=" + id + ", modelo=" + modelo + ", tipoVehiculo=" + tipoVehiculo + ", color=" + color + ", numSerie=" + numSerie + ", linea=" + linea + ", marca=" + marca + ", nuevo=" + nuevo + '}';
    }

}
