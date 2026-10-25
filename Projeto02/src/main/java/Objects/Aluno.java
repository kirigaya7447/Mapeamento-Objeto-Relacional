package Objects;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	@ManyToMany
	@JoinTable(
				name = "Aluno_disciplina",
				joinColumns = @JoinColumn(name = "Id_aluno"),
				inverseJoinColumns = @JoinColumn(name = "id_disciplina")
			)
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	public Aluno(){
		
	}
	
public Aluno(String nome, Endereco endereco, Curso curso){
	this.nome = nome;	
	this.endereco = endereco;
		this.curso = curso;
	}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Endereco getEndereco() {
	return endereco;
}

public void setEndereco(Endereco endereco) {
	this.endereco = endereco;
}

public Curso getCurso() {
	return curso;
}

public void setCurso(Curso curso) {
	this.curso = curso;
}


}