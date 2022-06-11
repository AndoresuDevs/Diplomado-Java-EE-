package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import dao.CategoriaDAOJPAImpl;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;

public class InsertarCategoriaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			servicioCategorias.insertar(
				new Categoria(request.getParameter("nomCat"))				
			);
			
//			new CategoriaDAOJPAImpl().insertar(new Categoria(
//					request.getParameter("nomCat")
//					));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return "MostrarCategorias.do";
	}

}
