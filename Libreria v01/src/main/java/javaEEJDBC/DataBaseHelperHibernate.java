package javaEEJDBC;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DataBaseHelperHibernate<T> extends Libro{
	private static final Logger log = LogManager.getLogger(DataBaseHelper.class.getPackage().getName());
	
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
			
		}catch(Throwable e) {
			System.err.println("ERROR AL CREAR LA SESION DE FACTORY "+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	
	
	public int insertarRegistro(T objeto) throws DataBaseException{
		int filasAfectadas=0;
		//INSERTAR
		//BORRAR
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaction = session.beginTransaction();
			session.save(objeto);
			transaction.commit();
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
			try {
				transaction.rollback();
			}catch(IllegalStateException e1) {
				System.out.println("NO SE PUDO REALIZAR EL ROLLBACK");
				e1.printStackTrace();
			}
		}
		catch(SecurityException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (session!=null) session.close();
		}
		return filasAfectadas;
	}
	
	@SuppressWarnings("unchecked")
	public List<T>seleccionarRegistros(String query) throws DataBaseException {
		System.out.println("DBHH QUERY: "+query);
		Session session = null;
		List<T>listaDeObjetos=new ArrayList<T>();
		
		try {
			
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query<T> consulta = session.createQuery(query);
			listaDeObjetos=consulta.list();
			
			
			
		}catch(Exception e) {
			
		}
		
		return listaDeObjetos;
	}
	
	public void actualizarRegistro(T objeto) {
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaction = session.beginTransaction();
			session.update(objeto);
			transaction.commit();
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
			try {
				transaction.rollback();
			}catch(IllegalStateException e1) {
				System.out.println("NO SE PUDO REALIZAR EL ROLLBACK");
				e1.printStackTrace();
			}
		}
		catch(SecurityException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (session!=null) session.close();
		}
	}
	
	public void borrarRegistro(int id) {
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaction = session.beginTransaction();
			
			session.delete(session.load(Libro.class, id));
			transaction.commit();
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
			try {
				transaction.rollback();
			}catch(IllegalStateException e1) {
				System.out.println("NO SE PUDO REALIZAR EL ROLLBACK");
				e1.printStackTrace();
			}
		}
		catch(SecurityException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (session!=null) session.close();
		}
		
	}
}
