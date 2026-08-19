package Objects;

public class Produto {
	private int cod;
	private String nome;
	private int categoria;
	
	public Produto(int cod, String nome, int categoria) {
		this.cod = cod;
		this.nome = nome;
		this.categoria = categoria;
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

