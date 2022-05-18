<%-- 
    Document   : FrmMantDetalles
    Created on : 8 may 2022, 22:34:28
    Author     : Software
--%>

<%@page import="Capa_Entidades.*"%>
<%@page import="Capa_Logica.*"%>
<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Compras</title>
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
                        <h1>Facturacion</h1>
                    </div><br>
                </div>
                <div class="col-12">
                    <%
                        String id = request.getParameter("idCrearModificar");
                        int codigo = Integer.parseInt(id);
                        Detalle_Factura detalle;
                        BLDetalle_Factura logica = new BLDetalle_Factura();
                        Productos producto = new Productos();

                        if (codigo > 0) {
                            detalle = logica.Obtener("ID_DETALLE =" + id);
                        } else {
                            detalle = new Detalle_Factura();
                            Date fecha = new Date();
                            java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
                            detalle.setFecha_v(fechasql);
                        }
                    %>
                    <form action="CrearFactura" method="post" id="form_AgregarModificar">

                        <div class="form-group">
                            <%if (codigo > 0) {%>
                            <label for="txtcodigo" class="control-label">Codigo</label>
                            <input type="number" id="" name="txtcodigo" value="<%=detalle.getIdFactura()%>" readonly class="form-control">
                            <%} else {%>
                            <input type="hidden" id="txtcodigo" name="txtcodigo" value="-1"><br>
                            <%}%>
                        </div>

                        <div class="form-group">
                            <label for="txtvendedor" class="control-label">Vendedor</label>
                            <input type="text" id="txtIDVend" name="txtIDVend" value="<%=detalle.getIdVendedor()%>" readonly class="form-control"><br>
                            <a id="btnBuscarVend" class="btn btn-dark text-light" data-toggle="modal"
                               data-target="#buscarVend"><i class="fas fa-search"></i></a>&nbsp; &nbsp;
                        </div>
                        <div class="form-group">
                            <label for="txtidcliente" class="control-label">Cliente</label>
                            <input type="text" id="txtIDCliente" name="txtIDCliente" value="<%=detalle.getIdCliente()%>" readonly class="form-control"><br>
                            <a id="btnBuscarCliente" class="btn btn-dark text-light" data-toggle="modal"
                               data-target="#buscarCliente"><i class="fas fa-search"></i></a>&nbsp; &nbsp;
                        </div>  
                        <div class="form-group">

                            <label for="txtprod" class="control-label">Producto</label>
                            <input type="text" id="txtProd" name="txtProd" value="<%=detalle.getIdProducto()%>" readonly class="form-control"><br>
                            <a id="btnBuscarProd" class="btn btn-dark text-light" data-toggle="modal"
                               data-target="#buscarProd"><i class="fas fa-search"></i></a>&nbsp; &nbsp;
                        </div>
                        <div class="form-group">
                            <label for="txtprecio" class="control-label">Precio</label>
                            <input type="number" id="txtPrecio" name="txtPrecio" value="<%=detalle.getPrecio()%>" readonly class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="txtcantidad" class="control-label">Cantidad</label>
                            <input type="number" id="txtCantidad" name="txtCantidad" value="<%=detalle.getCantidadProd()%>" class="form-control"oninput="calcular()"><br>
                        </div>
                        <div class="form-group">
                            <label for="txtfecha" class="control-label">Fecha</label>
                            <input type="text" id="txtFecha" name="txtFecha" value="<%=detalle.getFecha_v()%>" readonly class="datepicker form-control"><br>
                        </div>
                        <div class="form-group">
                            <label for="txtimpuesto" class="control-label">Impuesto</label>
                            <input type="number" id="txtImpuesto" name="txtImpuesto" value="<%=detalle.getImpuesto()%>" readonly class="form-control" oninput="calcular()"><br>
                        </div>
                        <div class="form-group">

                            <label for="txtsubtotal" class="control-label">Subtotal</label>
                            <input type="number" id="txtSubtotal" name="txtSubtotal" value="<%=detalle.getSubtotal()%>" readonly class="form-control"><br>
                        </div>
                        <div class="form-group">
                            <label for="txttotal" class="control-label">Total</label>
                            <input type="number" id="txtTotal" name="txtTotal" value="<%=detalle.getTotal()%>" readonly class="form-control" oninput="calcular()"><br>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <input type="submit" id="btnGuardar" value="Guardar" class="btn btn-primary"> &nbsp;&nbsp;
                                <input type="button" id="btnRegresar" value="Regresar" class="btn btn-primary" onclick="location.href = 'FrmDetalle.jsp'" class="btn btn-secondary">&nbsp;&nbsp;
                            </div>
                        </div>
                    </form>
                    <div class="modal" id="buscarVend" tabindex="1" role="dialog" aria-labelledby="TituloVentana">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 id="tituloVentana">Buscar Vendedor</h5>
                                    <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true" onclick="LimpiarVend()">
                                        <span aria-hidden>&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <!-- Tabla de Clientes -->
                                    <table id="tablaVendedores">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Nombre</th>
                                                <th>Seleccionar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                BLVendedores logicaVen = new BLVendedores();
                                                List<Vendedores> datosVen;
                                                datosVen = logicaVen.Listar("");
                                                for (Vendedores registroVen : datosVen) {
                                            %>
                                            <tr>
                                                <% int codigoVen = registroVen.getIdentificacion();
                                                    String nombreVen = registroVen.getNombre();
                                                %>
                                                <td><%=codigoVen%></td>
                                                <td><%=nombreVen%></td>
                                                <td>
                                                    <a href="#" data-dismiss="modal"
                                                       onClick="SeleccionarVendedor('<%=codigoVen%>');">Seleccionar</a>
                                                </td>
                                            </tr>
                                            <%}%><!-- Finaliza el ciclo for -->
                                        </tbody>
                                    </table>


                                </div><!-- Finaliza el div del body modal -->
                                <div class="modal-footer">
                                    <button class="btn btn-danger" type="button" data-dismiss="modal" onClick="LimpiarVend();">Cancelar</button>
                                </div>
                            </div>
                        </div>
                    </div><!-- Finaliza modal de Proveedores -->
                    <div class="modal" id="buscarCliente" tabindex="1" role="dialog" aria-labelledby="TituloVentana">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 id="tituloVentana">Buscar Cliente</h5>
                                    <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true" onclick="LimpiarCli()">
                                        <span aria-hidden>&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <!-- Tabla de Clientes -->
                                    <table id="tablaClientes">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Nombre</th>
                                                <th>Seleccionar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                BLClientes logicaCli = new BLClientes();
                                                List<Clientes> datosCli;
                                                datosCli = logicaCli.ListarClientes("");
                                                for (Clientes registroCli : datosCli) {
                                            %>
                                            <tr>
                                                <% int codigoCli = registroCli.getIdentificacion();
                                                    String nombreCli = registroCli.getNombre();
                                                %>
                                                <td><%=codigoCli%></td>
                                                <td><%=nombreCli%></td>
                                                <td>
                                                    <a href="#" data-dismiss="modal"
                                                       onClick="SeleccionarCliente('<%=codigoCli%>');">Seleccionar</a>
                                                </td>
                                            </tr>
                                            <%}%><!-- Finaliza el ciclo for -->
                                        </tbody>
                                    </table>


                                </div><!-- Finaliza el div del body modal -->
                                <div class="modal-footer">
                                    <button class="btn btn-danger" type="button" data-dismiss="modal" onClick="LimpiarCli();">Cancelar</button>
                                </div>
                            </div>
                        </div>
                    </div><!-- Finaliza modal de Clientes -->
                    <div class="modal" id="buscarProd" tabindex="1" role="dialog" aria-labelledby="TituloVentana">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 id="tituloVentana">Buscar Producto</h5>
                                    <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true" onclick="LimpiarProd()">
                                        <span aria-hidden>&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <!-- Tabla de Clientes -->
                                    <table id="tablaProductos">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Nombre</th>
                                                <th>Seleccionar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                BLProductos logicaPro = new BLProductos();
                                                List<Productos> datosPro;
                                                datosPro = logicaPro.Listar("");
                                                for (Productos registroPro : datosPro) {
                                            %>
                                            <tr>
                                                <% int codigoPro = registroPro.getIdentificacion();
                                                    double precio = registroPro.getPrecio();
                                                %>
                                                <td><%=codigoPro%></td>
                                                <td><%=precio%></td>
                                                <td>
                                                    <a href="#" data-dismiss="modal"
                                                       onClick="SeleccionarProd('<%=codigoPro%>', '<%=precio%>');">Seleccionar</a>
                                                </td>
                                            </tr>
                                            <%}%><!-- Finaliza el ciclo for -->
                                        </tbody>
                                    </table>


                                </div><!-- Finaliza el div del body modal -->
                                <div class="modal-footer">
                                    <button class="btn btn-danger" type="button" data-dismiss="modal" onClick="LimpiarProd();">Cancelar</button>
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
                                        //Cuando el documento esté listo
                                        //Cargue las siguientes funciones
                                        $(document).ready(function(){
                                        //Mostrar calendario
                                        $('.datepicker').datepicker({
                                        format: 'yyyy-mm-dd',
                                                autoclose: true,
                                                language: 'es'
                                        });
                                        //Hacer que la lista de clientes se comporte como un datatable
                                        //Configurar la tabla clientes en el modal
                                        $('#tablaClientes').dataTable({
                                        "lengthMenu": [[5, 15, 15, - 1], [5, 10, 15, "ALL"]],
                                                "language": {
                                                "info": "Página_PAGE_ de _PAGES_",
                                                        "infoEmpty": "No existen registros disponibles",
                                                        "zeroRecords": "No se encuentran registros",
                                                        "search": "Buscar",
                                                        "infoFiltered": "",
                                                        "lengthMenu": "Mostrar _MENU_ Registros",
                                                        "Paginate":{
                                                        "first": "Primero",
                                                                "last": "Último",
                                                                "next": "Siguiente",
                                                                "previous": "Anterior"
                                                        }
                                                }
                                        });
                                        //Configura la tabla productos del modal
                                        & ('#tablaProductos').dataTable({
                                        "lengthMenu": [[5 15, 15, - 1], [5, 10, 15, "All"]],
                                                "language": {
                                                "info": "Página_PAGE_ de _PAGES_",
                                                        "infoEmpty": "No existen registros disponibles",
                                                        "zeroRecords": "No se encuentran registros",
                                                        "search": "Buscar",
                                                        "infoFiltered": "",
                                                        "lengthMenu": "Mostrar _MENU_ Registros",
                                                        "Paginate":{
                                                        "first": "Primero",
                                                                "last": "Último",
                                                                "next": "Siguiente",
                                                                "previous": "Anterior"
                                                        }
                                                }
                                        });
                                        });
        </script>
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
            function SeleccionarVendedor(codigoVend) {
            $("#txtIDVend").val(codigoVend);
            }
            function LimpiarVend() {
            $("#txtIDVend").val("");
            }
            function SeleccionarCliente(codigoCli) {
            $("#txtIDCliente").val(codigoCli);
            }
            function LimpiarCli() {
            $("#txtIDCliente").val("");
            }
            function SeleccionarProd(codigoProd, precio) {
            $("#txtProd").val(codigoProd);
            $("#txtPrecio").val(precio);
            }
            function LimpiarProd() {
            $("#txtProd").val("");
            }



        </script>

        <script>

            function calcular(){
            var textCantidad = parseFloat(document.getElementById("txtCantidad").value) || 0;
            var textPrecio = parseFloat(document.getElementById("txtPrecio").value) || 0;
            document.getElementById("txtImpuesto").value = ((textCantidad * textPrecio) * 0.13);
            document.getElementById("txtSubtotal").value = (textCantidad * textPrecio);
            document.getElementById("txtTotal").value = ((textCantidad * textPrecio) + (textCantidad * textPrecio) * 0.13);

            }
        </script>

    </body>
</html>