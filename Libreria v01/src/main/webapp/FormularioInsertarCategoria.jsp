<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
		<title>Formulario para alta de Categoria</title>
		
		<link rel="stylesheet" href="css/formularios.css">
	</head>
	<body background="img/formulario.jpg">
		<div class="formulario">
			<h1>Formulario Alta Categoria</h1>
			<form action="InsertarCategoria.do" method="GET">	
						
				<p><label class="txt" for="Categoria">Categoria:</label><br>
				<input class="inputs" id="Categoria" type="text" name="nomCat"/></p>
			
				<input class="boton"  type="submit" value="Insertar" name="insertar"><br>
				
				<p class="navegar"><a href="MostrarCategorias.do">Volver al Listado de Categorias</a></p>
					
			</form>
		</div>
	</body>
</html>