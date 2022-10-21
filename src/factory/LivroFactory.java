package factory;

import controller.Controller;
import controller.LivroController;
import model.Entidade;
import model.Livro;
import view.LivroMenu;
import view.Menu;
import persistence.LivroPersistence;
import persistence.Persistence;

public class LivroFactory extends Factory {
	private static LivroFactory livroFactory; 

	private LivroFactory() {}
	
	public synchronized static LivroFactory getInstance() {
		if (livroFactory == null) {
			livroFactory = new LivroFactory();
		}
		return livroFactory;
	}
	
	@Override
	public Controller createController() {
	
		return new LivroController();
	}

	@Override
	public Menu createMenu() {
		
		return new LivroMenu();
	}

	@Override
	public Entidade createEntidade() {
		
		return new Livro();
	}

	@Override
	public Persistence createPersistence() {
		
		return LivroPersistence.getInstance();
	}

}
