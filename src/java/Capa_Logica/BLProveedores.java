/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_AccesoDatos.DAProveedores;
import Capa_Entidades.Proveedores;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software
 */
public class BLProveedores {
    //Atributo
    private String mensaje;
    
    //Metodo
    public String getMensaje() throws Exception{
        return mensaje;
    }
    
    public int Insertar(Proveedores proveedor) throws Exception{
        int id = -1;
        
        DAProveedores daproveedores;
        
        try {
            daproveedores = new DAProveedores();
            id = daproveedores.Insertar(proveedor);
            
            mensaje = daproveedores.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        
        return id;
    }
    //Modificar
    public int Modificar(Proveedores proveedor) throws Exception{
        int resultado=-1;
        DAProveedores daproveedores;
        try {
            daproveedores=new DAProveedores();
            resultado=daproveedores.Modificar(proveedor);
            mensaje=daproveedores.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    //Eliminar Cliente
      public int Eliminar(Proveedores proveedor) throws Exception{
        int resultado=-1;
        DAProveedores daproveedores;
        try {
            daproveedores=new DAProveedores();
            resultado=daproveedores.Eliminar(proveedor);
            mensaje=daproveedores.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    public List<Proveedores> Listar(String condicion)throws Exception{
        List<Proveedores> proveedores = new ArrayList();
        DAProveedores proveedor = new DAProveedores();
        
        try {
            proveedor = new DAProveedores();
            proveedores = proveedor.Listar(condicion);
        } catch (Exception e) {
        } finally {
        }
        return proveedores;
    }
    //Obtener Cliente
    
    public Proveedores Obtener(String condicion) throws Exception{
        Proveedores resultado;
        DAProveedores daproveedores;
        try {
            daproveedores = new DAProveedores();
            resultado = daproveedores.Obtener(condicion);
            if (resultado.isExiste()) {
                mensaje = "Proveedor encontrado satisfactoriamente";
            }else{
                mensaje = "El proveedor no esta en la Base de Datos";
            }
        } catch (Exception e) {
        throw e;
        }
        
        return resultado;
    }
}
