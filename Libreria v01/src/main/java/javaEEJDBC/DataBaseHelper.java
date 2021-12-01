package javaEEJDBC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper<T> extends Libro{

	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost/libreria";
	private static final String USUARIO ="JavaEE";
	private static final String CLAVE ="12345";
	
	Connection con=null;
	Statement stm=null;
	
	public DataBaseHelper() throws DataBaseException{
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USUARIO,CLAVE);
			if(con!=null) {
				//System.out.println("Conexion exitosa!");
			}
		}catch( SQLException e) {
			System.out.println("Error de SQL: "+e.getMessage());
			throw new DataBaseException("Error de SQL");
		} catch (ClassNotFoundException e) {
			
			System.out.println("CLASE NO ENCONTRADA: "+e.getMessage());
			throw new DataBaseException("Clase No Encontrada");
		}
	}

	//EL THROWS RETORNA EL ERROR A DONDE FUE LLAMADO, EL TRY CATCH USUALMENTE IMPRIME LA E.PRINTSTACKTRACE EN LA CONSOLA
	public int modificarRegistro(String querySQL) throws DataBaseException {
		int filasAfectadas=0;
		
		try {
			stm = con.createStatement();
			filasAfectadas =  stm.executeUpdate(querySQL);
		} catch (SQLException e) {
			System.out.println("Error de SQL: "+e.getMessage());
			throw new DataBaseException("Error de SQL");
		}
		
		
		cerrarObjetos();
		return filasAfectadas;
	}
	
	public void cerrarObjetos() {
		try {
			if(stm!=null) stm.close();
			if(con!=null) con.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> seleccionarRegistros(String query, Class clase) throws DataBaseException
	{
		ResultSet filas=null;
		List<T>listaDeObjetos=new ArrayList<T>();
		try {
			stm = con.createStatement();
			filas=stm.executeQuery(query);
			while(filas.next()) {
				
				T objeto = (T) Class.forName( //FORNAME BUSCA LA RUTA DONDE ESTA LA CLASE QUE SE LLAME IGUAL
						clase.getName()).getDeclaredConstructor().newInstance(); //LUEGO SE TRAE SU CONTRUCTOR Y SE INSTANCIA
				Method[]metodos=objeto.getClass().getDeclaredMethods();
				
				for(int i=0; i<metodos.length;i++) {
					if(metodos[i].getName().startsWith("set")) {
						
						//IF POR SI NUESTOR VALOR ES INTEGER
						if((metodos[i].getName().substring(3)).equals("num_lib") || metodos[i].getName().substring(3).equals("cat_lib")|| metodos[i].getName().substring(3).equals("id_cat")) {
							metodos[i].invoke(objeto, filas.getInt(metodos[i].getName().substring(3)));
						}else
						//IF POR SI NUESTRO VALOR ES FLOTANTE
						if((metodos[i].getName().substring(3)).equals("pre_lib")) {
							metodos[i].invoke(objeto, filas.getFloat(metodos[i].getName().substring(3)));
						}else {
							metodos[i].invoke(objeto, filas.getString(metodos[i].getName().substring(3)));
						}
						
					}else if(objeto.getClass().getName().equals("java.lang.Integer")) { //PROBABLEMENTE NO SIRVE ESTE ELSE IF
						objeto = (T)(""+filas.getInt("cat_lib")); //EFECTIVAMENTE NO SIRVE ESTA VALIDACION
					}		
				}
				listaDeObjetos.add(objeto);
				
			}
		}catch(SQLException|InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			//e.printStackTrace();
			System.out.println("Error al seleccionar registros: "+e.getMessage());
			throw new DataBaseException("Error al leer registros");
		}
		return listaDeObjetos;
	}
	
	public int actualizarRegistro(int id, Libro lib) {
		String SQL ="UPDATE libros SET isbn_lib=?, tit_lib=?, cat_lib=?, pre_lib=? WHERE num_lib=?";
		int filas=0;
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, lib.getisbn_lib());
			ps.setString(2, lib.gettit_lib());
			ps.setInt(3, lib.getcat_lib());
			ps.setFloat(4, lib.getpre_lib());
			ps.setInt(5, id);
			filas=ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		this.cerrarObjetos();
		return filas;
	}
	
	
}