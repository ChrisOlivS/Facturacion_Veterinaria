/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Software
 */
public class Proveedores {
    
        //Atributos
    private int identificacion;
    private String nombreProveedor;
    private String direccionProveedor;
    private String correoElectronico_proveedor;
    private boolean existe;

    //Getter
    public int getIdentificacion() {
        return identificacion;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public String getCorreoElectronico_proveedor() {
        return correoElectronico_proveedor;
    }

    public boolean isExiste() {
        return existe;
    }
    //Setter
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public void setCorreoElectronico_proveedor(String correoElectronico_proveedor) {
        this.correoElectronico_proveedor = correoElectronico_proveedor;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    //Constructor vacio
    public Proveedores() {
        identificacion = 0;
        nombreProveedor = "";
        direccionProveedor = "";
        correoElectronico_proveedor = "";
        existe = false;
    }
    //Constructor con Parametros
    public Proveedores(int identificacion, String nombreProveedor, String direccionProveedor, String correoElectronico_proveedor) {
        this.identificacion = identificacion;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.correoElectronico_proveedor = correoElectronico_proveedor;
        this.existe = existe;
    }

    


}
