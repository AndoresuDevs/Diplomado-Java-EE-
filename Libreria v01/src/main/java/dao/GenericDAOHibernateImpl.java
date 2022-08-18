package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Categoria;
import javaEEJDBC.DataBaseHelperHibernate;
@SuppressWarnings("unchecked")
public abstract class GenericDAOHibernateImpl <T, Id extends Serializable> implements GenericDAO<T, Id> {
	
	private Class<T> claseDePersitencia;

	public GenericDAOHibernateImpl() {
		this.claseDePersitencia=(Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	public T buscarPorClave(Id id)  {
		T objeto = null;
		try {
			SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
			Session session = factoriaSession.openSession();
			objeto = (T)session.get(claseDePersitencia.getName(), id);
			session.close();
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			
		}
		  return objeto;
	}
	
	public List<T> buscarTodos() {
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<T>Lista = session.createQuery("from "+claseDePersitencia.getName()+" objeto").list();
		session.close();
		return Lista;
	}
	
	public void borrar(T objeto){
		System.out.println("BORRAR HIBERNATE");
		System.out.println("CLASS: "+objeto.getClass());
		
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
		
		if(claseDePersitencia.getSimpleName().equals("Categoria")) {
			Categoria c = (Categoria)objeto;
			System.out.println("CATEGORIA:");
			System.out.println("ID : "+c.getid_cat());
			System.out.println("NOM: "+c.getnom_cat());
		}
		
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(objeto);
		session.getTransaction().commit();
		session.close();	
	}


}
