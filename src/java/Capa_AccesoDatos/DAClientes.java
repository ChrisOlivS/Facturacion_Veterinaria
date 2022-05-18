/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_AccesoDatos;

import Capa_Entidades.Clientes;
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
public class DAClientes {
    //Atributos
    private Connection _cnn;
    private String mensaje;
    //Getter
    public String getMensaje(){
        return mensaje;
    }
    
    public DAClientes() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public int Insertar(Clientes cliente) throws Exception{
        int id_cliente = -1;
        
        String sentencia = "insert into Clientes (nombre_cliente,primer_apellido_cliente,segundo_apellido_cliente,direccion_cliente,correo_electronico) values(?,?,?,?,?)";
        try {
            PreparedStatement sm = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            sm.setString(1, cliente.getNombre());
            sm.setString(2, cliente.getApellido1());
            sm.setString(3, cliente.getApellido2());
            sm.setString(4, cliente.getDireccionCliente());
            sm.setString(5, cliente.getCorreoElectronico());
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
    
    public int Modificar(Clientes cliente) throws SQLException{
            int resultado = 0;
            String sentencia = "Update clientes set nombre_cliente=?,primer_apellido_cliente=?,segundo_apellido_cliente=?,direccion_cliente=?,correo_electronico=? where Id_cliente = ?";
            try {
                PreparedStatement ps = _cnn.prepareStatement(sentencia);
                ps.setString(1,cliente.getNombre());
                ps.setString(2,cliente.getApellido1());
                ps.setString(3,cliente.getApellido2());
                ps.setString(4,cliente.getDireccionCliente());
                ps.setString(5,cliente.getCorreoElectronico());
                ps.setInt(6,cliente.getIdentificacion());
                
                resultado = ps.executeUpdate();
                if (resultado > 0) {
                    mensaje = "Cliente modificado";
                }
            } catch (Exception e) {
                throw e;
            } finally {
                _cnn = null;
            }
            return resultado;
        }
    //Eliminar Cliente
    public int Eliminar(Clientes cliente) throws SQLException{
            int resultado = 0;
            String sentencia ="delete Clientes where id_cliente = ?";
            try {
                PreparedStatement ps = _cnn.prepareStatement(sentencia);
                ps.setInt(1,cliente.getIdentificacion());
                resultado = ps.executeUpdate();
                if (resultado>0) {
                    mensaje = "Cliente eliminado";
                }
            } catch (Exception e) {
                throw e;
            } finally {
                _cnn = null;
            }
            return resultado;
        }
    //Listar Registros Array
    
        public List<Clientes>ListarClientes(String condicion) throws SQLException{
        ResultSet rs = null;
        List<Clientes> lista = new ArrayList();
        
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_cliente, nombre_cliente,primer_apellido_cliente,segundo_apellido_cliente,correo_electronico, direccion_cliente from clientes";
            
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Clientes(rs.getInt("id_cliente"),
                                      rs.getString("nombre_cliente"),
                                      rs.getString("primer_apellido_cliente"),
                                      rs.getString("segundo_apellido_cliente"),
                                      rs.getString("correo_electronico"),
                                      rs.getString("direccion_cliente")
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
        public Clientes ObtenerCliente(String condicion) throws SQLException{ //Solo se usa en DA
            
            ResultSet rs = null;
            Clientes cliente = new Clientes();
            
            try {
                Statement stm = _cnn.createStatement();
                String sentencia = "Select id_cliente, nombre_cliente, primer_apellido_cliente,segundo_apellido_cliente, direccion_cliente, correo_electronico from clientes";
            
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs = stm.executeQuery(sentencia);
                if (rs.next()) {
                    cliente.setIdentificacion(rs.getInt(1));
                    cliente.setNombre(rs.getString(2));
                    cliente.setApellido1(rs.getString(3));
                    cliente.setApellido2(rs.getString(4));
                    cliente.setDireccionCliente(rs.getString(5));
                    cliente.setCorreoElectronico(rs.getString(6));
                    cliente.setExiste(true);
                }
                
            } catch (Exception ex) {
                throw ex;
            }finally{
                _cnn = null;
            }
            
            return cliente;
        }
}
