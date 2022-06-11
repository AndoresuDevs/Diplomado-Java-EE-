package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion {
	
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response); 
	//patron factory
	public static Accion getAccion(String tipo) {
		//ES IMPORTANTE TRABAJAR EL TIPO SIN EL .DO YA QUE ESO ES DE SERVLET, ESTE NO ES UN SERVLET
		//EL PARAMETRO TIPO SE LIMPIA ANTES DE INVOCAR LA ACCION EN EL CONTROLADOR
		Accion accion = null;
		try 
		{
			String text = Accion.class.getPackage()+"."+tipo+"Accion";
			accion = (Accion) Class.forName(text.substring(8,text.length())).newInstance();
		} catch (InstantiationException  | ClassNotFoundException | IllegalAccessException e) {
			e.printStackTrace();
		} 
		return accion;
	}
	
	
}
