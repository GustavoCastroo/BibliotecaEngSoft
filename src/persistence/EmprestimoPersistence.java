package persistence;

import model.Entidade;

public class EmprestimoPersistence extends Persistence {
private static EmprestimoPersistence emprestimoPersistence; 
	
	private EmprestimoPersistence(){}
	
	public synchronized static EmprestimoPersistence getInstance() {
		if (emprestimoPersistence == null) {
			emprestimoPersistence = new EmprestimoPersistence();
		}
		return emprestimoPersistence;
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
