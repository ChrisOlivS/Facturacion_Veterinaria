/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_AccesoDatos.DADetalle_Factura;
import Capa_Entidades.Detalle_Factura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software
 */
public class BLDetalle_Factura {
    //Atributo
    private String mensaje;
    
    //Metodo
    public String getMensaje() throws Exception{
        return mensaje;
    }
    //Insertar
    public int Insertar(Detalle_Factura detalle) throws Exception{
        int id = -1;
        
        DADetalle_Factura dadetalle;
        
        try {
            dadetalle = new DADetalle_Factura();
            id = dadetalle.Insertar(detalle);
            
            mensaje = dadetalle.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        
        return id;
    }

    //Eliminar
      public int Eliminar(Detalle_Factura detalle) throws Exception{
        int resultado=-1;
        DADetalle_Factura dadetalle;
        try {
            dadetalle=new DADetalle_Factura();
            resultado=dadetalle.Eliminar(detalle);
            mensaje=dadetalle.getMensaje();
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    public List<Detalle_Factura> Listar(String condicion)throws Exception{
        List<Detalle_Factura> detalles = new ArrayList();
        DADetalle_Factura detalle = new DADetalle_Factura();
        
        try {
            detalle = new DADetalle_Factura();
            detalles = detalle.Listar(condicion);
        } catch (Exception e) {
        } finally {
        }
        return detalles;
    }
    //Obtener
    
    public Detalle_Factura Obtener(String condicion) throws Exception{
        Detalle_Factura resultado;
        DADetalle_Factura dadetalle;
        try {
            dadetalle = new DADetalle_Factura();
            resultado = dadetalle.Obtener(condicion);
            if (resultado.isExiste()) {
                mensaje = "Detalle encontrado satisfactoriamente";
            }else{
                mensaje = "El detalle no esta en la BD";
            }
        } catch (Exception e) {
        throw e;
        }
        
        return resultado;
    }
}
