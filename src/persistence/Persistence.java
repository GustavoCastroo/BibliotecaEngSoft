package persistence;

import model.Entidade;

public abstract class Persistence {
	
	public abstract void cadastrar(Entidade ent);
	
	public abstract void alterar(Entidade ent);
	
	public abstract void excluir(Entidade ent);
	
	public abstract Entidade buscar(String string);
	
	public abstract Entidade buscar(Integer id);
}
