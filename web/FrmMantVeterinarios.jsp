<%-- 
    Document   : FrmMantVeterinarios
    Created on : 8 may 2022, 15:25:18
    Author     : Software
--%>
<%@page import="Capa_Entidades.Veterinarios"%>
<%@page import="Capa_Logica.BLVeterinarios"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Veterinarios</title>
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
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
        </header>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="card-header">
                        <h1>Mantenimiento de Veterinarios</h1>
                    </div><br>
                </div>
                <div class="col-12">
                    <%
                        String id = request.getParameter("idCrearModificar");
                        int codigo = Integer.parseInt(id);
                        Veterinarios veterinario;
                        BLVeterinarios logica = new BLVeterinarios();

                        if (codigo > 0) {
                            veterinario = logica.Obtener("ID_VETERINARIO =" + id);
                        } else {
                            veterinario = new Veterinarios();
                        }

                    %>
                    <form action="CrearModificarVeterinario" method="post" id="form_AgregarModificar">

                        <div class="form-group">
                            <%if (codigo > 0) {%>
                            <label for="txtcodigo" class="control-label">Codigo</label>
                            <input type="number" id="" name="txtcodigo" value="<%=veterinario.getIdentificacion()%>" readonly class="form-control">
                            <%} else {%>
                            <input type="hidden" id="txtcodigo" name="txtcodigo" value="-1"><br>
                            <%}%>
                        </div>

                        <div class="form-group">
                            <label for="txtnombre" class="control-label">Nombre</label>
                            <input type="text" id="" name="txtNombre" value="<%=veterinario.getNombre()%>" class="form-control"><br>
                        </div>
                        <div class="form-group">
                            <label for="txtapellido1" class="control-label">Primer Apellido</label>
                            <input type="text" id="" name="txtApellido1" value="<%=veterinario.getApellido1()%>" class="form-control"> <br>
                        </div>
                        <div class="form-group">
                            <label for="txtapellido2" class="control-label">Segundo Apellido</label>
                            <input type="text" id="" name="txtApellido2" value="<%=veterinario.getApellido2()%>" class="form-control"><br>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <input type="submit" id="btnGuardar" value="Guardar" class="btn btn-primary"> &nbsp;&nbsp;
                                <input type="button" id="btnRegresar" value="Regresar" class="btn btn-primary" onclick="location.href = 'FrmVeterinarios.jsp'" class="btn btn-secondary">
                            </div>
                        </div>
                    </form>
                </div>




            </div>
        </div>

        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>

        <script>
                                    $(document).ready(function () {
                                        $("#form_AgregarModificar").validate({
                                            rules: {
                                                txtNombre: {required: true, maxlength: 50},
                                                txtApellido1: {required: true, minlength: 8, maxlength: 11},
                                                txtApellido2: {required: true, maxlength: 80}
                                            },
                                            messages: {
                                                txtNombre: "El campo nombre es obligatorio, maximo 50 caracteres",
                                                txtApellido1: "El campo primer apellido es obligatorio, minimo 8 caracteres ,maximo 11 caracteres",
                                                txtApellido2: "El campo segundo apellido es obligatorio, maximo 80 caracteres"
                                            },
                                            errorElement: 'span'
                                        });
                                    });

        </script>
    </body>
</html>