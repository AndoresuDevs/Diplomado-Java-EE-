package servicios;

import java.util.List;

import beans.Libro;
import dao.CategoriaDAO;
import dao.LibroDAO;

public interface ServicioLibros 
{
	
	
	
	public abstract void insertar(Libro libro);
	public abstract List<Libro> buscarTodos();
	public abstract void borrar(Libro lib);
	public abstract void guardarCambios(Libro lib);
	public abstract Libro buscarPorClave(Integer id);
	public abstract List<Libro> buscarPorCategoria(int idCat);
	
	public LibroDAO getLibroDAO();
	public void setLibroDAO(LibroDAO libro);
	public CategoriaDAO getCategoriaDAO();
	public void setCategoriaDAO(CategoriaDAO categoria);
	
}
