package paqueteDePruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Categoria;
import beans.Libro;
import javaEEJDBC.DataBaseHelperHibernate;
import javaEEJDBC.JPAHelper;

public class Prueba<T> {
	
	private Class<T> claseDePersitencia;
	
	
	public static void main(String[] args) {
		Prueba<Libro> p = new Prueba<Libro>();
		
		System.out.println("TAMAÑO: "+p.buscarTodos().size());
		
		Prueba<Categoria>p2 = new Prueba<Categoria>();
		p2.insertar(new Categoria("Aguacates"));

	}
	
	public <T> List<T> buscarTodos() {
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		List<T>Lista = session.createQuery("from "+"Categoria"+" objeto").list();
		session.close();
		return Lista;
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

}
