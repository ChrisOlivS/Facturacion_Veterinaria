/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Software
 */
public class Persona {
    //Atributos 
    
    private int identificacion;
    private String nombre;
    private String apellido1;
    private String apellido2;

    //Propiedades Getter
    public int getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    //Propiedades Setter
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    //Constructor vacio
    public Persona() {
        identificacion = 0;
        nombre = "";
        apellido1 = "";
        apellido2 = "";
    }
    //Constructor con Parametros
    public Persona(int identificacion, String nombre, String apellido1, String apellido2) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    
    
}
