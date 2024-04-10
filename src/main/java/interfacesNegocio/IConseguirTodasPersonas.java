/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesNegocio;

import Entidades.Persona;
import java.util.List;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface IConseguirTodasPersonas {
    
    /**
     *
     * @return
     */
    public List<Persona> cargarTodasPersonas();
}
