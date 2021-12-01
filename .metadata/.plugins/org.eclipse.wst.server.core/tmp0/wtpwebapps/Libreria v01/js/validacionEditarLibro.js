

function editar(){
	var error=false;
	
	var id=document.getElementById("ID").value
	var isbn=document.getElementById("ISBN").value
	var nom=document.getElementById("Titulo").value
	var cat=document.getElementById("Categoria").value
	var pre=document.getElementById("Precio").value
	
	var msjError=[]
	
	if(isbn==null||isbn==""){
		msjError.push("Ingresar el ID")
		error=true;	
	}
	
	if(nom==null||nom==""){
		msjError.push("Ingresar el Nombre")
		error=true;	
	}
	
	if(cat==null||cat==""){
		msjError.push("Ingresar la Categoria")
		error=true;	
	}
	
	if(pre==null||pre==""){
		msjError.push("Ingresar el precio")
		error=true;	
	}
	
	if(error){
		alert(msjError.join(", "))
	}else{
		 
		alert("Libro Actualizado")
		document.forms[0].action="EditarLibro.jsp?ID="+id+"&ISBN="+isbn+"&Titulo="+nom+"&Categoria="+cat+"&Precio="+pre;
		document.forms[0].method = "post";
		document.forms[0].submit();
		
	}
}

var idSel


function setId(id){
	alert("VALOR DEL ID: "+id)
	
}

function getId(){
	return idSel
}





