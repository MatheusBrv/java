package interfacez;

import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import laboratorio_clinico.conexion_MYSQL;

/**
 *
  * @authores :
 * Sornoza Samuel
 * Hidalgo Silvia
 * Bravo Matheus
 */
public class search_P extends javax.swing.JFrame {

    DefaultTableModel model;

    // Esrtablecer conexion a MYSQL
    conexion_MYSQL c = new conexion_MYSQL();
    Connection conectar = c.obtener_conexion();

    String[] Campos_tabla = {"Cédula", "Nombres", "Apellidos", "Edad", "Dirección", "Télefono"};
    String[] informacion = new String[50]; /*2 ta*/

    public void mostrar_pacientes() {

        //Query para para realizar la consulta en la base de datos...
        String Query = "SELECT *FROM pacientes";
        model = new DefaultTableModel(null, Campos_tabla);
        try {
            Statement st = (Statement) conectar.createStatement();
            ResultSet rs = st.executeQuery(Query);

            while (rs.next()) {    /*3 n*tc + tc*/
                informacion[0] = rs.getString("cedula");
                informacion[1] = rs.getString("nombres");
                informacion[2] = rs.getString("apellidos");
                informacion[3] = rs.getString("edad");
                informacion[4] = rs.getString("direccion");
                informacion[5] = rs.getString("telefono");

                model.addRow(informacion);
            }
            tabla_pacientes.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public search_P() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/images/icon.png")).getImage();
        setIconImage(icon);
        mostrar_pacientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton(); // ta - Asignación de un botón
        jScrollPane2 = new javax.swing.JScrollPane(); // ta - Asignación de un componente de desplazamiento
        tabla_pacientes = new javax.swing.JTable(); // ta - Asignación de una tabla
        jLabel2 = new javax.swing.JLabel(); // ta - Asignación de una etiqueta
        txt_search = new javax.swing.JTextField(); // ta - Asignación de un campo de texto
        jButton2 = new javax.swing.JButton(); // ta - Asignación de otro botón

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(250, 240, 212));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mis Pacientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N // ta - Asignación de un panel
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 51, 255)); // ta - Asignación de color a un botón
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N // ta - Asignación de una fuente al botón
        jButton1.setForeground(new java.awt.Color(255, 255, 255)); // ta - Asignación de una fuente al botón
        jButton1.setText("Agregar Pacientes"); // ta - Asignación de texto a un botón
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1)); // ta - Asignación de posición al botón

        tabla_pacientes = new JTable()
        {
            public boolean isCellEditable(int row, int column)
            {
                for (int i = 0; i< tabla_pacientes.getRowCount();i++)
                {
                    if(row==i)
                    {
                        return false;
                    }
                }
                return true;
            }
        };
        tabla_pacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombres", "Apellidos", "edad", "Direccion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_pacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_pacientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_pacientes);
        if (tabla_pacientes.getColumnModel().getColumnCount() > 0) {
            tabla_pacientes.getColumnModel().getColumn(3).setMinWidth(50);
            tabla_pacientes.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabla_pacientes.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 590, 190));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N // ta - Asignación de una fuente a la etiqueta
        jLabel2.setForeground(new java.awt.Color(0, 0, 0)); // ta - Asignación de color de fuente a la etiqueta
        jLabel2.setText("Buscar paciente por nombre:"); // ta - Asignación de texto a la etiqueta
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20)); // ta - Asignación de posición a la etiqueta

        txt_search.setBackground(new java.awt.Color(255, 255, 255)); // ta - Asignación de color de fondo al campo de texto
        txt_search.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N // ta - Asignación de fuente al campo de texto
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchKeyPressed(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 63, 160, 30)); // ta - Asignación de posición al campo de texto

        jButton2.setBackground(new java.awt.Color(255, 255, 255)); // ta - Asignación de color a otro botón
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N // ta - Asignación de fuente a otro botón
        jButton2.setForeground(new java.awt.Color(0, 0, 0));// ta - Asignación de color de fuente a otro botón
        jButton2.setText("CANCELAR"); // ta - Asignación de texto a otro botón
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, -1)); // ta - Asignación de posición a otro botón

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed // ta - Asignación de un botón
        register_P rp = new register_P();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed // ta - Asignación de otro botón
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabla_pacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_pacientesMouseClicked
        // ta - Manejo del evento de clic en la tabla de pacientes
        int columna = tabla_pacientes.getSelectedRow();
        if (evt.getClickCount() == 2) {

            register_P r = new register_P();
            r.setVisible(true);
            // ta - Asignación de valores a los campos en la ventana de registro
            register_P.txt_cedula.setText(tabla_pacientes.getModel().getValueAt(columna, 0).toString());
            register_P.txt_name.setText(tabla_pacientes.getModel().getValueAt(columna, 1).toString());
            register_P.txt_lastname.setText(tabla_pacientes.getModel().getValueAt(columna, 2).toString());
            register_P.txt_age.setText(tabla_pacientes.getModel().getValueAt(columna, 3).toString());
            register_P.txt_address.setText(tabla_pacientes.getModel().getValueAt(columna, 4).toString());
            register_P.txt_phone.setText(tabla_pacientes.getModel().getValueAt(columna, 5).toString());

            register_P.btn_register.setEnabled(false);
            register_P.btn_update.setEnabled(true);
            register_P.btn_delete.setEnabled(true);

            this.dispose();
        }
    }//GEN-LAST:event_tabla_pacientesMouseClicked

    private void txt_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyPressed
        // to - Inicio del procesamiento de la tecla presionada en el campo de búsqueda
        //Query para para realizar consulta por medio LIKE...
        String Query = "SELECT *FROM pacientes WHERE nombres LIKE '%" + txt_search.getText() + "%' ";
        model = new DefaultTableModel(null, Campos_tabla);
        try {
            Statement st = (Statement) conectar.createStatement();
            ResultSet rs = st.executeQuery(Query);

            while (rs.next()) {
                informacion[0] = rs.getString("cedula");
                informacion[1] = rs.getString("nombres");
                informacion[2] = rs.getString("apellidos");
                informacion[3] = rs.getString("edad");
                informacion[4] = rs.getString("direccion");
                informacion[5] = rs.getString("telefono");

                model.addRow(informacion);
            }
            tabla_pacientes.setModel(model);
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_txt_searchKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
             //tc - Manejo de excepción en caso de error de clase no encontrada
            java.util.logging.Logger.getLogger(search_P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            // tc - Manejo de excepción en caso de error de instanciación
            java.util.logging.Logger.getLogger(search_P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
        // tc - Manejo de excepción en caso de error de acceso ilegal
            java.util.logging.Logger.getLogger(search_P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            // tc - Manejo de excepción en caso de error de apariencia no soportada
            java.util.logging.Logger.getLogger(search_P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search_P().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable tabla_pacientes;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
