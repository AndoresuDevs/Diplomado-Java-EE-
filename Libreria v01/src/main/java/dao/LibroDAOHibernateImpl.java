package dao;

import java.util.List;

import beans.Libro;

public class LibroDAOHibernateImpl extends GenericDAOHibernateImpl<Libro,Integer> implements LibroDAO {



	@Override
	public List<Libro> buscarPorCategoria(int idCat) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Libro> buscarPorProveedor(int idCat) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
