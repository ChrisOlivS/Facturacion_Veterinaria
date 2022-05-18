<%-- 
    Document   : FrmMantProductos
    Created on : 8 may 2022, 19:08:14
    Author     : Software
--%>
<%@page import="Capa_Entidades.*"%>
<%@page import="java.util.*"%>
<%@page import="Capa_Logica.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Veterinarios</title>


        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/bootstrap-datepicker/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/DataTables/datatables.min.css" rel="stylesheet" type="text/css"/>
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
                        Productos producto;
                        BLProductos logica = new BLProductos();

                        if (codigo > 0) {
                            producto = logica.Obtener("ID_PRODUCTO =" + id);
                        } else {
                            producto = new Productos();
                        }

                    %>
                    <form action="CrearModificarProductos" method="post" id="form_AgregarModificar">

                        <div class="form-group">
                            <%if (codigo > 0) {%>
                            <label for="txtcodigo" class="control-label">Codigo</label>
                            <input type="number" id="" name="txtcodigo" value="<%=producto.getIdentificacion()%>" readonly class="form-control">
                            <%} else {%>
                            <input type="hidden" id="txtcodigo" name="txtcodigo" value="-1"><br>
                            <%}%>
                        </div>

                        <div class="form-group">
                            <label for="txtnombre" class="control-label">Codigo Proveedor</label>
                            <input type="text" id="txtCodProv" name="txtCodProv" value="<%=producto.getCodigoProveedor()%>" class="form-control"><br>
                            <a id="btnBuscarP" class="btn btn-dark text-light" data-toggle="modal"
                               data-target="#buscarProv"><i class="fas fa-search"></i></a>&nbsp; &nbsp;
                        </div>
                        <div class="form-group">
                            <label for="txtapellido1" class="control-label">Nombre Producto</label>
                            <input type="text" id="" name="txtNombre" value="<%=producto.getNombre_producto()%>" class="form-control"> <br>
                        </div>
                        <div class="form-group">
                            <label for="txtapellido2" class="control-label">Cantidad</label>
                            <input type="text" id="" name="txtCantidad" value="<%=producto.getCantidad()%>" class="form-control"><br>
                        </div>
                        <div class="form-group">
                            <label for="txtapellido2" class="control-label">Precio</label>
                            <input type="text" id="" name="txtPrecio" value="<%=producto.getPrecio()%>" class="form-control"><br>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <input type="submit" id="btnGuardar" value="Guardar" class="btn btn-primary"> &nbsp;&nbsp;
                                <input type="button" id="btnRegresar" value="Regresar" class="btn btn-primary" onclick="location.href = 'FrmProductos.jsp'" class="btn btn-secondary">&nbsp;&nbsp;
                            </div>
                        </div>
                    </form>
                    <div class="modal" id="buscarProv" tabindex="1" role="dialog" aria-labelledby="TituloVentana">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 id="tituloVentana">Buscar Proveedor</h5>
                                    <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true" onclick="Limpiar()">
                                        <span aria-hidden>&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <!-- Tabla de Clientes -->
                                    <table id="tablaProveedores">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Nombre</th>
                                                <th>Seleccionar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                BLProveedores logicaPro = new BLProveedores();
                                                List<Proveedores> datosPro;
                                                datosPro = logicaPro.Listar("");
                                                for (Proveedores registroPro : datosPro) {
                                            %>
                                            <tr>
                                                <% int codigoProv = registroPro.getIdentificacion();
                                                    String nombreProv = registroPro.getNombreProveedor();
                                                %>
                                                <td><%=codigoProv%></td>
                                                <td><%=nombreProv%></td>
                                                <td>
                                                    <a href="#" data-dismiss="modal"
                                                       onClick="SeleccionarProveedor('<%=codigoProv%>');">Seleccionar</a>
                                                </td>
                                            </tr>
                                            <%}%><!-- Finaliza el ciclo for -->
                                        </tbody>
                                    </table>


                                </div><!-- Finaliza el div del body modal -->
                                <div class="modal-footer">
                                    <button class="btn btn-warning" type="button" data-dismiss="modal" onClick="Limpiar();">Cancelar</button>
                                </div>
                            </div>
                        </div>
                    </div><!-- Finaliza modal de Proveedores -->
                </div>




            </div>
        </div>

        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap-datepicker/locales/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
        <script src="lib/DataTables/datatables.min.js" type="text/javascript"></script>
        <script src="lib/DataTables/DataTables-1.10.21/js/dataTables.bootstrap4.min.js" type="text/javascript"></script> 

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

                                        function SeleccionarProveedor(codigoProv) {
                                            $("#txtCodProv").val(codigoProv);
                                        }
                                        function Limpiar() {
                                            $("#txtCodProv").val("");
                                        }


        </script>
    </body>
</html>