package factory;

import view.Menu;
import controller.Controller;
import model.Entidade;
import persistence.Persistence;

public abstract class Factory {
	
	public static Factory getFactory(String string) {
		
		if (string.equals("Livro")) {
			
			LivroFactory livroFactory = LivroFactory.getInstance();
			return livroFactory;
			
		}else {
			EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
			return emprestimoFactory;	
		}
	}
	
	public abstract Controller createController();
	
	public abstract Menu createMenu();
	
	public abstract Entidade createEntidade();
	
	public abstract Persistence createPersistence();
	
}
