package com.gabrielrocha;

import com.gabrielrocha.dao.InscricaoDAO;
import com.gabrielrocha.model.Aluno;
import com.gabrielrocha.model.Inscricao;
import com.gabrielrocha.model.Turma;
import com.gabrielrocha.service.AlunoService;
import com.gabrielrocha.service.InscricaoService;
import com.gabrielrocha.service.TurmaService;
import com.gabrielrocha.util.FabricaDeDaos;
import corejava.Console;

public class PrincipalInscricao {
    private final InscricaoService inscricaoService = new InscricaoService();
    private final AlunoService alunoService = new AlunoService();
    private final TurmaService turmaService = new TurmaService();

    public void principal(){
        Inscricao umaInscricao;
        String data;
        int idInscricao;
        int idAluno;
        int idTurma;
        int nota;
        boolean continua = true;

        while (continua){
            System.out.println('\n' + "========================================================");
            System.out.println('\n' + "O que você deseja fazer?");
            System.out.println('\n' + "1. Cadastrar uma inscricao");
            System.out.println("2. Remover uma inscricao");
            System.out.println("3. Listar todos as inscricoes");
            System.out.println("4. Voltar");

            int opcao = Console.readInt('\n' + "Digite um número entre 1 e 4:");
            System.out.println();


            //==============//TRATAR NOTA MAIOR QUE 10//==============//
            switch (opcao){
                case 1->{
                    data = Console.readLine("Informe a data da inscricao: ");
                    nota = Console.readInt("Informe a nota do aluno: ");
                    idAluno = Console.readInt("Informe o id do aluno a ser inscrito: ");
                    idTurma = Console.readInt("Informe o id da turma a ser inscrita: ");
                    Turma turma = turmaService.recuperarPorId(idAluno);
                    Aluno aluno = alunoService.recuperarPorId(idAluno);
                    umaInscricao = new Inscricao(aluno, turma, data, nota);
                    inscricaoService.incluir(umaInscricao);
                    alunoService.recuperarPorId(idAluno).getInscricaos().add(umaInscricao);
                }

                case 2->{
                    idInscricao = Console.readInt("Informe o id da inscricao a ser removida: ");
                    inscricaoService.remover(idInscricao);
                }

                case 3->{
                    for(Inscricao inscricao: inscricaoService.recuperarTodos()){
                        System.out.println(inscricao.toString());
                    }
                }
                case 4->{
                    continua = false;
                }
                default -> {
                    System.out.println("Opcao invalida" + '\n');
                }
            }
        }

    }

}
