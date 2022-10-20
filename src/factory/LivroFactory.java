package factory;

import controller.Controller;
import model.Entidade;
import view.Menu;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu createMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidade createEntidade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persistence createPersistence() {
		// TODO Auto-generated method stub
		return null;
	}

}
