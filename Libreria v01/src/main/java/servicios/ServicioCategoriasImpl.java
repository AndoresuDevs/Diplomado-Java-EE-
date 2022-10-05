package servicios;

import java.util.List;

import beans.Categoria;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;

public class ServicioCategoriasImpl implements ServicioCategorias{

	private CategoriaDAO catDAO=null;
	
	public ServicioCategoriasImpl() {
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		this.catDAO=factoria.getCategoriaDAO();
	}
	 
	
	@Override
	public void insertar(Categoria categoria) {
		catDAO.insertar(categoria);
		
	}

	@Override
	public List<Categoria> buscarTodos() {
		return catDAO.buscarTodos();
	}

	@Override
	public void borrar(Categoria categoria) {
		System.out.println("ENTRO BORRAR CAT");
		catDAO.borrar(categoria);
		
	}

	@Override
	public void guardarCambios(Categoria categoria) {
		System.out.println("ENTRO guardar CAT");
		catDAO.guardarCambios(categoria);
	}

	@Override
	public Categoria buscarPorClave(Integer id) {
		return catDAO.buscarPorClave(id);
	}

	@Override
	public CategoriaDAO getcatDAO() {
		
		return catDAO;
	}


	@Override
	public void setcatDAO(CategoriaDAO cat) {
		this.catDAO = cat;
	}
	
	
	
}
