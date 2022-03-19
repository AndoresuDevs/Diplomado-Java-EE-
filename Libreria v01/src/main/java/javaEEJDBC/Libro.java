package javaEEJDBC;

import java.io.File;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

//ANOTACIONES QUE LEE EL FRAMEWORK HIBERNATE
@SuppressWarnings({ "rawtypes", "unchecked" })
@Entity
@Table(name="libros")
public class Libro {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_lib;
	private String isbn_lib;
	private String tit_lib;
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
	

	
	
	public static List<Integer> buscarLasCategorias() throws DataBaseException{
		String consultaSQL="SELECT DISTINCT(cat_lib) FROM libros";
		DataBaseHelper dbh = new DataBaseHelper();
		List<Integer> ListaDeCategorias=dbh.seleccionarRegistros(consultaSQL,Integer.class);
		//List<Integer>ListaDeCategorias = new ArrayList<Integer>();
		
		dbh.cerrarObjetos();
		return ListaDeCategorias;
	}
	
	public int insertar ()throws DataBaseException {
//		String consultaSQL="INSERT INTO libros(isbn_lib,tit_lib,cat_lib,pre_lib) VALUES ";
//		consultaSQL +="('"+isbn_lib+"','"+tit_lib+"',"+cat_lib+","+pre_lib+");";
//		DataBaseHelper dbh = new DataBaseHelper();
//		int filasModif=dbh.modificarRegistro(consultaSQL);
//		dbh.cerrarObjetos();
		
		DataBaseHelperHibernate dbhh = new DataBaseHelperHibernate();
		dbhh.insertarRegistro(this);
		
		return 0;
	}
	
	public static List<Libro> buscarTodos()throws DataBaseException {
//		String SQL ="SELECT * FROM libros";
//		DataBaseHelper  dbh = new DataBaseHelper();
//		dbh.cerrarObjetos();
		String consulta ="from Libro libro";
		DataBaseHelperHibernate  dbhh = new DataBaseHelperHibernate();
		List<Libro>ListaDeLibros = dbhh.seleccionarRegistros(consulta);
		return ListaDeLibros;
	}
	
	public Libro buscarLibro(int ID) throws DataBaseException {
		String SQL ="SELECT * FROM libros WHERE num_lib="+ID;
		DataBaseHelper dbh  = new DataBaseHelper();
		List<Libro> listaDeLibros = dbh.seleccionarRegistros(SQL, Libro.class);		
		dbh.cerrarObjetos();
		return  listaDeLibros.get(0);
	}
	
	  public void editarLibro(int ID)throws DataBaseException {
//		DataBaseHelper dbh = new DataBaseHelper();
//		int filasModif=dbh.actualizarRegistro(ID, this);
//		dbh.cerrarObjetos();
//		System.out.println("FILAS MODIFICADAS: "+filasModif);
		
		DataBaseHelperHibernate dbhh = new DataBaseHelperHibernate();
		this.setnum_lib(ID);
		dbhh.actualizarRegistro(this);
	}
	
	public void BorrarLibro(int id) throws DataBaseException {
//		String SQL ="DELETE  FROM libros WHERE num_lib="+id+";";
//		DataBaseHelper dbh = new DataBaseHelper();
//		int filas=dbh.modificarRegistro(SQL);
		DataBaseHelperHibernate dbhh = new DataBaseHelperHibernate();
		dbhh.borrarRegistro(id);
		
	}
	
	
	//PENDIENTE!!!
	public static List<Libro> buscarPorCategoria(int cat) throws DataBaseException {
//		System.out.println(new File("Reflection, busca la ruta de esta cosa y la imprime").getAbsolutePath()); ////OTRO EJEMPLO DE REFLECTION 
//		String SQL ="SELECT * FROM libros WHERE cat_lib="+cat;
//		DataBaseHelper dbh = new DataBaseHelper();
//		List<Libro>ListaDeLibros = dbh.seleccionarRegistros(SQL, Libro.class);
//		dbh.cerrarObjetos();
//		return ListaDeLibros;
		
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
