<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="encabezado.jsp" />
<jsp:include page="menu.jsp" />
<!-- start: content -->
<div id="content">
    <div class="panel box-shadow-none content-header">
        <div class="panel-body">
            <div class="col-md-12">
                <h3 class="animated fadeInLeft">Administrar Clientes</h3>
                <p class="animated fadeInDown">
                    Form <span class="fa-angle-right fa"></span> Form Element
                </p>
            </div>
        </div>
    </div>

    <div class="col-md-12 top-20 padding-0">
        <div class="col-md-12">
            <div class="panel">
                <div class="panel-heading"><h3>Clientes</h3></div>
                <div class="panel-body">
                    <div class="responsive-table">
                        <table id="datatables-example" class="table table-striped table-bordered" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Razon social</th>
                                    <th>Nit</th>
                                    <th>Ciudad</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>
                                    <th>Aciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="n" items="${requestScope.LISTAR}">                          
                                <tr>
                                    <td><c:out value="${n.razonSocial}" /></td>
                                    <td><c:out value="${n.nit}" /></td>
                                    <td><c:out value="${n.ciudad}" /></td>
                                    <td><c:out value="${n.direccion}" /></td>
                                    <td><c:out value="${n.telefono}" /></td>
                                    <td>
                                        <button class=" btn btn-circle btn-mn btn-primary" onclick="location.href = 'ClientesController?action=update&id=${n.idCliente}'">
                                            <span class="fa fa-edit"></span>
                                        </button>
                                        <button class=" btn btn-circle btn-mn btn-danger" onclick="location.href = 'ClientesController?action=delete&id=${n.idCliente}'">
                                            <span class="fa fa-trash"></span>
                                        </button>
                                    </td>
                                </tr>  
                                  </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>  
    </div>
</div>
<!-- end: content -->


<button id="mimin-mobile-menu-opener" class="animated rubberBand btn btn-circle btn-danger">
    <span class="fa fa-bars"></span>
</button>
<!-- end: Mobile -->

<!-- start: Javascript -->
<script src="asset/js/jquery.min.js"></script>
<script src="asset/js/jquery.ui.min.js"></script>
<script src="asset/js/bootstrap.min.js"></script>


<!-- plugins -->

<script src="asset/js/plugins/moment.min.js"></script>
<script src="asset/js/plugins/jquery.datatables.min.js"></script>
<script src="asset/js/plugins/datatables.bootstrap.min.js"></script>
<script src="asset/js/plugins/jquery.nicescroll.js"></script>


<!-- custom -->
<script src="asset/js/main.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#datatables-example').DataTable();
    });
</script>
<!-- end: Javascript -->
</body>
</html>