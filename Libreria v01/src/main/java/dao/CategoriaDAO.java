package dao;

import java.util.List;

import beans.Categoria;

public interface CategoriaDAO {
	
	public abstract void insertar(Categoria cat);
	public abstract List<Categoria> buscarTodos();
	public abstract void borrar(Categoria cat);
	public abstract void guardarCambios(Categoria cat);
	public abstract Categoria buscarPorClave(Integer id);
	
}
