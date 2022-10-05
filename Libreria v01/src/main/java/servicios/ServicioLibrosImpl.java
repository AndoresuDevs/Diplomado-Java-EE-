package servicios;

import java.util.List;

import acciones.MostrarLibrosAccion;
import beans.Libro;
import dao.CategoriaDAO;
import dao.LibroDAO;
import dao.jpa.LibroDAOJPAImpl;

public class ServicioLibrosImpl implements ServicioLibros{
	
	private LibroDAO libroDAO = null;
	
	@Override
	public void insertar(Libro libro) {
		libroDAO.insertar(libro);
	}

	@Override
	public List<Libro> buscarTodos() 
	{
		return libroDAO.buscarTodos();	
	}

	@Override
	public void borrar(Libro libro) 
	{
		libroDAO.borrar(libro);
		
	}

	@Override
	public void guardarCambios(Libro lib) 
	{
		libroDAO.guardarCambios(lib);
	}

	@Override
	public Libro buscarPorClave(Integer id) 
	{
		System.out.println("CLAVE SERV LIB IMPL:"+id);
		
		MostrarLibrosAccion mla = new MostrarLibrosAccion();
		
		List<Libro> libs =  libroDAO.buscarTodos();
		
		//return libroDAO.buscarPorClave(id);
		return libs.get(id);
	}

	@Override
	public List<Libro> buscarPorCategoria(int idCat) 
	{
		System.out.println("FILTRO POR CATEGORIA: "+idCat);
		return libroDAO.buscarPorCategoria(idCat);
	}

	
	//nuevos metodos
	
	@Override
	public LibroDAO getLibroDAO() {
		return libroDAO;
	}

	@Override
	public void setLibroDAO(LibroDAO libro) {
		this.libroDAO=libro;
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		
		return null;
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoria) {
	
		
	}
	



}
