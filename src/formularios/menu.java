
package formularios;

import entidades.conexionDB;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class menu extends javax.swing.JFrame implements Runnable{
     //reloj
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    public static int  TipoU;
    // reloj
    public menu() {
        initComponents();
         //reloj
        h1 = new Thread((Runnable) this);
        h1.start();
        //reloj
    }
       public void run() {
                      Thread ct = Thread.currentThread();
                      while (ct == h1) {
                          calcula();
                          this.lbHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
                          try {
                              Thread.sleep(1000);
                          } catch (InterruptedException e) {
                          }
                      }
                  }
            public void calcula() {
                Calendar calendario = new GregorianCalendar();
                Date fechaHoraActual = new Date();


                calendario.setTime(fechaHoraActual);
                ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

                if (ampm.equals("PM")) {
                    int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
                    hora = h > 9 ? "" + h : "0" + h;
                } else {
                    hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
                }
                minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
                segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
 
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

        jPanel1 = new javax.swing.JPanel();
        btnRV = new javax.swing.JButton();
        btnAP = new javax.swing.JButton();
        btnAC = new javax.swing.JButton();
        btnHC = new javax.swing.JButton();
        btnHV = new javax.swing.JButton();
        btnVI = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnVP = new javax.swing.JButton();
        lbHora = new javax.swing.JLabel();
        btnHV1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setExtendedState(6);
        setIconImage(getIconImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menú", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnRV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/contabilidad.png"))); // NOI18N
        btnRV.setText("Registrar Venta");
        btnRV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRVActionPerformed(evt);
            }
        });

        btnAP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/aggPaciente..png"))); // NOI18N
        btnAP.setText("Agregar Proveedor");
        btnAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPActionPerformed(evt);
            }
        });

        btnAC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/anadir carrito.png"))); // NOI18N
        btnAC.setText("Registrar Compra");
        btnAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnACActionPerformed(evt);
            }
        });

        btnHC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/ver_compras.png"))); // NOI18N
        btnHC.setText("Historial Compras");
        btnHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHCActionPerformed(evt);
            }
        });

        btnHV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/cartera.png"))); // NOI18N
        btnHV.setText("Historial Ventas");
        btnHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHVActionPerformed(evt);
            }
        });

        btnVI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/inventario.png"))); // NOI18N
        btnVI.setText("Ver Inventario");
        btnVI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVIActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/despachar.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnVP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/btnVer.png"))); // NOI18N
        btnVP.setText("Ver Proveedores");
        btnVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPActionPerformed(evt);
            }
        });

        lbHora.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHora.setText("jLabel1");

        btnHV1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/verPacientes.png"))); // NOI18N
        btnHV1.setText("Reportes");
        btnHV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHV1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVI, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRV, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAC))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVP)
                            .addComponent(btnHV, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHV1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnHV, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVI, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHV1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRVActionPerformed
    frm_Reg_Venta rv =new frm_Reg_Venta();
    rv.setVisible(true);
        
    }//GEN-LAST:event_btnRVActionPerformed

    private void btnAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPActionPerformed
   frm_Reg_Proveedor rp =new frm_Reg_Proveedor();
    rp.setVisible(true);     

// TODO add your handling code here:
    }//GEN-LAST:event_btnAPActionPerformed

    private void btnVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVPActionPerformed
    try {
        frm_Ver_Proveedor vp =new frm_Ver_Proveedor();
        vp.setVisible(true);  
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVPActionPerformed

    private void btnACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnACActionPerformed
    frm_Agg_Producto ap =new frm_Agg_Producto();
    ap.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnACActionPerformed

    private void btnHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHCActionPerformed
    try {
        frm_Hist_Compra hc =new frm_Hist_Compra();
        hc.setVisible(true);
    }catch  (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHCActionPerformed

    private void btnHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHVActionPerformed
        try {
            frm_Hist_Venta hv =new frm_Hist_Venta();        
            hv.setVisible(true);
// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHVActionPerformed

    private void btnVIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVIActionPerformed
    try {
    frm_Inventario fi =new frm_Inventario();
    frm_Inventario.TipoU=menu.TipoU;
    fi.setVisible(true);   
     } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnVIActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
   Iniciar_form Inicio=new Iniciar_form();
   Inicio.show();
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnHV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHV1ActionPerformed
reportes rep=new reportes();
rep.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHV1ActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAC;
    private javax.swing.JButton btnAP;
    private javax.swing.JButton btnHC;
    private javax.swing.JButton btnHV;
    private javax.swing.JButton btnHV1;
    private javax.swing.JButton btnRV;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVI;
    private javax.swing.JButton btnVP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbHora;
    // End of variables declaration//GEN-END:variables
}
