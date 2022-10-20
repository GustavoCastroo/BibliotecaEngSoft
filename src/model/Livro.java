package model;

public class Livro extends Entidade{
	private String autor;
	private String nome;
	private Integer edicao; 
	
	public String toString() {
		
		return "Identificador: " + getId() + "Livro: " + this.nome + " Autor: " + this.autor + " Edição: " + this.edicao + "ª .";
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}	
}
