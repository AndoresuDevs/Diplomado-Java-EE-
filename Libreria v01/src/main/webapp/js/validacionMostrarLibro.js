/**
 * 
 */

function idLibro(id){
		alert("VALOR DEL ID: "+id)
		console.log("VALOR DEL ID: "+id)
		
		document.forms[0].action="FormularioEditarLibro.jsp?ID="+id;
		document.forms[0].method = "post";
		document.forms[0].submit();
		
 		
		
}
