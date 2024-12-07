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
	
	<div class="row"  style="margin-top: 5%">
			<div class="form-group col-md-4">
				<label class="control-label" for="id_nombre">Nombres</label>
				<input class="form-control" type="text" id="id_nombre" name="nombre">	
			</div>
			<div class="form-group col-md-4">
				<label class="control-label" for="id_telefono">Teléfono</label>
				<input class="form-control" type="text" id="id_telefono" name="telefono">	
			</div>
			<div class="form-group col-md-4">
				<label class="control-label" for="id_pais"> País </label> 
				<select	class="form-control" id="id_pais" name="pais" >
					<option value="-1">[Todos]</option>
				</select>
			</div>
	</div>
	<div class="row" style="margin-top: 2%">
			<div class="form-group col-md-4">
				<label class="control-label" for="id_dni">DNI</label>
				<input class="form-control" type="text" id="id_dni" name="dni">	
			</div>
			<div class="form-group col-md-4">
				<label class="control-label" for="id_fecha_desde">Fecha Nacimiento(Desde)</label>
				<input class="form-control" type="date" id="id_fecha_desde" name="fechaDesde" >
			</div>
			<div class="form-group col-md-4">
				<label class="control-label" for="id_fecha_hasta">Fecha Nacimiento(Hasta)</label>
				<input class="form-control" type="date" id="id_fecha_hasta" name="fechaHasta" >
			</div>
	</div>
	<div class="row"  align="center" style="margin-top: 2%">
			<div class="form-group col-md-12">
					<button type="button" class="btn btn-primary" id="id_btn_filtrar">Filtrar</button>
			</div>
	</div>
	
	<div class="row" style="margin-top: 4%">
			<table id="id_table" class="table table-bordered table-hover table-condensed" >
				<thead style='background-color:#337ab7; color:white'>
					<tr>
						<th>Código</th>
						<th>Nombres</th>
						<th>Apellidos</th>
						<th>Teléfono</th>
						<th>DNI</th>
						<th>Correo</th>
						<th>FechaNacimiento</th>
						<th>Estado</th>
						<th>País</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
	</div>
	
</div>

<script type="text/javascript">
	$("#id_btn_filtrar").click(function() {
		var vfnombre = $("#id_nombre").val();
		var vtelefono = $("#id_telefono").val();
		var vdni = $("#id_dni").val();
		var vfdesde = $("#id_fecha_desde").val();
		var vfhasta = $("#id_fecha_hasta").val();
		var vpais = $("#id_pais").val();
		
		console.log("vfnombre >>> " + vfnombre);
		console.log("vtelefono >>> " + vtelefono);
		console.log("vdni >>> " + vdni);
		console.log("vfdesde >>> " + vfdesde);
		console.log("vfhasta >>> " + vfhasta);
		console.log("vpais >>> " + vpais);
		
		$.getJSON("consultaAlumno", {"nombre":vfnombre,
									 "telefono":vtelefono,
									 "dni":vdni,
									 "desde":vfdesde,
									 "pais":vpais,
									 "hasta":vfhasta}, function(data) {
			agregarGrilla(data);
		});
	});
	
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
					{data: "telefono", className:'text-center'},
					{data: "dni", className:'text-center'},
					{data: "correo", className:'text-center'},
					{data: "fechaNacimientoFormateada", className:'text-center'},
					{data: function(row, type, val, meta){
						return row.estado == 1 ? "Activo" : "Inactivo";  
					},className:'text-center'},
					{data: "pais.nombre",className:'text-center'},
				]                                     
		    });
	}
	
	$.getJSON("cargaComboPais", function(data) {
	    $.each(data, function(index, value) {
	        $("#id_pais").append("<option value='" + value.idPais + "'>" + value.nombre + "</option>");
	    });
	});
	
	$("#id_btn_filtrar").click(function(){});
	
	
	</script>
	
</body>
</html>