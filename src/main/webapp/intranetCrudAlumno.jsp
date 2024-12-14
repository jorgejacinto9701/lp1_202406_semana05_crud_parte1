<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>

<title>Sistemas - Jorge Jacinto Gutarra</title>
</head>
<body>
	<div class="container" style="margin-top: 4%">
	<h4>Consulta Alumno</h4>
	
		<div class="row" style="margin-top: 3%">
			<div class="col-md-2">
				<label class="control-label">Nombre o Apellido</label>
			</div>
			<div class="col-md-3">
					<input class="form-control" type="text" id="id_filtro" name="nombres" placeholder="Ingrese el nombre">
			</div>
			<div class="col-md-2">
					<button type="button" class="btn btn-primary" id="id_filtrar">Filtrar</button>
			</div>		
			<div class="col-md-2">
					<button type="button" class="btn btn-primary" data-toggle='modal' data-target="#id_div_modal_registra" id="id_agregar">Agregar</button>
			</div>
		</div>
		<div class="row" style="margin-top: 3%">
			<table id="id_table" class="table table-bordered table-hover table-condensed" >
				<thead style='background-color:#337ab7; color:white'>
					<tr>
						<th>Código</th>
						<th>Nombres</th>
						<th>Apellidos</th>
						<th>DNI</th>
						<th>FechaNacimiento</th>
						<th>País</th>
						<th>Estado</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
		
		<!-- INICIO MODAL DE REGISTRO -->
		<div class="modal fade" id="id_div_modal_registra" >
			<div class="modal-dialog" style="width: 60%">
					<div class="modal-content">
					<div class="modal-header" >
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4><span class="glyphicon glyphicon-ok-sign"></span> Registro de Alumno</h4>
					</div>
					<div class="modal-body" >
						 <div class="panel-group" id="steps">
			                   <div class="panel panel-default">
			                   		<div id="stepOne" class="panel-collapse collapse in">
			                   			<form id="id_form_registra">
			                   			<input type="hidden" name="metodo" value="paramInserta">
			                   			<div class="panel-body">
			                                <div class="row" style="margin-top: 4%">
												<div class="form-group col-md-6">
													<label class="control-label" for="id_nombre">Nombres</label>
													<input class="form-control" type="text" id="id_nombre" name="nombres" placeholder="Ingrese el nombre">	
												</div>
												<div class="form-group col-md-6">
													<label class="control-label" for="id_apellido">Apellidos</label>
													<input class="form-control" type="text" id="id_apellido" name="apellidos" placeholder="Ingrese el apellido">	
												</div>
											</div>
											<div class="row" style="margin-top: 2%">
												<div class="form-group col-md-3">
													<label class="control-label" for="id_telefono">Teléfono</label>
													<input class="form-control" type="text" id="id_telefono" name="telefono" placeholder="Ingrese el teléfono">	
												</div>
												<div class="form-group col-md-3">
													<label class="control-label" for="id_dni">DNI</label>
													<input class="form-control" type="text" id="id_dni" name="dni" placeholder="Ingrese el DNI">	
												</div>
												<div class="form-group col-md-6">
													<label class="control-label" for="id_correo">Correo</label>
													<input class="form-control" type="text" id="id_correo" name="correo" placeholder="Ingrese el correo">	
												</div>
											</div>
											<div class="row" style="margin-top: 2%">
												<div class="form-group col-md-6">
													<label class="control-label" for="id_fecha">Fecha Nacimiento</label>
													<input class="form-control" type="date" id="id_fecha" name="fechaNacimiento">	
												</div>
												<div class="form-group col-md-6">
													<label class="control-label" for="id_pais"> País </label> 
													<select	class="form-control" id="id_pais" name="pais" >
														<option value=" ">[Seleccione]</option>
													</select>
												</div>
											</div>
											<div class="row"  align="center" style="margin-top: 2%">
													<button type="button" style="width: 80px" id="id_btn_registra" class="btn btn-primary btn-sm">Registrar</button>
		                                        	<button type="button" style="width: 80px" id="id_btn_reg_cancelar" class="btn btn-primary btn-sm" data-dismiss="modal">Cancelar</button>
													
											</div>
			                             </div>
			                             </form>
			                        </div>
			                   </div>
			              </div>
					</div>
				</div>
			</div>
		</div>
 		<!-- FIN MODAL DE REGISTRO -->
		
		<!-- INICIO MODAL DE ACTUALIZAR -->
		<div class="modal fade" id="id_div_modal_actualiza" >
			<div class="modal-dialog" style="width: 60%">
					<div class="modal-content">
					<div class="modal-header" >
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4><span class="glyphicon glyphicon-ok-sign"></span> Actualiza de Alumno</h4>
					</div>
					<div class="modal-body" >
						 <div class="panel-group" id="steps">
			                   <div class="panel panel-default">
			                   		<div id="stepOne" class="panel-collapse collapse in">
			                   			<form id="id_form_actualiza">
			                   			<input type="hidden" name="metodo" value="paramActualiza">
			                   			<input type="hidden" name="idAlumno" id="idAlumno">
			                   			<div class="panel-body">
			                                <div class="row" style="margin-top: 4%">
												<div class="form-group col-md-6">
													<label class="control-label" for="id_nombre_actualiza">Nombres</label>
													<input class="form-control" type="text" id="id_nombre_actualiza" name="nombres" placeholder="Ingrese el nombre">	
												</div>
												<div class="form-group col-md-6">
													<label class="control-label" for="id_apellido_actualiza">Apellidos</label>
													<input class="form-control" type="text" id="id_apellido_actualiza" name="apellidos" placeholder="Ingrese el apellido">	
												</div>
											</div>
											<div class="row" style="margin-top: 2%">
												<div class="form-group col-md-3">
													<label class="control-label" for="id_telefono_actualiza">Teléfono</label>
													<input class="form-control" type="text" id="id_telefono_actualiza" name="telefono" placeholder="Ingrese el teléfono">	
												</div>
												<div class="form-group col-md-3">
													<label class="control-label" for="id_dni_actualiza">DNI</label>
													<input class="form-control" type="text" id="id_dni_actualiza" name="dni" placeholder="Ingrese el DNI">	
												</div>
												<div class="form-group col-md-6">
													<label class="control-label" for="id_correo_actualiza">Correo</label>
													<input class="form-control" type="text" id="id_correo_actualiza" name="correo" placeholder="Ingrese el correo">	
												</div>
											</div>
											<div class="row" style="margin-top: 2%">
												<div class="form-group col-md-4">
													<label class="control-label" for="id_fecha_actualiza">Fecha Nacimiento</label>
													<input class="form-control" type="date" id="id_fecha_actualiza" name="fechaNacimiento">	
												</div>
												<div class="form-group col-md-4">
													<label class="control-label" for="id_pais_actualiza"> País </label> 
													<select	class="form-control" id="id_pais_actualiza" name="pais" >
														<option value=" ">[Seleccione]</option>
													</select>
												</div>
												<div class="form-group col-md-4">
													<label class="control-label" for="id_estado_actualiza"> Estado </label> 
													<select	class="form-control" id="id_estado_actualiza" name="estado" >
														<option value=" ">[Seleccione]</option>
														<option value="1">Activo</option>
														<option value="0">Inactivo</option>
													</select>
												</div>
											</div>
											<div class="row"  align="center" style="margin-top: 2%">
													<button type="button" style="width: 80px" id="id_btn_actualiza" class="btn btn-primary btn-sm">Actualizar</button>
		                                        	<button type="button" style="width: 80px" id="id_btn_act_cancelar" class="btn btn-primary btn-sm" data-dismiss="modal">Cancelar</button>
													
											</div>
			                             </div>
			                             </form>
			                        </div>
			                   </div>
			              </div>
					</div>
				</div>
			</div>
		</div>
 		<!-- FIN MODAL DE ACTUALIZAR -->
		
	</div>
