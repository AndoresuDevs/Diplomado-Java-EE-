package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import javaEEJDBC.JPAHelper;


public abstract class GenericDAOJPAImpl <T, Id extends Serializable> implements GenericDAO<T, Id> 
{
	
	private Class<T> claseDePersitencia;
	
	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl()
	{
		this.claseDePersitencia=(Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	public T buscarPorClave(Id id){
		
		EntityManager manager = JPAHelper.createEntityManager();
		T objeto = null;
		try {
			objeto = (T) manager.find(claseDePersitencia, id);
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return objeto;
		
		
	}
	
	
	public  List<T> buscarTodos(){
		TypedQuery<T> consulta = null;
		try {
			consulta = JPAHelper.createEntityManager().createQuery("SELECT o FROM "+claseDePersitencia.getSimpleName()+" o",claseDePersitencia);
			//System.out.println("JPA QUERY");
			
			//System.out.println("SELECT o FROM "+claseDePersitencia.getSimpleName()+" o" + claseDePersitencia);
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
		return consulta.getResultList();
	}
	                                               
	public void borrar(T objeto) {
		EntityManager manager = JPAHelper.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx=manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(objeto));
			tx.commit();
			manager.close();
		}catch(PersistenceException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			manager.close();
		}
		
		
	}
	
	
	public void insertar(T objeto) {
		EntityManager manager = JPAHelper.createEntityManager();
		EntityTransaction tx = null;
	
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(objeto);
			tx.commit();
		}catch(PersistenceException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			manager.close();
		}
	}
	
	
	public void guardarCambios(T objeto) {
		EntityManager manager = JPAHelper.createEntityManager();
		EntityTransaction tx = null;
	
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.merge(objeto);
			tx.commit();
		}catch(PersistenceException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			manager.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
