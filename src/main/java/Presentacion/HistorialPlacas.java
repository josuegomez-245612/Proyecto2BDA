/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

/**
 *
 * @author Ryzen 5
 */
public class HistorialPlacas extends javax.swing.JFrame {

    ConsultarPlacas consultarPlacas;
    /**
     * Creates new form HistorialPlacas
     */
    public HistorialPlacas() {
        initComponents();
    }
    
    public HistorialPlacas(ConsultarPlacas frame) {
        initComponents();
        consultarPlacas = frame;
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
        clienteLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        historialTable = new javax.swing.JTable();
        volverBtn = new javax.swing.JButton();
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
        descClienteLabel.setText("Historial de Placas de la Persona:");
        jPanel1.add(descClienteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        clienteLabel.setText("Jorge Eduardo Elias Cazarez");
        jPanel1.add(clienteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 760, 30));

        historialTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"G5H7LN", "Sentra", "Nissan", "2008", "07/08/2012", null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numero de Placas", "Linea  Vehiculo", "Marca Vehiculo", "Modelo Vehiculo", "Fecha Expedicion", "Fecha Recepcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(historialTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 700, 540));

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });
        jPanel1.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 720, -1, -1));

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
        consultarPlacas.setVisible(true);
    }//GEN-LAST:event_volverBtnActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clienteLabel;
    private javax.swing.JLabel descClienteLabel;
    private javax.swing.JLabel headerImgLabel;
    private javax.swing.JTable historialTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables
}
