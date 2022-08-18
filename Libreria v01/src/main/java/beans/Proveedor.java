package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedor {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_prov;
	private String nom_prov;
	private String tel_prov;
	private String dir_prov;
	
	public Proveedor(String Nombre, String Telefono, String Direccion) {
		this.nom_prov = Nombre;
		this.tel_prov = Telefono;
		this.dir_prov = Direccion;
	}

	public Proveedor() {
		
	}
	
	public int getid_prov() {
		return id_prov;
	}


	public void setid_prov(int ID) {
		this.id_prov = ID;
	}


	public String getnom_prov() {
		return nom_prov;
	}


	public void setnom_prov(String Nombre) {
		this.nom_prov = Nombre;
	}


	public String gettel_prov() {
		return tel_prov;
	}


	public void settel_prov(String Telefono) {
		this.tel_prov = Telefono;
	}


	public String getdir_prov() {
		return dir_prov;
	}


	public void setdir_prov(String Direccion) {
		this.dir_prov = Direccion;
	}

	
}
