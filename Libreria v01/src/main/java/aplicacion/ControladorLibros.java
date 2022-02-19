package aplicacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import acciones.BorrarLibroAccion;
import acciones.EditarLibroAccion;
import acciones.FiltrarPorCategoriaAccion;
import acciones.InsertarLibroAccion;
import acciones.MostrarLibrosAccion;
import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

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
		
		if(request.getServletPath().equals("/MostrarLibros.do"))   //SACA EL ORIGEN DE DONDE SE LLAMO Y LO COMPARA CON MSOTRAR LIBRO
		{
			System.out.println("ENTRO EL /MOSTRAR LIBROS DO");
			accion = new MostrarLibrosAccion();   
		}
		else if(request.getServletPath().equals("/ControladorLibros.do")) 
		{
			
			if(request.getParameter("categoria")==null|| request.getParameter("categoria").equals("Seleccionar")) {
				accion = new MostrarLibrosAccion();   
			}else {
				accion = new FiltrarPorCategoriaAccion();
			}
			
		}
		
		else if(request.getServletPath().equals("/FormularioInsertarLibro.do")){
			System.out.println("CTRL FORMULARIO INSERTAR QUE NO SE QUE HACE");
			List<Categoria> listaDeCategorias=null;
			try {
				listaDeCategorias = Categoria.buscarCategorias();
				request.setAttribute("ListaDeCategorias", listaDeCategorias);
				despachador=request.getRequestDispatcher("FormularioInsertarLibro.jsp");
				despachador.forward(request, response);
			} catch (DataBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(request.getServletPath().equals("/EditarLibro.do")) {
			System.out.println("ENTRO EL /EDITAR LIBROS DO");
			accion= new EditarLibroAccion();
		
		}
		
		else if(request.getServletPath().equals("/InsertarLibro.do")) {
			System.out.println("ENTRO EL /INSERTA LIBROS DO");
			accion = new InsertarLibroAccion();
		}
		
		else if(request.getServletPath().equals("/BorrarLibro.do")) {
			System.out.println("ENTRO EL /MOSTRAR LIBROS DO");
			System.out.println("CTRL BORRAR LIBRO");
			accion = new BorrarLibroAccion();
		}
		
		if(accion!=null) { //BUSCAR DONDE SE LANZA NULL Y CORREGIRLO!!!
			despachador=request.getRequestDispatcher(accion.ejecutar(request, response));
			despachador.forward(request, response);
		}
		
		
		
	}

	

}
