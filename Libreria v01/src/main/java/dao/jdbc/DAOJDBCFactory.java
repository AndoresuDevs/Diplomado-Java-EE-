package dao.jdbc;

import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.ProveedorDAO;

public class DAOJDBCFactory implements DAOFactory {

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new CategoriaJDBCImpl();
	}

	@Override
	public LibroDAO getLibroDAO() {
		// TODO Auto-generated method stub
		return new LibroDAOJDBCImpl();
	}

	@Override
	public ProveedorDAO getProveedorDao() {
		// TODO Auto-generated method stub
		return new ProveedorDAOJDBCImpl();
	}

}
