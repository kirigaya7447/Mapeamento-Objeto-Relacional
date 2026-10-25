package Objects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column 
	private String nome;
	
	@OneToMany(mappedBy = "curso")
	private List<Aluno> alunos = new ArrayList<>();
	
	public Curso() {
		
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
