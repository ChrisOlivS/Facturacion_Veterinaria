/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

import java.sql.Date;

/**
 *
 * @author Software
 */
public class Detalle_Factura {
    
    //Atributos
    private int idFactura;
    private String idProducto;
    private String idCliente;
    private int cantidadProd;
    private String idVendedor;
    private Date fecha_v;
    private double precio;
    private double subtotal;
    private double impuesto;
    private double total;
    private boolean existe;
    
    //Getter
    public int getIdFactura() {
        return idFactura;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public Date getFecha_v() {
        return fecha_v;
    }
        public double getPrecio() {
        return precio;
    }


    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }

    public boolean isExiste() {
        return existe;
    }

    //Setter
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public void setFecha_v(Date fecha_v) {
        this.fecha_v = fecha_v;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    //Constructor vacio
    public Detalle_Factura() {
        idFactura = 0;
        idProducto = "";
        idCliente = "";
        cantidadProd = 0;
        idVendedor = "";
        subtotal = 0;
        impuesto = 0;
        precio = 0;
        total = 0;
        existe = false;
    }
    //Constructor parametros
    public Detalle_Factura(int idFactura, String idProducto, String idCliente, int cantidadProd, String idVendedor, Date fecha_v,double precio, double subtotal, double impuesto, double total) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.idCliente = idCliente;
        this.cantidadProd = cantidadProd;
        this.idVendedor = idVendedor;
        this.fecha_v = fecha_v;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.precio = precio;
        this.total = total;
        this.existe = existe;
    }

    
}
