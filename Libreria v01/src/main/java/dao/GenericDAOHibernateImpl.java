package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaEEJDBC.DataBaseHelperHibernate;

public abstract class GenericDAOHibernateImpl <T, Id extends Serializable> implements GenericDAO<T, Id> {
	
	private Class<T> claseDePersitencia;

	@SuppressWarnings("unchecked")
	public GenericDAOHibernateImpl(Class<T> claseDePersitencia) {
		this.claseDePersitencia=(Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T buscarPorClave(int id)  {
		T objeto = null;
		try {
			SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
			Session session = factoriaSession.openSession();
			objeto = (T)session.get(claseDePersitencia, id);
			session.close();
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() {
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<T>Lista = session.createQuery("from "+claseDePersitencia+" objeto").list();
		session.close();
		return Lista;
	}
	
	public void borrar(T objeto){
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.delete(objeto);
		session.getTransaction().commit();
		session.close();		
	}
	
	
	public void insertar (T objeto){
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(objeto);
		session.getTransaction().commit();
		session.close();	
	}
	
	//FALTA guardarCambios pero Hibernate lo hace en insertar
	public void guardarCambios (T objeto){
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(objeto);
		session.getTransaction().commit();
		session.close();	
	}
	
}
