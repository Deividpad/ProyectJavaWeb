<jsp:include page="encabezado.jsp" />
<jsp:include page="menu.jsp" />
<!-- start: content -->
<div id="content">
    <div class="panel box-shadow-none content-header">
        <div class="panel-body">
            <div class="col-md-12">
                <h3 class="animated fadeInLeft">Registrar Cliente</h3>
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
            <div class="col-md-12 panel-body" style="padding-bottom:30px;">
                <div class="col-md-12">
                    <form class="cmxform" id="signupForm" method="POST" action="ClientesController?action=create">
                        <div class="col-md-6">
                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="razonsocial" name="razonsocial" required>
                                <span class="bar"></span>
                                <label>Razon  social</label>
                            </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="nit" name="nit" required>
                                <span class="bar"></span>
                                <label>Nit</label>
                            </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="ciudad" name="ciudad" required>
                                <span class="bar"></span>
                                <label>Ciudad</label>
                            </div>


                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="number" class="form-text" id="telefono" name="telefono" required>
                                <span class="bar"></span>
                                <label>Telefono</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="password" class="form-text" id="contrasena" name="contrasena" required>
                                <span class="bar"></span>
                                <label>Contraseña</label>
                            </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="password" class="form-text" id="confirmar_contrasena" name="confirmar_contrasena" required>
                                <span class="bar"></span>
                                <label>Confirma Contraseña</label>
                            </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="direccion" name="direccion" required>
                                <span class="bar"></span>
                                <label>Direccion</label>
                            </div>
                        </div>  

                        <div class="col-md-12">
                            <input class="submit btn btn-danger" type="submit" value="Guardar">
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
                razonsocial: "required",
                nit: "required",
                ciudad: "required",
                direccion: "required",
                telefono: {
                    required: true,
                    min: 1,
                    minlength: 10
                },
                contrasena: {
                    required: true,
                    minlength: 5
                },
                confirmar_contrasena: {
                    required: true,
                    minlength: 5,
                    equalTo: "#confirmar_contrasena"
                },
                validate_agree: "required"
            },
            messages: {
                razonsocial: "Por favor, introduzca Razon social",
                nit: "Por favor, introduzca el Nit",
                ciudad: "Por favor, introduzca la ciudad",
                direccion: "por favor, introduzca su direccion",
                telefono: {
                    required: "proporcione un numero de telefono",
                    minlength: "su telefono debe tener almenos 10 caracteres"
                },
                contrasena: {
                    required: "Proporcione una contraseña",
                    minlength: "Su contraseña debe tener al menos 5 caracteres"
                },
                confirmar_contrasena: {
                    required: "Proporcione una contraseña",
                    minlength: "Su contraseña debe tener al menos 5 caracteres",
                    equalTo: "Ingrese la misma contraseña que la anterior"
                },

            }
        });


    });
</script>
<!-- end: Javascript -->
</body>
</html>