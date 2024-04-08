/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Presentacion;

import Interfaces.IConexionBD;
import Persistencia.ConexionBD;
import Utilidades.ConstantesGUI;

/**
 *
 * @author JOSUE GOMEZ
 */
public class Proyecto2BDA {

    public static void main(String[] args) {
       IConexionBD conexion = new ConexionBD("com.mycompany_Proyecto2BDA_jar_1.0-SNAPSHOTPU");
       ConstantesGUI operacion = null;
       PantallaPrincipal pp = new PantallaPrincipal(conexion, operacion);
       
       pp.setVisible(true);
    }
}
