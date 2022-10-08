package repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import beans.Libro;


@Repository
public interface LibroRepository extends JpaRepository<Libro,Integer>{
		/*
		@Query(value="SELECT * FROM Libros INNER JOIN Categorias ON cat_lib = id_cat INNER JOIN Proveedores ON prov_lib = id_prov"
				+ "", nativeQuery=true)
		public List<Libro> findListLibros();
		*/
	
	
}
