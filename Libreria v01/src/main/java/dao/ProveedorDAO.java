package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import beans.Proveedor;
import javaEEJDBC.JPAHelper;

public class ProveedorDAO {
	public void insertar(Proveedor prov)
	{
		//EntityManagerFactory factoriaSession
		EntityManager manager = JPAHelper.createEntityManager();
		
		EntityTransaction tx = null;
	
		tx = manager.getTransaction();
		tx.begin();
		
		manager.persist(prov);
		tx.commit();
		manager.close();		
		
	}
	
	public void guardarCambios(Proveedor prov) {
		EntityManager manager = JPAHelper.createEntityManager();
		EntityTransaction tx = null;
		tx=manager.getTransaction();
		tx.begin();
		manager.merge(prov);
		tx.commit();
		manager.close();
	}
	
	public static List<Proveedor> buscarTodos()
	{
		EntityManager em = JPAHelper.createEntityManager();
		TypedQuery<Proveedor> consulta = em.createQuery("SELECT P from Proveedor P",Proveedor.class);
		List<Proveedor> lista = consulta.getResultList();
		for(Proveedor P:lista) {
			System.out.println(P.getnom_prov());
		}
		
		return lista;
	}
	
	public void borrarProveedor(Proveedor prov)
	{
		EntityManager manager = JPAHelper.createEntityManager();
		EntityTransaction tx = null;
		
		tx=manager.getTransaction();
		tx.begin();
		manager.remove(manager.merge(prov));
		tx.commit();
		manager.close();
		
		
	}
	
	public Proveedor buscarProveedor(int id)
	{
		EntityManager em = JPAHelper.createEntityManager();
		TypedQuery<Proveedor> consulta;
		Proveedor prov = null;
		try {
			consulta = em.createQuery("SELECT P from Proveedor P "
									+ "where P.nom_prov ="+id, Proveedor.class);
			prov = consulta.getSingleResult();
			em.close();
		}catch(PersistenceException e)
		{
			e.printStackTrace();
		}

		
		return prov;
	}
	
	
	
}
