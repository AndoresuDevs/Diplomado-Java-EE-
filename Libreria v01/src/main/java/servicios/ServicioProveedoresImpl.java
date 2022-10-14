package servicios;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import beans.Proveedor;
import dao.ProveedorDAO;

@Service
public class ServicioProveedoresImpl implements ServicioProveedores {
	private ProveedorDAO provDAO=null;
	
	@Override
	@Transactional
	public void insertar(Proveedor prov) 
	{
		provDAO.insertar(prov);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Proveedor> buscarTodos() 
	{
		return provDAO.buscarTodos();
	}

	@Override
	@Transactional
	public void borrar(Proveedor prov) 
	{
		provDAO.borrar(prov);
	}

	@Override
	@Transactional
	public void guardarCambios(Proveedor prov) {
		// TODO Auto-generated method stub
		provDAO.guardarCambios(prov);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Proveedor buscarPorClave(Integer id) 
	{
		return provDAO.buscarPorClave(id);
	}

	@Override
	@Transactional
	public ProveedorDAO getprovDAO() 
	{
		return provDAO;
	}


	@Override
	@Transactional
	public void setprovDAO(ProveedorDAO prov) 
	{
		this.provDAO = prov;
	}
	
	

}
