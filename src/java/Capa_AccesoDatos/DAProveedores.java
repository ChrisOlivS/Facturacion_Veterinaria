/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_AccesoDatos;

import Capa_Entidades.Proveedores;
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
public class DAProveedores {
    //Atributos
    private Connection _cnn;
    private String mensaje;
    //Getter
    public String getMensaje(){
        return mensaje;
    }
    
    public DAProveedores() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public int Insertar(Proveedores proveedor) throws Exception{
        int id_cliente = -1;
        
        String sentencia = "insert into Proveedores (nombre_proveedor,direccion_proveedor,correo_electronico_proveedor) values(?,?,?)";
        try {
            PreparedStatement sm = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            sm.setString(1, proveedor.getNombreProveedor());
            sm.setString(2, proveedor.getDireccionProveedor());
            sm.setString(3, proveedor.getCorreoElectronico_proveedor());
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
    
    public int Modificar(Proveedores proveedor) throws SQLException{
            int resultado = 0;
            String sentencia = "Update proveedores set nombre_proveedor=?,direccion_proveedor=?,correo_electronico_proveedor=? where id_proveedor = ?";
            try {
                PreparedStatement ps = _cnn.prepareStatement(sentencia);
                ps.setString(1, proveedor.getNombreProveedor());
                ps.setString(2, proveedor.getDireccionProveedor());
                ps.setString(3, proveedor.getCorreoElectronico_proveedor());
                ps.setInt(4,proveedor.getIdentificacion());
                
                resultado = ps.executeUpdate();
                if (resultado > 0) {
                    mensaje = "Proveedor modificado";
                }
            } catch (Exception e) {
                throw e;
            } finally {
                _cnn = null;
            }
            return resultado;
        }
    //Eliminar Cliente
    public int Eliminar(Proveedores proveedor) throws SQLException{
            int resultado = 0;
            String sentencia ="delete Proveedores where id_proveedor = ?";
            try {
                PreparedStatement ps = _cnn.prepareStatement(sentencia);
                ps.setInt(1,proveedor.getIdentificacion());
                resultado = ps.executeUpdate();
                if (resultado>0) {
                    mensaje = "Proveedor eliminado";
                }
            } catch (Exception e) {
                throw e;
            } finally {
                _cnn = null;
            }
            return resultado;
        }
    //Listar Registros Array
    
        public List<Proveedores>Listar(String condicion) throws SQLException{
        ResultSet rs = null;
        List<Proveedores> lista = new ArrayList();
        
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_proveedor,nombre_proveedor,direccion_proveedor,correo_electronico_proveedor from proveedores";
            
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Proveedores(rs.getInt("id_proveedor"),
                                      rs.getString("nombre_proveedor"),
                                      rs.getString("direccion_proveedor"),
                                      rs.getString("correo_electronico_proveedor")
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
        public Proveedores Obtener(String condicion) throws SQLException{ //Solo se usa en DA
            
            ResultSet rs = null;
            Proveedores proveedores = new Proveedores();
            
            try {
                Statement stm = _cnn.createStatement();
                String sentencia = "Select id_proveedor, nombre_proveedor, direccion_proveedor,correo_electronico_proveedor from proveedores";
            
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs = stm.executeQuery(sentencia);
                if (rs.next()) {
                    proveedores.setIdentificacion(rs.getInt(1));
                    proveedores.setNombreProveedor(rs.getString(2));
                    proveedores.setDireccionProveedor(rs.getString(3));
                    proveedores.setCorreoElectronico_proveedor(rs.getString(4));
                    proveedores.setExiste(true);
                }
                
            } catch (Exception ex) {
                throw ex;
            }finally{
                _cnn = null;
            }
            
            return proveedores;
        }
}
