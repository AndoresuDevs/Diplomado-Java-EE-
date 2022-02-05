package aplicacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if(request.getServletPath().equals("/MostrarLibros.do"))   //SACA EL ORIGEN DE DONDE SE LLAMO Y LO COMPARA CON MSOTRAR LIBRO
		{
			System.out.println(""+response.getWriter().append("Served at: ").append(request.getContextPath()));
			System.out.println("ACABA DE ENTRAR AL SERVLET");
			
			List<Libro>ListaDeLibros = null;
			List<Libro>ListaPorCategorias = null;
			try {
				if(request.getParameter("categoria")==null|| request.getParameter("categoria").equals("Seleccionar")) {
					System.out.println("PARAMETRO: "+request.getParameter("categoria"));
					ListaDeLibros= Libro.buscarTodos();
				}else {
					int cat = Integer.parseInt(request.getParameter("categoria"));
					ListaPorCategorias=Libro.buscarPorCategoria(cat);
				}
				
				
				//ListaPorCategorias= Libro.buscarPorCategoria(1);
				List<Categoria>ListaDeCategorias= Categoria.buscarCategorias();
				
				
					
				
				request.setAttribute("ListaDeLibros", ListaDeLibros);
				request.setAttribute("ListaDeCategorias", ListaDeCategorias);
				request.setAttribute("ListaPorCategoria", ListaPorCategorias);
				
				
				
				
			} catch (DataBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			despachador=request.getRequestDispatcher("MostrarLibros.jsp");
			despachador.forward(request, response);
			//getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		}
		else if(request.getServletPath().equals("/ControladorLibros.do")) 
		{
			List<Libro>ListaPorCategorias = null;
			List<Libro>ListaDeLibros = null;
			try {
				if(request.getParameter("categoria")==null|| request.getParameter("categoria").equals("Seleccionar")) {
					System.out.println("PARAMETRO: "+request.getParameter("categoria"));
					ListaDeLibros= Libro.buscarTodos();
				}else {
					int cat = Integer.parseInt(request.getParameter("categoria"));
					ListaPorCategorias=Libro.buscarPorCategoria(cat);
				}
				
				
				//ListaPorCategorias= Libro.buscarPorCategoria(1);
				List<Categoria>ListaDeCategorias= Categoria.buscarCategorias();
				
				
					
				
			 	request.setAttribute("ListaDeLibros", ListaDeLibros);
				request.setAttribute("ListaDeCategorias", ListaDeCategorias);
				request.setAttribute("ListaPorCategoria", ListaPorCategorias);
				
				
				
				
			} catch (DataBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			despachador=request.getRequestDispatcher("MostrarLibros.jsp");
			despachador.forward(request, response);
		}
		
		else if(request.getServletPath().equals("/FormularioInsertarLibro.do")){
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
		else if(request.getServletPath().equals("/BorrarLibro.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				
				new Libro().BorrarLibro(id);
				
			} catch (DataBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			despachador=request.getRequestDispatcher("MostrarLibros.do");
			despachador.forward(request, response);
		}
		else if(request.getServletPath().equals("/EditarLibro.do")) {
			int id = Integer.parseInt(request.getParameter("idLibro"));
			String StrISBN = request.getParameter("ISBN");
			String StrTitulo = request.getParameter("nomLibro");
			String Cat = request.getParameter("catLibro");
			String Pre = request.getParameter("preLibro");
			
			try {
				new Libro(StrISBN, StrTitulo, Integer.parseInt(Cat), Float.parseFloat(Pre)).editarLibro(id);
			} catch (NumberFormatException | DataBaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				
				 new Libro(StrISBN, StrTitulo, Integer.parseInt(Cat), Float.parseFloat(Pre)).insertar();
				 
				 
			} catch (DataBaseException e) {
				
				e.printStackTrace();
			}
			
			despachador=request.getRequestDispatcher("MostrarLibros.do"); //FALTA QUE SE RELLENE DESPUES DE ACTUALIZAR XD
			despachador.forward(request, response);
		}
		else {
			String StrISBN = request.getParameter("ISBN");
			String StrTitulo = request.getParameter("nomLibro");
			String Cat = request.getParameter("catLibro");
			String Pre = request.getParameter("preLibro"); 
			try {
				
				 new Libro(StrISBN, StrTitulo, Integer.parseInt(Cat), Float.parseFloat(Pre)).insertar();
				 
				 
			} catch (DataBaseException e) {
				e.printStackTrace();
			}
			
			despachador=request.getRequestDispatcher("MostrarLibros.do");
			despachador.forward(request, response);
			
			
		}
		
		
	}

	

}
