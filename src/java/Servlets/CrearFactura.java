/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Capa_Entidades.Detalle_Factura;
import Capa_Logica.BLDetalle_Factura;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Software
 */
public class CrearFactura extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */

            BLDetalle_Factura logica = new BLDetalle_Factura();

            Detalle_Factura detalle = new Detalle_Factura();

            int resultado;

            detalle.setIdFactura(Integer.parseInt(request.getParameter("txtcodigo")));
            detalle.setIdCliente(new String(request.getParameter("txtIDCliente")));
            detalle.setIdVendedor(request.getParameter("txtIdVend"));
            detalle.setIdProducto(new String(request.getParameter("txtProd")));
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaString = request.getParameter("txtFecha");
            Date fecha = formato.parse(fechaString);
            java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
            detalle.setFecha_v(fechasql);
            detalle.setCantidadProd(Integer.parseInt(request.getParameter("txtCantidad")));
            detalle.setImpuesto(Double.parseDouble(request.getParameter("txtImpuesto")));
            detalle.setSubtotal(Double.parseDouble(request.getParameter("txtSubtotal")));
            detalle.setTotal(Double.parseDouble(request.getParameter("txtTotal")));

            resultado = logica.Insertar(detalle);
            response.sendRedirect("FrmDetalle.jsp");
        } catch (Exception ex) {
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
