/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Interfaces.IConexionBD;
import Negocio.ValidadoresTramitesLicencia;
import Negocio.ValidadoresTramitesPlaca;
import Utilidades.ConstantesGUI;
import Utilidades.TramitesDTO;
import interfacesNegocio.IValidadoresTramites;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ryzen 5
 */
public class GenerarReporte extends javax.swing.JFrame {

    IConexionBD conexion;
    ValidadoresTramitesLicencia tramitesLicenciaNegocio;
    ValidadoresTramitesPlaca tramitesPlacaNegocio;
    ConstantesGUI operacion;

      /** 
     * Crea una nueva instancia de ConsultarPersonas.
     * @param conexion Una instancia de {@code IConexionBD} para la conexión a la base de datos.
     * @param gui Una instancia de {@code ConstantesGUI} para definir la operación a realizar.
     */
    public GenerarReporte(IConexionBD conexion, ConstantesGUI gui) {
        initComponents();
        this.conexion = conexion;
        this.tramitesLicenciaNegocio = new ValidadoresTramitesLicencia(this.conexion.crearConexion(), conexion);
        this.tramitesPlacaNegocio = new ValidadoresTramitesPlaca(this.conexion.crearConexion(), conexion);
        this.operacion = gui;

    }
    /**
     * Creates new form GenerarReporte
     */
    public GenerarReporte() {
        initComponents();
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
        tipoTramitesLabel = new javax.swing.JLabel();
        solicitanteTramitesLabel = new javax.swing.JLabel();
        periodoTramitesLabel = new javax.swing.JLabel();
        tipoTramitesComboBox = new javax.swing.JComboBox<>();
        solicitanteTramitesTxtField = new javax.swing.JTextField();
        periodoDesdeTramitesTxtField = new javax.swing.JTextField();
        periodoHastaTramitesTxtField = new javax.swing.JTextField();
        generarReporteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reporteTxtArea = new javax.swing.JTextArea();
        cancelarBtn = new javax.swing.JButton();
        exportarBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        headerImgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(227, 227, 217));

        tipoTramitesLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        tipoTramitesLabel.setText("Tipo de Tramites");

        solicitanteTramitesLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        solicitanteTramitesLabel.setText("Solicitante de Tramites");

        periodoTramitesLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        periodoTramitesLabel.setText("Periodo de Tramites");

        tipoTramitesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Placa", "Licencia", "Todos" }));
        tipoTramitesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoTramitesComboBoxActionPerformed(evt);
            }
        });

        solicitanteTramitesTxtField.setText("Jorge Elias");

        periodoDesdeTramitesTxtField.setText("02/10/2001");

        periodoHastaTramitesTxtField.setText("06/08/2015");

        generarReporteBtn.setText("Generar Reporte");
        generarReporteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteBtnActionPerformed(evt);
            }
        });

        reporteTxtArea.setColumns(20);
        reporteTxtArea.setRows(5);
        reporteTxtArea.setText("Reporte :)");
        jScrollPane1.setViewportView(reporteTxtArea);

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        exportarBtn.setText("Exportar a PDF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportarBtn))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tipoTramitesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tipoTramitesLabel))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(solicitanteTramitesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(solicitanteTramitesTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(periodoTramitesLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(periodoDesdeTramitesTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(periodoHastaTramitesTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(generarReporteBtn)))))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoTramitesLabel)
                    .addComponent(solicitanteTramitesLabel)
                    .addComponent(periodoTramitesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoTramitesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solicitanteTramitesTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodoDesdeTramitesTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodoHastaTramitesTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generarReporteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBtn)
                    .addComponent(exportarBtn))
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 800, 770));

        headerImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marcoPantallaPrincipal.png"))); // NOI18N
        headerImgLabel.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(headerImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(headerImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 130));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void tipoTramitesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoTramitesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoTramitesComboBoxActionPerformed

    private void generarReporteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteBtnActionPerformed
        /* Output file location to create report in pdf form */
