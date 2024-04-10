/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesNegocio;

import Entidades.Persona;

/**
 *
 * @author JOSUE GOMEZ
 */
public interface IBuscarPersonaPorCurp {
     /**
     * Busca una persona por su CURP (Clave Única de Registro de Población).
     * 
     * @param CURP El CURP de la persona a buscar.
     * @return La persona que corresponde al CURP especificado, o null si no se encuentra ninguna persona con ese CURP.
     */
      public Persona encontrarPersonaPorCurp(String CURP);
}
