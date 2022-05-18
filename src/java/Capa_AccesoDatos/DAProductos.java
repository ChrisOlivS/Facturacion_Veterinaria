/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_AccesoDatos;

import Capa_Entidades.Productos;
import Config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software
 */
public class DAProductos {
    //Atributos
    private Connection _cnn;
    private String mensaje;
    //Getter
    public String getMensaje(){
        return mensaje;
    }
    
    public DAProductos() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public int Insertar(Productos producto) throws Exception{
        int id_cliente = -1;
        
        String sentencia = "insert into Productos (id_proveedor,nombre_producto,cantidad,precio) values(?,?,?,?)";
        try {
            PreparedStatement sm = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            sm.setString(1, producto.getCodigoProveedor());
            sm.setString(2, producto.getNombre_producto());
            sm.setInt(3, producto.getCantidad());
            sm.setInt(4, producto.getPrecio());
            sm.execute();
            ResultSet rs = sm.getGeneratedKeys();
            if (rs!= null && rs.next()) {
                id_cliente = rs.getInt(1);
                mensaje = "Datos Ingresados Exitosamente";
            }
            
        } catch (Exception ex) {
        }
        return id_cliente;
    }
    //Modificar
    
    public int Modificar(Productos producto) throws SQLException{
            int resultado = 0;
            String sentencia = "Update productos set id_proveedor=?,nombre_producto=?,cantidad=?,precio=? where id_producto = ?";
            try {
                PreparedStatement ps = _cnn.prepareStatement(sentencia);
                ps.setString(1, producto.getCodigoProveedor());
                ps.setString(2, producto.getNombre_producto());
                ps.setInt(3, producto.getCantidad());
                ps.setInt(4, producto.getPrecio());
                ps.setInt(5,producto.getIdentificacion());
                
                resultado = ps.executeUpdate();
                if (resultado > 0) {
                    mensaje = "Producto modificado";
                }
            } catch (Exception e) {
                throw e;
            } finally {
                _cnn = null;
            }
            return resultado;
        }
    //Eliminar Cliente
    public int Eliminar(Productos producto) throws SQLException{
            int resultado = 0;
            String sentencia ="delete productos where id_producto = ?";
            try {
                PreparedStatement ps = _cnn.prepareStatement(sentencia);
                ps.setInt(1,producto.getIdentificacion());
                resultado = ps.executeUpdate();
                if (resultado>0) {
                    mensaje = "Producto eliminado";
                }
            } catch (Exception e) {
                throw e;
            } finally {
                _cnn = null;
            }
            return resultado;
        }
    //Listar Registros Array
    
        public List<Productos>Listar(String condicion) throws SQLException{
        ResultSet rs = null;
        List<Productos> lista = new ArrayList();
        
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_PRODUCTO, NOMBRE_PROVEEDOR, NOMBRE_PRODUCTO,CANTIDAD,PRECIO\n" +
"FROM PRODUCTOS P INNER JOIN PROVEEDORES PR\n" +
"ON	 P.ID_PROVEEDOR = PR.ID_PROVEEDOR";
            
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Productos(rs.getInt("ID_PRODUCTO"),
                                      rs.getString("NOMBRE_PROVEEDOR"),
                                      rs.getString("NOMBRE_PRODUCTO"),
                                      rs.getInt("PRECIO"),
                                      rs.getInt("CANTIDAD")
                                      
                ));
                
            }
        } catch (Exception ex) {
            throw ex;
        }finally{
            _cnn = null;
        }
        return lista;
    }
        
    //Obtener Clientes
        public Productos Obtener(String condicion) throws SQLException{ //Solo se usa en DA
            
            ResultSet rs = null;
            Productos producto = new Productos();
            
            try {
                Statement stm = _cnn.createStatement();
                String sentencia = "Select id_producto,id_proveedor,nombre_producto,cantidad,precio from productos";
            
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs = stm.executeQuery(sentencia);
                if (rs.next()) {
                    producto.setIdentificacion(rs.getInt(1));
                    producto.setCodigoProveedor(rs.getString(2));
                    producto.setNombre_producto(rs.getString(3));
                    producto.setCantidad(rs.getInt(4));
                    producto.setPrecio(rs.getInt(5));
                    producto.setExiste(true);
                }
                
            } catch (Exception ex) {
                throw ex;
            }finally{
                _cnn = null;
            }
            
            return producto;
        }
}
