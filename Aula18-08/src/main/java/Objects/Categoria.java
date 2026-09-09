package Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod;
	@Column (name="descricaocateg")
	private String descricao;
	@Column (name="ativocateg")
	private String ativo;
	
	public Categoria(String descricao, String ativo) {
		this.descricao = descricao;
		this.ativo = ativo;
	}
	
public Categoria() {
		
	}

public int getCod() {
	return cod;
}

public void setCod(int cod) {
	this.cod = cod;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public String getAtivo() {
	return ativo;
}

public void setAtivo(String ativo) {
	this.ativo = ativo;
}
@Override
public String toString() {
return "Categoria [cod: " + cod + ", descrição: " + descricao + ", ativo: " + ativo + "]";
}


}
