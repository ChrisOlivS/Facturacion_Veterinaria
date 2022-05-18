/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Capa_Entidades.Compras;
import Capa_Logica.BLCompras;
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
public class EliminarCompra extends HttpServlet {

        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Indica el tipo de salida a generar HTML dentro del Servlet
            response.setContentType("text/html;charset=UTF-8");

            //Para poder escribir en el HTML
            PrintWriter out = response.getWriter();

            try {
                BLCompras logica = new BLCompras();
                Compras compra = new Compras();
                //Parametro que se envio Query String
                String id = request.getParameter("idEliminar");
                int codigo = Integer.parseInt(id);
                compra.setCodigoCompra(codigo);
                int resultado = logica.Eliminar(compra);
                String mensaje = logica.getMensaje();//Mensaje sp
                mensaje = URLEncoder.encode(mensaje, "UTF-8");
                //Redireccionar a la pagina jsp
                response.sendRedirect("FrmCompras.jsp?mensaje=" + mensaje + "&resultado=" + resultado);
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }

        }

}