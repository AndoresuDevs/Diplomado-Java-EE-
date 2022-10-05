package dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import dao.GenericDAO;



@SuppressWarnings("hiding")
public abstract class GenericDAOJPAImpl <T, Id extends Serializable> extends JpaDaoSupport implements GenericDAO<T, Id> 
{
	
	private Class<T> claseDePersitencia;
	//private JpaTemplate plantillaJPA;
	
	EntityManagerFactory entityManagerFactory;
	
	
	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl()
	{
		this.claseDePersitencia=(Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	
	public T buscarPorClave(Id id){
		
		System.out.println("BUSCAR POR CLAVE JPA: "+id);
		EntityManager manager = entityManagerFactory.createEntityManager();
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
		EntityManager manager = entityManagerFactory.createEntityManager();
		TypedQuery<T> consulta = null;
		try {
			consulta = manager.createQuery("SELECT o FROM "+claseDePersitencia.getSimpleName()+" o",claseDePersitencia);
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
		return consulta.getResultList();
	}
	                                               
	public void borrar(T objeto) {
		System.out.println("BORRAR JPA");
		EntityManager manager = entityManagerFactory.createEntityManager();
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
		EntityManager manager = entityManagerFactory.createEntityManager();
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
		EntityManager manager = entityManagerFactory.createEntityManager();
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
