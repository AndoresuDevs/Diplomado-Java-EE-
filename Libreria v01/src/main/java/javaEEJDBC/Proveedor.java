package javaEEJDBC;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings({ "rawtypes", "unchecked" })
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


	public static List<Proveedor> buscarTodos()throws DataBaseException {
//		String SQL ="SELECT * FROM proveedores";
//		DataBaseHelper  dbh = new DataBaseHelper();
//		List<Proveedor>ListaDeProveedores = dbh.seleccionarRegistros(SQL, Proveedor.class);
//		String SQL ="SELECT * FROM proveedores";
		//dbh.cerrarObjetos();
		String consulta ="from Proveedor proveedor";
		DataBaseHelperHibernate  dbhh = new DataBaseHelperHibernate();
		List<Proveedor>ListaDeProveedores = dbhh.seleccionarRegistros(consulta);
		return ListaDeProveedores;
		
	}


	public void BorrarProveedor(int id) throws DataBaseException{
//		String SQL ="DELETE  FROM proveedores WHERE id_prov="+id+";";
//		DataBaseHelper dbh;
//		dbh = new DataBaseHelper();
//		int filas=dbh.modificarRegistro(SQL);
//		System.out.println(filas);
		DataBaseHelperHibernate dbhh = new DataBaseHelperHibernate();
		dbhh.borrarRegistro(id);
		
		
	}
	
	
	
	public int insertar ()throws DataBaseException {
//		String consultaSQL="INSERT INTO proveedores(nom_prov,tel_prov,dir_prov) VALUES ";
//		consultaSQL +="('"+nom_prov+"','"+tel_prov+"','"+dir_prov+"');";
//		DataBaseHelper dbh = new DataBaseHelper();
//		int filasModif=dbh.modificarRegistro(consultaSQL);
//		dbh.cerrarObjetos();
//		return filasModif;
		
		DataBaseHelperHibernate dbhh = new DataBaseHelperHibernate();
		dbhh.insertarRegistro(this);
		
		return 0;
	}
	
	
	
	//PENDIENTE DE HIBERNATE
	public Proveedor buscarProveedor(int ID) throws DataBaseException {
		System.out.println("ID RECIBIDO DE PROVEEDOR: "+ID);
		String SQL ="SELECT * FROM proveedores WHERE id_prov="+ID;
		DataBaseHelper dbh  = new DataBaseHelper();
		List<Proveedor> listaDeProveedores = dbh.seleccionarRegistros(SQL, Proveedor.class);		
		dbh.cerrarObjetos();
		return  listaDeProveedores.get(0);
	}
	
	public void editarProveedor(int ID)throws DataBaseException {
//		DataBaseHelper dbh = new DataBaseHelper();
//		int filasModif=dbh.actualizarProveedor(ID, this);
//		dbh.cerrarObjetos();
//		System.out.println("FILAS MODIFICADAS: "+filasModif);
		
		DataBaseHelperHibernate dbhh = new DataBaseHelperHibernate();
		this.setid_prov(ID);
		dbhh.actualizarRegistro(this);
	}
	
}
