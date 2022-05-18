/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_AccesoDatos;

import Capa_Entidades.Veterinarios;
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
public class DAVeterinarios {
     //Atributos
    private Connection _cnn;
    private String mensaje;
    //Getter
    public String getMensaje(){
        return mensaje;
    }
    
    public DAVeterinarios() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public int Insertar(Veterinarios veterinario) throws Exception{
        int id_cliente = -1;
        
        String sentencia = "insert into Veterinarios (nombre_veterinario,primer_apellido_veterinario,segundo_apellido_veterinario) values(?,?,?)";
        try {
            PreparedStatement sm = _cnn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            sm.setString(1, veterinario.getNombre());
            sm.setString(2, veterinario.getApellido1());
            sm.setString(3, veterinario.getApellido2());
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
    
    public int Modificar(Veterinarios veterinario) throws SQLException{
            int resultado = 0;
            String sentencia = "Update Veterinarios set nombre_veterinario=?,primer_apellido_veterinario=?,segundo_apellido_veterinario=? where id_veterinario = ?";
            try {
                PreparedStatement ps = _cnn.prepareStatement(sentencia);
                ps.setString(1,veterinario.getNombre());
                ps.setString(2,veterinario.getApellido1());
                ps.setString(3,veterinario.getApellido2());
                ps.setInt(4,veterinario.getIdentificacion());
                
                resultado = ps.executeUpdate();
                if (resultado > 0) {
                    mensaje = "Veterinario modificado";
                }
            } catch (Exception e) {
                throw e;
            } finally {
                _cnn = null;
            }
            return resultado;
        }
    //Eliminar Cliente
    public int Eliminar(Veterinarios veterinario) throws SQLException{
            int resultado = 0;
            String sentencia ="delete Veterinarios where id_veterinario = ?";
            try {
                PreparedStatement ps = _cnn.prepareStatement(sentencia);
                ps.setInt(1,veterinario.getIdentificacion());
                resultado = ps.executeUpdate();
                if (resultado>0) {
                    mensaje = "Veterinario eliminado";
                }
            } catch (Exception e) {
                throw e;
            } finally {
                _cnn = null;
            }
            return resultado;
        }
    //Listar Registros Array
    
        public List<Veterinarios>Listar(String condicion) throws SQLException{
        ResultSet rs = null;
        List<Veterinarios> lista = new ArrayList();
        
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_veterinario, nombre_veterinario,primer_apellido_veterinario,segundo_apellido_veterinario from veterinarios";
            
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Veterinarios(rs.getInt("id_veterinario"),
                                      rs.getString("nombre_veterinario"),
                                      rs.getString("primer_apellido_veterinario"),
                                      rs.getString("segundo_apellido_veterinario")
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
        public Veterinarios Obtener(String condicion) throws SQLException{ //Solo se usa en DA
            
            ResultSet rs = null;
            Veterinarios veterinario = new Veterinarios();
            
            try {
                Statement stm = _cnn.createStatement();
                String sentencia = "Select id_veterinario, nombre_veterinario, primer_apellido_veterinario,segundo_apellido_veterinario from Veterinarios";
            
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs = stm.executeQuery(sentencia);
                if (rs.next()) {
                    veterinario.setIdentificacion(rs.getInt(1));
                    veterinario.setNombre(rs.getString(2));
                    veterinario.setApellido1(rs.getString(3));
                    veterinario.setApellido2(rs.getString(4));
                    veterinario.setExiste(true);
                }
                
            } catch (Exception ex) {
                throw ex;
            }finally{
                _cnn = null;
            }
            
            return veterinario;
        }
}
