package factory;

import view.Menu;
import controller.Controller;
import model.Entidade;
import persistence.Persistence;

public abstract class Factory {
	
	public static Factory getFactory(String string) {
		
		if (string.equals("Livro")) {
			return new LivroFactory();
			
		}else {			
			return new EmprestimoFactory();	
		}
	}
	
	public abstract Controller createController();
	
	public abstract Menu createMenu();
	
	public abstract Entidade createEntidade();
	
	public abstract Persistence createPersistence();
	
}
