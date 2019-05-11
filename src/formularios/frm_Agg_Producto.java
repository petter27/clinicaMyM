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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
/**
 *
 * @author pedro
 */
public class frm_Agg_Producto extends javax.swing.JFrame {
conexionDB cn = new conexionDB();
conexionDB cn2 = new conexionDB();
conexionDB cn3 = new conexionDB();
SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
public static String[] arrayCategoria;
String[] arrayProveedor;
String[] arrayNombreC;
String[] arrayProveedorN;
Date fechaA;
 DefaultTableModel model;

 
    public frm_Agg_Producto() {
        initComponents();
         this.dgvDatos.setSelectionForeground(Color.white);
         this.dateChooser.setDateFormat(formatoFecha);
         model = (DefaultTableModel) this.dgvDatos.getModel();
        
        
        try {
                    cn.conectarBD();
            Statement stmt = cn.conn.createStatement();
            String query = "SELECT idCategoria, categoria_nombre FROM categoria;";
            ResultSet rs = stmt.executeQuery(query);
            int i = 0;
            while(rs.next())
            {
                this.cboCategoria.addItem(rs.getString(2));
                i++; 
            }
             arrayCategoria = new String[i];
             i=1;
             rs.first();
             arrayCategoria[0] = rs.getString(1);
             while(rs.next())
            {
                arrayCategoria[i] = rs.getString(1);
                i++; 
            }
            
            Statement stmt2 = cn.conn.createStatement();
            String query2 = "SELECT idProveedor, proveedor_nombre FROM proveedor;";
            ResultSet rs2 = stmt2.executeQuery(query2);
            
            int j = 0;
            while(rs2.next())
            {
                this.cboProveedor.addItem(rs2.getString(2));
                j++; 
            }
            arrayProveedor = new String[j];
            j=1;
            rs2.first();
            arrayProveedor[0] = rs2.getString(1);
            while(rs2.next())
            {
                arrayProveedor[j] = rs2.getString(1);
                j++; 
            }
cn.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(frm_Agg_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
                @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/images/logo-M&M-64x64.png"));
        return retValue;
    }
    
     public static void aCategorias()
    {
         try {
             frm_Agg_Producto.cboCategoria.removeAllItems();
            conexionDB cn = new conexionDB();
            cn.conectarBD();
            Statement stmt = cn.conn.createStatement();
            String query = "SELECT idCategoria, categoria_nombre FROM categoria;";
            ResultSet rs = stmt.executeQuery(query);
            int i = 0;
            while(rs.next())
            {
                frm_Agg_Producto.cboCategoria.addItem(rs.getString(2));
                i++; 
            }
             arrayCategoria = new String[i];
             i=1;
             rs.first();
             arrayCategoria[0] = rs.getString(1);
             while(rs.next())
            {
                arrayCategoria[i] = rs.getString(1);
                i++; 
            }
             cn.conn.close();
         } catch (SQLException ex) {
            Logger.getLogger(frm_Agg_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//     public String aStock(String producto)
//     {
//        try
//        {
//            String query = "SELECT producto_nombre, producto_fechaExp, producto_stock FROM producto ";
//            Statement stmt = cn.conn.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while(rs.next())
//            {
//                if(rs.getString(1).equals(producto) && rs.getInt(2)>0)
//                {
//                   producto = producto + " 2";
//                   if(aStock(producto));
//                }
//            }
//        }
//        catch (SQLException ex) {
//            Logger.getLogger(frm_Agg_Producto.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         return producto;
//     }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtPrecioC = new javax.swing.JTextField();
        txtPrecioU = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboProveedor = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvDatos = new javax.swing.JTable();
        dateChooser = new datechooser.beans.DateChooserCombo();
        btnTerminar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Producto");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Agregar Compra");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del producto:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Categoría:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fecha de Caducidad:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Stock");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Precio Compra:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Precio Unitario:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cboCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtStock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPrecioC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPrecioU.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Proveedor");

        cboProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/anadir carrito.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        dgvDatos.setBackground(new java.awt.Color(51, 51, 51));
        dgvDatos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dgvDatos.setForeground(new java.awt.Color(255, 255, 255));
        dgvDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio Compra", "Precio Unitario", "Caducidad", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvDatos.setRowHeight(20);
        dgvDatos.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(dgvDatos);

        dateChooser.setCalendarPreferredSize(new java.awt.Dimension(350, 250));
        dateChooser.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));

        btnTerminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTerminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/carrito compra.png"))); // NOI18N
        btnTerminar.setText("Terminar Compra");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/btnEliminar.png"))); // NOI18N
        btnBorrar.setText("Eliminar Producto");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/btnRegresar.png"))); // NOI18N
        jButton2.setText("Menú");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnTerminar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jButton1)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(136, 136, 136)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addComponent(txtPrecioC, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTerminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try 
        {
            String nombre = this.txtNombre.getText();
            String FechaExp = this.dateChooser.getText();
            String stock = this.txtStock.getText();
            float PrecioC= Float.parseFloat(this.txtPrecioC.getText());
            float PrecioU = Float.parseFloat(this.txtPrecioU.getText());
            String idC=null;
            idC =this.cboCategoria.getSelectedItem().toString();
        //agregando a JTable
        if (   !"".equals(nombre.trim()) && !"".equals(FechaExp.trim()) && conexionDB.isNumeric(stock)==true && PrecioC>0 && PrecioU>=PrecioC){

         Object Datos[]= new Object[6];
         Datos[0]= nombre;
         Datos[1]= stock;
         Datos[2]= PrecioC;
         Datos[3]= PrecioU;
         Datos[4]= FechaExp;
         Datos[5]= idC;
         model.addRow(Datos);
         this.txtNombre.setText("");
         this.txtPrecioC.setText("");
         this.txtPrecioU.setText("");
         this.txtStock.setText("");
        }else {
        JOptionPane.showMessageDialog(null,"Llene todos los campos" );
        }
        }
        catch (NumberFormatException ex)
        {
        JOptionPane.showMessageDialog(null,"LLene los campos correctamente" );
        }
        

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed

        int a = dgvDatos.getRowCount();
        
        if (a>0)  {
        try {
            cn.conectarBD();
            int idCompra= cn.HistorialC();
             for (int i=0; i<a; i++) {
            
            String idProveedor=arrayProveedor[this.cboProveedor.getSelectedIndex()];
            String nombre = dgvDatos.getValueAt(i, 0).toString(); 
            String Categoria=dgvDatos.getValueAt(i, 5).toString();
            double stock = Double.parseDouble(dgvDatos.getValueAt(i, 1).toString());
            double PrecioC= Double.parseDouble(dgvDatos.getValueAt(i, 2).toString());
            String FechaExp = dgvDatos.getValueAt(i, 4).toString();
            String PrecioU = dgvDatos.getValueAt(i, 3).toString();
            
            if (cn.Existencia(nombre)){
                 Statement stmt = cn.conn.createStatement() ;
            String query = "update producto set producto_stock=producto_stock+"+stock+",producto_pCompra="+PrecioC+", producto_pVenta="+PrecioU+" where producto.producto_nombre='"+nombre+"';" ;
            PreparedStatement pst  = cn.conn.prepareStatement(query);
            int n=pst.executeUpdate();
                
            }else{
            Statement stmt = cn.conn.createStatement() ;
            String query = "INSERT INTO producto (idProveedor, producto_nombre, idCategoria, producto_stock, "
            + "producto_pCompra, producto_fechaExp, producto_pVenta) VALUES(?,?,?,?,?,?,?);" ;
            PreparedStatement pst  = cn.conn.prepareStatement(query);
            pst.setString(1, idProveedor);
            pst.setString(2, nombre);
            pst.setString(3, arrayCategoria[this.cboCategoria.getSelectedIndex()]);
            pst.setString(4, Double.toString(stock));
            pst.setString(5, Double.toString(PrecioC));
            pst.setString(6, FechaExp);
            pst.setString(7, PrecioU);

            int n=pst.executeUpdate();
            }
            //Agregar la nueva compra
            
               //compra
                 String idProducto=cn.ObtenerIdP(nombre);
                 
               if(i==0){
                   double total=0;
                   for(int j=0; j<a; j++){
                   total=total+(Double.parseDouble(dgvDatos.getValueAt(j, 2).toString())*Double.parseDouble(dgvDatos.getValueAt(j, 1).toString()));
                   }
            String id_compra= dgvDatos.getValueAt(i, 2).toString();
            Statement stmt_compra = cn.conn.createStatement() ;
            String query2 = "INSERT INTO compra (fecha_compra, total, idProveedor)"
                    + " VALUES(?,?,?);" ;
                Date fechaHoraActual = new Date();
    
            PreparedStatement pst2  = cn.conn.prepareStatement(query2);
           pst2.setString(1, (formatoFecha.format(fechaHoraActual)));
            pst2.setString(2, Double.toString(total));
            pst2.setString(3, idProveedor);
           int n2=pst2.executeUpdate();}
                       
            //detalle
            String id_proveedor=arrayProveedor[this.cboProveedor.getSelectedIndex()];
            String detalle_total= dgvDatos.getValueAt(i, 5).toString();
            String detalle_fecha = dgvDatos.getValueAt(i, 1).toString();
            
         
            Statement stmt_detalle = cn.conn.createStatement() ;
            String compra_precioU = dgvDatos.getValueAt(i, 2).toString();
            String compra_cantidad = dgvDatos.getValueAt(i, 1).toString();
            String compra_total= Double.toString(PrecioC*stock);
                       
            String query3 = "INSERT INTO detalle_compra (idCompra, idProducto,cantidad,subtotal) VALUES(?,?,?,?);" ;
            PreparedStatement pst3  = cn.conn.prepareStatement(query3);
            fechaA=new Date();
            pst3.setInt(1, (idCompra));
            pst3.setString(2,idProducto);
            pst3.setString(3, compra_cantidad);
            pst3.setString(4, compra_total);
            
           int n3=pst3.executeUpdate();
           cn.conn.close();
            } 
           //Limpiar jTable

           model.setRowCount(0);
           
            JOptionPane.showMessageDialog(null, "Compra Realizada con exito");

        } catch (SQLException ex) {
            System.out.printf(ex.toString());
            Logger.getLogger(frm_Reg_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }else { JOptionPane.showMessageDialog(null,
    "Debe agregar almenos un producto a la compra" );}
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

int a = dgvDatos.getSelectedRow();

if (a<0){
    JOptionPane.showMessageDialog(null,
    "Debe seleccionar una fila de la tabla" );
    }else {
        int confirmar=JOptionPane.showConfirmDialog(null,
        "Esta seguro que desea Eliminar la compra del producto? ");
              
if(JOptionPane.OK_OPTION==confirmar) {
     model.removeRow(a);                 
     JOptionPane.showMessageDialog(null,"Producto Eliminado" );
}
        }            
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //categorias nuevas
        AggCategoria ac =new AggCategoria();
            ac.setVisible(true);




        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Agg_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Agg_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Agg_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Agg_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Agg_Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnTerminar;
    public static final javax.swing.JComboBox<String> cboCategoria = new javax.swing.JComboBox<>();
    private javax.swing.JComboBox<String> cboProveedor;
    private datechooser.beans.DateChooserCombo dateChooser;
    private javax.swing.JTable dgvDatos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioC;
    private javax.swing.JTextField txtPrecioU;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
