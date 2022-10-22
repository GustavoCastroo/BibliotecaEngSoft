package controller;

import factory.LivroFactory;
import model.Entidade;
import persistence.LivroPersistence;

public class LivroController extends Controller {
	
	public void cadastrar(Entidade ent) {
		LivroFactory livroFactory = LivroFactory.getInstance();
		LivroPersistence livroPersistence = (LivroPersistence) livroFactory.createPersistence();

		livroPersistence.cadastrar(ent);
	}

	@Override
	public void alterar(Entidade ent) {
		LivroFactory livroFactory = LivroFactory.getInstance();
		LivroPersistence livroPersistence = (LivroPersistence) livroFactory.createPersistence();
		
		livroPersistence.alterar(ent);		
	}

	@Override
	public void excluir(Entidade ent) {
		LivroFactory livroFactory = LivroFactory.getInstance();
		LivroPersistence livroPersistence = (LivroPersistence) livroFactory.createPersistence();
		
		livroPersistence.excluir(ent);
	}

	@Override
	public Entidade buscar(String string) {
		LivroFactory livroFactory = LivroFactory.getInstance();
		LivroPersistence livroPersistence = (LivroPersistence) livroFactory.createPersistence();
		
		return livroPersistence.buscar(string);
	}

	@Override
	public Entidade buscar(Integer id) {
		LivroFactory livroFactory = LivroFactory.getInstance();
		LivroPersistence livroPersistence = (LivroPersistence) livroFactory.createPersistence();
		
		return livroPersistence.buscar(id);
	}
}
