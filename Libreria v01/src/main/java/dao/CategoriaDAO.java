package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import beans.Categoria;
import beans.Libro;
import javaEEJDBC.JPAHelper;

public interface CategoriaDAO {
	
	public abstract void insertar(Categoria cat);
	public abstract List<Categoria> buscarTodos();
	public abstract void borrar(Categoria cat);
	public abstract void guardarCambios(Categoria cat);
	public abstract Categoria buscarPorClave(Integer id);
	
	
	
}
