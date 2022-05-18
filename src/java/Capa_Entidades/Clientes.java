/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Software
 */
public class Clientes extends Persona{
    //Atributos
    
    private String correoElectronico;
    private String direccionCliente;
    private boolean existe;

    //Getter
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }
    public boolean isExiste() {
        return existe;
    }
    //Setter
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    //Constructor Vacio
    
    public Clientes(){
        correoElectronico = "";
        direccionCliente = "";
        existe = false;
    }
    
    //Constructor Parametros
    
    public Clientes(int identificacion, String nombre, String apellido1, String apellido2, String correoElectronico, String direccionCliente){
        super(identificacion,nombre,apellido1,apellido2);
        this.correoElectronico = correoElectronico;
        this.direccionCliente = direccionCliente;
        this.existe = existe;
    }
}
