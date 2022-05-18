/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Software
 */
public class Vendedores extends Persona{
    //Atributos

    private boolean existe;

    
    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public Vendedores() {
    }

    public Vendedores(int identificacion, String nombre, String apellido1, String apellido2) {
        super(identificacion, nombre, apellido1, apellido2);
        this.existe = existe;
    }
 
}
