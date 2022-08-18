package dao;

public class DAOHibernateFactory implements DAOFactory {

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new CategoriaDAOHibernateImpl();//listo

	}

	@Override
	public LibroDAO getLibroDAO() {
		// TODO Auto-generated method stub
		return new LibroDAOHibernateImpl();
	}

	@Override
	public ProveedorDAO getProveedorDao() {
		// TODO Auto-generated method stub
		return new ProveedorDAOHibernateImpl();
	}
}