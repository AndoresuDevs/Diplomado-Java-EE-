package aplicacion;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import acciones.Accion;
import acciones.FiltrarPorCategoriaAccion;
import acciones.MostrarLibrosAccion;

/**
 * Servlet implementation class ControladorLibros
 */
//@WebServlet("/ControladorLibros")// ESTOS SON ANOTACIONES
public class ControladorLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLibros() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		RequestDispatcher despachador = null;
		Accion accion = null;
		String url=request.getServletPath();
		System.out.println(url.substring(1,url.length()-3));
		accion = Accion.getAccion(url.substring(1,url.length()-3));

		if(request.getServletPath().equals("/ControladorLibros.do")) 
		{
			if(request.getParameter("categoria")==null|| request.getParameter("categoria").equals("Seleccionar")) {
				accion = new MostrarLibrosAccion();   
			}else {
				accion = new FiltrarPorCategoriaAccion();
			}
		}else {
			accion = Accion.getAccion(url.substring(1,url.length()-3)); 
		}
		
		if(accion!=null) { //BUSCAR DONDE SE LANZA NULL Y CORREGIRLO!!!
			despachador=request.getRequestDispatcher(accion.ejecutar(request, response));
			despachador.forward(request, response);
		}
	}
}

