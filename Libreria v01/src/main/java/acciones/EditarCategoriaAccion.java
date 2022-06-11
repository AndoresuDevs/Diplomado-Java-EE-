package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Proveedor;
import dao.CategoriaDAOJPAImpl;
import dao.ProveedorDAOJPAImpl;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;

public class EditarCategoriaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			//NUEVO OBJETO CON LOS CAMBIOS HECHOS
			Categoria cat = new Categoria(
					request.getParameter("nomCat")
					);
//			
//		    System.out.println("CATEGORIA: "+cat.getid_cat()+" - "+cat.getnom_cat());
//			CategoriaDAOJPAImpl dao = new CategoriaDAOJPAImpl();
//			dao.guardarCambios(cat);
			
			servicioCategorias.guardarCambios(cat);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "MostrarCategorias.do";
				
	}

}
