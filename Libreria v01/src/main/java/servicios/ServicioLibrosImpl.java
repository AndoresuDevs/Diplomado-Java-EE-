package servicios;

import java.util.List;

import beans.Libro;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;

public class ServicioLibrosImpl implements ServicioLibros{
	
	private LibroDAO libroDao = null;
	private CategoriaDAO catDao=null;
	
	
	public ServicioLibrosImpl() {
		DAOFactory factoria = DAOAbstractFactory.getInstance() ;
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		this.libroDao= factoria.getLibroDAO();
		this.catDao=factoria.getCategoriaDAO();

	}

	@Override
	public void insertar(Libro libro) {
		libroDao.insertar(libro);
		
	}

	@Override
	public List<Libro> buscarTodos() 
	{
		return libroDao.buscarTodos();	
	}

	@Override
	public void borrar(Libro libro) 
	{
		libroDao.borrar(libro);
		
	}

	@Override
	public void guardarCambios(Libro lib) 
	{
		libroDao.guardarCambios(lib);
		
	}

	@Override
	public Libro buscarPorClave(Integer id) 
	{
		return libroDao.buscarPorClave(id);
		
	}

	@Override
	public List<Libro> buscarPorCategoria(int idCat) 
	{
		return libroDao.buscarPorCategoria(idCat);
	}

}
