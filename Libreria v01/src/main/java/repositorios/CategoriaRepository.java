package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import beans.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	//public List<Categoria> findAllByListaDeLibros_CatLib(int cat);
	
	//public List<Libro> findAllByIdCat(int idCat);
}