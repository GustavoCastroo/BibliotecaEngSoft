package model;

import java.util.LinkedList;
import java.util.List;

public class Emprestimo extends Entidade{
	private String matriculaAluno;
	private String nomeAluno;
	private List<Livro> livros = new LinkedList<Livro>();
	public String toString() {
		String string = "Identificador: " + getId() + ", Matricula do Aluno: " + this.matriculaAluno + ", Nome do Aluno: " + this.nomeAluno + ", Lista de Livros:";
		
		for (Livro livro : livros) {
			string += "\n   " + livro.toString();
		}
		
		return string; 
	}
	public String getMatriculaAluno() {
		return matriculaAluno;
	}
	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
