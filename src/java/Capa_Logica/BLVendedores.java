/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_AccesoDatos.DAVendedores;
import Capa_Entidades.Vendedores;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software
 */
public class BLVendedores {
    //Atributo
    private String mensaje;
    
    //Metodo
    public String getMensaje() throws Exception{
        return mensaje;
    }
    
    public int Insertar(Vendedores vendedor) throws Exception{
        int id = -1;
        
        DAVendedores davendedor;
        
        try {
            davendedor = new DAVendedores();
            id = davendedor.Insertar(vendedor);
            
            mensaje = davendedor.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        
        return id;
    }
    //Modificar
    public int Modificar(Vendedores vendedor) throws Exception{
        int resultado=-1;
        DAVendedores davendedor;
        try {
            davendedor=new DAVendedores();
            resultado=davendedor.Modificar(vendedor);
            mensaje=davendedor.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    //Eliminar Cliente
      public int Eliminar(Vendedores vendedor) throws Exception{
        int resultado=-1;
        DAVendedores davendedor;
        try {
            davendedor=new DAVendedores();
            resultado=davendedor.Eliminar(vendedor);
            mensaje=davendedor.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    public List<Vendedores> Listar(String condicion)throws Exception{
        List<Vendedores> clientes = new ArrayList();
        DAVendedores cliente = new DAVendedores();
        
        try {
            cliente = new DAVendedores();
            clientes = cliente.Listar(condicion);
        } catch (Exception e) {
        } finally {
        }
        return clientes;
    }
    //Obtener Cliente
    
    public Vendedores Obtener(String condicion) throws Exception{
        Vendedores resultado;
        DAVendedores davendedor;
        try {
            davendedor = new DAVendedores();
            resultado = davendedor.Obtener(condicion);
            if (resultado.isExiste()) {
                mensaje = "Vendedor encontrado satisfactoriamente";
            }else{
                mensaje = "El vendedor no esta en la BD";
            }
        } catch (Exception e) {
        throw e;
        }
        
        return resultado;
    }
}
