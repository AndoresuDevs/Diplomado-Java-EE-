package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import beans.Categoria;
import beans.Libro;
import javaEEJDBC.JPAHelper;

public class CategoriaDAO {
	public void insertar(Categoria cat )
	{
		//EntityManagerFactory factoriaSession
		EntityManager manager = JPAHelper.createEntityManager();
		
		EntityTransaction tx = null;
	
		tx = manager.getTransaction();
		tx.begin();
		
		manager.persist(cat);
		tx.commit();
		manager.close();		
		
	}
	
	public void guardarCambios(Categoria cat) {
		EntityManager manager = JPAHelper.createEntityManager();
		EntityTransaction tx = null;
		tx=manager.getTransaction();
		tx.begin();
		manager.merge(cat);
		tx.commit();
		manager.close();
	}
	
	public static List<Categoria> buscarTodas()
	{
		EntityManager em = JPAHelper.createEntityManager();
		TypedQuery<Categoria> consulta = em.createQuery("SELECT C from Categoria C",Categoria.class);
		List<Categoria> lista = consulta.getResultList();
		for(Categoria C:lista) {
			System.out.println(C.getnom_cat());
		}
		
		return lista;
	}
	
	public void BorrarLibro(Categoria cat)
	{
		EntityManager manager = JPAHelper.createEntityManager();
		EntityTransaction tx = null;
		
		tx=manager.getTransaction();
		tx.begin();
		manager.remove(manager.merge(cat));
		tx.commit();
		manager.close();
		
		
	}
	
	public Categoria buscarCategoria(int id)
	{
		EntityManager em = JPAHelper.createEntityManager();
		TypedQuery<Categoria> consulta;
		Categoria cat = null;
		try {
			consulta = em.createQuery("SELECT C from Categoria C "
									+ "where C.nom_cat ="+id, Categoria.class);
			cat = consulta.getSingleResult();
			em.close();
		}catch(PersistenceException e)
		{
			e.printStackTrace();
		}

		
		return cat;
	}
	
	
	
}
