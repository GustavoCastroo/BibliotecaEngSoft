package persistence;

import java.util.LinkedList;
import java.util.List;
import model.Emprestimo;
import model.Entidade;

public class EmprestimoPersistence extends Persistence {
	private static EmprestimoPersistence emprestimoPersistence; 
	private List<Emprestimo> emprestimos = new LinkedList<Emprestimo>();
	
	private EmprestimoPersistence(){}
	
	public synchronized static EmprestimoPersistence getInstance() {
		if (emprestimoPersistence == null) {
			emprestimoPersistence = new EmprestimoPersistence();
		}
		return emprestimoPersistence;
	}

	@Override
	public void cadastrar(Entidade ent) {
		
		emprestimos.add((Emprestimo)ent);	
	}

	@Override
	public void alterar(Entidade ent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Entidade ent) {
		
		emprestimos.remove((Emprestimo)ent);
	}

	@Override
	public Entidade buscar(String string) {
		for(Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getMatriculaAluno().equals(string)) {
				return emprestimo;
			}
		}
		return null;
	}

	@Override
	public Entidade buscar(Integer id) {
		for(Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getId().equals(id)) {
				return emprestimo;
			}
		}
		return null;
	}
}
