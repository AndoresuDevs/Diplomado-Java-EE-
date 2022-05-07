package beans;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javaEEJDBC.DataBaseHelperHibernate;
import javaEEJDBC.JPAHelper;


//ESTA ETIQUETA ES LA FORMA EN QUE NOS CONECTAMOS CON EL FRAMEWORK PARA 
@Entity
@Table(name="categorias")
public class Categoria 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cat;
	private String nom_cat;
	//PARA QUE FUNCIONE CHIDO EL HIBERNATE
	@Fetch(value = FetchMode.SELECT)//////
	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name="id_cat") //ESTA ETIQUETA FUNCIONA CON ESTA LISTA CON EL CAMPO DE ESTA TABLA...
	private List<Libro>listaDeLibros;
	
//	public Categoria(int ID, String Categoria) {
//		//super();
//		this.id_cat=ID;
//		this.nom_cat=Categoria;
//	}
//	
//	

	public Categoria() {
	
	}
	
	public List<Libro> getListaDeLibros() {
		return listaDeLibros;
	}


	public void setListaDeLibros(List<Libro> listaDeLibros) {
		this.listaDeLibros = listaDeLibros;
	}
	
	public int getid_cat() {
		return id_cat;
	}

	public void setid_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	public String getnom_cat() {
		return nom_cat;
	}

	public void setnom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}


	public static List<Categoria> buscarCategorias()
	{
		System.out.println("BUSCAR CATEGORIAS");
	
		
		
		System.out.println("TRONO?");
		EntityManager em = JPAHelper.createEntityManager();
		TypedQuery<Categoria> consulta = em.createQuery("SELECT C from Categoria C",Categoria.class);
		List <Categoria>ListaDeCategorias = consulta.getResultList();
		for(Categoria l:ListaDeCategorias) {
			System.out.println(l.getnom_cat());
		}
		
	
		
		return ListaDeCategorias;
	}
	
	/*public static List<Categoria> buscarCategorias()
	{
		System.out.println("BUSCAR CATEGORIAS");
	
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		System.out.println("1");
		Session session = factoriaSession.openSession();
		System.out.println("2");
		List <Categoria>ListaDeCategorias = session.createQuery("from Categoria cat").list();
		System.out.println("3");
		session.close();
		
		System.out.println("TRONO?");
		return ListaDeCategorias;
	}*/
	
	
	
}
