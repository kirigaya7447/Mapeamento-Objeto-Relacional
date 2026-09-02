package Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod;
	@Column(name="nomeprod")
	private String nome;
	@Column(name="categprod")
	private int categoria;
	
	public Produto(String nome, int categoria) {
		this.nome = nome;
		this.categoria = categoria;
	}
	
	public Produto() {
		
	}
	

public int getCod() {
	return cod;
}
public String getNome() {
	return nome;
}
public int getCategoria() {
	return categoria;
}
public void setCod(int cod) {
	this.cod = cod;
}
public void setNome(String nome) {
	this.nome = nome;
}
public void setCategoria(int categoria) {
	this.categoria = categoria;
}

@Override
	public String toString() {
	return "Produto [cod: " + cod + ", nome: " + nome + ", categoria: " + categoria + "]";
}
}

