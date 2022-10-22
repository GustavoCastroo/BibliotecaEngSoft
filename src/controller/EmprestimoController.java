package controller;

import factory.EmprestimoFactory;
import model.Entidade;
import persistence.EmprestimoPersistence;


public class EmprestimoController extends Controller {
	
	@Override
	public void cadastrar(Entidade ent) {
		EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
		EmprestimoPersistence emprestimoPersistence = (EmprestimoPersistence) emprestimoFactory.createPersistence();

		emprestimoPersistence.cadastrar(ent);		
	}

	@Override
	public void alterar(Entidade ent) {
		EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
		EmprestimoPersistence emprestimoPersistence = (EmprestimoPersistence) emprestimoFactory.createPersistence();

		emprestimoPersistence.alterar(ent);
	}

	@Override
	public void excluir(Entidade ent) {
		EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
		EmprestimoPersistence emprestimoPersistence = (EmprestimoPersistence) emprestimoFactory.createPersistence();

		emprestimoPersistence.excluir(ent);		
	}

	@Override
	public Entidade buscar(String string) {
		EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
		EmprestimoPersistence emprestimoPersistence = (EmprestimoPersistence) emprestimoFactory.createPersistence();

		return emprestimoPersistence.buscar(string);
	}

	@Override
	public Entidade buscar(Integer id) {
		EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
		EmprestimoPersistence emprestimoPersistence = (EmprestimoPersistence) emprestimoFactory.createPersistence();

		return emprestimoPersistence.buscar(id);
	}
}
