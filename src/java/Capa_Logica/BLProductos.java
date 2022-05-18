/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_AccesoDatos.DAProductos;
import Capa_Entidades.Productos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software
 */
public class BLProductos {
    //Atributo
    private String mensaje;
    
    //Metodo
    public String getMensaje() throws Exception{
        return mensaje;
    }
    //Insertar
    public int Insertar(Productos producto) throws Exception{
        int id = -1;
        
        DAProductos daproducto;
        
        try {
            daproducto = new DAProductos();
            id = daproducto.Insertar(producto);
            
            mensaje = daproducto.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        
        return id;
    }
    //Modificar
    public int Modificar(Productos cliente) throws Exception{
        int resultado=-1;
        DAProductos daproducto;
        try {
            daproducto=new DAProductos();
            resultado=daproducto.Modificar(cliente);
            mensaje=daproducto.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    //Eliminar
      public int Eliminar(Productos producto) throws Exception{
        int resultado=-1;
        DAProductos daproducto;
        try {
            daproducto=new DAProductos();
            resultado=daproducto.Eliminar(producto);
            mensaje=daproducto.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    public List<Productos> Listar(String condicion)throws Exception{
        List<Productos> productos = new ArrayList();
        DAProductos producto = new DAProductos();
        
        try {
            producto = new DAProductos();
            productos = producto.Listar(condicion);
        } catch (Exception e) {
        } finally {
        }
        return productos;
    }
    //Obtener
    
    public Productos Obtener(String condicion) throws Exception{
        Productos resultado;
        DAProductos daproducto;
        try {
            daproducto = new DAProductos();
            resultado = daproducto.Obtener(condicion);
            if (resultado.isExiste()) {
                mensaje = "Cliente encontrado satisfactoriamente";
            }else{
                mensaje = "El cliente no esta en la BD";
            }
        } catch (Exception e) {
        throw e;
        }
        
        return resultado;
    }
}
