<%@page import="models.Empleados"%>
<jsp:include page="encabezado.jsp" />
<jsp:include page="menu.jsp" />
<!-- start: content -->
<div id="content">
    <div class="panel box-shadow-none content-header">
        <div class="panel-body">
            <div class="col-md-12">
                <h3 class="animated fadeInLeft">Registrar Empleado</h3>
                <p class="animated fadeInDown">
                    Form <span class="fa-angle-right fa"></span> Form Element
                </p>
            </div>
        </div>
    </div>


    <div class="col-md-10">
        <div class="col-md-12 panel">
            <div class="col-md-12 panel-heading">
                <h4>Ingrese los datos</h4>
            </div>
            <% Empleados editaremp = (Empleados) request.getAttribute("empleado");%>
            <div class="col-md-12 panel-body" style="padding-bottom:30px;">
                <div class="col-md-12">
                    <form class="cmxform" id="signupForm" method="post" action="EmpleadoControllers?action=update&id=<%= editaremp.getIdEmpleado() %>">
                        <div class="col-md-6">
                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="nombre" name="nombre" value="<%= editaremp.getNombres()%>" required>
                                <span class="bar"></span>
                                <label>Nombre</label>
                            </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="apellido" name="apellido" value="<%=editaremp.getApellidos()%>" required>
                                <span class="bar"></span>
                                <label>Apellido</label>
                            </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="number" class="form-text" id="documento" name="documento" value="<%=editaremp.getDocumento()%>" required>
                                <span class="bar"></span>
                                <label>Documento</label>
                            </div>

                        </div>

                        <div class="col-md-6">
                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="email" name="email" value="<%=editaremp.getCorreo()%>" required>
                                <span class="bar"></span>
                                <label>Email</label>
                            </div>
                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="password" class="form-text" id="password" name="password" value="<%=editaremp.getContrasena()%>" required>
                                <span class="bar"></span>
                                <label>Password</label>
                            </div>
                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="password" class="form-text" id="validate_confirm_password" name="validate_confirm_password" value="<%=editaremp.getContrasena()%>" required>
                                <span class="bar"></span>
                                <label>Confirm Password</label>
                            </div>

                            <div class="col-md-6">                 

                                <div class="col-sm-18 padding-0">
                                    <span class="bar"></span>
                                    <label>Perfil  </label>
                                    <select class="form-control" name="perfil">
                                        <option value="Gerente">Gerente</option>
                                        <option value="DirVentas">Director de Ventas</option>
                                        <option value="Vendedor">Vendedor</option>                                        
                                    </select>
                                </div>
                            </div>
                        </div>  

                        <div class="col-md-12">
                            <input class="submit btn btn-success" type="submit" value="Registrar">                            
                        </div>
                    </form>

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
<script src="asset/js/plugins/jquery.knob.js"></script>
<script src="asset/js/plugins/ion.rangeSlider.min.js"></script>
<script src="asset/js/plugins/bootstrap-material-datetimepicker.js"></script>
<script src="asset/js/plugins/jquery.nicescroll.js"></script>
<script src="asset/js/plugins/jquery.mask.min.js"></script>
<script src="asset/js/plugins/select2.full.min.js"></script>
<script src="asset/js/plugins/nouislider.min.js"></script>
<script src="asset/js/plugins/jquery.validate.min.js"></script>


<!-- custom -->
<script src="asset/js/main.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        $("#signupForm").validate({
            errorElement: "em",
            errorPlacement: function (error, element) {
                $(element.parent("div").addClass("form-animate-error"));
                error.appendTo(element.parent("div"));
            },
            success: function (label) {
                $(label.parent("div").removeClass("form-animate-error"));
            },
            rules: {
                nombre: "required",
                apellido: "required",
                documento: {
                    required: true,
                    min: 1,
                    minlength: 7
                },
                validate_username: {
                    required: true,
                    minlength: 2
                },
                password: {
                    required: true,
                    minlength: 5
                },
                validate_confirm_password: {
                    required: true,
                    minlength: 5,
                    equalTo: "#password"
                },
                email: {
                    required: true,
                    email: true
                },
                validate_agree: "required"
            },
            messages: {
                nombre: "Por favor ingrese el nombre",
                apellido: "Por favor ingrese el apellido",
                password: {
                    required: "Por favor ingrese la contraseña",
                    minlength: "Minimo 5 caracteres"
                },
                validate_confirm_password: {
                    required: "Por favor verifique la contraseña",
                    minlength: "Minimo 5 caracteres",
                    equalTo: "Las contraseñas no coinciden"
                },
                documento: {
                    required: "Por favor ingrese documento",
                    min: "Documento no valido",
                    minlength: "Documento no valido",
                    equalTo: "Please enter the same password as above"
                },
                email: "Por favor ingrese email",
                validate_agree: "Please accept our policy"
            }
        });


    });
</script>
<!-- end: Javascript -->
</body>
</html>