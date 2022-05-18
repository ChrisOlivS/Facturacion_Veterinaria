/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_AccesoDatos;

import Capa_Entidades.Detalle_Factura;
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
public class DADetalle_Factura {

    //Atributos
    private Connection _cnn;
    private String mensaje;

    //Getter
    public String getMensaje() {
        return mensaje;
    }

    public DADetalle_Factura() throws Exception {
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }

    //Insertar
    public int Insertar(Detalle_Factura detalle) throws Exception {
        int id_cliente = -1;

        String sentencia = "INSERT INTO DETALLE_FACTURAS(ID_VENDEDOR,ID_PRODUCTO,ID_CLIENTE,CANTIDAD_PRODUCTOS,SUBTOTAL,TOTAL) values(?,?,?,?,?,?)";
        try {
            PreparedStatement sm = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            sm.setString(1, detalle.getIdVendedor());
            sm.setString(2, detalle.getIdProducto());
            sm.setString(3, detalle.getIdCliente());
            sm.setInt(4, detalle.getCantidadProd());
            sm.setDate(5,detalle.getFecha_v());
            sm.setDouble(6,detalle.getImpuesto());
            sm.setDouble(7, detalle.getSubtotal());
            sm.setDouble(8, detalle.getTotal());
            
            sm.execute();
            ResultSet rs = sm.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id_cliente = rs.getInt(1);
                mensaje = "Datos Ingresados Exitosamente";
            }

        } catch (Exception ex) {
        }
        return id_cliente;
    }

    //Eliminar
    public int Eliminar(Detalle_Factura detalle) throws SQLException {
        int resultado = 0;
        String sentencia = "DELETE FROM DETALLE_FACTURAS WHERE ID_DETALLE = ?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, detalle.getIdFactura());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Detalle eliminado";
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }
        return resultado;
    }
    //Listar Registros Array

    public List<Detalle_Factura> Listar(String condicion) throws SQLException {
        ResultSet rs = null;
        List<Detalle_Factura> lista = new ArrayList();

        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID_DETALLE,NOMBRE_VENDEDOR+' '+PRIMER_APELLIDO_VENDEDOR\n"
                    + "+' '+SEGUNDO_APELLIDO_VENDEDOR AS NOMBRE_COMPLETO_V, NOMBRE_CLIENTE \n"
                    + "+ ' '+ PRIMER_APELLIDO_CLIENTE+' '+SEGUNDO_APELLIDO_CLIENTE AS NOMBRE_COMPLETO_C,\n"
                    + "NOMBRE_PRODUCTO, CANTIDAD_PRODUCTOS,PRECIO,SUBTOTAL,IMPUESTO,TOTAL,FECHA_V\n"
                    + "FROM DETALLE_FACTURAS DF INNER JOIN CLIENTES C\n"
                    + "ON	 DF.ID_CLIENTE = C.ID_CLIENTE\n"
                    + "INNER JOIN PRODUCTOS P\n"
                    + "ON	 DF.ID_PRODUCTO = P.ID_PRODUCTO\n"
                    + "INNER JOIN VENDEDORES V\n"
                    + "ON	 DF.ID_VENDEDOR = V.ID_VENDEDOR";

            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Detalle_Factura(rs.getInt("ID_DETALLE"),
                        rs.getString("NOMBRE_COMPLETO_V"),
                        rs.getString("NOMBRE_COMPLETO_C"),
                        rs.getInt("CANTIDAD_PRODUCTOS"),
                        rs.getString("NOMBRE_PRODUCTO"),
                        rs.getDate("FECHA_V"),
                        rs.getDouble("PRECIO"),
                        rs.getDouble("SUBTOTAL"),
                        rs.getDouble("IMPUESTO"),
                        rs.getDouble("TOTAL")
                ));

            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return lista;
    }

    //Obtener 
    public Detalle_Factura Obtener(String condicion) throws SQLException { //Solo se usa en DA

        ResultSet rs = null;
        Detalle_Factura detalle = new Detalle_Factura();

        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_detalle,id_cliente,id_producto,id_vendedor,cantidad_productos,fecha_v,impuesto,subtotal,total from detalle_facturas";

            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                detalle.setIdFactura(rs.getInt(1));
                detalle.setIdCliente(rs.getString(2));
                detalle.setIdProducto(rs.getString(3));
                detalle.setIdVendedor(rs.getString(4));
                detalle.setCantidadProd(rs.getInt(5));
                detalle.setFecha_v(rs.getDate(6));
                detalle.setImpuesto(rs.getDouble(7));
                detalle.setSubtotal(rs.getDouble(8));
                detalle.setTotal(rs.getDouble(9));
                detalle.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }

        return detalle;
    }
}
