package servicios;

import java.util.List;

import beans.Proveedor;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.ProveedorDAO;

public class ServicioProveedoresImpl implements ServicioProveedores {
	private ProveedorDAO provDAO=null;
	
	public ServicioProveedoresImpl() {
		DAOFactory factoria = DAOAbstractFactory.getInstance() ;
		this.provDAO=factoria.getProveedorDao();
	}
	
	
	@Override
	public void insertar(Proveedor prov) {
		// TODO Auto-generated method stub
		provDAO.insertar(prov);
	}

	@Override
	public List<Proveedor> buscarTodos() {
		// TODO Auto-generated method stub
		return provDAO.buscarTodos();
	}

	@Override
	public void borrar(Proveedor prov) {
		// TODO Auto-generated method stub
		provDAO.borrar(prov);
	}

	@Override
	public void guardarCambios(Proveedor prov) {
		// TODO Auto-generated method stub
		provDAO.guardarCambios(prov);
		
	}

	@Override
	public Proveedor buscarPorClave(Integer id) {
		// TODO Auto-generated method stub
		return provDAO.buscarPorClave(id);
	}

}
