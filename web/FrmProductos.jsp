<%-- 
    Document   : FrmProductos
    Created on : 3 may 2022, 11:33:40
    Author     : Software
--%>

<%@page import="Capa_Entidades.Productos"%>
<%@page import="Capa_Logica.BLProductos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Sistema Facturacion</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="CSS/style.css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-dark bg-dark border-bottom box-shadow mb-3">
            <div class="container">
                <a class="navbar-brand" href="index.html">Facturación <i class="fas fa-tasks"></i></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link text-light" href="index.html">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light ml-2" href="FrmVeterinarios.jsp">Veterinarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light ml-2"" href="FrmProveedores.jsp">Proveedores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light ml-2"" href="FrmProductos.jsp">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light ml-2"" href="FrmClientes.jsp">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light ml-2"" href="FrmDetalle.jsp">Detalle Facturas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light ml-2"" href="FrmVendedores.jsp">Vendedores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light ml-2"" href="FrmCompras.jsp">Compras</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="card-header">
                <h1>Listado de Productos</h1>
            </div>                      
            <br>

            <!-- El formulario se va a cargar a si mismo -->    
            <form action="FrmProductos.jsp" method="post">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" id="txtnombre" name="txtnombre" value="" 
                               placeholder="Buscar por Nombre" class="form-control"/>
                        &nbsp;&nbsp;
                        <input type="submit" id="btnbuscar" name="btnbuscar" value="Buscar" 
                               class="btn btn-primary"/><br><br>
                    </div> 
                </div> 
            </form>
            <hr>
            <table class="table table-dark table-striped table-hover">
                <thead>
                    <tr id="titulos">
                        <th>Código</th>
                        <th>Proveedor</th>
                        <th>Nombre Producto</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>

                    <!--Hacer una consulta a la bd para obtener la lista de clientes
                        mediante código JAVA--> 
                    <%
                        String nombre = "";
                        String condicion = "";
                        //si el txtnombre no está vacio
                        if (request.getParameter("txtnombre") != null) {
                            nombre = request.getParameter("txtnombre");
                            condicion = "NOMBRE_PRODUCTO LIKE '%" + nombre + "%'";
                        }
                        BLProductos logica = new BLProductos();
                        List<Productos> datos;
                        datos = logica.Listar(condicion);

                        //for para llenar la tabla
                        for (Productos registro : datos) {
                    %>
                    <tr>
                        <% int codigo = registro.getIdentificacion();%>
                        <td><%=codigo%></td>
                        <td><%=registro.getCodigoProveedor()%></td>
                        <td><%=registro.getNombre_producto()%></td>
                        <td><%=registro.getCantidad()%></td>
                        <td><%=registro.getPrecio()%></td>
                        <!--Columna para los botones -->
                        <td>
                            <!--Botón para modificar -->
                            <a href="FrmMantProductos.jsp?idCrearModificar=<%=codigo%>"> <i class="fas fa-user-edit"></i></a> |
                            <!--Botón para Eliminar -->
                            <a href="EliminarProductos?idEliminar=<%=codigo%>"> <i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <%}%><!--Para cerrar el for --> 
                </tbody>
            </table>
            <br> 
            <a href="FrmMantProductos.jsp?idCrearModificar=-1"><button type="button" class="btn btn-dark mb-3">Agregar Producto</button></a> |
            <a href="FrmProductos.jsp"><button type="button" class="btn btn-dark mb-3">Actualizar</button></a> |
            <a href="index.html"><button type="button" class="btn btn-dark mb-3">Inicio</button></a>

        </div><!--Fin Container --> 
        <footer>

        </footer>
        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
