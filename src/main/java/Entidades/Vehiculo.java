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
 * Esta entidad representa automóviles con sus respectivos atributos.
 */
@Entity
@Table(name = "Vehiculos")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehiculo_id")
    private Long id;

    @Column(name = "modelo", nullable = false, length = 20)
    private String modelo;
    
    @Column(name = "tipoVehiculo", nullable = false, length = 20)
    private String tipoVehiculo;
    
    @Column(name = "color", nullable = false, length = 40)
    private String color;
    
    @Column(name = "numSerie", nullable = false, length = 20)
    private String numSerie;
    
    @Column(name = "linea", nullable = false, length = 40)
    private String linea;
    
    @Column(name = "marca", nullable = false, length = 40)
    private String marca;
    
    @Column(name = "nuevo", nullable = false)
    private boolean nuevo;

    @OneToMany(mappedBy = "vehiculo", cascade = {CascadeType.PERSIST})
    private List<Placa> placas;
    
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

    public Vehiculo(String modelo, String tipoVehiculo, String color, String numSerie, String linea, String marca, boolean nuevo) {
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = nuevo;
    }

    public Vehiculo(String modelo, String color, String numSerie, String linea, String marca, boolean nuevo) {
        this.modelo = modelo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = nuevo;
    }
    

    public String getModelo() {
        return modelo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getColor() {
        return color;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public String getLinea() {
        return linea;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
