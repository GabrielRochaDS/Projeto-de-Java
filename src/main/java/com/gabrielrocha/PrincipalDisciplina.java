package com.gabrielrocha;

import com.gabrielrocha.model.Aluno;
import com.gabrielrocha.model.Disciplina;
import com.gabrielrocha.model.Professor;
import com.gabrielrocha.model.Turma;
import com.gabrielrocha.service.DisciplinaService;
import com.gabrielrocha.service.ProfessorService;
import corejava.Console;

public class PrincipalDisciplina {
    private final DisciplinaService disciplinaService = new DisciplinaService();

    public void principal(){
        int id;
        int cargaHoraria;
        String nome;
        boolean continua = true;

        while (continua){
            System.out.println('\n' + "========================================================");
            System.out.println('\n' + "O que você deseja fazer?");
            System.out.println('\n' + "1. Cadastrar ums nova disciplina");
            System.out.println("2. Remover uma disciplina");
            System.out.println("3. Listar todos as disciplinas");
            System.out.println("4. Voltar");

            int opcao = Console.readInt('\n' + "Digite um número entre 1 e 4:");
            System.out.println();

            switch (opcao){
                case 1-> {
                    nome = Console.readLine("Informe o nome da disciplina: ");
                    cargaHoraria = Console.readInt("Informe a carga horaria da disciplina: ");

                    Disciplina disciplina = new Disciplina(nome, cargaHoraria);
                    disciplinaService.incluir(disciplina);
                }
                case 2-> {
                    id = Console.readInt("Digite o id da disciplina a ser removida: ");
                    disciplinaService.remover(id);
                }
                case 3-> {
                    for(Disciplina disciplina: disciplinaService.recuperarTodos()){
                        System.out.println(disciplina.toString());
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

