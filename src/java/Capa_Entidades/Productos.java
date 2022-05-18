/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Software
 */
public class Productos {
    
    //Atributos
    private int identificacion;
    private String codigoProveedor;
    private String nombre_producto;
    private int precio;
    private int cantidad;
    private boolean existe;
    //Getter
    public int getIdentificacion() {
        return identificacion;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    //Atributos
    public boolean isExiste() {
        return existe;
    }

    //Setter
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    //Constructor vacio
        public Productos() {
        identificacion = 0;
        codigoProveedor = "";
        nombre_producto = "";
        precio = 0;
        cantidad = 0;
        existe = false;
    }
    //Constructor Parametros
    public Productos(int identificacion, String codigoProveedor, String nombre_producto, int precio, int cantidad) {
        this.identificacion = identificacion;
        this.codigoProveedor = codigoProveedor;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.existe = existe;
    }

    

}
