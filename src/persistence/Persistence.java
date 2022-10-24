package persistence;

import java.io.IOException;
import java.util.List;

import model.Entidade;

public abstract class Persistence {
	
	public abstract void cadastrar(Entidade ent) throws IOException;
	
	public abstract void alterar(Entidade ent) throws IOException;
	
	public abstract void excluir(Entidade ent) throws IOException;
	
	public abstract List<Entidade> buscar(String string);
	
	public abstract Entidade buscar(Integer id);
}
