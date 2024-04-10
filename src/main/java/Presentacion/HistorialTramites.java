/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Entidades.Persona;
import Interfaces.IConexionBD;
import Persistencia.TramiteLicenciasDAO;
import Persistencia.TramitePlacasDAO;
import Utilidades.TramitesDTO;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ryzen 5
 */
public class HistorialTramites extends javax.swing.JFrame {

    private IConexionBD conexion;

    private Persona personaSeleccionada;

    private TramiteLicenciasDAO licenciasDAO;

    private TramitePlacasDAO placasDAO;

    ConsultarPersonas consultarLicencias;

    public HistorialTramites(IConexionBD conexion,Persona personaSeleccionada) {
        initComponents();
        this.conexion = conexion;
        this.personaSeleccionada = personaSeleccionada;
        this.licenciasDAO = new TramiteLicenciasDAO(conexion.crearConexion());
        this.placasDAO = new TramitePlacasDAO(conexion.crearConexion());
        this.cargarTramites();
    }

    /**
     * Creates new form HistorialPlacas
     *
     * @param frame
     */
    public HistorialTramites(ConsultarPersonas frame) {
        initComponents();
        consultarLicencias = frame;
    }

    private void cargarTramites() {
        boolean mostrarVentana = true;
        String tipo = (String) this.cbxTipo.getSelectedItem();
        List<TramitesDTO> tramites = new ArrayList<>();

        switch (tipo) {
            case "Todo":
                tramites.addAll(licenciasDAO.cargarTramites(personaSeleccionada.getId()));
                tramites.addAll(placasDAO.cargarTramites(personaSeleccionada.getId()));
                break;
            case "Placa":
                tramites.addAll(placasDAO.cargarTramites(personaSeleccionada.getId()));
                break;
            default:
                tramites.addAll(licenciasDAO.cargarTramites(personaSeleccionada.getId()));
                break;
        }

        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel modeloTabla = (DefaultTableModel) this.historialTable.getModel();
        modeloTabla.setRowCount(0);
        for (int i = 0; i < tramites.size(); i++) {
            if (tramites.get(i) != null) {
                Object[] fila = {tramites.get(i).getTipoTramite(), ("$" + tramites.get(i).getCostoTramite()), formateador.format((tramites.get(i).getFechaExpedicion()).getTime()),
                    (tramites.get(i).getNombrePersona() + " " + tramites.get(i).getApellidoPersona())};
                modeloTabla.addRow(fila);
            }
        }

        if (tramites.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Esta persona no ha realizado trámites");
            if (tipo.equals("Todo")) {
                mostrarVentana = false;
            }

        }

        if (!this.isVisible()) {
            this.setVisible(mostrarVentana);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        descClienteLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        historialTable = new javax.swing.JTable();
        volverBtn = new javax.swing.JButton();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        headerImgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 900));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(227, 227, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 770));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descClienteLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        descClienteLabel.setText("Tipo de historial");
        jPanel1.add(descClienteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 760, 30));

        historialTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"3 años", "$700", "Si", "2008"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vigencia", "Costo", "Fecha Expedicion", "Nombre solicitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(historialTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 700, 540));

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });
        jPanel1.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 720, -1, -1));

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Placa", "Licencia" }));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 120, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgBusqueda/loupe-et-icone-de-recherche-de-couleur-orange (1).png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marcoPantallaPrincipal.png"))); // NOI18N
        headerImgLabel.setText("jLabel1");
        jPanel2.add(headerImgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 130));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 130));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cargarTramites();
        }
    }//GEN-LAST:event_cbxTipoItemStateChanged

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed

    }//GEN-LAST:event_cbxTipoActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked

    }//GEN-LAST:event_jLabel13MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel descClienteLabel;
    private javax.swing.JLabel headerImgLabel;
    private javax.swing.JTable historialTable;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables
}
