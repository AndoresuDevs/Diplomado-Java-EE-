package paqueteDePruebas;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javaEEJDBC.Libro;
import javaEEJDBC.Proveedor;



public class CRUDHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Prueba.class.getPackage().toString());
		
		CRUDHibernate hib = new CRUDHibernate();
		//hib.insertar();
		
		
		System.out.println("\nBUSCAR TODOS");
		for(Libro L:hib.buscarTodos()) {
			System.out.println(L.getnum_lib()+"\t\t"+L.getisbn_lib()+"\t\t"+L.gettit_lib()+"\t\t"+L.getCategoria().getnom_cat()+"\t\t"+L.getpre_lib());
		
		}
		

	}

	public List<Libro>  buscarTodos() 
	{
		List<Libro>ListaDeLibros=null;
		Session session = null;
		
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query consulta = session.createQuery("from Libro libro");
			ListaDeLibros = consulta.list();
			
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (session!=null) session.close();
		}
		return ListaDeLibros;
		
	}
	
	public List<Proveedor>  buscarProveedores() 
	{
		List<Proveedor>Lista=null;
		Session session = null;
		
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query consulta = session.createQuery("from Proveedor proveedor");
			Lista = consulta.list();
			
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (session!=null) session.close();
		}
		return Lista;
		
	}
	
	public void insertar() {
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaction = session.beginTransaction();
			Libro lib = new Libro("47474774","HIBERNATE 2",5,666.02f);
			session.save(lib);
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
	
	private void editarLibro() {//////////////
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaction = session.beginTransaction();
			Libro lib = new Libro("47474774","HIBERNATE",1,666.02f);
			
			session.update(lib);
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
	
	private Libro buscarLibro(int id) {
		Libro lib=null;
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaction = session.beginTransaction();
			lib = (Libro)session.get(Libro.class, id);
			session.update(lib);
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
		return lib;
	}
	
	private void borrarLibro(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaction = session.beginTransaction();
			
			Libro lib= (Libro) session.load(Libro.class, id); //clase, id
			
			session.delete(lib);
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

	public List<Libro> buscarPorCategoria(int cat) {
		
		
		List<Libro>ListaDeLibros=null;
		Session session = null;
		
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query consulta = session.createQuery("FROM Libro libro WHERE cat_lib=(:cat)");
			consulta.setParameter("cat", cat);
			ListaDeLibros = consulta.list();
			
			
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (session!=null) session.close();
		}
		return ListaDeLibros;
		
		
		        
	}
	
}
