package servicios;

import java.util.List;

import beans.Categoria;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;

public class ServicioCategoriasImpl implements ServicioCategorias{

	private CategoriaDAO catDao=null;
	
	public ServicioCategoriasImpl() {
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		this.catDao=factoria.getCategoriaDAO();
	}
	 
	
	@Override
	public void insertar(Categoria categoria) {
		catDao.insertar(categoria);
		
	}

	@Override
	public List<Categoria> buscarTodos() {
		return catDao.buscarTodos();
	}

	@Override
	public void borrar(Categoria categoria) {
		System.out.println("ENTRO BORRAR CAT");
		catDao.borrar(categoria);
		
	}

	@Override
	public void guardarCambios(Categoria categoria) {
		System.out.println("ENTRO guardar CAT");
		catDao.guardarCambios(categoria);
		
	}

	@Override
	public Categoria buscarPorClave(Integer id) {
		return catDao.buscarPorClave(id);
	}
	
}
