package controller;

import model.Entidade;

public class EmprestimoController extends Controller {
	private static EmprestimoController emprestimoController; 
	
	private EmprestimoController(){}
	
	public synchronized static EmprestimoController getInstance() {
		if (emprestimoController == null) {
			emprestimoController = new EmprestimoController();
		}
		return emprestimoController;
	}
	
	@Override
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidade buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
