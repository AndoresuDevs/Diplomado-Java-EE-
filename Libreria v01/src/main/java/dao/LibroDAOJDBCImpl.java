package dao;

import java.util.List;

import beans.Libro;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelper;

public class LibroDAOJDBCImpl extends GenericDAOJDBCImpl<Libro, Integer> implements LibroDAO {

	@Override
	public List<Libro> buscarPorCategoria(int idCat) {
		String query ="SELECT * FROM libros WHERE cat_lib="+idCat;
		// TODO Auto-generated method stub
		try {
			DataBaseHelper<Libro> db = new DataBaseHelper<Libro>();
			return db.seleccionarRegistros(query, Libro.class);
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	

}
