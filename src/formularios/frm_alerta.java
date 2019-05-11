/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import entidades.conexionDB;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class frm_alerta extends javax.swing.JFrame {
conexionDB cn = new conexionDB();
     DefaultTableModel model;
     SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
     String query2; 
     String arrayCat[];
     String idCategoria[];
    /**
     * Creates new form frm_alerta
     */
    public frm_alerta() {
        initComponents();
         this.dgvAlertas.setSelectionForeground(Color.white);
        
    try {
        cn.conectarBD();
        String query="SELECT idProducto,producto_nombre,categoria_nombre,producto_stock,"
                 + "producto_fechaExp FROM producto "
                 + "inner join categoria on categoria.idCategoria=producto.idCategoria where producto_stock<=5 or TIMESTAMPDIFF(MONTH,now(),"
                + "producto_fechaExp)<3 ORDER BY idProducto;" ;
        this.dgvAlertas.setModel(cn.Alertas(this.dgvAlertas,query));
        int fecha=cn.AlertaFecha();
        int cantidad=cn.AlertaStock();
        int todas=cn.AlertaSF();
        this.btnTodas.setText("Todas("+(todas)+")");
        this.btnExistencia.setText("Existencia("+cantidad+")");
        this.btnVencimiento.setText("Vencimiento("+fecha+")");
        cn.conn.close();
    } catch (SQLException ex) {
        Logger.getLogger(frm_alerta.class.getName()).log(Level.SEVERE, null, ex);
    }
        this.model = (DefaultTableModel) this.dgvAlertas.getModel();
        
        
    }

                    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/images/logo-M&M-64x64.png"));
        return retValue;
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
        dgvAlertas = new javax.swing.JTable();
        btnTodas = new javax.swing.JButton();
        btnExistencia = new javax.swing.JButton();
        btnVencimiento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alertas");
        setIconImage(getIconImage());

        dgvAlertas.setBackground(new java.awt.Color(51, 51, 51));
        dgvAlertas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dgvAlertas.setForeground(new java.awt.Color(255, 255, 255));
        dgvAlertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoria", "Stock", "FechaExp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvAlertas.setRowHeight(20);
        dgvAlertas.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(dgvAlertas);

        btnTodas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTodas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/verPacientes.png"))); // NOI18N
        btnTodas.setText("Todas");
        btnTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasActionPerformed(evt);
            }
        });

        btnExistencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/inventario.png"))); // NOI18N
        btnExistencia.setText("Existencia");
        btnExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExistenciaActionPerformed(evt);
            }
        });

        btnVencimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVencimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/ver_compras.png"))); // NOI18N
        btnVencimiento.setText("Vencimiento");
        btnVencimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVencimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodasActionPerformed

    try {
        cn.conectarBD();
        String query="SELECT idProducto,producto_nombre,categoria_nombre,producto_stock,"
                 + "producto_fechaExp FROM producto "
                 + "inner join categoria on categoria.idCategoria=producto.idCategoria where producto_stock<=5 or TIMESTAMPDIFF(MONTH,now(),"
                + "producto_fechaExp)<3 ORDER BY idProducto;" ;
        this.dgvAlertas.setModel(cn.Alertas(this.dgvAlertas,query));
cn.conn.close();
    } catch (SQLException ex) {
        Logger.getLogger(frm_alerta.class.getName()).log(Level.SEVERE, null, ex);
    }
        this.model = (DefaultTableModel) this.dgvAlertas.getModel();
            
        
// TODO add your handling code here:
    }//GEN-LAST:event_btnTodasActionPerformed

    private void btnExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExistenciaActionPerformed
 try {
     cn.conectarBD();
        String query="SELECT idProducto,producto_nombre,categoria_nombre,producto_stock,"
                 + "producto_fechaExp FROM producto  "
                 + "inner join categoria on categoria.idCategoria=producto.idCategoria where producto_stock<=5 ORDER BY idProducto;" ;
        this.dgvAlertas.setModel(cn.Alertas(this.dgvAlertas,query));
        cn.conn.close();
    } catch (SQLException ex) {
        Logger.getLogger(frm_alerta.class.getName()).log(Level.SEVERE, null, ex);
    }
        this.model = (DefaultTableModel) this.dgvAlertas.getModel();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExistenciaActionPerformed

    private void btnVencimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVencimientoActionPerformed
 try {
     cn.conectarBD();
        String query="SELECT idProducto,producto_nombre,categoria_nombre,producto_stock,"
                 + "producto_fechaExp FROM producto "
                 + "inner join categoria on categoria.idCategoria=producto.idCategoria where TIMESTAMPDIFF(MONTH,now(),"
                + "producto_fechaExp)<3 ORDER BY idProducto;" ;
        this.dgvAlertas.setModel(cn.Alertas(this.dgvAlertas,query));
cn.conn.close();
    } catch (SQLException ex) {
        Logger.getLogger(frm_alerta.class.getName()).log(Level.SEVERE, null, ex);
    }
        this.model = (DefaultTableModel) this.dgvAlertas.getModel();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnVencimientoActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_alerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_alerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_alerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_alerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_alerta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExistencia;
    private javax.swing.JButton btnTodas;
    private javax.swing.JButton btnVencimiento;
    private javax.swing.JTable dgvAlertas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}