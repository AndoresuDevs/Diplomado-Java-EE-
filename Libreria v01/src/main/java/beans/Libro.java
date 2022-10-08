package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.FetchType;
//ANOTACIONES QUE LEE EL FRAMEWORK HIBERNATE

@Entity
@Table(name="libros")
public class Libro {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_lib")
	private int num_lib;
	@Column(name="isbn_lib")
	private String isbn_lib;
	@Column(name="tit_lib")
	private String tit_lib;
	@Column(name="pre_lib")
	private float pre_lib;
	
	@Fetch(value = FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)  //TIPO DE RELACION ENTRE LOS CAMPOS DE LA TABLA
	@JoinColumn(name = "cat_lib", referencedColumnName="id_cat", insertable=false, updatable=false, nullable=false) //CAMPO REFERENCIADO DE ESTA TABLA
	private Categoria categoria; //EL OBJETO REFERENCIADO
	@Column(name="cat_lib")
	private int cat_lib;
	
	//PARA TRABAJAR CON CUALQUIER FRAMEWORK SE REQUIERE UN CONSTRUCTOR VACIO SI O SI
	public Libro() {
			
	}
	
	public Libro(String ISBN, String titulo, int categoria, float precio) {
		isbn_lib = ISBN;
		tit_lib = titulo;
		cat_lib = categoria;
		pre_lib = precio;
	}
	
	
	
	public int getnum_lib() {
		return num_lib;
	}
	
	public void setnum_lib(int Numero) {
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
//	77777777777777777777777
	
//	public int getid_cat() {
//		return 1;
//	}
//	
//	public int getnom_cat() {
//		return 1;
//	}
	

	


	
	
}
