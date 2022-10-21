package factory;

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

	protected EmprestimoFactory() {}
	
	public synchronized static EmprestimoFactory getInstance() {
		if (emprestimoFactory == null) {
			emprestimoFactory = (EmprestimoFactory) Factory.getFactory("Emprestimo");
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
	public Persistence createPersistence() {
		
		return EmprestimoPersistence.getInstance();
	}
}
