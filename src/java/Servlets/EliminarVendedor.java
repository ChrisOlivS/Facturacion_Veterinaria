/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Capa_Entidades.Vendedores;
import Capa_Logica.BLVendedores;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Software
 */
public class EliminarVendedor extends HttpServlet {

         @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Indica el tipo de salida a generar HTML dentro del Servlet
            response.setContentType("text/html;charset=UTF-8");

            //Para poder escribir en el HTML
            PrintWriter out = response.getWriter();

            try {
                BLVendedores logica = new BLVendedores();
                Vendedores vendedor = new Vendedores();
                //Parametro que se envio Query String
                String id = request.getParameter("idEliminar");
                int codigo = Integer.parseInt(id);
                vendedor.setIdentificacion(codigo);
                int resultado = logica.Eliminar(vendedor);
                String mensaje = logica.getMensaje();//Mensaje sp
                mensaje = URLEncoder.encode(mensaje, "UTF-8");
                //Redireccionar a la pagina jsp
                response.sendRedirect("FrmVendedores.jsp?mensaje=" + mensaje + "&resultado=" + resultado);
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }

        }

}
