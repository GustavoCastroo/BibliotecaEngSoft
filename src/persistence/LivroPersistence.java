package persistence;

import java.util.LinkedList;
import java.util.List;

import model.Entidade;
import model.Livro;

public class LivroPersistence extends Persistence{
	private static LivroPersistence livroPersistence; 
	private List<Livro> acervo = new LinkedList<Livro>();
	
	private LivroPersistence(){}
	
	public synchronized static LivroPersistence getInstance() {
		if (livroPersistence == null) {
			livroPersistence = new LivroPersistence();
		}
		return livroPersistence;
	}

	@Override
	public void cadastrar(Entidade ent) {
		
		acervo.add((Livro) ent);
	}

	@Override
	public void alterar(Entidade ent) {
		// Por estarmos retornando o próprio Objeto Livro na busca para o LivroMenu, 
		// ao alterarmos o objeto no LivroMenu, ele ja estará sendo alterado na memória 
	}

	@Override
	public void excluir(Entidade ent) {
		
		acervo.remove(ent);
	}

	@Override
	public Entidade buscar(String string) {
		
		for(Livro livro : acervo) {
			if (livro.getNome().equals(string)) {
				return livro;
			}
		}
		return null;
	}

	@Override
	public Entidade buscar(Integer id) {
		
		for(Livro livro : acervo) {
			if (livro.getId().equals(id)) {
				return livro;
			}
		}
		return null;
	}
}
