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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("RUTAAAAA");
		System.out.println(""+response.getWriter().append("Served at: ").append(request.getContextPath()));
		System.out.println("ACABA DE ENTRAR AL SERVLET");
		RequestDispatcher despachador = null;
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

	

}
