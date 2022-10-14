package dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;

import dao.GenericDAO;
import repositorios.CategoriaRepository;
import repositorios.LibroRepository;
import repositorios.ProveedorRepository;

@SuppressWarnings("hiding")
public abstract class GenericDAOJPAImpl <T, Id extends Serializable> implements GenericDAO<T, Id> 
{
	
	private Class<T> claseDePersitencia;
	EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private LibroRepository repoLib;
	
	@Autowired
	private CategoriaRepository repoCat;
	
	@Autowired
	private ProveedorRepository repoProv;
	
	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl()
	{
		this.claseDePersitencia=(Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public T buscarPorClave(Id id){
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
	
	
	@SuppressWarnings("unchecked")
	public  List<T> buscarTodos(){
		
		if(claseDePersitencia.getSimpleName().equals("Libro")) {
			return (List<T>)repoLib.findAll();
		}else 
		if (claseDePersitencia.getSimpleName().equals("Categoria")){
			return (List<T>)repoCat.findAll();
		}else {
			return (List<T>)repoProv.findAll();
		}
		
		
		
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
