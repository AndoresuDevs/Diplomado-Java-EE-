package javaEEJDBC;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import beans.Libro;




public class DataBaseHelperHibernate<T>extends Libro{
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
	
	
	
}
