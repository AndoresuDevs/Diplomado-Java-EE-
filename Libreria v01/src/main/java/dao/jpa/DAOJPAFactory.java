package dao.jpa;

import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.ProveedorDAO;

public class DAOJPAFactory implements DAOFactory
{
	
	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOJPAImpl();
		
	}
	
	@Override
	public LibroDAO getLibroDAO() {
		System.out.println("ENTRO EL JPA FACTORY LIBRO DAO");
		return new LibroDAOJPAImpl();
	}

	@Override
	public ProveedorDAO getProveedorDao() {
		// TODO Auto-generated method stub
		return new ProveedorDAOJPAImpl();
	}
}