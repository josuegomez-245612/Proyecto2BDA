/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Entidades.Persona;
import Interfaces.IConexionBD;
import Persistencia.PersistenciaException;
import Persistencia.PersonaDAO;
import Utilidades.ConstantesGUI;
import Utilidades.ParametrosBusquedaPersonas;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOSUE GOMEZ
 */
public class ConsultarPersonas extends javax.swing.JFrame {

    IConexionBD conexion;
    PersonaDAO pDAO;
    ConstantesGUI operacion;

    /**
     * Creates new form ConsultarPlacas
     *
     * @param conexion
     */
    public ConsultarPersonas(IConexionBD conexion, ConstantesGUI gui) {
        initComponents();
        this.conexion = conexion;
        this.pDAO = new PersonaDAO(conexion.crearConexion());
        this.cargarPersonas();
        this.operacion = gui;

    }

    private void cargarPersonas() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel modeloTabla = (DefaultTableModel) this.listaPersonasJT.getModel();
        modeloTabla.setRowCount(0);
        List<Persona> listaPersonas = new ArrayList<>();
        if (this.txtFieldNombre.getText().equalsIgnoreCase("Ingrese su Nombre") && this.txtFieldCURP.getText().equalsIgnoreCase("Ingrese su CURP") && this.DpFecha.getDate() == null) {
            listaPersonas = pDAO.cargarTodasPersonas();
        } else {
            ParametrosBusquedaPersonas parametros = new ParametrosBusquedaPersonas(this.txtFieldCURP.getText(), this.txtFieldNombre.getText(), this.DpFecha.getDate());
            listaPersonas = pDAO.consultarPersonas(parametros);
        }
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i) != null) {
                Object[] fila = {listaPersonas.get(i).getNombres(), listaPersonas.get(i).getApellido_paterno(),
                    listaPersonas.get(i).getApellido_materno(), listaPersonas.get(i).getRfc(), listaPersonas.get(i).getCurp(), formateador.format((listaPersonas.get(i).getFecha_nacimiento()).getTime())};
                modeloTabla.addRow(fila);
            }
        }
    }

    /**
     * Método que comprueba que la persona puede continuar con el trámite de
     * licencia
     *
     * @param rfcPersonaSeleccionada Rfc de la persona
     */
    private void operacionLicencia(String rfcPersonaSeleccionada) throws PersistenciaException {
        boolean vigencia = pDAO.consultarLicenciaVigentePersona(rfcPersonaSeleccionada),
                mayoriaEdad = pDAO.validarMayoriaEdadPersona(rfcPersonaSeleccionada);

        if (vigencia && mayoriaEdad) {
            JOptionPane.showMessageDialog(null, "No se puede registrar licencia para esta persona debido a que ya cuenta con una vigente");
        } else if (!vigencia && mayoriaEdad) {
            JOptionPane.showMessageDialog(null, "Cumple con los requisitos para seguir con el trámite");
            Persona personaElegida = this.pDAO.getPersonaByCurp((String) this.listaPersonasJT.getValueAt(this.listaPersonasJT.getSelectedRow(), 4));
            new JDRenovarLicencia(conexion, personaElegida, this, true).setVisible(true);
            this.setVisible(false);
        } else if (!vigencia && !mayoriaEdad) {
            JOptionPane.showMessageDialog(null, "No se puede registrar licencia para esta persona debido a que es menor de edad");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede registrar licencia para esta persona debido a que es menor de edad");
        }
    }
      private void operacionPlacas(String rfcPersonaSeleccionada) throws PersistenciaException {
    boolean vigencia = pDAO.consultarLicenciaVigentePersona(rfcPersonaSeleccionada),
            mayoriaEdad = pDAO.validarMayoriaEdadPersona(rfcPersonaSeleccionada);
    if (vigencia && mayoriaEdad) {
        JOptionPane.showMessageDialog(null, "Cumple con los requisitos para seguir con el trámite");
       Persona personaElegida = this.pDAO.getPersonaByCurp((String) this.listaPersonasJT.getValueAt(this.listaPersonasJT.getSelectedRow(), 4));
//            new JDSeleccionPlacas(conexion, personaElegida, this, true).setVisible(true);
            this.setVisible(false);
    } else if (!vigencia && mayoriaEdad) {
        JOptionPane.showMessageDialog(null, "No se puede seguir con el trámite debido a que no cuenta con una licencia vigente");
    } else if (!vigencia && !mayoriaEdad) {
        JOptionPane.showMessageDialog(null, "No se puede seguir con el trámite debido a que no cuenta con una licencia vigente y es menor de edad");
    } else {
        JOptionPane.showMessageDialog(null, "No se puede seguir con el trámite debido a que es menor de edad");
    }
}

    public void Consultar() throws PersistenciaException {
        Integer indiceRenglonInicial = 0, indiceColumnaCURP = 4;
        if (this.listaPersonasJT.getSelectedRow() >= indiceRenglonInicial) {
            String CURPPersonaSeleccionada = (String) this.listaPersonasJT.getModel().getValueAt(this.listaPersonasJT.getSelectedRow(), indiceColumnaCURP);
            if (null != this.operacion) switch (this.operacion) {
                case LICENCIAS:
                    this.operacionLicencia(CURPPersonaSeleccionada);
                    break;
                case PLACAS:
                    this.operacionPlacas(CURPPersonaSeleccionada);
                    break;
                case HISTORIAL:
//                    this.operacionHistorial(CURPPersonaSeleccionada);
                    break;
                default:
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, this, "Seleccione a una persona.", JOptionPane.INFORMATION_MESSAGE);
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
        imagen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPersonasJT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DpFecha = new com.github.lgooddatepicker.components.DatePicker();
        txtFieldCURP = new javax.swing.JTextField();
        txtFieldNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 900));
        setPreferredSize(new java.awt.Dimension(800, 900));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(227, 227, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(804, 878));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marcoPantallaPrincipal.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 813, 130));

        jPanel2.setBackground(new java.awt.Color(227, 227, 217));

        jLabel1.setText("Seleccione a la persona a la cual se quiere tramitar la licencia");
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        listaPersonasJT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Jorge Elias", "JEIE46856161", "08/02/2024", null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "RFC", "CURP", "Fecha de nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaPersonasJT.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(listaPersonasJT);
        if (listaPersonasJT.getColumnModel().getColumnCount() > 0) {
            listaPersonasJT.getColumnModel().getColumn(0).setResizable(false);
            listaPersonasJT.getColumnModel().getColumn(1).setResizable(false);
            listaPersonasJT.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setText("CURP");
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        jLabel3.setText("Nombre");
        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        jLabel4.setText("Fecha de Nacimiento");
        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        jLabel5.setText("Buscar por: ");
        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        jButton2.setText("Consultar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel6");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgBusqueda/loupe-et-icone-de-recherche-de-couleur-orange (1).png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        txtFieldCURP.setText("Ingrese su CURP");
        txtFieldCURP.setBorder(null);
        txtFieldCURP.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldCURP.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldCURP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldCURPFocusLost(evt);
            }
        });
        txtFieldCURP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldCURPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldCURPMouseExited(evt);
            }
        });
        txtFieldCURP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCURPActionPerformed(evt);
            }
        });
        txtFieldCURP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldCURPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldCURPKeyTyped(evt);
            }
        });

        txtFieldNombre.setText("Ingrese su Nombre");
        txtFieldNombre.setBorder(null);
        txtFieldNombre.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldNombreFocusLost(evt);
            }
        });
        txtFieldNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldNombreMouseExited(evt);
            }
        });
        txtFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNombreActionPerformed(evt);
            }
        });
        txtFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldNombreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jButton3)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtFieldCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4))
                            .addComponent(DpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldCURP, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 813, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.Consultar();
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConsultarPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtFieldCURPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldCURPFocusLost
        if (txtFieldCURP.getText().equals("")) {
            txtFieldCURP.setText("Ingrese su CURP");
        }
    }//GEN-LAST:event_txtFieldCURPFocusLost

    private void txtFieldCURPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldCURPMouseEntered
        if (txtFieldCURP.getText().equals("Ingrese su CURP"))
            txtFieldCURP.setText("");
    }//GEN-LAST:event_txtFieldCURPMouseEntered

    private void txtFieldCURPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldCURPMouseExited
        if (txtFieldCURP.getText().equals("")) {
            txtFieldCURP.setText("Ingrese su CURP");
        } else if (!txtFieldCURP.getText().equals("Ingrese su CURP")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldCURPMouseExited

    private void txtFieldCURPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCURPActionPerformed

    }//GEN-LAST:event_txtFieldCURPActionPerformed

    private void txtFieldCURPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCURPKeyReleased
        // TODO add your handling code here:
        txtFieldCURP.setText(txtFieldCURP.getText().trim());
    }//GEN-LAST:event_txtFieldCURPKeyReleased

    private void txtFieldCURPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCURPKeyTyped
        txtFieldCURP.setText(txtFieldCURP.getText().trim());
        if (txtFieldCURP.getText().equals("Ingrese su CURP")) {
            txtFieldCURP.setText("");
        }

        // Permitir solo letras y números
        char c = evt.getKeyChar();
        if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldCURPKeyTyped

    private void txtFieldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldNombreFocusLost
        if (txtFieldNombre.getText().equals("")) {
            txtFieldNombre.setText("Ingrese su Nombre");
        }
    }//GEN-LAST:event_txtFieldNombreFocusLost

    private void txtFieldNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNombreMouseEntered
        if (txtFieldNombre.getText().equals("Ingrese su Nombre"))
            txtFieldNombre.setText("");
    }//GEN-LAST:event_txtFieldNombreMouseEntered

    private void txtFieldNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNombreMouseExited
        if (txtFieldNombre.getText().trim().equals("")) {
            txtFieldNombre.setText("Ingrese su Nombre");
        } else if (!txtFieldNombre.getText().equals("Ingrese su Nombre")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldNombreMouseExited

    private void txtFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNombreActionPerformed

    }//GEN-LAST:event_txtFieldNombreActionPerformed

    private void txtFieldNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyReleased
        // TODO add your handling code here:
        //txtFieldNombre.setText(txtFieldNombre.getText().trim());
    }//GEN-LAST:event_txtFieldNombreKeyReleased
    private boolean spacePressed = false;
    private void txtFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            // El caracter ingresado es una letra
            evt.setKeyChar(c); // Permitir el caracter
            spacePressed = false;
        } else if (Character.isISOControl(c)) {
            // Permitir caracteres de control como backspace y delete
            evt.setKeyChar(c);
            spacePressed = false;
        } else if (Character.isWhitespace(c)) {
            // Permitir un solo espacio
            if (!spacePressed) {
                evt.setKeyChar(c);
                spacePressed = true;
            } else {
                evt.consume(); // Ignorar el caracter
            }
        } else {
            // El caracter ingresado no es una letra ni un caracter de control
            evt.consume(); // Ignorar el caracter
            spacePressed = false;
        }
    }//GEN-LAST:event_txtFieldNombreKeyTyped

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.cargarPersonas();
    }//GEN-LAST:event_jLabel7MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker DpFecha;
    private javax.swing.JLabel imagen;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaPersonasJT;
    private javax.swing.JTextField txtFieldCURP;
    private javax.swing.JTextField txtFieldNombre;
    // End of variables declaration//GEN-END:variables
}
