package beans;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


//ESTA ETIQUETA ES LA FORMA EN QUE NOS CONECTAMOS CON EL FRAMEWORK PARA 
@Entity
@Table(name="categorias")
public class Categoria 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @PrimaryKeyJoinColumn //el join column no jalaba abajo...
	private int id_cat;
	private String nom_cat;
	
//	PARA QUE FUNCIONE CHIDO EL HIBERNATE
//	@Fetch(value = FetchMode.SELECT)//////
//	@OneToMany
//	@JoinColumn(name="id_cat") //ESTA ETIQUETA FUNCIONA CON ESTA LISTA CON EL CAMPO DE ESTA TABLA...
//	private List<Libro>listaDeLibros;
	
	@OneToMany
	@JoinColumn(name="cat_lib") //ESTA ETIQUETA FUNCIONA CON ESTA LISTA CON EL CAMPO DE ESTA TABLA...
	private List<Libro>listaDeLibros;
	
	public Categoria() {}
	
	public Categoria(String Categoria) {
		this.nom_cat=Categoria;
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
	
	public List<Libro> traerListaDeLibros() {
		return listaDeLibros;
	}

	public void ListaDeLibros(List<Libro> listaDeLibros) {
		this.listaDeLibros = listaDeLibros;
	}
	
}
