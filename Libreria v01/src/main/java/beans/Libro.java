package beans;

import java.io.File;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelperHibernate;
import javaEEJDBC.JPAHelper;

//ANOTACIONES QUE LEE EL FRAMEWORK HIBERNATE

@Entity
@Table(name="libros")
public class Libro {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_lib;
	private String isbn_lib;
	private String tit_lib;
	@ManyToOne  //TIPO DE RELACION ENTRE LOS CAMPOS DE LA TABLA
	@JoinColumn(name = "cat_lib", referencedColumnName="id_cat", insertable=false, updatable=false, nullable=false) //CAMPO REFERENCIADO DE ESTA TABLA
	private Categoria categoria; //EL OBJETO REFERENCIADO
	private int cat_lib;
	private float pre_lib;
	
	
	public Libro(String ISBN, String titulo, int categoria, float precio) {
		
		isbn_lib = ISBN;
		tit_lib = titulo;
		cat_lib = categoria;
		pre_lib = precio;
	}
	
	//PARA TRABAJAR CON CUALQUIER FRAMEWORK SE REQUIERE UN CONSTRUCTOR VACIO SI O SI
	public Libro() {
		
	}
	
	public int getnum_lib() {
		return num_lib;
	}
	
	protected void setnum_lib(int Numero) {
		this.num_lib = Numero;
	}

	public String getisbn_lib() {
		return isbn_lib;
	}

	public void setisbn_lib(String ISBN) {
		this.isbn_lib = ISBN;
	}

	public String gettit_lib() {
		return tit_lib;
	}

	public void settit_lib(String Titulo) {
		this.tit_lib = Titulo;
	}

	public int getcat_lib() {
		return cat_lib;
	}

	public void setcat_lib(int Categoria) {
		this.cat_lib = Categoria;
	}

	public float getpre_lib() {
		return pre_lib;
	}

	public void setpre_lib(float Precio) {
		this.pre_lib = Precio;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	public void insertar()
	{
		EntityManager em = JPAHelper.createEntityManager();
		
		EntityTransaction et = null;
	
		et = em.getTransaction();
		et.begin();
		
		em.persist(this);
		et.commit();
		em.close();		
		
	}
	
	public void guardarCambios() {
		
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
	
	public void BorrarLibro()
	{
		EntityManager em = JPAHelper.createEntityManager();
		EntityTransaction et = null;
		
		et = em.getTransaction();
		et.begin();
		em.remove(em.merge(this));
		et.commit();
		em.close();
		
	}
	
	public static Libro buscarLibro(int id)
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
	
	public static List<Libro> buscarPorProveedor(int idProv)
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
	//METODOS CON HIBERNATE HELPER
	/*
	public static List<Integer> buscarLasCategorias() throws DataBaseException{
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		//CONSULTA SQL ES EN STRING, CONSULTA HQL ES EN FORMATO QUERY
		String consulta= "SELECT DISTINCT libro.cat_lib FROM Libro libro";
		List <Integer>ListaDeCategorias=session.createQuery(consulta).list();
		session.close();
		return ListaDeCategorias;
	}
	
	public void insertar (){
		imprimirEnConsola();
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
		session.close();	
		
		
	}
	
	public static List<Libro> buscarTodos()throws DataBaseException {
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<Libro>ListaDeLibros = session.createQuery("from Libro libro").list();
		session.close();
		return ListaDeLibros;
	}
	
	public Libro buscarLibro(int ID) throws DataBaseException {
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		Libro libro = (Libro)session.get(Libro.class, ID);
		session.close();
		return libro;
	}
	
	public void BorrarLibro(){
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
		session.close();		
	}
	
	

	public static List<Libro> buscarPorCategoria(int cat) throws DataBaseException {

		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		Query consulta = session.createQuery("FROM Libro libro WHERE libro.cat_lib=:categoria");
		consulta.setParameter("categoria", cat);
		List<Libro>ListaDeLibros=consulta.list();
		session.close();
		return ListaDeLibros;
		
		
	}
	
	
	private void imprimirEnConsola() {
		System.out.println("LIBRO EN JAVA BEAN:");
		System.out.println("NUM: "+num_lib);
		System.out.println("ISBN: "+isbn_lib);
		System.out.println("TIT: "+tit_lib);
		System.out.println("PRE:"+pre_lib);
		System.out.println("CAT: "+cat_lib);
		System.out.println("FIN DEL LIBRO");
	}
	
	
	
	
} */
