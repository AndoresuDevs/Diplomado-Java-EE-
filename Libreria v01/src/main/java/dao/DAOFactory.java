package dao;

public interface DAOFactory {
	public CategoriaDAO getCategoriaDAO();
	public LibroDAO getLibroDAO();
	public ProveedorDAO getProveedorDao();
}
