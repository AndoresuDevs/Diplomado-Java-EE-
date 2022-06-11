package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import beans.Libro;
import beans.Proveedor;
import javaEEJDBC.JPAHelper;

public interface ProveedorDAO {
	
	public abstract void insertar(Proveedor prov);
	public abstract List<Proveedor> buscarTodos();
	public abstract void borrar(Proveedor prov);
	public abstract void guardarCambios(Proveedor prov);
	public abstract Proveedor buscarPorClave(Integer id);
	
}
