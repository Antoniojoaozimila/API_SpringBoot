package antonio.joao.zimila.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import antonio.joao.zimila.Objects.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria ,Integer>{

}
