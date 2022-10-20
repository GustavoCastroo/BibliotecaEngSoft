package controller;

import model.Entidade;

public class LivroController extends Controller {
	private static LivroController livroController; 
	
	private LivroController(){}
	
	public synchronized static LivroController getInstance() {
		if (livroController == null) {
			livroController = new LivroController();
		}
		return livroController;
	}
	
	public void cadastrar(Entidade ent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Entidade ent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Entidade ent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entidade buscar(String string) {
		
		return null;
	}

	@Override
	public Entidade buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
