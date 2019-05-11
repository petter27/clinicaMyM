/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import formularios.menu;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class conexionDB {
    
     public Connection conn;
    public void conectarBD() 
        {
            try
            {
                  Class.forName("com.mysql.jdbc.Driver") ;
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicadb", 
                      "root", "root") ;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            } catch (SQLException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error 2");
            }
        }
    //llenar proveedores
        public DefaultTableModel llenarProveedores( JTable jTable1)throws SQLException 
        {
            DefaultTableModel model;
          Statement stmt = conn.createStatement() ;
         String query = "SELECT * FROM proveedor  ORDER BY idProveedor;" ;
         ResultSet rs = stmt.executeQuery(query) ;
          
          model = (DefaultTableModel) jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[6];
          
          while (rs.next())
           {
              for (int i=0;i<5;i++)
              {
                  Datos[i]=rs.getObject(i+1);
              }
              
              model.addRow(Datos);
           }
          // jTable1.setModel(model);
           return model;
        }
        
        //Inventario
        
         public DefaultTableModel llenarInventario( JTable jTable1)throws SQLException 
        {
            DefaultTableModel model;
          Statement stmt = conn.createStatement() ;
         String query = "SELECT idProducto,proveedor_nombre,producto_nombre,categoria_nombre,producto_stock,producto_pCompra,"
                 + "producto_fechaExp,producto_pVenta FROM producto inner join proveedor on proveedor.idProveedor=producto.idProveedor "
                 + "inner join categoria on categoria.idCategoria=producto.idCategoria ORDER BY idProducto;" ;
         ResultSet rs = stmt.executeQuery(query) ;
          
          model = (DefaultTableModel) jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[9];
          
          while (rs.next())
           {
              for (int i=0;i<8;i++)
              {
                  Datos[i]=rs.getObject(i+1);
              }
              
              model.addRow(Datos);
           }
           return model;
        }
         
         //Historial compras
        
         public DefaultTableModel hcompra( JTable jTable1)throws SQLException 
        {
            DefaultTableModel model;
          Statement stmt = conn.createStatement() ;
         String query = "SELECT compra.idCompra,proveedor_nombre,fecha_compra,total FROM compra "
                 + "inner join proveedor on compra.idProveedor=proveedor.idProveedor  ORDER BY idCompra;" ;
         ResultSet rs = stmt.executeQuery(query) ;
          
          model = (DefaultTableModel) jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[9];
          
          while (rs.next())
           {
              for (int i=0;i<4;i++)
              {
                  Datos[i]=rs.getObject(i+1);
              }
              
              model.addRow(Datos);
           }
           return model;
        }
        //Historial DEtallecompras
        
         public DefaultTableModel hDetalle( JTable jTable1, String codeCompra)throws SQLException 
        {
            DefaultTableModel model;
          Statement stmt = conn.createStatement() ;
         String query = "SELECT P.producto_nombre,P.producto_pVenta,  D.cantidad, D.subtotal FROM detalle_compra D "
                 + "INNER JOIN producto P ON P.idProducto = D.idProducto "
                 + "WHERE idCompra = "+codeCompra+";";
         ResultSet rs = stmt.executeQuery(query) ;
          model = (DefaultTableModel) jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[4];
          while (rs.next())
           {
              for (int i=0;i<4;i++)
              {
                  Datos[i]=rs.getObject(i+1);
              }
              
              model.addRow(Datos);
           }
           return model;
        }
         
         //Historial DetalleVenta
        
         public DefaultTableModel vDetalle( JTable jTable1, String codeVenta)throws SQLException 
        {
            DefaultTableModel model;
          Statement stmt = conn.createStatement() ;
        String query = "SELECT P.producto_nombre,P.producto_pVenta,  D.cantidad, D.subtotal FROM detalle_venta D "
                 + "INNER JOIN producto P ON P.idProducto = D.idProducto "
                 + "WHERE idVenta = "+codeVenta+";";
         ResultSet rs = stmt.executeQuery(query) ;
          model = (DefaultTableModel) jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[4];
          while (rs.next())
           {
              for (int i=0;i<4;i++)
              {
                  Datos[i]=rs.getObject(i+1);
              }
              
              model.addRow(Datos);
           }
           return model;
        }
         
         //Buscar Producto
          public DefaultTableModel buscarProducto( JTable jTable1, String query) throws SQLException
        {
            DefaultTableModel model;
          Statement stmt = conn.createStatement() ;
       // query = "SELECT * FROM producto WHERE(producto_nombre LIKE '%" +nproducto+ "%');";
         ResultSet rs = stmt.executeQuery(query) ;
          
          model = (DefaultTableModel) jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[100];
          
          while (rs.next())
           {
              for (int i=0;i<8;i++)
              {
                  Datos[i]=rs.getObject(i+1);
              }
              
              model.addRow(Datos);
           }
           return model;
        }
                //Buscar Compras
          public DefaultTableModel buscarCompra( JTable jTable1, String query) throws SQLException
        {
            DefaultTableModel model;
          Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
          model = (DefaultTableModel) jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[4];
          while (rs.next())
           {
              for (int i=0;i<4;i++)
              {
                  Datos[i]=rs.getObject(i+1);
              }
              
              model.addRow(Datos);
           }
           return model;
        }
          
          //obtener el id de un producto
          public String ObtenerIdP(String nombre) throws SQLException{
         Statement stmt = conn.createStatement() ;
         String query = "SELECT idProducto FROM producto where producto_nombre='"+nombre+"';" ;
         ResultSet rs = stmt.executeQuery(query) ;
         if (rs.next()){
         String ID=(rs.getString(1));
         return ID;}
         else {
         return "1"; }
         }
          
          //id de la nueva compra :v
          
          //comprar producto
          
           public String ConsultarPrecio( String nombre)throws SQLException 
        {
          String resultado;
          Statement stmt = conn.createStatement() ;
         String query = "SELECT producto_pVenta FROM producto WHERE producto_nombre='"+nombre+"';" ;
         ResultSet rs = stmt.executeQuery(query) ;
          

          if (rs.next()){
         String ID=(rs.getString(1));
         return ID;}
         else {
         return "1";
          }
        }
          
           
           public boolean Existencia(String nombre) throws SQLException{
           Statement stmt=conn.createStatement();
           String query="select producto_nombre from producto where producto_nombre like '"+nombre+"';";
           ResultSet rs = stmt.executeQuery(query) ;
           return rs.next();
           }
                     
          
            //nuevo registro de compra
          
           public int HistorialC()throws SQLException 
        {
          String resultado;
          Statement stmt = conn.createStatement() ;
         String query = "SELECT MAX(idCompra) FROM compra;" ;
         ResultSet rs = stmt.executeQuery(query) ;
          
          if (rs.next()){
         int ID=(rs.getInt(1)+1);
         return ID;}
         else {
         return 0;
          }
}
           
     public int HistorialV()throws SQLException 
        {
          String resultado;
          Statement stmt = conn.createStatement() ;
         String query = "SELECT MAX(idVenta) FROM venta;" ;
         ResultSet rs = stmt.executeQuery(query) ;
          
          if (rs.next()){
         int ID=(rs.getInt(1)+1);
         return ID;}
         else {
         return 0;
          }           
        }  
     
     public String ObtenerIdV(String nombre) throws SQLException{
         Statement stmt = conn.createStatement() ;
         String query = "SELECT idVendedor FROM vendedor where vendedor_nombre='"+nombre+"';" ;
         ResultSet rs = stmt.executeQuery(query) ;
         if (rs.next()){
         String ID=(rs.getString(1));
         return ID;}
         else {
         return "1"; }
         }
           
          public String ObtenerIdVenta() throws SQLException{
         Statement stmt = conn.createStatement() ;
         String query = "select  idVenta from venta order by idVenta desc;" ;
         ResultSet rs = stmt.executeQuery(query) ;
         if (rs.next()){
         String ID=(rs.getString(1));
         return ID;}
         else {
         return "1"; }
         } 
          
          public DefaultTableModel hventa( JTable jTable1)throws SQLException 
        {
            DefaultTableModel model;
          Statement stmt = conn.createStatement() ;
         String query = "select venta.idVenta, CONCAT(empleado.nombre, ' ', empleado.apellido) ,venta_fecha,venta_total from venta " +
                        "inner join empleado on empleado.empleado_code=venta.empleado_code order by venta_fecha;" ;
         ResultSet rs = stmt.executeQuery(query) ;
          
          model = (DefaultTableModel) jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[100];
          
          while (rs.next())
           {
              for (int i=0;i<4;i++)
              {
                  Datos[i]=rs.getObject(i+1);
              }
              
              model.addRow(Datos);
           }
          // jTable1.setModel(model);
           return model;
        }
          
            public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
            
        public int ComprobarStock(String nombre) throws SQLException{
         Statement stmt = conn.createStatement() ;
         String query = "select  producto_stock from producto where producto_nombre='"+nombre+ "';" ;
         ResultSet rs = stmt.executeQuery(query) ;
         if (rs.next()){
         int stock=(Integer.parseInt(rs.getString(1)));
         return stock;}
         else {
         return 0; }
         }

        public void BorrarProveedor(String nombre, String nit) throws SQLException{
        Statement stmt = conn.createStatement() ;
         String query = "delete from proveedor where proveedor_nombre='"+nombre+"' and proveedor_nit='"+nit+"';" ;
        stmt.execute(query);     
        }
        
        public void ActualizarProveedor(String idp, String nombre, String nit, String direccion, String tel) throws SQLException{
        Statement stmt = conn.createStatement() ;
         String query = "Update proveedor set proveedor_nombre='"+nombre+"', proveedor_nit='"+nit+"',"
                 + "proveedor_direccion='"+direccion+"',proveedor_telefono='"+tel+"'  where idProveedor='"+idp+"';" ;
        stmt.execute(query);     
        }
        
        public int AlertaStock() throws SQLException{
         Statement stmt = conn.createStatement() ;
         String query = "select count(producto_stock) from producto where producto_stock<=5;" ;
         ResultSet rs = stmt.executeQuery(query) ;
         int cantidad=0;
         if (rs.next()){
         cantidad=(Integer.parseInt(rs.getString(1)));
         return cantidad;}
        
        return cantidad;
        }
        
        public int AlertaSF() throws SQLException{
         Statement stmt = conn.createStatement() ;
         String query = "select count(producto_stock) from producto where producto_stock<=5 or TIMESTAMPDIFF(MONTH,now(),producto_fechaExp)<3;" ;
         ResultSet rs = stmt.executeQuery(query) ;
         int cantidad=0;
         if (rs.next()){
         cantidad=(Integer.parseInt(rs.getString(1)));
         return cantidad;}
        
        return cantidad;
        }
        
        public int AlertaFecha() throws SQLException{
         Statement stmt = conn.createStatement() ;
         String query = "select count(idProducto) from producto where TIMESTAMPDIFF(MONTH,now(),producto_fechaExp)<3;" ;
         ResultSet rs = stmt.executeQuery(query) ;
         int cantidad=0;
         if (rs.next()){
         cantidad=(Integer.parseInt(rs.getString(1)));
         return cantidad;}
        
        return cantidad;
            //select count(idProducto) from producto where TIMESTAMPDIFF(MONTH,now(),producto_fechaExp)<3;


        }
        
                //iniciar sesion
        public int iniciar(String usuario, String contra)
        {
            int tipoU = -1;
        try {
            
            Statement stmt = conn.createStatement() ;
            String query = "SELECT nombre, contrasena, tipoU_code FROM usuario WHERE(nombre = '" +usuario+ "' AND contrasena = '" + contra + "');";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next())
            {
                tipoU = rs.getInt(3);
            }
         } catch (SQLException ex) {
             Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
         }  
            return tipoU;
        }
        
        //Mostrar todas las alertas
        public DefaultTableModel Alertas( JTable jTable1, String sql)throws SQLException 
        {
            DefaultTableModel model;
          Statement stmt = conn.createStatement() ;
         String query = sql;
         ResultSet rs = stmt.executeQuery(query) ;
          
          model = (DefaultTableModel) jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[9];
          
          while (rs.next())
           {
              for (int i=0;i<5;i++)
              {
                  Datos[i]=rs.getObject(i+1);
              }
              
              model.addRow(Datos);
           }
           return model;
        }
        
        
        public String ConsultarCategoria( String nombre)throws SQLException 
        {
          String resultado;
          Statement stmt = conn.createStatement() ;
         String query = "SELECT categoria.categoria_nombre FROM producto "
                 + "inner join categoria on categoria.idCategoria=producto.idCategoria WHERE producto.producto_nombre='"+nombre+"';" ;
         ResultSet rs = stmt.executeQuery(query) ;
          

          if (rs.next()){
         String ID=(rs.getString(1));
         return ID;}
         else {
         return "1";
          }
        }
        
         public String idCategoria( String nombre)throws SQLException 
        {
          String resultado;
          Statement stmt = conn.createStatement() ;
         String query = "select idCategoria from categoria where categoria_nombre='"+nombre+"';" ;
         ResultSet rs = stmt.executeQuery(query) ;
          if (rs.next()){
         String ID=(rs.getString(1));
         return ID;}
         else {
         return "1";
          }
        }
         
         
         public DefaultTableModel Editarproveedor( JTable jTable1,String nombre)throws SQLException 
        {
            DefaultTableModel model;
          Statement stmt = conn.createStatement() ;
         String query = "SELECT * FROM proveedor where proveedor_nombre='"+nombre+"' ;" ;
         ResultSet rs = stmt.executeQuery(query) ;
          
          model = (DefaultTableModel) jTable1.getModel();
          model.setRowCount(0);
          Object Datos[]= new Object[6];
          
          while (rs.next())
           {
              for (int i=0;i<5;i++)
              {
                  Datos[i]=rs.getObject(i+1);
              }
              
              model.addRow(Datos);
           }
          // jTable1.setModel(model);
           return model;
   
        }
         
         public void ActualizarProducto(String idp, String nombre, String Stock, String PrecioV ) throws SQLException{
        Statement stmt = conn.createStatement();
         String query = "Update producto set producto_nombre='"+nombre+"', producto_stock="+Stock+", producto_pVenta="+PrecioV+"\n" +
" where idProducto="+idp+";" ;
        stmt.execute(query);     
        }
         
 public   String SafeSql(String inputSQL){
          return inputSQL.replace("'", "''");
        }
}
          
          
         
       
         
        
    

        
    
        
        
      

