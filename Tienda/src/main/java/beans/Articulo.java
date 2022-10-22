package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Articulo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id_art;
	
	private String nom_art;
	private Float pre_art;
	private int cat_art;
	private int prov_art;
	
	public Articulo(Integer id_art, String nom_art, Float pre_art, int cat_art, int prov_art) {
		super();
		this.id_art = id_art;
		this.nom_art = nom_art;
		this.pre_art = pre_art;
		this.cat_art = cat_art;
		this.prov_art = prov_art;
	}
	
	public Articulo() {
		
	}

	public Integer getId_art() {
		return id_art;
	}

	public void setId_art(Integer id_art) {
		this.id_art = id_art;
	}

	public String getNom_art() {
		return nom_art;
	}

	public void setNom_art(String nom_art) {
		this.nom_art = nom_art;
	}

	public Float getPre_art() {
		return pre_art;
	}

	public void setPre_art(Float pre_art) {
		this.pre_art = pre_art;
	}

	public int getCat_art() {
		return cat_art;
	}

	public void setCat_art(int cat_art) {
		this.cat_art = cat_art;
	}

	public int getProv_art() {
		return prov_art;
	}

	public void setProv_art(int prov_art) {
		this.prov_art = prov_art;
	}
	
	
	
	
	
}
