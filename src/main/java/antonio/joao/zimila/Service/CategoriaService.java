package antonio.joao.zimila.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antonio.joao.zimila.DTOs.CategoriaDTO;
import antonio.joao.zimila.Exceptions.DataIntegrityViolationeException;
import antonio.joao.zimila.Exceptions.ObjectNotFoundException;
import antonio.joao.zimila.Objects.Categoria;
import antonio.joao.zimila.Repositories.CategoriaRepository;
@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id); 
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objecto nao encontrado! Id: "+id+", Tipo:"+Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
		
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj =findById(id);
		obj.setNome(objDto.getNome());	
		obj.setDescricao(objDto.getDescricao());
		
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) {
		
		findById(id);
		
		try {
			categoriaRepository.deleteById(id);
			
		} catch (DataIntegrityViolationeException e) {
			throw new DataIntegrityViolationeException("Categoria nao pode ser deletada possui livros associados.");
		}
		
	}


}
