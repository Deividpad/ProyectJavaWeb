<jsp:include page="../encabezado.jsp" />
<jsp:include page="../menu.jsp" />
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
            <div class="col-md-12 panel-body" style="padding-bottom:30px;">
                <div class="col-md-12">
                    <form class="cmxform" id="signupForm" method="post" action="../EmpledoController?action=create">
                        <div class="col-md-6">
                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="validate_firstname" name="validate_firstname" required>
                                <span class="bar"></span>
                                <label>Nombre</label>
                            </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="validate_lastname" name="validate_lastname" required>
                                <span class="bar"></span>
                                <label>Apellido</label>
                            </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="validate_username" name="validate_username" required>
                                <span class="bar"></span>
                                <label>Username</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="password" class="form-text" id="validate_password" name="validate_password" required>
                                <span class="bar"></span>
                                <label>Password</label>
                            </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="password" class="form-text" id="validate_confirm_password" name="validate_confirm_password" required>
                                <span class="bar"></span>
                                <label>Confirm Password</label>
                            </div>

                            <div class="form-group form-animate-text" style="margin-top:40px !important;">
                                <input type="text" class="form-text" id="validate_email" name="validate_email" required>
                                <span class="bar"></span>
                                <label>Email</label>
                            </div>
                        </div>  
                        <div class="col-md-6">
                            <div class="form-group">
                                <select class="select2-A">
                                    <optgroup label="Alaskan/Hawaiian Time Zone">
                                        <option value="AK">Alaska</option>
                                        <option value="HI">Hawaii</option>
                                    </optgroup>
                                    <optgroup label="Pacific Time Zone">
                                        <option value="CA">California</option>
                                        <option value="NV">Nevada</option>
                                        <option value="OR">Oregon</option>
                                        <option value="WA">Washington</option>
                                    </optgroup>

                                </select>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <input class="submit btn btn-danger" type="submit" value="Submit">
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
                validate_firstname: "required",
                validate_lastname: "required",
                validate_username: {
                    required: true,
                    minlength: 2
                },
                validate_password: {
                    required: true,
                    minlength: 5
                },
                validate_confirm_password: {
                    required: true,
                    minlength: 5,
                    equalTo: "#validate_password"
                },
                validate_email: {
                    required: true,
                    email: true
                },
                validate_agree: "required"
            },
            messages: {
                validate_firstname: "Please enter your firstname",
                validate_lastname: "Please enter your lastname",
                validate_username: {
                    required: "Please enter a username",
                    minlength: "Your username must consist of at least 2 characters"
                },
                validate_password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 5 characters long"
                },
                validate_confirm_password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 5 characters long",
                    equalTo: "Please enter the same password as above"
                },
                validate_email: "Please enter a valid email address",
                validate_agree: "Please accept our policy"
            }
        });


    });
</script>
<!-- end: Javascript -->
</body>
</html>