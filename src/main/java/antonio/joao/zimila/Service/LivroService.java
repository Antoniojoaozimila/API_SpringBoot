package antonio.joao.zimila.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antonio.joao.zimila.Exceptions.ObjectNotFoundException;
import antonio.joao.zimila.Objects.Categoria;
import antonio.joao.zimila.Objects.Livro;
import antonio.joao.zimila.Repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id); 
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objecto nao encontrado! Id: "+id+", Tipo:"+Livro.class.getName()));
	}
	
	
	public List<Livro> findAll(Integer id_cat) {
		// TODO Auto-generated method stub
		categoriaService.findById(id_cat);
		return livroRepository.findAllByCategoria(id_cat);
	}
	
	
	public Livro update(Integer id, Livro obj) {
		// TODO Auto-generated method stub
		Livro newObj =findById(id);
		updateData(newObj,obj);
		return livroRepository.save(newObj);
	}
	
	
	private void updateData(Livro newObj, Livro obj) {
		// TODO Auto-generated method stub
		newObj.setAutor(obj.getAutor());
		newObj.setTexto(obj.getTexto());
		newObj.setTitulo(obj.getTitulo());
	}
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
		Livro obj = findById(id);
		
		livroRepository.delete(obj);
		
		
	}


	public Livro create(Integer id_cat, Livro obj) {
		// TODO Auto-generated method stub
		obj.setId(null);
		
		Categoria cat =categoriaService.findById(id_cat);
		
		obj.setCategoria(cat);
		return livroRepository.save(obj);
		
	}


}
