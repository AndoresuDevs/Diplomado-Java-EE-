package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import beans.Libro;
import javaEEJDBC.JPAHelper;

public class LibroDAO {

	public void insertar(Libro libro)
	{
		//EntityManagerFactory factoriaSession
		EntityManager manager = JPAHelper.createEntityManager();
		
		EntityTransaction tx = null;
	
		tx = manager.getTransaction();
		tx.begin();
		
		manager.persist(libro);
		tx.commit();
		manager.close();		
		
	}
	
	public void guardarCambios(Libro lib) {
		EntityManager manager = JPAHelper.createEntityManager();
		EntityTransaction tx = null;
		tx=manager.getTransaction();
		tx.begin();
		manager.merge(lib);
		tx.commit();
		manager.close();
	}
	
	public static List<Libro> buscarTodos()
	{
		EntityManager em = JPAHelper.createEntityManager();
		TypedQuery<Libro> consulta = em.createQuery("SELECT L from Libro L",Libro.class);
		List<Libro> lista = consulta.getResultList();
		for(Libro l:lista) {
			System.out.println(l.gettit_lib());
		}
		
		return lista;
	}
	
	public void BorrarLibro(Libro lib)
	{
		EntityManager manager = JPAHelper.createEntityManager();
		EntityTransaction tx = null;
		
		tx=manager.getTransaction();
		tx.begin();
		manager.remove(manager.merge(lib));
		tx.commit();
		manager.close();
		
		
	}
	
	public Libro buscarLibro(int id)
	{
		EntityManager em = JPAHelper.createEntityManager();
		TypedQuery<Libro> consulta;
		Libro libro = null;
		try {
			consulta = em.createQuery("SELECT L from Libro L "
									+ "where L.num_lib ="+id, Libro.class);
			libro = consulta.getSingleResult();
			em.close();
		}catch(PersistenceException e)
		{
			e.printStackTrace();
		}

		
		return libro;
	}
	
	public static List<Libro> buscarPorCategoria(int idCat)
	{
		EntityManager em = JPAHelper.createEntityManager();
		TypedQuery<Libro> consulta;
		List<Libro> ListaLibros = null;
		try {
			consulta = em.createQuery("SELECT L from Libro L where L.cat_lib ="+idCat, Libro.class);
			ListaLibros = consulta.getResultList();
			em.close();
		}catch(PersistenceException e)
		{
			e.printStackTrace();
		}

		return ListaLibros;
	}
	
	public List<Libro> buscarPorProveedor(int idProv)
	{
		EntityManager em = JPAHelper.createEntityManager();
		TypedQuery<Libro> consulta;
		List<Libro> ListaLibros = null;
		try {
			consulta = em.createQuery("SELECT L from Libro L where L.prov_lib ="+idProv, Libro.class);
			ListaLibros = consulta.getResultList();
			em.close();
		}catch(PersistenceException e)
		{
			e.printStackTrace();
		}
		
		return ListaLibros;
	}
	
}
