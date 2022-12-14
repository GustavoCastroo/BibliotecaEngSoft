package factory;

import java.io.IOException;

import controller.Controller;
import controller.EmprestimoController;
import model.Emprestimo;
import model.Entidade;
import view.EmprestimoMenu;
import view.Menu;
import persistence.EmprestimoPersistence;
import persistence.Persistence;

public class EmprestimoFactory extends Factory{
	private static EmprestimoFactory emprestimoFactory; 

	private EmprestimoFactory() {}
	
	public synchronized static EmprestimoFactory getInstance() {
		if (emprestimoFactory == null) {
			emprestimoFactory = new EmprestimoFactory();
		}
		return emprestimoFactory;
	}
	
	@Override
	public Controller createController() {
		
		return new EmprestimoController();
	}

	@Override
	public Menu createMenu() {
		
		return new EmprestimoMenu();
	}

	@Override
	public Entidade createEntidade() {
		
		return new Emprestimo();
	}

	@Override
	public Persistence createPersistence() throws IOException {
		
		return EmprestimoPersistence.getInstance();
	}
}
