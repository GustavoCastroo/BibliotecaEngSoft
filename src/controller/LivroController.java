package controller;

import java.io.IOException;
import java.util.List;

import factory.LivroFactory;
import model.Entidade;
import persistence.LivroPersistence;

public class LivroController extends Controller {
	
	public void cadastrar(Entidade ent) throws IOException {
		LivroFactory livroFactory = LivroFactory.getInstance();
		LivroPersistence livroPersistence = (LivroPersistence) livroFactory.createPersistence();

		livroPersistence.cadastrar(ent);
	}

	@Override
	public void alterar(Entidade ent) throws IOException {
		LivroFactory livroFactory = LivroFactory.getInstance();
		LivroPersistence livroPersistence = (LivroPersistence) livroFactory.createPersistence();
		
		livroPersistence.alterar(ent);		
	}

	@Override
	public void excluir(Entidade ent) throws IOException {
		LivroFactory livroFactory = LivroFactory.getInstance();
		LivroPersistence livroPersistence = (LivroPersistence) livroFactory.createPersistence();
		
		livroPersistence.excluir(ent);
	}

	@Override
	public List<Entidade> buscar(String string) throws IOException {
		LivroFactory livroFactory = LivroFactory.getInstance();
		LivroPersistence livroPersistence = (LivroPersistence) livroFactory.createPersistence();
		
		return livroPersistence.buscar(string);
	}

	@Override
	public Entidade buscar(Integer id) throws IOException {
		LivroFactory livroFactory = LivroFactory.getInstance();
		LivroPersistence livroPersistence = (LivroPersistence) livroFactory.createPersistence();
		
		return livroPersistence.buscar(id);
	}
}
