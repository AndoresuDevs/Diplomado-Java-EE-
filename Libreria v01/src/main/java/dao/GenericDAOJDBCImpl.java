package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericDAOJDBCImpl <T, Id extends Serializable> implements GenericDAO<T, Id>{

	private Class<T> claseDePersitencia;

	@SuppressWarnings("unchecked")
	public GenericDAOJDBCImpl(Class<T> claseDePersitencia) {
		this.claseDePersitencia=(Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T buscarPorClave(int id) {
		T objeto = null;
		
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
		
		return objeto;
	}
	
	public List<T> buscarTodos() {
		List<T> lista= null;
		
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
		return lista;
		
	}
	
	public void borrar(T objeto) {
		
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
		
	}
	
	public void insertar(T objeto) {
		
		
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
		
	}
	
	public void guardarCambios(T objeto) {
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
		
	}
	
	
	

}
