/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Software
 */
public class Compras {
    //Atributos
    private int codigoCompra;
    private String identificacionVeterinario;
    private String codigoProveedor;
    private String nombreProducto;
    private int cantidad;
    private boolean existe;
    //Getter
    public int getCodigoCompra() {
        return codigoCompra;
    }

    public String getIdentificacionVeterinario() {
        return identificacionVeterinario;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isExiste() {
        return existe;
    }
    //Setter
    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public void setIdentificacionVeterinario(String identificacionVeterinario) {
        this.identificacionVeterinario = identificacionVeterinario;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    //Constructor vacio
    public Compras() {
        codigoCompra = 0;
        identificacionVeterinario = "";
        codigoProveedor = "";
        nombreProducto = "";
        cantidad = 0;
        existe = false;
    }
    //Constructor con Parametros
    public Compras(int codigoCompra, String identificacionVeterinario, String codigoProveedor, String nombreProducto, int cantidad) {
        this.codigoCompra = codigoCompra;
        this.identificacionVeterinario = identificacionVeterinario;
        this.codigoProveedor = codigoProveedor;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.existe = existe;
    }
 

    
}
