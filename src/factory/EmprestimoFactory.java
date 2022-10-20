package factory;

import controller.Controller;
import model.Entidade;
import view.Menu;
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
