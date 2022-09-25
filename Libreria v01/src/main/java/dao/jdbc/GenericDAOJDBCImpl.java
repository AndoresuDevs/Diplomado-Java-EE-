package dao.jdbc;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import beans.Categoria;
import beans.Libro;
import beans.Proveedor;
import dao.GenericDAO;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelper;

public abstract class GenericDAOJDBCImpl <T, Id extends Serializable> implements GenericDAO<T,Id>{
	
	private Class<T> claseDePersitencia;
	
	
	@SuppressWarnings("unchecked")
	public GenericDAOJDBCImpl() {
		this.claseDePersitencia=(Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];		 
	}
	
	
	public T buscarPorClave(Id id) {
		T objeto=null;
		String query=null;
		if(claseDePersitencia.getSimpleName().equals("Libro")) {
			query="SELECT * FROM libros WHERE num_lib="+id;
		}else if(claseDePersitencia.getSimpleName().equals("Categoria")) {
			query="SELECT * FROM categorias WHERE id_cat="+id;
		}else {
			query="SELECT * FROM proveedores WHERE id_prov="+id;
		}
		try {
			
			objeto=(T) new DataBaseHelper<T>().seleccionarRegistros(query, claseDePersitencia).get(0);
		} catch (DataBaseException e) {
			e.printStackTrace();
		}
		
		return objeto;
	}
	
	public List<T> buscarTodos(){
		List<T>lista=null;
		String query=null;
		if(claseDePersitencia.getSimpleName().equals("Libro")) {
			query="SELECT * FROM libros";
		}else if(claseDePersitencia.getSimpleName().equals("Categoria")) {
			query="SELECT * FROM categorias";
		}else {
			query="SELECT * FROM proveedores";
		}
		try {
			lista=new DataBaseHelper<T>().seleccionarRegistros(query, claseDePersitencia);
		} catch (DataBaseException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void borrar(T objeto) {
		String query=null;
		
		if(claseDePersitencia.getSimpleName().equals("Libro")) 
		{
			Libro l = (Libro)objeto;
			query="DELETE FROM libros WHERE num_lib="+l.getnum_lib();
		}
		else if(claseDePersitencia.getSimpleName().equals("Categoria")) 
		{
			Categoria c = (Categoria)objeto;
			query="DELETE FROM categorias WHERE id_cat="+c.getid_cat();
		}
		else 
		{
			Proveedor p = (Proveedor)objeto;
			query="DELETE FROM proveedores WHERE id_prov="+p.getid_prov();
		}
		try {
			new DataBaseHelper<T>().modificarRegistro(query);
		} catch (DataBaseException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void insertar(T objeto) {
		
		//INSERT INTO `categorias`(`id_cat`, `nom_cat`) VALUES ('','Prueba CONSOLA SQL')
		System.out.println("ENTRO INSERTAR JDBC");
		String query=null;
		
		if(claseDePersitencia.getSimpleName().equals("Libro")) 
		{
			Libro l = (Libro)objeto;
			query="INSERT INTO libros (num_lib, isbn_lib, tit_lib, cat_lib, pre_lib) VALUES (NULL,'"+l.getisbn_lib()+"','"+l.gettit_lib()+"','"+l.getcat_lib()+"','"+l.getpre_lib()+"')";
		}
		else if(claseDePersitencia.getSimpleName().equals("Categoria")) 
		{
			Categoria c = (Categoria)objeto;
			//query="INSERT INTO categorias(id_cat, nom_cat) VALUES ('','"+c.getnom_cat()+"')";
			query="INSERT INTO categorias(id_cat, nom_cat) VALUES (NULL,'"+c.getnom_cat()+"')";
		}
		else 
		{
			Proveedor p = (Proveedor)objeto;
			query="INSERT INTO proveedores(id_prov, nom_prov, tel_prov, dir_prov) VALUES (NULL,'"+p.getnom_prov()+"','"+p.gettel_prov()+"','"+p.getdir_prov()+"')";
		}
		try {
			new DataBaseHelper<T>().modificarRegistro(query);
		} catch (DataBaseException e) {
			e.printStackTrace();
		}
	}
	
	public void guardarCambios(T objeto) {
		String query=null;
		if(claseDePersitencia.getSimpleName().equals("Categoria")) {
			Categoria c = (Categoria)objeto;
			System.out.println("CATEGORIA:");
			System.out.println("ID : "+c.getid_cat());
			System.out.println("NOM: "+c.getnom_cat());
		}
		
		if(claseDePersitencia.getSimpleName().equals("Libro")) 
		{
			Libro l = (Libro)objeto;
			query="UPDATE `libros` SET isbn_lib='"+l.getisbn_lib()+"',tit_lib='"+l.gettit_lib()+"',cat_lib="+l.getcat_lib()+",pre_lib="+l.getpre_lib()+" WHERE num_lib="+l.getnum_lib();
		}
		else if(claseDePersitencia.getSimpleName().equals("Categoria")) 
		{
			Categoria c = (Categoria)objeto;
			query="UPDATE `categorias` SET nom_cat='"+c.getnom_cat()+"' WHERE id_cat="+c.getid_cat();
			System.out.println(query);
		}
		else 
		{
			Proveedor p = (Proveedor)objeto;
			query="UPDATE `proveedores` SET nom_prov='"+p.getnom_prov()+"',tel_prov='"+p.gettel_prov()+"',dir_prov='"+p.getdir_prov()+"' WHERE id_prov="+p.getid_prov();
		}
		try {
			new DataBaseHelper<T>().modificarRegistro(query);
		} catch (DataBaseException e) {
			e.printStackTrace();
		}
	}
	
}
