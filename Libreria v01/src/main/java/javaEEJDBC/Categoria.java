package javaEEJDBC;


import java.util.List;

public class Categoria {
	private int id_cat;
	private String nom_cat;
	
	public Categoria(int ID, String Categoria) {
		//super();
		this.id_cat=ID;
		this.nom_cat=Categoria;
	}
	
	

	public Categoria() {
	
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



	//CAMBIAR LOS ARRAYLIST POR LIST (SOLO LO PRIMERO Y EL RETORNO)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Categoria> buscarCategorias() throws DataBaseException {
		String consultaSQL="SELECT * FROM categorias";
		DataBaseHelper dbh = new DataBaseHelper();
		List <Categoria>ListaDeCategorias=dbh.seleccionarRegistros(consultaSQL, Categoria.class);
		
		
		dbh.cerrarObjetos();
		return ListaDeCategorias;
	}
	
	
	
}
