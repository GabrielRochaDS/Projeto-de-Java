package com.gabrielrocha;

import com.gabrielrocha.model.Aluno;
import com.gabrielrocha.model.Inscricao;
import com.gabrielrocha.service.AlunoService;
import corejava.Console;

import java.util.List;

public class PrincipalAluno {
    private final AlunoService alunoService = new AlunoService();

    public void principal(){
        Aluno umAluno;
        int idAluno;
        String nome;
        String email;
        boolean continua = true;

        while (continua){
            System.out.println('\n' + "========================================================");
            System.out.println('\n' + "O que você deseja fazer?");
            System.out.println('\n' + "1. Cadastrar um aluno");
            System.out.println("2. Remover um aluno");
            System.out.println("3. Listar todos os alunos");
            System.out.println("4. Listar todas as inscricoes de um aluno");
            System.out.println("5. Voltar");

            int opcao = Console.readInt('\n' + "Digite um número entre 1 e 5:");
            System.out.println();

            switch (opcao){
                case 1 -> {
                    nome = Console.readLine("Informe o nome do aluno: ");
                    email = Console.readLine("Informe o email do aluno: ");

                    umAluno = new Aluno(nome, email);

                    alunoService.incluir(umAluno);
                }

                case 2 -> {
                    idAluno = Console.readInt("Informe o Id do aluno a ser removido:");
                    alunoService.remover(idAluno);
                }

                case 3-> {
                        for(Aluno aluno: alunoService.recuperarTodos()){
                            System.out.println(aluno.toString() + '\n');
                        }
                }

                case 4->{
                    idAluno = Console.readInt("Informe o Id do aluno para listar as inscricoes do mesmo:");
                    List<Inscricao> lista = alunoService.recuperarPorId(idAluno).getInscricaos();
                    if(lista.isEmpty()){
                        System.out.println("O aluno nao esta inscrito em nenhuma matéria" + "\n");
                    }
                    else {
                        for(Inscricao inscricao: lista){

                            System.out.println(inscricao.toString());
                        }
                    }

                }


                case 5->{
                    continua = false;
                }
                default -> {
                    System.out.println('\n' + "Opcao invalida");
                }

            }


        }

    }


}
