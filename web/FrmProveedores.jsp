<%-- 
    Document   : FrmProveedores
    Created on : 3 may 2022, 10:58:58
    Author     : Software
--%>
<%@page import="Capa_Entidades.Proveedores"%>
<%@page import="Capa_Logica.BLProveedores"%>
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
                <h1>Listado de Proveedores</h1>
            </div>                      
            <br>

            <!-- El formulario se va a cargar a si mismo -->    
            <form action="FrmProveedores.jsp" method="post">
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
                        <th>Nombre Proveedor</th>
                        <th>Direccion</th>
                        <th>Correo Electronico</th>
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
                        if(request.getParameter("txtnombre")!=null){
                            nombre = request.getParameter("txtnombre");
                            condicion = "NOMBRE_PROVEEDOR LIKE '%" + nombre + "%'";
                        }
                        BLProveedores logica = new BLProveedores();
                        List<Proveedores> datos;
                        datos = logica.Listar(condicion);
            
                        //for para llenar la tabla
                        for (Proveedores registro:datos){
                    %>
                    <tr>
                        <% int codigo=registro.getIdentificacion();%>
                        <td><%=codigo %></td>
                        <td><%=registro.getNombreProveedor()%></td>
                        <td><%=registro.getDireccionProveedor()%></td>
                        <td><%=registro.getCorreoElectronico_proveedor()%></td>
                        <!--Columna para los botones -->
                        <td>
                            <!--Botón para modificar -->
                            <a href="FrmMantProveedores.jsp?idCrearModificar=<%=codigo%>"> <i class="fas fa-user-edit"></i></a> |
                            <!--Botón para Eliminar -->
                            <a href="EliminarProveedores?idEliminar=<%=codigo%>"> <i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <%}%><!--Para cerrar el for --> 
                </tbody>
            </table>
                <br> 
             <a href="FrmMantProveedores.jsp?idCrearModificar=-1"><button type="button" class="btn btn-dark mb-3">Agregar Proveedor</button></a> |
             <a href="FrmProveedores.jsp"><button type="button" class="btn btn-dark mb-3">Actualizar</button></a> |
             <a href="index.html"><button type="button" class="btn btn-dark mb-3">Inicio</button></a>
             
        </div><!--Fin Container --> 
        <footer>
            
        </footer>
        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
