package controller;

import java.io.IOException;
import java.util.List;

import factory.EmprestimoFactory;
import model.Entidade;
import persistence.EmprestimoPersistence;


public class EmprestimoController extends Controller {
	
	@Override
	public void cadastrar(Entidade ent) throws IOException {
		EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
		EmprestimoPersistence emprestimoPersistence = (EmprestimoPersistence) emprestimoFactory.createPersistence();

		emprestimoPersistence.cadastrar(ent);		
	}

	@Override
	public void alterar(Entidade ent) throws IOException {
		EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
		EmprestimoPersistence emprestimoPersistence = (EmprestimoPersistence) emprestimoFactory.createPersistence();

		emprestimoPersistence.alterar(ent);
	}

	@Override
	public void excluir(Entidade ent) throws IOException {
		EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
		EmprestimoPersistence emprestimoPersistence = (EmprestimoPersistence) emprestimoFactory.createPersistence();

		emprestimoPersistence.excluir(ent);		
	}

	@Override
	public List<Entidade> buscar(String string) throws IOException {
		EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
		EmprestimoPersistence emprestimoPersistence = (EmprestimoPersistence) emprestimoFactory.createPersistence();

		return emprestimoPersistence.buscar(string);
	}

	@Override
	public Entidade buscar(Integer id) throws IOException {
		EmprestimoFactory emprestimoFactory = EmprestimoFactory.getInstance();
		EmprestimoPersistence emprestimoPersistence = (EmprestimoPersistence) emprestimoFactory.createPersistence();

		return emprestimoPersistence.buscar(id);
	}
}
