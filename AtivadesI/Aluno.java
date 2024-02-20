package AtivadesI;

public class Aluno {
	    private String nome;
	    private int idade;
	    private double iaa;
	    private Curso curso;
	    
	    public Aluno(String nome, int idade, double iaa, Curso curso) {
	        this.nome = nome;
	        this.idade = idade;
	        this.iaa = iaa;
	        this.curso = curso;
	    }
	    
	    public String getNome() {
	        return nome;
	    }
	    
	    public double getIaa() {
	        return iaa;
	    }
	    
	    @Override
	    public String toString() {
	        return "Nome: " + nome + ", Idade: " + idade + ", IAA: " + iaa + ", Curso: " + curso;
	    }
	
}
