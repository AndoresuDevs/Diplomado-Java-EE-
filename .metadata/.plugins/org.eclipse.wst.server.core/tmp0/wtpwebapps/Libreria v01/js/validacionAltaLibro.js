/**
 * 
 */



function validar(){
	var error=false;
	
	var id=document.getElementById("ISBN").value
	var nom=document.getElementById("Titulo").value
	var cat=document.getElementById("Categoria").value
	var pre=document.getElementById("Precio").value
	
	
	var msjError=[]
	if(id==null||id==""){
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
		 
		alert("ACCESO AL PENTAGONO PERMITIDO")
		
		document.forms[0].action="Insertar.do?ISBN="+id+"&Titulo="
		+nom+"&Categoria="+cat+"&Precio="+pre;
		
		document.forms[0].method = "post";
		document.forms[0].submit();
		
	}
	
	
	
}