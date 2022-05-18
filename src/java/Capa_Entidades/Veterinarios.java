/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Software
 */
public class Veterinarios extends Persona{
    
    //Atributos
     private boolean existe;

     //Getter
    public boolean isExiste() {
        return existe;
    }
    
    //Setter
    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
    //Constructor Vacio
    public Veterinarios() {
        existe = false;
    }
    
    //Constructor Parametros
    public Veterinarios(int identificacion, String nombre, String apellido1, String apellido2) {
        super(identificacion, nombre, apellido1, apellido2);
        this.existe = existe;
    }
    
   
}
