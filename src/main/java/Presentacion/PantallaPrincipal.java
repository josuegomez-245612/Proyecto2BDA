/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Interfaces.IConexionBD;
import Persistencia.PersonaDAO;
import Utilidades.ConstantesGUI;
import static Utilidades.ConstantesGUI.LICENCIAS;
import static Utilidades.ConstantesGUI.PLACAS;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSUE GOMEZ
 */
public class PantallaPrincipal extends javax.swing.JFrame {
   JDRenovarLicencia renovarLicencia;
    ConsultarPersonas cl;
JDSeleccionPlacas sp;
PersonaDAO pDAO;
IConexionBD conexion;
ConstantesGUI operacion;
    /**
     * Creates new form PantallaPrincipal
     * @param conexion
     */
    public PantallaPrincipal(IConexionBD conexion,ConstantesGUI gui) {
        initComponents();
        this.conexion = conexion;
        this.pDAO = new PersonaDAO(conexion.crearConexion());
        this.operacion = gui;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        checkbox1 = new java.awt.Checkbox();
        jPanel1 = new javax.swing.JPanel();
        headerImgLabel = new javax.swing.JLabel();
        bienvenidaLabel = new javax.swing.JLabel();
        insercionMasivaBtn = new javax.swing.JButton();
        addImgLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        tramitesMenu = new javax.swing.JMenu();
        licenciaMenu = new javax.swing.JMenu();
        tramitarLicenciaMenuItem = new javax.swing.JMenuItem();
        renovarLicenciaMenuItem = new javax.swing.JMenuItem();
        tramitarPlacasMenuItem = new javax.swing.JMenuItem();
        operacionesMenu = new javax.swing.JMenu();
        menuConsultas = new javax.swing.JMenu();
        consultaPlacasMenuItem = new javax.swing.JMenuItem();
        consultaLicenciaMenuItem = new javax.swing.JMenuItem();
        reporteMenuItem = new javax.swing.JMenuItem();
        informacionMenu = new javax.swing.JMenu();
        acercaDeMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        checkbox1.setLabel("checkbox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 543));
        setPreferredSize(new java.awt.Dimension(800, 543));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(227, 227, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 520));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marcoPantallaPrincipal.png"))); // NOI18N
        jPanel1.add(headerImgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 130));

        bienvenidaLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bienvenidaLabel.setText("Bienvenido al sistema!");
        jPanel1.add(bienvenidaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        insercionMasivaBtn.setBackground(new java.awt.Color(238, 228, 187));
        insercionMasivaBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        insercionMasivaBtn.setText("Insercion Masiva");
        insercionMasivaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insercionMasivaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(insercionMasivaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 404, -1, 40));

        addImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/6325028.png"))); // NOI18N
        jPanel1.add(addImgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 391, -1, 53));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));

        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(51, 102, 0));

        tramitesMenu.setText("Tramites");

        licenciaMenu.setText("Licencia");
        licenciaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenciaMenuActionPerformed(evt);
            }
        });

        tramitarLicenciaMenuItem.setText("Tramitar Licencia");
        tramitarLicenciaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tramitarLicenciaMenuItemActionPerformed(evt);
            }
        });
        licenciaMenu.add(tramitarLicenciaMenuItem);

        renovarLicenciaMenuItem.setText("Renovar Licencia");
        renovarLicenciaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renovarLicenciaMenuItemActionPerformed(evt);
            }
        });
        licenciaMenu.add(renovarLicenciaMenuItem);

        tramitesMenu.add(licenciaMenu);

        tramitarPlacasMenuItem.setText("Tramitar Placas");
        tramitarPlacasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tramitarPlacasMenuItemActionPerformed(evt);
            }
        });
        tramitesMenu.add(tramitarPlacasMenuItem);

        jMenuBar1.add(tramitesMenu);

        operacionesMenu.setText("Operaciones");

        menuConsultas.setText("Consultas");

        consultaPlacasMenuItem.setText("Placas");
        consultaPlacasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPlacasMenuItemActionPerformed(evt);
            }
        });
        menuConsultas.add(consultaPlacasMenuItem);

        consultaLicenciaMenuItem.setText("Licencias");
        consultaLicenciaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaLicenciaMenuItemActionPerformed(evt);
            }
        });
        menuConsultas.add(consultaLicenciaMenuItem);

        operacionesMenu.add(menuConsultas);

        reporteMenuItem.setText("Reporte");
        reporteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteMenuItemActionPerformed(evt);
            }
        });
        operacionesMenu.add(reporteMenuItem);

        jMenuBar1.add(operacionesMenu);

        informacionMenu.setText("Informacion");

        acercaDeMenuItem.setText("Acerca de...");
        acercaDeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaDeMenuItemActionPerformed(evt);
            }
        });
        informacionMenu.add(acercaDeMenuItem);

        jMenuBar1.add(informacionMenu);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void acercaDeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeMenuItemActionPerformed
   JOptionPane.showMessageDialog(null, 
    "Programa realizado por:\n" +
    "Josué Gómez Garza\n" +
    "Jorge Eduardo Elias Cazarez\n" +
            "\n"+
    "Estudiantes de Ingeniería en Software de ITSON\n" +
    "Número de contacto:\n" +
    "6442586327",
    "Información de contacto",
    JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_acercaDeMenuItemActionPerformed

    private void tramitarLicenciaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tramitarLicenciaMenuItemActionPerformed
   operacion = LICENCIAS;
        cl = new ConsultarPersonas(conexion,operacion);
        cl.setVisible(true);
    }//GEN-LAST:event_tramitarLicenciaMenuItemActionPerformed

    private void tramitarPlacasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tramitarPlacasMenuItemActionPerformed
        operacion = PLACAS;
        cl = new ConsultarPersonas(conexion,operacion);
        cl.setVisible(true);
    }//GEN-LAST:event_tramitarPlacasMenuItemActionPerformed

    private void consultaPlacasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaPlacasMenuItemActionPerformed
       
        ConsultarPlacas consultarPlacas = new ConsultarPlacas();
        consultarPlacas.setVisible(true);
    }//GEN-LAST:event_consultaPlacasMenuItemActionPerformed

    private void consultaLicenciaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaLicenciaMenuItemActionPerformed

        ConsultarPersonas consultarLicencias = new ConsultarPersonas(conexion,operacion);
        consultarLicencias.setVisible(true);
    }//GEN-LAST:event_consultaLicenciaMenuItemActionPerformed

    private void insercionMasivaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insercionMasivaBtnActionPerformed
                                       
  pDAO.insercionMasivaPersonas();
        JOptionPane.showMessageDialog(null, "Se han agregado los clientes con exito");
    }//GEN-LAST:event_insercionMasivaBtnActionPerformed

    private void renovarLicenciaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renovarLicenciaMenuItemActionPerformed
      
    }//GEN-LAST:event_renovarLicenciaMenuItemActionPerformed

    private void reporteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteMenuItemActionPerformed
        GenerarReporte generarReporte = new GenerarReporte();
        generarReporte.setVisible(true);
    }//GEN-LAST:event_reporteMenuItemActionPerformed

    private void licenciaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenciaMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_licenciaMenuActionPerformed

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem acercaDeMenuItem;
    private javax.swing.JLabel addImgLabel;
    private javax.swing.JLabel bienvenidaLabel;
    private java.awt.Checkbox checkbox1;
    private javax.swing.JMenuItem consultaLicenciaMenuItem;
    private javax.swing.JMenuItem consultaPlacasMenuItem;
    private javax.swing.JLabel headerImgLabel;
    private javax.swing.JMenu informacionMenu;
    private javax.swing.JButton insercionMasivaBtn;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu licenciaMenu;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu operacionesMenu;
    private javax.swing.JMenuItem renovarLicenciaMenuItem;
    private javax.swing.JMenuItem reporteMenuItem;
    private javax.swing.JMenuItem tramitarLicenciaMenuItem;
    private javax.swing.JMenuItem tramitarPlacasMenuItem;
    private javax.swing.JMenu tramitesMenu;
    // End of variables declaration//GEN-END:variables
}
