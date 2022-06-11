package dao;

import beans.Proveedor;

public class ProveedorDAOHibernateImpl extends GenericDAOHibernateImpl<Proveedor, Integer> implements ProveedorDAO{

	public ProveedorDAOHibernateImpl(Class<Proveedor> claseDePersitencia) {
		super(claseDePersitencia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Proveedor buscarPorClave(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
