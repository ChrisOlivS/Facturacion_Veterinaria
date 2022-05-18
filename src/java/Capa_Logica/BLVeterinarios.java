/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_AccesoDatos.DAVeterinarios;
import Capa_Entidades.Veterinarios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software
 */
public class BLVeterinarios {
    //Atributo
    private String mensaje;
    
    //Metodo
    public String getMensaje() throws Exception{
        return mensaje;
    }
    
    public int Insertar(Veterinarios veterinario) throws Exception{
        int id = -1;
        
        DAVeterinarios daveterinario;
        
        try {
            daveterinario = new DAVeterinarios();
            id = daveterinario.Insertar(veterinario);
            
            mensaje = daveterinario.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        
        return id;
    }
    //Modificar
    public int Modificar(Veterinarios veterinario) throws Exception{
        int resultado=-1;
        DAVeterinarios daveterinario;
        try {
            daveterinario=new DAVeterinarios();
            resultado=daveterinario.Modificar(veterinario);
            mensaje=daveterinario.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    //Eliminar Cliente
      public int Eliminar(Veterinarios veterinario) throws Exception{
        int resultado=-1;
        DAVeterinarios daveterinario;
        try {
            daveterinario=new DAVeterinarios();
            resultado=daveterinario.Eliminar(veterinario);
            mensaje=daveterinario.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    public List<Veterinarios> Listar(String condicion)throws Exception{
        List<Veterinarios> veterinarios = new ArrayList();
        DAVeterinarios veterinario = new DAVeterinarios();
        
        try {
            veterinario = new DAVeterinarios();
            veterinarios = veterinario.Listar(condicion);
        } catch (Exception e) {
        } finally {
        }
        return veterinarios;
    }
    //Obtener Cliente
    
    public Veterinarios Obtener(String condicion) throws Exception{
        Veterinarios resultado;
        DAVeterinarios daveterinario;
        try {
            daveterinario = new DAVeterinarios();
            resultado = daveterinario.Obtener(condicion);
            if (resultado.isExiste()) {
                mensaje = "Veterinario encontrado satisfactoriamente";
            }else{
                mensaje = "El veterinario no esta en la BD";
            }
        } catch (Exception e) {
        throw e;
        }
        
        return resultado;
    }
}
