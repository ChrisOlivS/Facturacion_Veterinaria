/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_AccesoDatos;

import Capa_Entidades.Vendedores;
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
public class DAVendedores {
    //Atributos
    private Connection _cnn;
    private String mensaje;
    //Getter
    public String getMensaje(){
        return mensaje;
    }
    
    public DAVendedores() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public int Insertar(Vendedores vendedor) throws Exception{
        int id_cliente = -1;
        
        String sentencia = "insert into Vendedores (nombre_vendedor,primer_apellido_vendedor,segundo_apellido_vendedor) values(?,?,?)";
        try {
            PreparedStatement sm = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            sm.setString(1, vendedor.getNombre());
            sm.setString(2, vendedor.getApellido1());
            sm.setString(3, vendedor.getApellido2());
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
    
    public int Modificar(Vendedores vendedor) throws SQLException{
            int resultado = 0;
            String sentencia = "Update vendedores set nombre_vendedor=?,primer_apellido_vendedor=?,segundo_apellido_vendedor=? where id_vendedor = ?";
            try {
                PreparedStatement ps = _cnn.prepareStatement(sentencia);
                ps.setString(1,vendedor.getNombre());
                ps.setString(2,vendedor.getApellido1());
                ps.setString(3,vendedor.getApellido2());
                ps.setInt(4,vendedor.getIdentificacion());
                
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
    public int Eliminar(Vendedores vendedor) throws SQLException{
            int resultado = 0;
            String sentencia ="delete Vendedores where id_vendedor = ?";
            try {
                PreparedStatement ps = _cnn.prepareStatement(sentencia);
                ps.setInt(1,vendedor.getIdentificacion());
                resultado = ps.executeUpdate();
                if (resultado>0) {
                    mensaje = "Vendedor eliminado";
                }
            } catch (Exception e) {
                throw e;
            } finally {
                _cnn = null;
            }
            return resultado;
        }
    //Listar Registros Array
    
        public List<Vendedores>Listar(String condicion) throws SQLException{
        ResultSet rs = null;
        List<Vendedores> lista = new ArrayList();
        
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_vendedor,nombre_vendedor,primer_apellido_vendedor,segundo_apellido_vendedor from vendedores";
            
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Vendedores(rs.getInt("id_vendedor"),
                                      rs.getString("nombre_vendedor"),
                                      rs.getString("primer_apellido_vendedor"),
                                      rs.getString("segundo_apellido_vendedor")
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
        public Vendedores Obtener(String condicion) throws SQLException{ //Solo se usa en DA
            
            ResultSet rs = null;
            Vendedores vendedor = new Vendedores();
            
            try {
                Statement stm = _cnn.createStatement();
                String sentencia = "Select id_vendedor,nombre_vendedor,primer_apellido_vendedor,segundo_apellido_vendedor from vendedores";
            
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs = stm.executeQuery(sentencia);
                if (rs.next()) {
                    vendedor.setIdentificacion(rs.getInt(1));
                    vendedor.setNombre(rs.getString(2));
                    vendedor.setApellido1(rs.getString(3));
                    vendedor.setApellido2(rs.getString(4));
                    vendedor.setExiste(true);
                }
                
            } catch (Exception ex) {
                throw ex;
            }finally{
                _cnn = null;
            }
            
            return vendedor;
        }
}
