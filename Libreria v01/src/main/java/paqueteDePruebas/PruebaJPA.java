package paqueteDePruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import beans.Libro;

public class PruebaJPA {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta = em.createQuery("SELECT L from Libro L",Libro.class);
		
		System.out.println("PRUEBA DE JPA");
		//TypedQuery<Libro> consulta = Persistence.createEntityManagerFactory("JavaEE").createEntityManager().createQuery("SELECT l from Libro l", Libro.class);
		List<Libro> lista = consulta.getResultList();
		for(Libro l:lista) {
			System.out.println(l.gettit_lib());
		}
		
		
		

	}

}
