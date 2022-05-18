/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_AccesoDatos.DAClientes;
import Capa_Entidades.Clientes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software
 */
public class BLClientes {
    //Atributo
    private String mensaje;
    
    //Metodo
    public String getMensaje() throws Exception{
        return mensaje;
    }
    
    public int Insertar(Clientes cliente) throws Exception{
        int id = -1;
        
        DAClientes dacliente;
        
        try {
            dacliente = new DAClientes();
            id = dacliente.Insertar(cliente);
            
            mensaje = dacliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        
        return id;
    }
    //Modificar
    public int Modificar(Clientes cliente) throws Exception{
        int resultado=-1;
        DAClientes dacliente;
        try {
            dacliente=new DAClientes();
            resultado=dacliente.Modificar(cliente);
            mensaje=dacliente.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    //Eliminar Cliente
      public int Eliminar(Clientes cliente) throws Exception{
        int resultado=-1;
        DAClientes dacliente;
        try {
            dacliente=new DAClientes();
            resultado=dacliente.Eliminar(cliente);
            mensaje=dacliente.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    public List<Clientes> ListarClientes(String condicion)throws Exception{
        List<Clientes> clientes = new ArrayList();
        DAClientes cliente = new DAClientes();
        
        try {
            cliente = new DAClientes();
            clientes = cliente.ListarClientes(condicion);
        } catch (Exception e) {
        } finally {
        }
        return clientes;
    }
    //Obtener Cliente
    
    public Clientes ObtenerCliente(String condicion) throws Exception{
        Clientes resultado;
        DAClientes dacliente;
        try {
            dacliente = new DAClientes();
            resultado = dacliente.ObtenerCliente(condicion);
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
