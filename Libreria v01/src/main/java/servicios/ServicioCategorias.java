package servicios;

import java.util.List;

import beans.Categoria;
import dao.CategoriaDAO;

public interface ServicioCategorias {
	public abstract void insertar(Categoria categoria);
	public abstract List<Categoria> buscarTodos();
	public abstract void borrar(Categoria categoria);
	public abstract void guardarCambios(Categoria categoria);
	public abstract Categoria buscarPorClave(Integer id);
	
	public CategoriaDAO getcatDAO();
	public void setcatDAO(CategoriaDAO cat);
}
