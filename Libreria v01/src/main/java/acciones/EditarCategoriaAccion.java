package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import servicios.ServicioCategorias;

public class EditarCategoriaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioCategorias servicioCategorias = (ServicioCategorias) getBean("ServicioCategorias", request);
			Categoria cat = new Categoria(request.getParameter("nomCat"));
			cat.setid_cat(Integer.parseInt(request.getParameter("idCat")));
			servicioCategorias.guardarCambios(cat);
			return "MostrarCategorias.do";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
