package AtivadesI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alunos {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("|            MENU                |");
            System.out.println("----------------------------------");
            System.out.println("|Op 1 - Inserir                  |");
            System.out.println("|Op 2 - Remover                  |");
            System.out.println("|Op 3 - Listar                   |");
            System.out.println("|Op 4 - Sair                     |");
            System.out.println("----------------------------------");
            System.out.println("Digite a opção que deseja: ");
            int op = ler.nextInt();
            
            switch (op) {
                case 1:
                    inserirAluno(ler, alunos);
                    break;
                case 2:
                    removerAluno(ler, alunos);
                    break;
                case 3:
                    listarAlunos(alunos);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    mostrarMaiorIAA(alunos);
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    private static void inserirAluno(Scanner ler, List<Aluno> alunos) {
        System.out.println("Digite o nome do Aluno: ");
        String nome = ler.next(); 
        System.out.println("Digite a idade do aluno: ");
        int idade = ler.nextInt();
        System.out.println("Digite o IAA (indice de aproveitamento) do aluno: ");
        double iaa = ler.nextDouble();
        System.out.println("Digite o curso (BCC, Calculo, Fisica): ");
        String curso = ler.next();
        
    
        Curso disciplina = null;
        try {
            disciplina = Curso.valueOf(curso);
        } catch (IllegalArgumentException e) {
            System.out.println("Curso inválido!");
            return;
        }
        
        alunos.add(new Aluno(nome, idade, iaa, disciplina));
    }
    
    private static void removerAluno(Scanner ler, List<Aluno> alunos) {
        System.out.println("Digite o nome do aluno que deseja remover: ");
        String nome = ler.next();
        
        boolean removido = false;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                alunos.remove(aluno);
                removido = true;
                System.out.println("Aluno removido com sucesso.");
                break; // Interrompe o loop após encontrar e remover o aluno
            }
        }
        
        if (!removido) {
            System.out.println("Aluno não encontrado.");
        }
    }

    
    private static void listarAlunos(List<Aluno> alunos) {
        System.out.println("Lista de Alunos:");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(i+1 + " - " + alunos.get(i));
        }
    }
    
    private static void mostrarMaiorIAA(List<Aluno> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos na lista.");
            return;
        }
        
        double maiorIAA = alunos.get(0).getIaa();
        String nomeMaiorIAA = alunos.get(0).getNome();
        
        for (Aluno aluno : alunos) {
            if (aluno.getIaa() > maiorIAA) {
                maiorIAA = aluno.getIaa();
                nomeMaiorIAA = aluno.getNome();
            }
        }
        
        System.out.println("O aluno com o maior IAA é: " + nomeMaiorIAA + ", com IAA de " + maiorIAA);
    }

}