//        String outputFile = "C:\\Users\\amitk\\Desktop\\JASPER\\" + "JasperReportExample.pdf";
        try
        {         
            List<TramitesDTO> dsReporteTramites = new ArrayList<TramitesDTO>();
//            Date sqlDate = Date.valueOf("2024-01-01");
            Calendar calendar = Calendar.getInstance();
//            System.out.println(sqlDate.toString());
//            dsReporteTramites.add(new TramitesDTO(900, sqlDate, "Placa", "Laurita Galindo Soto"));
//            dsReporteTramites.add(new TramitesDTO(900, sqlDate, "Placa", "Laurita Galindo Soto"));
            /* Placas */
            if(tipoTramitesComboBox.getSelectedIndex() == 0)
            {
                if(solicitanteTramitesTxtField.getText().isBlank() && (periodoDesdeTramitesTxtField.getText().isBlank() || periodoHastaTramitesTxtField.getText().isBlank()))
                {
                    dsReporteTramites = tramitesPlacaNegocio.cargarTodosTramites();
                }
                else if(periodoDesdeTramitesTxtField.getText().isBlank() || periodoHastaTramitesTxtField.getText().isBlank())
                {
                    dsReporteTramites = tramitesPlacaNegocio.cargarTramitesByNombre(solicitanteTramitesTxtField.getText());
                }
                else if(solicitanteTramitesTxtField.getText().isBlank())
                {
                    dsReporteTramites = tramitesPlacaNegocio.cargarTramitesInPeriod(calendar, calendar);
                }
                else
                {
                    dsReporteTramites = tramitesPlacaNegocio.cargarTramitesByNombreInPeriod(solicitanteTramitesTxtField.getText(), 
                            calendar, calendar);
                }
            }

            /* Licencias */
            if(tipoTramitesComboBox.getSelectedIndex() == 1)
            {
                if(solicitanteTramitesTxtField.getText().isBlank() && (periodoDesdeTramitesTxtField.getText().isBlank() || periodoHastaTramitesTxtField.getText().isBlank()))
                {
                    dsReporteTramites = tramitesLicenciaNegocio.cargarTodosTramites();
                }
                else if(periodoDesdeTramitesTxtField.getText().isBlank() || periodoHastaTramitesTxtField.getText().isBlank())
                {
                    dsReporteTramites = tramitesLicenciaNegocio.cargarTramitesByNombre(solicitanteTramitesTxtField.getText());
                }
                else if(solicitanteTramitesTxtField.getText().isBlank())
                {
                    dsReporteTramites = tramitesLicenciaNegocio.cargarTramitesInPeriod(calendar, calendar);
                }
                else
                {
                    dsReporteTramites = tramitesLicenciaNegocio.cargarTramitesByNombreInPeriod(solicitanteTramitesTxtField.getText(), 
                            calendar, calendar);
                }
            }

            /* Todos */
            if(tipoTramitesComboBox.getSelectedIndex() == 2)
            {
                if(solicitanteTramitesTxtField.getText().isBlank() && (periodoDesdeTramitesTxtField.getText().isBlank() || periodoHastaTramitesTxtField.getText().isBlank()))
                {
                    dsReporteTramites = tramitesPlacaNegocio.cargarTodosTramites();
                    dsReporteTramites.addAll(tramitesLicenciaNegocio.cargarTodosTramites());
                }
                else if(periodoDesdeTramitesTxtField.getText().isBlank() || periodoHastaTramitesTxtField.getText().isBlank())
                {
                    dsReporteTramites = tramitesPlacaNegocio.cargarTramitesByNombre(solicitanteTramitesTxtField.getText());
                    dsReporteTramites.addAll(tramitesLicenciaNegocio.cargarTramitesByNombre(solicitanteTramitesTxtField.getText()));
                }
                else if(solicitanteTramitesTxtField.getText().isBlank())
                {
                    dsReporteTramites = tramitesPlacaNegocio.cargarTramitesInPeriod(calendar, calendar);
                    dsReporteTramites.addAll(tramitesLicenciaNegocio.cargarTramitesInPeriod(calendar, calendar));
                }
                else
                {
                    dsReporteTramites = tramitesPlacaNegocio.cargarTramitesByNombreInPeriod(solicitanteTramitesTxtField.getText(), 
                            calendar, calendar);
                    dsReporteTramites.addAll(tramitesLicenciaNegocio.cargarTramitesByNombreInPeriod(solicitanteTramitesTxtField.getText(), 
                            calendar, calendar));
                }
            }

            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(dsReporteTramites);

            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("ds", itemsJRBean);

            //read jrxml file and creating jasperdesign object
            InputStream input = new FileInputStream(new File("src/main/resources/Reports/ReporteTramites.jrxml"));

            JasperDesign jasperDesign = JRXmlLoader.load(input);

            /*compiling jrxml with help of JasperReport class*/
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            /* Using jasperReport object to generate PDF */
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            /*call jasper engine to display report in jasperviewer window*/
            JasperViewer.viewReport(jasperPrint);


            /* outputStream to create PDF */
            //OutputStream outputStream = new FileOutputStream(new File(outputFile));


            /* Write content to PDF file */
            //JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            System.out.println("File Generated");
        }
        catch(JRException | FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_generarReporteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JButton exportarBtn;
    private javax.swing.JButton generarReporteBtn;
    private javax.swing.JLabel headerImgLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField periodoDesdeTramitesTxtField;
    private javax.swing.JTextField periodoHastaTramitesTxtField;
    private javax.swing.JLabel periodoTramitesLabel;
    private javax.swing.JTextArea reporteTxtArea;
    private javax.swing.JLabel solicitanteTramitesLabel;
    private javax.swing.JTextField solicitanteTramitesTxtField;
    private javax.swing.JComboBox<String> tipoTramitesComboBox;
    private javax.swing.JLabel tipoTramitesLabel;
    // End of variables declaration//GEN-END:variables
}
