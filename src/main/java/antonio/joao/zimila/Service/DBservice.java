package antonio.joao.zimila.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antonio.joao.zimila.Objects.Categoria;
import antonio.joao.zimila.Objects.Livro;
import antonio.joao.zimila.Repositories.CategoriaRepository;
import antonio.joao.zimila.Repositories.LivroRepository;

@Service
public class DBservice {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	public void instaciaBaseDeDados(){

		Categoria c2 =new Categoria(null,"Matematica","Logs senos");
		Categoria c3=new Categoria(null,"Portugues","verbos atributos");
		
	    Livro lv2 = new Livro(null,"Pitagoras","Author","txitixt",c2);
	    Livro lv3= new Livro(null,"Pinto","Jose Craverinha","txitixt",c2);
		
		c2.getLivros().addAll(Arrays.asList(lv2,lv3));
		
		 this.categoriaRepository.saveAll(Arrays.asList(c2,c3));
		 this.livroRepository.saveAll(Arrays.asList(lv2,lv3));
		
	}

}
