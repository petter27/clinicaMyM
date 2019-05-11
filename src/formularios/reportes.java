
package formularios;

import entidades.conexionDB;
import java.awt.Image;
import java.awt.Toolkit;
import java.security.Principal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author JRSVALDEZ
 */
public class reportes extends javax.swing.JFrame {
    public static String reporte = "";
    conexionDB cn = new conexionDB();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    public reportes() {
        initComponents();
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
        btnRcontableDiario = new javax.swing.JButton();
        btnRVentasDiarias = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnVentasPers = new javax.swing.JButton();
        btnComprasPers = new javax.swing.JButton();
        btnContabilidadPers = new javax.swing.JButton();
        btnMasVendidos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");
        setExtendedState(6);
        setIconImage(getIconImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reportes Diarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        btnRcontableDiario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRcontableDiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/contabilidad.png"))); // NOI18N
        btnRcontableDiario.setText("Contabilidad");

        btnRVentasDiarias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRVentasDiarias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/cartera.png"))); // NOI18N
        btnRVentasDiarias.setText("Ventas");
        btnRVentasDiarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRVentasDiariasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btnRVentasDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRcontableDiario)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRcontableDiario, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnRVentasDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reportes Personalizabes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        btnVentasPers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVentasPers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/cartera.png"))); // NOI18N
        btnVentasPers.setText("Ventas");
        btnVentasPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasPersActionPerformed(evt);
            }
        });

        btnComprasPers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnComprasPers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/carrito compra.png"))); // NOI18N
        btnComprasPers.setText("Compras");
        btnComprasPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasPersActionPerformed(evt);
            }
        });

        btnContabilidadPers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnContabilidadPers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/contabilidad.png"))); // NOI18N
        btnContabilidadPers.setText("Contabilidad");
        btnContabilidadPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContabilidadPersActionPerformed(evt);
            }
        });

        btnMasVendidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMasVendidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/verPacientes.png"))); // NOI18N
        btnMasVendidos.setText("Mas vendidos");
        btnMasVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasVendidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVentasPers, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMasVendidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnComprasPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnContabilidadPers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnContabilidadPers, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnComprasPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVentasPers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnMasVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Reportes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRVentasDiariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRVentasDiariasActionPerformed
        Map parameters = new HashMap ();
            //A nuestro informe de prueba le vamos a enviar la fecha de hoy
            parameters.put ("fecha1", formatoFecha.format(new Date()));
            parameters.put ("fecha2", formatoFecha.format(new Date()));  
        JasperReport reporte; //Creo el objeto reporte
         // Ubicacion del Reporte
        String path = ".//src//Reportes//RVentasDiaria.jasper";
        try {
            cn.conectarBD();
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); //Cargo el reporte al objeto
            JasperPrint jprint = JasperFillManager.fillReport(path, parameters, this.cn.conn); //Llenado del Reporte con Tres parametros ubicacion,parametros,conexion a la base de datos
            JasperViewer viewer = new JasperViewer(jprint,false); //Creamos la vista del Reporte
             viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Le agregamos que se cierre solo el reporte cuando lo cierre el usuario
            viewer.setVisible(true); //Inicializamos la vista del Reporte
            cn.conn.close();
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRVentasDiariasActionPerformed

    private void btnVentasPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasPersActionPerformed
       ReportesPers R = new ReportesPers();
       ReportesPers.reporte = "RVentasDiaria.jasper";
        R.show();
    }//GEN-LAST:event_btnVentasPersActionPerformed

    private void btnComprasPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasPersActionPerformed
        ReportesPers R = new ReportesPers();
        R.show();
        ReportesPers.reporte = "RCompras.jasper";
    }//GEN-LAST:event_btnComprasPersActionPerformed

    private void btnContabilidadPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContabilidadPersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContabilidadPersActionPerformed

    private void btnMasVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasVendidosActionPerformed
        ReportesPers R = new ReportesPers();
        R.show();
        ReportesPers.reporte = "RMasVendidos.jasper";
    }//GEN-LAST:event_btnMasVendidosActionPerformed

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
            java.util.logging.Logger.getLogger(reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprasPers;
    private javax.swing.JButton btnContabilidadPers;
    private javax.swing.JButton btnMasVendidos;
    private javax.swing.JButton btnRVentasDiarias;
    private javax.swing.JButton btnRcontableDiario;
    private javax.swing.JButton btnVentasPers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
