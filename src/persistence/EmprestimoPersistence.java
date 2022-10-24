package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import factory.EmprestimoFactory;
import factory.Factory;
import factory.LivroFactory;
import model.Emprestimo;
import model.Entidade;
import model.Livro;

public class EmprestimoPersistence extends Persistence {
	static java.io.File diretorioEmprestimo = new java.io.File("C:\\Users\\gusta\\Desktop\\UFSJ\\POO\\eclipse-workspace\\BibliotecaEngSoft");	
	static java.io.File arquivoEmprestimo = new java.io.File(diretorioEmprestimo, "Arquivo Emprestimo.txt");
	private static FileWriter fileWriter = null;
	private static PrintWriter printWriter = null;
	private static EmprestimoPersistence emprestimoPersistence; 
	private static List<Emprestimo> emprestimos = new LinkedList<Emprestimo>();
	
	private EmprestimoPersistence(){}
	
	public synchronized static EmprestimoPersistence getInstance() throws IOException {
		if (emprestimoPersistence == null) {
			emprestimoPersistence = new EmprestimoPersistence();
		}
		lerArquivo();
		return emprestimoPersistence;
	}

	@Override
	public void cadastrar(Entidade ent) throws IOException {
		
		emprestimos.add((Emprestimo)ent);
		alterarArquivo();
	}

	@Override
	public void alterar(Entidade ent) throws IOException {
		
		alterarArquivo();
	}

	@Override
	public void excluir(Entidade ent) throws IOException {
		
		emprestimos.remove((Emprestimo)ent);
		alterarArquivo();
	}

	
	public List<Entidade> buscar(String string) {
		List<Entidade> resultado = new LinkedList<Entidade>();
		
		for(Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getMatriculaAluno().equals(string)) {
				resultado.add(((Emprestimo)emprestimo));
			}
		}
		return resultado;
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
	
	public static void lerArquivo() throws IOException {
		LivroFactory livroFactory = (LivroFactory) Factory.getFactory("Livro");		
		EmprestimoFactory emprestimoFactory = (EmprestimoFactory) Factory.getFactory("Emprestimo");		
		
		if (arquivoEmprestimo.exists()) {
			FileReader fileReader = new FileReader(arquivoEmprestimo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while (bufferedReader.ready()) {
				Emprestimo emprestimo = (Emprestimo) emprestimoFactory.createEntidade();				
				Livro livro = (Livro) livroFactory.createEntidade();			
				
				String linha = bufferedReader.readLine();
				if (linha.contains("@")) {
					String conteudo[] = linha.split("@");
					emprestimo.setId(Integer.parseInt(conteudo[1]));
					emprestimos.add(emprestimo);
				}
				if (linha.contains("#")) {
					String conteudo[] = linha.split("#");
					int size = emprestimos.size();
					emprestimo = emprestimos.get(size - 1);
					emprestimo.setNomeAluno(conteudo[1]);
					
				}
				if (linha.contains("%")) {
					String conteudo[] = linha.split("%");				
					int size = emprestimos.size();
					emprestimo = emprestimos.get(size - 1);
					emprestimo.setMatriculaAluno(conteudo[1]);
				}
				if (linha.contains("&")) {
					String conteudo[] = linha.split("&");				
					int size = emprestimos.size();
					emprestimo = emprestimos.get(size - 1);	
					livro.setId(Integer.parseInt(conteudo[1]));
					emprestimo.getLivros().add(livro);					
				}
				
				if (linha.contains("§")) {
					String conteudo[] = linha.split("§");				
					int size = emprestimos.size();
					emprestimo = emprestimos.get(size - 1);	
					size = emprestimo.getLivros().size();
					livro = emprestimo.getLivros().get(size - 1);
					livro.setNome(conteudo[1]);										
				}
				
				if (linha.contains(";")) {
					String conteudo[] = linha.split(";");				
					int size = emprestimos.size();
					emprestimo = emprestimos.get(size - 1);	
					size = emprestimo.getLivros().size();
					livro = emprestimo.getLivros().get(size - 1);
					livro.setAutor(conteudo[1]);				
				}
				
				if (linha.contains("¨")) {
					String conteudo[] = linha.split("¨");				
					int size = emprestimos.size();
					emprestimo = emprestimos.get(size - 1);	
					size = emprestimo.getLivros().size();
					livro = emprestimo.getLivros().get(size - 1);
					livro.setEdicao(Integer.parseInt(conteudo[1]));				
				}
			}	
			bufferedReader.close();
			fileReader.close();		
		}				
	}
		
	public void escreverArquivo(Entidade entidade) throws IOException {
		fileWriter = new FileWriter(arquivoEmprestimo, true);
		printWriter = new PrintWriter(fileWriter);
		
		printWriter.println("****** EMPRÉSTIMO ******\n");
		printWriter.println("Identificador Numérico: @" + ((Emprestimo)entidade).getId() + "@.");
		printWriter.println("Nome do Aluno: #" + ((Emprestimo)entidade).getNomeAluno() + "#.");
		printWriter.println("Matrícula do Aluno: %" + ((Emprestimo)entidade).getMatriculaAluno() + "%.\n");
		printWriter.println("***** LIVROS ****\n");
		
		for(Livro livro : ((Emprestimo)entidade).getLivros()) {			
			printWriter.println("Identificador Numérico: &" + livro.getId() + "& .");
			printWriter.println("Nome: §" + livro.getNome() + "§ .");
			printWriter.println("Autor: ;" + livro.getAutor() + "; .");
			printWriter.println("Edicao: ¨" + livro.getEdicao() + "¨.\n");	
		}
					
		printWriter.flush();
		printWriter.close();
	}
	
	public void alterarArquivo() throws IOException {
		arquivoEmprestimo.delete();
		for (Emprestimo emprestimo : emprestimos)
			escreverArquivo(emprestimo);

	}
}