<script type="text/javascript">


function agregarGrilla(lista){
	 $('#id_table').DataTable().clear();
	 $('#id_table').DataTable().destroy();
	 $('#id_table').DataTable({
			data: lista,
			language: IDIOMA,
			searching: true,
			ordering: true,
			processing: true,
			pageLength: 10,
			lengthChange: false,
			info:true,
			scrollY: 305,
	        scroller: {
	            loadingIndicator: true
	        },
			columns:[
				{data: "idAlumno",className:'text-center'},
				{data: "nombres",className:'text-center'},
				{data: "apellidos",className:'text-center'},
				{data: "dni", className:'text-center'},
				{data: "fechaNacimientoFormateada", className:'text-center'},
				{data: "pais.nombre",className:'text-center'},
				{data: function(row, type, val, meta){
					return row.estado == 1 ? "Activo" : "Inactivo";  
				},className:'text-center'},
				{data: function(row){
					return '<button type="button" class="btn btn-info btn-sm" onClick="busca(\'' + row.idAlumno + '\',\'' + row.nombres + '\',\'' + row.apellidos+ '\',\'' + row.dni+ '\',\'' + row.fechaNacimientoFormateada+ '\',\'' + row.correo + '\',\'' + row.telefono + '\',\'' + row.estado  + '\',\'' + row.pais.idPais + '\');">Editar</button>';  
				},className:'text-center'},
				{data: function(row){
					return '<button type="button" class="btn btn-warning btn-sm" onClick="eliminacionLogica(\'' + row.idAlumno + '\',\'' + row.estado  +'\');">E.Lógica</button>';  
				},className:'text-center'},
				{data: function(row){
					return '<button type="button" class="btn btn-danger btn-sm" onClick="eliminacionFisica(\'' + row.idAlumno + '\');">E.Física</button>';  
				},className:'text-center'},
			]                                     
	    });
}

	//Cargar los datos al ejecutar
	$.getJSON("crudAlumno", {"metodo":"paramLista", "filtro": ""}, function(data){
		agregarGrilla(data);
	});

	//Consulta alumno
	$("#id_filtrar").click(function() {
		var filtro = $("#id_filtro").val();
		console.log("filtro >> " + filtro);
		$.getJSON("crudAlumno", {"metodo":"paramLista", "filtro": filtro}, function(data){
			agregarGrilla(data);
		});
	});
	
	function eliminacionLogica (idAlumno, estado){
		 $.ajax({
	          type: "POST",
	          url: "crudAlumno", 
	          data: {"metodo":"paramLogico", "id":idAlumno, "estado":estado},
	          success: function(data){
	        	  console.log(data);
	        	  agregarGrilla(data.datos);
	        	  mostrarMensaje(data.mensaje);
	          },
	          error: function(){
	        	  mostrarMensaje(MSG_ERROR);
	          }
	    });
		
	}
	
	function eliminacionFisica (idAlumno){
		mostrarMensajeConfirmacion(MSG_ELIMINAR, accionElimnar, null, idAlumno);
	}
	
	function accionElimnar(idAlumno){
		console.log(">>> idAlumno " + idAlumno)
		 $.ajax({
	          type: "POST",
	          url: "crudAlumno", 
	          data: {"metodo":"paramFisico", "id": idAlumno},
	          success: function(data){
	        	  console.log(data);
	        	  agregarGrilla(data.datos);
	        	  mostrarMensaje(data.mensaje);
	          },
	          error: function(){
	        	  mostrarMensaje(MSG_ERROR);
	          }
	    });
	}
	
	
	$.getJSON("cargaComboPais", function(data) {
	    $.each(data, function(index, value) {
	        $("#id_pais").append("<option value='" + value.idPais + "'>" + value.nombre + "</option>");
	        $("#id_pais_actualiza").append("<option value='" + value.idPais + "'>" + value.nombre + "</option>");
	    });
	});
	
	function busca(idAlumno, nombres, apellidos, dni, fechaNacimiento, correo, telefono, estado, pais) {
		$("#id_nombre_actualiza").val(nombres);
		$("#id_apellido_actualiza").val(apellidos);
		$("#id_dni_actualiza").val(dni);
		$("#id_fecha_actualiza").val(fechaNacimiento);
		$("#id_correo_actualiza").val(correo);
		$("#id_telefono_actualiza").val(telefono);
		$("#id_estado_actualiza").val(estado);
		$("#id_pais_actualiza").val(pais);
		$("#idAlumno").val(idAlumno);
		$("#id_div_modal_actualiza").modal('show');
	}
	
	
	$(document).ready(function(){
		$('#id_form_registra').bootstrapValidator(
	                {
	                    message : 'This value is not valid',
	                    feedbackIcons : {
	                        valid : 'glyphicon glyphicon-ok',
	                        invalid : 'glyphicon glyphicon-remove',
	                        validating : 'glyphicon glyphicon-refresh'
	                    },
	                    fields: {
							nombres:{
								selector: '#id_nombre',
								validators: {
	                                notEmpty: {
	                                    message: 'El nombre es requerido'
	                                },
	                                stringLength: {
	                                    min: 3,
	                                    max: 100,
	                                    message: 'El nombre debe tener entre 3 y 100 caracteres'
	                                }
	                            }
							},
							apellidos:{
								selector: '#id_apellido',
	                            validators: {
	                                notEmpty: {
	                                    message: 'El apellido es requerido'
	                                },
	                                stringLength: {
	                                    min: 3,
	                                    max: 100,
	                                    message: 'El apellido debe tener entre 3 y 100 caracteres'
	                                }
	                            }
							},
							telefono:{
								selector: '#id_telefono',
	                            validators: {
	                                notEmpty: {
	                                    message: 'El teléfono es requerido'
	                                },
	                                regexp: {
	                                    regexp: /^[9][0-9]{8}$/,
	                                    message: 'El teléfono debe ser numérico que empiece con 9'
	                                },
	                                remote: {
	                                    message: 'El teléfono ya existe',
	                                    url: 'validaTelefonolAlumnoServlet',
	                                    delay: 1000
	                                }
	                             }
							},
							dni:{
								selector: '#id_dni',
	                            validators: {
	                                notEmpty: {
	                                    message: 'El DNI es requerido'
	                                },
	                                regexp: {
	                                    regexp: /^[0-9]{8}$/,
	                                    message: 'El DNI debe ser numérico de 8 dígitos'
	                                },
	                                remote: {
	                                    message: 'El DNI ya existe',
	                                    url: 'validaDNIAlumnoServlet',
	                                    delay: 1000
	                                }
	                                
	                            }
							},
							correo:{
								selector: '#id_correo',
	                            validators: {
	                                notEmpty: {
	                                    message: 'El correo es requerido'
	                                },
	                                emailAddress: {
	                                    message: 'El correo no es válido'
	                                },
	                                remote: {
	                                    message: 'El correo ya existe',
	                                    url: 'validaEmailAlumnoServlet',
	                                    delay: 1000
	                                }
	                            }
							},
							fechaNacimiento:{
								selector: '#id_fecha',
	                            validators: {
	                                notEmpty: {
	                                    message: 'La fecha de nacimiento es requerida'
	                                },
	                                remote: {
	                                    message: 'El alumno debe ser mayor de edad',
	                                    url: 'validaFechaNacimientoAlumnoServlet',
	                                    delay: 1000
	                                }
	                            }
							},
							pais:{
								selector: '#id_pais',
	                            validators: {
	                                notEmpty: {
	                                    message: 'El país es requerido'
	                                }
	                            }
							}
	                    }
	                });
	    });

	
	$("#id_btn_registra").click(function() {
	    var validator = $('#id_form_registra').data('bootstrapValidator');
	    validator.validate();
	    
	    console.log($("#id_form_registra").serialize())
	    
	    if (validator.isValid()) {
	        $.ajax({
	            type : "POST",
	            url : "crudAlumno",
	            data : $("#id_form_registra").serialize(),
	            success : function(data) {
	            	mostrarMensaje(data.mensaje);
	            	validator.resetForm();
	            	agregarGrilla(data.datos);
	            	$('#id_div_modal_registra').modal("hide");
	            },
	            error : function(data) {
	            	mostrarMensaje(MSG_ERROR);
	            }
	        });
	    }
	   
	});
	
	
	$("#id_btn_actualiza").click(function() {
	    var validator = $('#id_form_actualiza').data('bootstrapValidator');
	    validator.validate();
	    
	    console.log($("#id_form_actualiza").serialize())
	    
	    if (validator.isValid()) {
	        $.ajax({
	            type : "POST",
	            url : "crudAlumno",
	            data : $("#id_form_actualiza").serialize(),
	            success : function(data) {
	            	mostrarMensaje(data.mensaje);
	            	validator.resetForm();
	            	agregarGrilla(data.datos);
	            	$('#id_div_modal_actualiza').modal("hide");
	            },
	            error : function(data) {
	            	mostrarMensaje(MSG_ERROR);
	            }
	        });
	    }
	   
	});
	

	$(document).ready(function(){
		$('#id_form_actualiza').bootstrapValidator(
	                {
	                    message : 'This value is not valid',
	                    feedbackIcons : {
	                        valid : 'glyphicon glyphicon-ok',
	                        invalid : 'glyphicon glyphicon-remove',
	                        validating : 'glyphicon glyphicon-refresh'
	                    },
	                    fields: {
							nombres:{
								selector: '#id_nombre_actualiza',
								validators: {
	                                notEmpty: {
	                                    message: 'El nombre es requerido'
	                                },
	                                stringLength: {
	                                    min: 3,
	                                    max: 100,
	                                    message: 'El nombre debe tener entre 3 y 100 caracteres'
	                                }
	                            }
							},
							apellidos:{
								selector: '#id_apellido_actualiza',
	                            validators: {
	                                notEmpty: {
	                                    message: 'El apellido es requerido'
	                                },
	                                stringLength: {
	                                    min: 3,
	                                    max: 100,
	                                    message: 'El apellido debe tener entre 3 y 100 caracteres'
	                                }
	                            }
							},
							telefono:{
								selector: '#id_telefono_actualiza',
	                            validators: {
	                                notEmpty: {
	                                    message: 'El teléfono es requerido'
	                                },
	                                regexp: {
	                                    regexp: /^[9][0-9]{8}$/,
	                                    message: 'El teléfono debe ser numérico que empiece con 9'
	                                },
	                             }
							},
							dni:{
								selector: '#id_dni_actualiza',
	                            validators: {
	                                notEmpty: {
	                                    message: 'El DNI es requerido'
	                                },
	                                regexp: {
	                                    regexp: /^[0-9]{8}$/,
	                                    message: 'El DNI debe ser numérico de 8 dígitos'
	                                },
	                                remote: {
	                                    message: 'El DNI ya existe',
	                                    url: 'validaDNIAlumnoEnActualizaServlet',
	                                    delay: 1000,
	                                    data: function(validator, $field, value) {
                                            return {
                                                id: $("#idAlumno").val()
                                            };
                                        }
	                                }
	                                
	                            }
							},
							correo:{
								selector: '#id_correo_actualiza',
	                            validators: {
	                                notEmpty: {
	                                    message: 'El correo es requerido'
	                                },
	                                emailAddress: {
	                                    message: 'El correo no es válido'
	                                },
	                            }
							},
							fechaNacimiento:{
								selector: '#id_fecha_actualiza',
	                            validators: {
	                                notEmpty: {
	                                    message: 'La fecha de nacimiento es requerida'
	                                },
	                                remote: {
	                                    message: 'El alumno debe ser mayor de edad',
	                                    url: 'validaFechaNacimientoAlumnoServlet',
	                                    delay: 1000
	                                }
	                            }
							},
							pais:{
								selector: '#id_pais_actualiza',
	                            validators: {
	                                notEmpty: {
	                                    message: 'El país es requerido'
	                                }
	                            }
							}
	                    }
	                });
	    });

</script>	
	
</body>
</html>


