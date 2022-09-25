package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import beans.Libro;
import dao.LibroDAO;
import javaEEJDBC.JPAHelper;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, Integer> implements LibroDAO
{

	@Override
	public List<Libro> buscarPorCategoria(int idCat)
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