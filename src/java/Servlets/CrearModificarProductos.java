/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Capa_Entidades.Productos;
import Capa_Logica.BLProductos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Software
 */
public class CrearModificarProductos extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            
            BLProductos logica = new BLProductos();
            
            Productos producto = new Productos();
            
            int resultado;
            
            producto.setIdentificacion(Integer.parseInt(request.getParameter("txtcodigo")));
            producto.setCodigoProveedor(new String(request.getParameter("txtCodProv").getBytes("ISO-8859-1"),"UTF-8"));
            producto.setNombre_producto(request.getParameter("txtNombre"));
            producto.setCantidad(Integer.parseInt(request.getParameter("txtCantidad")));
            producto.setPrecio(Integer.parseInt(request.getParameter("txtPrecio")));
            if (producto.getIdentificacion()> 0) {
                resultado = logica.Modificar(producto);
            
            }else{
                resultado = logica.Insertar(producto);
            }
            response.sendRedirect("FrmProductos.jsp");
        }catch(Exception ex){
            out.print(ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
