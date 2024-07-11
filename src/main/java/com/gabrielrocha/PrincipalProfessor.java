package com.gabrielrocha;

import com.gabrielrocha.model.Aluno;
import com.gabrielrocha.model.Professor;
import com.gabrielrocha.model.Turma;
import com.gabrielrocha.service.ProfessorService;
import corejava.Console;

public class PrincipalProfessor {
    private final ProfessorService professorService = new ProfessorService();

    public void principal(){
        int id;
        String nome;
        String email;
        boolean continua = true;

        while (continua){
            System.out.println('\n' + "========================================================");
            System.out.println('\n' + "O que você deseja fazer?");
            System.out.println('\n' + "1. Cadastrar uma novo professor");
            System.out.println("2. Remover um professor");
            System.out.println("3. Listar todos os professores");
            System.out.println("4. Voltar");

            int opcao = Console.readInt('\n' + "Digite um número entre 1 e 4:");
            System.out.println();

            switch (opcao){
                case 1-> {
                    nome = Console.readLine("Informe o nome do aluno: ");
                    email = Console.readLine("Informe o email do aluno: ");

                    Professor umProfessor = new Professor(nome, email);
                    professorService.incluir(umProfessor);
                }
                case 2-> {
                    id = Console.readInt("Digite o id do Professor a ser removida: ");
                    professorService.remover(id);
                }
                case 3-> {
                    for(Professor professor: professorService.recuperarTodos()){
                        System.out.println(professor.toString());
                    }
                }
                case 4 ->{
                    continua = false;
                }
                default -> System.out.println("Opcao invalida" + '\n');
            }
        }

    }

}
