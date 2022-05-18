/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_AccesoDatos;

import Capa_Entidades.Compras;
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
public class DACompras {

    //Atributos
    private Connection _cnn;
    private String mensaje;

    //Getter
    public String getMensaje() {
        return mensaje;
    }

    public DACompras() throws Exception {
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }

    public int Insertar(Compras compra) throws Exception {
        int id_compra = -1;

        String sentencia = "INSERT INTO COMPRAS(ID_VETERINARIO,ID_PROVEEDOR,NOMBRE_PRODUCTO_C,CANTIDAD_C) values(?,?,?,?)";
        try {
            PreparedStatement sm = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            sm.setString(1, compra.getIdentificacionVeterinario());
            sm.setString(2, compra.getCodigoProveedor());
            sm.setString(3, compra.getNombreProducto());
            sm.setInt(4, compra.getCantidad());
            sm.execute();
            ResultSet rs = sm.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id_compra = rs.getInt(1);
                mensaje = "Datos Ingresados Exitosamente";
            }

        } catch (Exception ex) {
        }
        return id_compra;
    }
    //Modificar

    //Eliminar Cliente
    public int Eliminar(Compras compra) throws SQLException {
        int resultado = 0;
        String sentencia = "delete Compras where id_compra = ?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, compra.getCodigoCompra());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Compra eliminada";
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return resultado;
    }
    //Listar Registros Array

    public List<Compras> Listar(String condicion) throws SQLException {
        ResultSet rs = null;
        List<Compras> lista = new ArrayList();

        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_COMPRA,NOMBRE_VETERINARIO+' '+PRIMER_APELLIDO_VETERINARIO+' '+SEGUNDO_APELLIDO_VETERINARIO+' ' AS NOMBRE_COMPLETO,\n"
                    + "NOMBRE_PROVEEDOR,NOMBRE_PRODUCTO_C,CANTIDAD_C\n"
                    + "FROM COMPRAS C INNER JOIN VETERINARIOS V\n"
                    + "ON	C.ID_VETERINARIO = V.ID_VETERINARIO\n"
                    + "INNER JOIN PROVEEDORES P\n"
                    + "ON	P.ID_PROVEEDOR = C.ID_PROVEEDOR";

            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Compras(rs.getInt("id_compra"),
                        rs.getString("NOMBRE_COMPLETO"),
                        rs.getString("NOMBRE_PROVEEDOR"),
                        rs.getString("nombre_producto_c"),
                        rs.getInt("cantidad_c")
                ));

            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return lista;
    }

    //Obtener Clientes
    public Compras Obtener(String condicion) throws SQLException { //Solo se usa en DA

        ResultSet rs = null;
        Compras compra = new Compras();

        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_compra,id_veterinario,id_proveedor,nombre_producto_c,cantidad_c from compras";

            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                compra.setCodigoCompra(rs.getInt(1));
                compra.setIdentificacionVeterinario(rs.getString(2));
                compra.setCodigoProveedor(rs.getString(3));
                compra.setNombreProducto(rs.getString(4));
                compra.setCantidad(rs.getInt(5));;
                compra.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }

        return compra;
    }
}
