package servicios;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.Categoria;
import dao.CategoriaDAO;

@Service
public class ServicioCategoriasImpl implements ServicioCategorias{

	private CategoriaDAO catDAO=null;
	
	@Override
	@Transactional
	public void insertar(Categoria categoria) {
		catDAO.insertar(categoria);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Categoria> buscarTodos() {
		return catDAO.buscarTodos();
	}

	@Override
	@Transactional
	public void borrar(Categoria categoria) {
		System.out.println("ENTRO BORRAR CAT");
		catDAO.borrar(categoria);
		
	}

	@Override
	@Transactional
	public void guardarCambios(Categoria categoria) {
		catDAO.guardarCambios(categoria);
	}

	@Override
	@Transactional(readOnly=true)
	public Categoria buscarPorClave(Integer id) {
		return catDAO.buscarPorClave(id);
	}

	@Override
	@Transactional
	public CategoriaDAO getcatDAO() {
		
		return catDAO;
	}


	@Override
	@Transactional
	public void setcatDAO(CategoriaDAO cat) {
		this.catDAO = cat;
	}
	
	
	
}
