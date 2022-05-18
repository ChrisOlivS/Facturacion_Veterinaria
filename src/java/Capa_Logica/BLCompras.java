/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_AccesoDatos.DACompras;
import Capa_Entidades.Compras;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software
 */
public class BLCompras {
    //Atributo
    private String mensaje;
    
    //Metodo
    public String getMensaje() throws Exception{
        return mensaje;
    }
    
    public int Insertar(Compras compra) throws Exception{
        int id = -1;
        
        DACompras dacompra;
        
        try {
            dacompra = new DACompras();
            id = dacompra.Insertar(compra);
            
            mensaje = dacompra.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        
        return id;
    }
    //Eliminar Cliente
      public int Eliminar(Compras compra) throws Exception{
        int resultado=-1;
        DACompras dacompra;
        try {
            dacompra=new DACompras();
            resultado=dacompra.Eliminar(compra);
            mensaje=dacompra.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    public List<Compras> Listar(String condicion)throws Exception{
        List<Compras> clientes = new ArrayList();
        DACompras compra = new DACompras();
        
        try {
            compra = new DACompras();
            clientes = compra.Listar(condicion);
        } catch (Exception e) {
        } finally {
        }
        return clientes;
    }
    //Obtener Cliente
    
    public Compras Obtener(String condicion) throws Exception{
        Compras resultado;
        DACompras dacompra;
        try {
            dacompra = new DACompras();
            resultado = dacompra.Obtener(condicion);
            if (resultado.isExiste()) {
                mensaje = "Compra encontrada satisfactoriamente";
            }else{
                mensaje = "La compra no esta en la BD";
            }
        } catch (Exception e) {
        throw e;
        }
        
        return resultado;
    }
}
