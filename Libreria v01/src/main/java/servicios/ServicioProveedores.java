package servicios;

import java.util.List;

import beans.Proveedor;
import dao.ProveedorDAO;

public interface ServicioProveedores {
	public abstract void insertar(Proveedor prov);
	public abstract List<Proveedor> buscarTodos();
	public abstract void borrar(Proveedor prov);
	public abstract void guardarCambios(Proveedor prov);
	public abstract Proveedor buscarPorClave(Integer id);

	public ProveedorDAO getprovDAO();
	public void setprovDAO(ProveedorDAO prov);
}
