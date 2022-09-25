package servicios;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import acciones.Accion;
import beans.Libro;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;

public class ServicioLibrosImpl implements ServicioLibros{
	
	private LibroDAO libroDAO = null;
	
//	public ServicioLibrosImpl() {
//		ApplicationContext factoria = new FileSystemXmlApplicationContext("classpath*:/contextoAplicacion.xml");
//		libroDAO = (LibroDAO) factoria.getBean("libroDAO");
//	}

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
		return libroDAO.buscarPorClave(id);
	}

	@Override
	public List<Libro> buscarPorCategoria(int idCat) 
	{
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
