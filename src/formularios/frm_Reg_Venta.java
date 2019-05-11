
package formularios;

import entidades.conexionDB;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class frm_Reg_Venta extends javax.swing.JFrame {
conexionDB cn = new conexionDB();
String[] arrayVendedor;
String [] arrayProducto;
String [] arraycategoria;
String [] estaCompra;
 DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
double total=0;
int cC = 0;
boolean duplicado = false;
DefaultTableModel model;
        
    public frm_Reg_Venta() {
        initComponents();
        this.dgvRegVenta.setSelectionForeground(Color.white);
        this.cboBuscarRV.setEnabled(false);
        model = (DefaultTableModel) this.dgvRegVenta.getModel();
         
         estaCompra = new String[25];
        try {
            cn.conectarBD();
            Statement stmt = cn.conn.createStatement();
            String query = "SELECT empleado_code, CONCAT(nombre, ' ', apellido) FROM empleado;";
            ResultSet rs = stmt.executeQuery(query);
            int i = 0;
            while(rs.next())
            {
                this.cboVendedor.addItem(rs.getString(2));
                i++; 
            }
            arrayVendedor = new String[i];
            i = 1;
            rs.first();
             arrayVendedor[0] = String.valueOf(rs.getInt(1));
            while(rs.next())
            {
               arrayVendedor[i] = String.valueOf(rs.getInt(1));
                i++;
            }
            Statement stmt2 = cn.conn.createStatement();
            String query2 = "SELECT producto_nombre FROM producto;";
            ResultSet rs2 = stmt2.executeQuery(query2);
            
            int j = 0;
            while(rs2.next())
            {
                this.cboProducto.addItem(rs2.getString(1));
                j++; 
            }

            Statement stmt3 = cn.conn.createStatement();
            String query3 = "SELECT categoria_nombre FROM categoria;";
            ResultSet rs3 = stmt3.executeQuery(query3);
            
            int k = 0;
            while(rs3.next())
            {
                this.cboBuscarRV.addItem(rs3.getString(1));
                k++; 
            }
            arraycategoria = new String[k];
              k = 1;
            rs3.first();
             arraycategoria[0] = String.valueOf(rs3.getString(1));
            while(rs3.next())
            {
               arraycategoria[k] = String.valueOf(rs3.getString(1));
                k++;
            }
            cn.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(frm_Reg_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboVendedor = new javax.swing.JComboBox<>();
        cboProducto = new javax.swing.JComboBox<>();
        spCantidad = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        rbTodo = new javax.swing.JRadioButton();
        rdCategoria = new javax.swing.JRadioButton();
        cboBuscarRV = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvRegVenta = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JButton();
        btnBorrarProducto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Venta");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Vendedor:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Producto");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad");

        cboVendedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cboProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        spCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        rbTodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbTodo.setSelected(true);
        rbTodo.setText("Todo");
        rbTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodoActionPerformed(evt);
            }
        });

        rdCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdCategoria.setText("Categoría");
        rdCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCategoriaActionPerformed(evt);
            }
        });

        cboBuscarRV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboBuscarRV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboBuscarRVItemStateChanged(evt);
            }
        });
        cboBuscarRV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBuscarRVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rbTodo)
                .addGap(18, 18, 18)
                .addComponent(rdCategoria)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(cboBuscarRV, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTodo)
                    .addComponent(rdCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboBuscarRV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/agg.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/btnCancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        dgvRegVenta.setBackground(new java.awt.Color(51, 51, 51));
        dgvRegVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dgvRegVenta.setForeground(new java.awt.Color(255, 255, 255));
        dgvRegVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio Unitario", "Subtotal"
            }
        ));
        dgvRegVenta.setRowHeight(20);
        dgvRegVenta.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(dgvRegVenta);

        lblTotal.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblTotal.setText("TOTAL: ");

        btnTerminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTerminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/contabilidad.png"))); // NOI18N
        btnTerminar.setText("Terminar Venta");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        btnBorrarProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBorrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/btnEliminar.png"))); // NOI18N
        btnBorrarProducto.setText("Eliminar Producto");
        btnBorrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Nueva Venta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(270, 270, 270)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBorrarProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(lblTotal))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(156, 156, 156)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodoActionPerformed
    cn.conectarBD();
    this.rbTodo.setSelected(true);
    this.rdCategoria.setSelected(false);
    this.cboBuscarRV.setEnabled(false);
        try {
            cn.conectarBD();
            Statement stmt2 = cn.conn.createStatement();
            String query2 = "SELECT producto_nombre FROM producto;";
            ResultSet rs2 = stmt2.executeQuery(query2);
            int j = 0;
            while(rs2.next())
            {
                this.cboProducto.addItem(rs2.getString(1));
                j++; 
            }
             arrayProducto = new String[j];
              j = 1;
            rs2.first();
             arrayProducto[0] = String.valueOf(rs2.getString(1));
            while(rs2.next())
            {
               arrayProducto[j] = String.valueOf(rs2.getString(1));
                j++;
            }
            cn.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(frm_Reg_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_rbTodoActionPerformed

    private void rdCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCategoriaActionPerformed
        this.rbTodo.setSelected(false);
        this.rdCategoria.setSelected(true);
        this.cboBuscarRV.setEnabled(true);
    }//GEN-LAST:event_rdCategoriaActionPerformed

    private void cboBuscarRVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBuscarRVActionPerformed

        //       select producto_nombre from producto where idCategoria="1";

    }//GEN-LAST:event_cboBuscarRVActionPerformed

    private void cboBuscarRVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboBuscarRVItemStateChanged
        //no sirve para cambiar datos entre jcombobox
       if(this.rdCategoria.isSelected())
       {
        this.cboProducto.removeAllItems();
     
        try {
        cn.conectarBD();
            Statement stmt2 = cn.conn.createStatement();
            String query2 = "SELECT producto_nombre FROM producto WHERE idCategoria=" + (cboBuscarRV.getSelectedIndex()+1)+";";
            ResultSet rs2 = stmt2.executeQuery(query2);
            int j = 0;
            while(rs2.next())
            {
                this.cboProducto.addItem(rs2.getString(1));
                j++;
            }
            arrayProducto = new String[j];
            rs2.first();
            j=1;
             arrayProducto[0] = String.valueOf(rs2.getString(1));
            while(rs2.next())
            {
               arrayProducto[j] = String.valueOf(rs2.getString(1));
                j++;
            }
            cn.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(frm_Reg_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    }//GEN-LAST:event_cboBuscarRVItemStateChanged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    duplicado = false;
        try {
        cn.conectarBD();
        String nombre = this.cboProducto.getSelectedItem().toString();
        double Cantidad = Double.parseDouble(""+this.spCantidad.getValue());
        double precioU = Double.parseDouble(cn.ConsultarPrecio(nombre));
        double Subtotal= Cantidad * precioU;
        int existencia=cn.ComprobarStock(nombre);
        
        for (int i = 0; i < cC; i++) {
            if(nombre.equals(estaCompra[i]))
            {
                 JOptionPane.showMessageDialog(null, "Este producto ya se encuentra agregado");
                 duplicado = true;
                 break;
            }
        }
        if (!duplicado) {
            if (existencia>=Cantidad){   
        total=total+Subtotal;
        this.lblTotal.setText("Total: "+total);
        //agregando a JTable

        Object Datos[]= new Object[4];
        Datos[0]= nombre;
        Datos[1]= Cantidad;
        Datos[2]= precioU;
        Datos[3]= Subtotal;
        model.addRow(Datos);
        estaCompra[cC] = nombre;
        cC++;
        duplicado = false;
        }else {
            JOptionPane.showMessageDialog(null, "Producto:  "+nombre+" Cantidad Disponible:  "+existencia+"");
        }
        }
             
       cn.conn.close();
    } catch (SQLException ex) {
        Logger.getLogger(frm_Reg_Venta.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
    int a = this.dgvRegVenta.getRowCount();
        
        if (a>0)  {
    try {
        cn.conectarBD();
        int idVenta= cn.HistorialV();
         for (int i=0; i<a; i++) {
         String nombreP=dgvRegVenta.getValueAt(i, 0).toString();
         double Cantidad=Double.parseDouble(dgvRegVenta.getValueAt(i, 1).toString());
         double Precio=Double.parseDouble(dgvRegVenta.getValueAt(i, 2).toString());
         double Subtotal=Double.parseDouble(dgvRegVenta.getValueAt(i, 3).toString()); 
         
         //Disminuir en Inventario
         if (cn.Existencia(nombreP)){
                 Statement stmt = cn.conn.createStatement() ;
            String query = "update producto set producto_stock=producto_stock-"+Cantidad+" where producto.producto_nombre='"+nombreP+"';" ;
            PreparedStatement pst  = cn.conn.prepareStatement(query);
            int n=pst.executeUpdate();}
         
         //Agregar a la tabla Venta
         
         if(i==0){
         double totalV=0;
                   for(int j=0; j<a; j++){
                   totalV=totalV+(Double.parseDouble(dgvRegVenta.getValueAt(j, 2).toString())*Double.parseDouble(dgvRegVenta.getValueAt(j, 1).toString()));
                   }
          Statement stmt_compra = cn.conn.createStatement() ;
          String query2 = "INSERT INTO venta (venta_fecha,empleado_code,venta_total)"
                    + " VALUES(?,?,?);" ;
          PreparedStatement pst2  = cn.conn.prepareStatement(query2);
          
           pst2.setString(1, formatoFecha.format(new Date()));
           String vend= arrayVendedor[this.cboVendedor.getSelectedIndex()];
            pst2.setString(2, vend);
            pst2.setString(3, Double.toString(totalV));
           int n2=pst2.executeUpdate();
         }
         
         
         //Agregar a Detalle Venta
        int idVentaA=cn.HistorialV()-1;
        Statement stmt_venta= cn.conn.createStatement() ;
        String query3 = "INSERT INTO detalle_venta (idVenta,idProducto,cantidad,subtotal)"
                    + " VALUES(?,?,?,?);" ;
        PreparedStatement pst3  = cn.conn.prepareStatement(query3);
         pst3.setInt(1, idVentaA);
         pst3.setInt(2, Integer.parseInt(cn.ObtenerIdP(nombreP)));
         pst3.setString(3, Cantidad+"");
         pst3.setString(4, Subtotal+"");
         int n3=pst3.executeUpdate();
         } 
         this.lblTotal.setText("TOTAL: 0");
         this.model.setRowCount(0);

         JOptionPane.showMessageDialog(null,"Venta Realizada con éxito." );
        cn.conn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"ERROR: "+ ex.toString());
    }
        }else{
        JOptionPane.showMessageDialog(null,"Debe agregar almenos un producto a la venta" );
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnBorrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.dgvRegVenta.getModel();
        int a = this.dgvRegVenta.getSelectedRow();

        if (a<0){
            JOptionPane.showMessageDialog(null,
            "Debe seleccionar una fila de la tabla" );
            }else {
                int confirmar=JOptionPane.showConfirmDialog(null,
                "Esta seguro que desea Eliminar el producto? ");

        if(JOptionPane.OK_OPTION==confirmar) {
            total=total-Double.parseDouble(dgvRegVenta.getValueAt(a,3).toString());
            this.lblTotal.setText("Total: "+total);
            estaCompra = Reordenar(dgvRegVenta.getValueAt(a,0).toString(),estaCompra);
            cC--;
            model.removeRow(a);
             JOptionPane.showMessageDialog(null,"Producto Eliminado" );
        }
                }            // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarProductoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    public String[] Reordenar(String producto, String[] array)
    {
        String[] a = new String[array.length];
        int cont = 0;
        for (int i = 0; i < array.length+1; i++) {
            if (array[i] != null) {
                if (!array[i].equals(producto)) {
                a[cont] = array[i];
                cont++;
            }
            } else break;
        }
        return a;
    }
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
            java.util.logging.Logger.getLogger(frm_Reg_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Reg_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Reg_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Reg_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Reg_Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JComboBox<String> cboBuscarRV;
    private javax.swing.JComboBox<String> cboProducto;
    private javax.swing.JComboBox<String> cboVendedor;
    private javax.swing.JTable dgvRegVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rbTodo;
    private javax.swing.JRadioButton rdCategoria;
    private javax.swing.JSpinner spCantidad;
    // End of variables declaration//GEN-END:variables
}
