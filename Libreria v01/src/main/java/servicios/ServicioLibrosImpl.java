package servicios;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.Libro;
import dao.CategoriaDAO;
import dao.LibroDAO;

@Service
public class ServicioLibrosImpl implements ServicioLibros{
	
	private LibroDAO libroDAO = null;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED) //ESTA MEDIDA ES LA DEFAULT DE TRANSACTIONAL, SI SOLO ES TRANSACTIONAL SERA ESTA OPCION
	public void insertar(Libro libro) {
		libroDAO.insertar(libro);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Libro> buscarTodos() 
	{
		return libroDAO.buscarTodos();	
	}

	@Override
	@Transactional
	public void borrar(Libro libro) 
	{
		libroDAO.borrar(libro);
		
	}

	@Override
	@Transactional
	public void guardarCambios(Libro lib) 
	{
		libroDAO.guardarCambios(lib);
	}

	@Override
	@Transactional(readOnly=true)
	public Libro buscarPorClave(Integer id) 
	{
		return libroDAO.buscarPorClave(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Libro> buscarPorCategoria(int idCat) 
	{
		System.out.println("FILTRO POR CATEGORIA: "+idCat);
		return libroDAO.buscarPorCategoria(idCat);
	}
	
	@Override
	@Transactional
	public LibroDAO getLibroDAO() {
		return libroDAO;
	}

	@Override
	@Transactional
	public void setLibroDAO(LibroDAO libro) {
		this.libroDAO=libro;
	}

	@Override
	@Transactional
	public CategoriaDAO getCategoriaDAO() {
		
		return null;
	}

	@Override
	@Transactional
	public void setCategoriaDAO(CategoriaDAO categoria) {
	
		
	}
	



}
