package servicios;

import java.util.List;

import beans.Proveedor;

public interface ServicioProveedores {
	public abstract void insertar(Proveedor prov);
	public abstract List<Proveedor> buscarTodos();
	public abstract void borrar(Proveedor prov);
	public abstract void guardarCambios(Proveedor prov);
	public abstract Proveedor buscarPorClave(Integer id);
}
