package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import factory.Factory;
import factory.LivroFactory;
import model.Entidade;
import model.Livro;

public class LivroPersistence extends Persistence{
	static java.io.File diretorioAcervo = new java.io.File("C:\\Users\\gusta\\Desktop\\UFSJ\\POO\\eclipse-workspace\\BibliotecaEngSoft");	
	static java.io.File arquivoAcervo = new java.io.File(diretorioAcervo, "Arquivo Acervo.txt");
	private static FileWriter fileWriter = null;
	private static PrintWriter printWriter = null;
	private static LivroPersistence livroPersistence; 
	private static List<Livro> acervo = new LinkedList<Livro>();
	
	private LivroPersistence(){}
	
	public synchronized static LivroPersistence getInstance() throws IOException {
		if (livroPersistence == null) {
			livroPersistence = new LivroPersistence();
		}
		lerArquivo();
		return livroPersistence;
	}

	@Override
	public void cadastrar(Entidade ent) throws IOException {
		
		acervo.add((Livro) ent);
		alterarArquivo();
	}

	@Override
	public void alterar(Entidade ent) throws IOException {
		alterarArquivo();
	}

	@Override
	public void excluir(Entidade ent) throws IOException {
		
		acervo.remove((Livro)ent);
		alterarArquivo();
	}

	@Override
	public List<Entidade> buscar(String string) {
		List<Entidade> resultado = new LinkedList<Entidade>();
		
		for(Entidade livro : acervo) {
			if (((Livro) livro).getNome().equals(string)) {
				resultado.add(livro);
			}
		}
		return resultado;	
	}

	@Override
	public Entidade buscar(Integer id) {
		
		for(Livro livro : acervo) {
			if (livro.getId().equals(id)) {
				return livro;
			}
		}
		return null;
	}
	
	public static void lerArquivo() throws IOException {
		
		LivroFactory livroFactory = (LivroFactory) Factory.getFactory("Livro");		
		
		if (arquivoAcervo.exists()) {
			FileReader fileReader = new FileReader(arquivoAcervo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while (bufferedReader.ready()) {
				Livro livro = (Livro) livroFactory.createEntidade();				
				
				String linha = bufferedReader.readLine();
				if (linha.contains("@")) {
					String conteudo[] = linha.split("@");
					livro.setId(Integer.parseInt(conteudo[1]));
					acervo.add(livro);
				}
				if (linha.contains("#")) {
					String conteudo[] = linha.split("#");
					int size = acervo.size();
					livro = acervo.get(size - 1);
					livro.setNome(conteudo[1]);
					
				}
				if (linha.contains("%")) {
					String conteudo[] = linha.split("%");				
					int size = acervo.size();
					livro = acervo.get(size - 1);
					livro.setAutor(conteudo[1]);
				}
				if (linha.contains("&")) {
					String conteudo[] = linha.split("&");				
					int size = acervo.size();
					livro = acervo.get(size - 1);					
					livro.setEdicao(Integer.parseInt(conteudo[1]));
				}				
			}	
			bufferedReader.close();
			fileReader.close();		
		}				
	}
		
	public void escreverArquivo(Entidade entidade) throws IOException {
		fileWriter = new FileWriter(arquivoAcervo, true);
		printWriter = new PrintWriter(fileWriter);
		
		printWriter.println("***** LIVRO ****\n");
		printWriter.println("Identificador numérico: @" + ((Livro)entidade).getId() + "@.");
		printWriter.println("Nome: #" + ((Livro)entidade).getNome() + "#.");
		printWriter.println("Autor: %" + ((Livro)entidade).getAutor() + "%.");
		printWriter.println("Edição: &" + ((Livro)entidade).getEdicao() + "&.\n");
		
		printWriter.flush();
		printWriter.close();
	}
	
	public void alterarArquivo() throws IOException {
		arquivoAcervo.delete();
		for (Livro livro : acervo)
			escreverArquivo(livro);

	}

}
