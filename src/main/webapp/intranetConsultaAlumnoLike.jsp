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
	
		<div class="row" style="margin-top: 4%">
			<div class="col-md-2">
				<label class="control-label">Nombres</label>
			</div>
			<div class="col-md-4">
				<input class="form-control" type="text" id="id_nombre" name="nombres" placeholder="Ingrese el nombre">	
			</div>
			<div class="col-md-4">
				<button type="button" class="btn btn-primary" id="id_filtrar">Filtrar</button>
			</div>
		</div>
		<div class="row" style="margin-top: 3%">
			<div class="col-md-12">
				<table id="id_table" class="table table-bordered table-hover table-condensed" >
					<thead style='background-color:#337ab7; color:white'>
						<tr>
							<th>Código</th>
							<th>Nombres</th>
							<th>Apellidos</th>
							<th>Teléfono</th>
							<th>DNI</th>
							<th>Correo</th>
							<th>Fecha Nacimiento</th>
							<th>País</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>

		</div>
</div>




</body>
</html>







