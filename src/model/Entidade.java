package model;

public abstract class Entidade {
	private Integer id;
	
	public abstract String toString();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
