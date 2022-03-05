<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
		<title>Formulario para alta de Proveedor</title>
		
		<link rel="stylesheet" href="css/formularios.css">
	</head>
	<body background="img/formulario.jpg">
		<div class="formulario">
			<h1>Formulario Alta Proveedor</h1>
			<form action="InsertarProveedor.do" method="GET">
			
				<p><label class="txt" for="Nombre">Nombre:</label><br>
				<input class="inputs" id="Nombre" type="text" name="nomProv"/></p>	
						
				<p><label class="txt" for="Telefono">Telefono:</label><br>
				<input class="inputs" id="Telefono" type="text" name="telProv"/></p>
				
				<p><label class="txt" for="Direccion">Direccion:</label><br>
				<input class="inputs" id="Direccion" type="text" name="dirProv"/></p>
				
				<input class="boton"  type="submit" value="Insertar" name="insertar"><br>
				
				<p class="navegar"><a href="MostrarProveedores.do">Volver al Listado de Proveedores</a></p>
					
			</form>
		</div>
	</body>
</html>