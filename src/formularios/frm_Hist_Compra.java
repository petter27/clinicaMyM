
package formularios;
import entidades.conexionDB;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pedro
 */
public class frm_Hist_Compra extends javax.swing.JFrame {
conexionDB cn = new conexionDB();
     DefaultTableModel model;
     DefaultTableModel modeloDetalle;
     DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
     
    public frm_Hist_Compra() throws SQLException{
        initComponents();
        this.jtCompra.setSelectionForeground(Color.white);
        this.jtDetalle.setSelectionForeground(Color.white);
        this.fecha1.setDateFormat(formatoFecha);
        this.fecha2.setDateFormat(formatoFecha);
        cn.conectarBD();
        this.jtCompra.setModel(cn.hcompra(this.jtCompra));
        this.model = (DefaultTableModel) jtCompra.getModel();
        cn.conn.close();
    }
                @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/images/logo-M&M-64x64.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCompra = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtDetalle = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        rdbPer = new javax.swing.JRadioButton();
        rdbMensual = new javax.swing.JRadioButton();
        rdbDiario = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        fecha1 = new datechooser.beans.DateChooserCombo();
        fecha2 = new datechooser.beans.DateChooserCombo();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial de Compras");
        setIconImage(getIconImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historial de Compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jtCompra.setBackground(new java.awt.Color(51, 51, 51));
        jtCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtCompra.setForeground(new java.awt.Color(255, 255, 255));
        jtCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Proovedor", "Fecha", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCompra.setRowHeight(20);
        jtCompra.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jtCompra.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCompra);

        jtDetalle.setBackground(new java.awt.Color(51, 51, 51));
        jtDetalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtDetalle.setForeground(new java.awt.Color(255, 255, 255));
        jtDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio", "Cantidad", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDetalle.setRowHeight(20);
        jtDetalle.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jtDetalle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jtDetalle);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        buttonGroup1.add(rdbPer);
        rdbPer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbPer.setText("Personalizada");

        buttonGroup1.add(rdbMensual);
        rdbMensual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbMensual.setText("Mensual");

        buttonGroup1.add(rdbDiario);
        rdbDiario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbDiario.setText("Diaria");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Desde:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Hasta:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/btnBuscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fecha1.setCalendarPreferredSize(new java.awt.Dimension(350, 250));
        fecha1.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));

        fecha2.setCalendarPreferredSize(new java.awt.Dimension(350, 250));
        fecha2.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbPer)
                            .addComponent(jLabel2)
                            .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdbMensual)
                                .addGap(43, 43, 43)
                                .addComponent(rdbDiario))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1)
                    .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPer)
                    .addComponent(rdbMensual)
                    .addComponent(rdbDiario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/btnRegresar.png"))); // NOI18N
        jButton3.setText("Menú");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCompraMouseClicked
        cn.conectarBD();
        if (this.jtCompra.getSelectedRows().length ==1) {
            try {
                String codeCompra =String.valueOf(model.getValueAt(jtCompra.getSelectedRow(),0));
                modeloDetalle = cn.hDetalle(jtDetalle, codeCompra);
                this.jtDetalle.setModel(modeloDetalle);
                cn.conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.toString());
            }
            
        }
    }//GEN-LAST:event_jtCompraMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(this.rdbPer.isSelected())
        {
            try {
                cn.conectarBD();
                String query = "SELECT C.idCompra, P.proveedor_nombre, C.fecha_compra, C.total FROM compra C "+
                        " INNER JOIN proveedor P ON P.idProveedor = C.idProveedor "
                        + "WHERE fecha_compra >= '"+this.fecha1.getText()+"' AND fecha_compra <= '"+this.fecha2.getText()+"';";
                jtCompra.setModel(cn.buscarCompra(jtCompra, query));
                 if (this.jtDetalle.getRowCount() >0)this.modeloDetalle.setRowCount(0);
                 cn.conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.toString());
            }
        }
        else
        {
            if(this.rdbDiario.isSelected())
            {
                 try {
                     cn.conectarBD();
                String query = "SELECT C.idCompra, P.proveedor_nombre, C.fecha_compra, C.total FROM compra C "+
                        " INNER JOIN proveedor P ON P.idProveedor = C.idProveedor "
                        + "WHERE fecha_compra = CURDATE();";
                jtCompra.setModel(cn.buscarCompra(jtCompra, query));
                 if (this.jtDetalle.getRowCount() >0)this.modeloDetalle.setRowCount(0);
                 cn.conn.close();
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "ERROR: " + ex.toString());
            }
            }
            else
            {
                 try {
                     cn.conectarBD();
                String query = "SELECT C.idCompra, P.proveedor_nombre, C.fecha_compra, C.total FROM compra C "+
                        " INNER JOIN proveedor P ON P.idProveedor = C.idProveedor "
                        + "WHERE month(fecha_compra) = MONTh(CURDATE());";
                jtCompra.setModel(cn.buscarCompra(jtCompra, query));
                if (this.jtDetalle.getRowCount() >0)this.modeloDetalle.setRowCount(0);
                cn.conn.close();
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "ERROR: " + ex.toString());
            }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_Hist_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Hist_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Hist_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Hist_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                new frm_Hist_Compra().setVisible(true);
                   }catch (SQLException ex) {
                        Logger.getLogger(frm_Ver_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    datechooser.beans.DateChooserCombo fecha1;
    datechooser.beans.DateChooserCombo fecha2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtCompra;
    private javax.swing.JTable jtDetalle;
    private javax.swing.JRadioButton rdbDiario;
    private javax.swing.JRadioButton rdbMensual;
    private javax.swing.JRadioButton rdbPer;
    // End of variables declaration//GEN-END:variables
}
