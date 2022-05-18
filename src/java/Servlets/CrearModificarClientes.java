/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Capa_Entidades.Clientes;
import Capa_Logica.BLClientes;
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
public class CrearModificarClientes extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            
            BLClientes logica = new BLClientes();
            
            Clientes cliente = new Clientes();
            
            int resultado;
            
            cliente.setIdentificacion(Integer.parseInt(request.getParameter("txtcodigo")));
            cliente.setNombre(new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"),"UTF-8"));
            cliente.setApellido1(request.getParameter("txtApellido1"));
            cliente.setApellido2(new String(request.getParameter("txtApellido2").getBytes("ISO-8859-1"),"UTF-8"));
            cliente.setDireccionCliente(request.getParameter("txtDireccion"));
            cliente.setCorreoElectronico(new String(request.getParameter("txtCorreoE").getBytes("ISO-8859-1"),"UTF-8"));
            if (cliente.getIdentificacion()> 0) {
                resultado = logica.Modificar(cliente);
            
            }else{
                resultado = logica.Insertar(cliente);
            }
            response.sendRedirect("FrmClientes.jsp");
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
