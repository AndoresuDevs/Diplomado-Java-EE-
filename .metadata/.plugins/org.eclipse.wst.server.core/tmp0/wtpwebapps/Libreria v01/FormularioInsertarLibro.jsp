<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
		<title>Formulario para alta de libro</title>
		<script type="text/javascript" src="js/validacionAltaLibro.js"></script>
		<link rel="stylesheet" href="css/formularios.css">
	</head>
	<body background="img/formulario.jpg">
		<div class="formulario">
			<h1>Formulario Alta Libro</h1>
			<form action="Insertar.do" method="GET">
			
				<p><label class="txt" for="ISBN">ISBN:</label><br>
				<input class="inputs" id="ISBN" type="text" name="ISBN"/></p>	
						
				<p><label class="txt" for="Titulo">Titulo: </label><br>
				<input class="inputs" id="Titulo" type="text" name="nomLibro"/></p>
				
				<p><label class="txt" for="Categoria">Categoria: </label><br>
				<input class="inputs" id="Categoria" type="text" name="catLibro"/></p>
				
				<p><label class="txt" for="Precio">Precio: </label><br>
				<input class="inputs" id="Precio" type="text" name="preLibro"/></p>
				
				<input class="boton"  type="submit" value="Insertar" name="insertar"><br>
				
				<p class="navegar"><a href="MostrarLibros.do">Volver al Listado de Libros</a></p>
					
			</form>
		</div>
	</body>
</html>

