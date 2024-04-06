/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.Persona;
import Entidades.Placa;
import Entidades.TramitePlacas;
import Entidades.Vehiculo;
import Interfaces.IConexionBD;
import Negocio.ValidadoresPlaca;
import Persistencia.ConexionBD;
import Persistencia.PersistenciaException;
import Persistencia.PersonaDAO;
import Utilidades.GeneradorPlacas;
import static Utilidades.GeneradorPlacas.generarCadena;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author RAUL EDUARDO GOMEZ
 */
public class JDRegistroPlacasNuevo extends javax.swing.JDialog {

    IConexionBD conexion;

    GeneradorPlacas generarp;
    PersonaDAO personaDAO;
    ValidadoresPlaca registrarPlaca;
    Persona personaElegida;

    /**
     * Creates new form JDRegistroPlacasNuevo
     *
     * @param conexion
     * @param persona
     */
    public JDRegistroPlacasNuevo(IConexionBD conexion, Persona persona) {
        initComponents();
        this.conexion = conexion;
        this.personaElegida = persona;
        this.personaDAO = new PersonaDAO(conexion.crearConexion());
        this.registrarPlaca = new ValidadoresPlaca(conexion, conexion.crearConexion());

    }

    public void settearNombrePersonaElegida() {
        curpTxtField.setText(personaElegida.getCurp());

    }

    public static boolean validarCamposTexto(JTextField... campos) {
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        headerImgLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        volverBtn = new javax.swing.JButton();
        aceptarBtn = new javax.swing.JButton();
        numeroSerieLabel = new javax.swing.JLabel();
        numeroSerieTxtField = new javax.swing.JTextField();
        marcaLabel = new javax.swing.JLabel();
        marcaTxtField = new javax.swing.JTextField();
        lineaLabel = new javax.swing.JLabel();
        lineaTxtField = new javax.swing.JTextField();
        modeloLabel = new javax.swing.JLabel();
        colorTxtField = new javax.swing.JTextField();
        colorLabel = new javax.swing.JLabel();
        modeloTxtField = new javax.swing.JTextField();
        curpLabel = new javax.swing.JLabel();
        curpTxtField = new javax.swing.JTextField();
        tituloLabel = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(227, 227, 217));

        headerImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marcoPantallaPrincipal.png"))); // NOI18N

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        aceptarBtn.setText("Aceptar");
        aceptarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBtnActionPerformed(evt);
            }
        });

        numeroSerieLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        numeroSerieLabel.setText("Numero de serie:");

        marcaLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        marcaLabel.setText("Marca:");

        lineaLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lineaLabel.setText("Linea:");

        modeloLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        modeloLabel.setText("Modelo:");

        colorLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        colorLabel.setText("Color:");

        modeloTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloTxtFieldActionPerformed(evt);
            }
        });

        curpLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        curpLabel.setText("CURP:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(headerImgLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(volverBtn)
                        .addGap(576, 576, 576)
                        .addComponent(aceptarBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(curpLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(curpTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(numeroSerieLabel)
                                    .addComponent(marcaLabel)
                                    .addComponent(lineaLabel)
                                    .addComponent(modeloLabel)
                                    .addComponent(colorLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(marcaTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numeroSerieTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lineaTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modeloTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1734, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(headerImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curpLabel)
                    .addComponent(curpTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroSerieTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroSerieLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marcaLabel))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lineaLabel)
                    .addComponent(lineaTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modeloTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modeloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(aceptarBtn))
                .addGap(21, 21, 21))
        );

        tituloLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tituloLabel.setText("Registro de placas nuevas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(295, 295, 295)
                    .addComponent(tituloLabel)
                    .addContainerGap(295, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(227, 227, 227)
                    .addComponent(tituloLabel)
                    .addContainerGap(250, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed

        dispose();


    }//GEN-LAST:event_volverBtnActionPerformed

    private void aceptarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBtnActionPerformed
        Calendar fechaActual = Calendar.getInstance();

        generarp = new GeneradorPlacas();
        if (!validarCamposTexto(curpTxtField, colorTxtField, lineaTxtField, marcaTxtField, modeloTxtField, numeroSerieTxtField)) {
            JOptionPane.showMessageDialog(null, "ERROR: rellene todos los campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String CURP = curpTxtField.getText();
            String color = colorTxtField.getText();
            String linea = lineaTxtField.getText();
            String marca = marcaTxtField.getText();
            String modelo = modeloTxtField.getText();
            String numeroSerie = numeroSerieTxtField.getText();
// public Vehiculo(String modelo, String color, String numSerie, String linea, String marca, boolean nuevo) 
            Vehiculo v = new Vehiculo(modelo, color, numeroSerie, linea, marca, true);
//  public Placa(Calendar fechaRecepcion, String seriePlacas, Vehiculo vehiculo)
            Placa p = new Placa(fechaActual, generarCadena(), v);
            try {
                // public TramitePlacas(Placa placa, int costo, Calendar fechaExpedicion, Persona persona)
                TramitePlacas tp = new TramitePlacas(p, 1500, fechaActual, personaDAO.getPersonaByCurp(CURP));
                registrarPlaca.RegistrarPlacaNuevo(p, v);
            } catch (PersistenciaException ex) {
                Logger.getLogger(JDRegistroPlacasNuevo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_aceptarBtnActionPerformed

    private void modeloTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloTxtFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBtn;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JTextField colorTxtField;
    private javax.swing.JLabel curpLabel;
    private javax.swing.JTextField curpTxtField;
    private javax.swing.JLabel headerImgLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lineaLabel;
    private javax.swing.JTextField lineaTxtField;
    private javax.swing.JLabel marcaLabel;
    private javax.swing.JTextField marcaTxtField;
    private javax.swing.JLabel modeloLabel;
    private javax.swing.JTextField modeloTxtField;
    private javax.swing.JLabel numeroSerieLabel;
    private javax.swing.JTextField numeroSerieTxtField;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables
}
