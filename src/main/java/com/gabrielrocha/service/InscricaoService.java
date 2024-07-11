package com.gabrielrocha.service;

import com.gabrielrocha.dao.AlunoDAO;
import com.gabrielrocha.dao.InscricaoDAO;
import com.gabrielrocha.model.Aluno;
import com.gabrielrocha.model.Disciplina;
import com.gabrielrocha.model.Inscricao;
import com.gabrielrocha.util.FabricaDeDaos;

import java.util.List;

public class InscricaoService {
    private final InscricaoDAO inscricaoDAO = FabricaDeDaos.getDAO(InscricaoDAO.class);

    public void incluir(Inscricao inscricao){
        int contador = 0;
        for (Disciplina disciplina: inscricao.getTurma().getDisciplina().getRequisitos()){
            for (Inscricao inscricaoAluno: inscricao.getAluno().getInscricaos()){
                if(inscricaoAluno.getNota()>= 6 && inscricaoAluno.getTurma().getDisciplina() == disciplina){
                    contador ++;
                }
            }
        }
        if(contador == inscricao.getTurma().getDisciplina().getRequisitos().size()){
            inscricaoDAO.incluir(inscricao.getId(), inscricao);
        }
        else {
            System.out.println("O aluno nao possui todos os requisitos para a inscrição" + '\n');
        }

    }

    public void remover(int id){
        if( inscricaoDAO.recuperarPorId(id).getTurma() != null || inscricaoDAO.recuperarPorId(id).getAluno() != null  ){
            System.out.println("Remoção nao autorizada" + '\b');
        }
        else{
            System.out.println("Inscricao " + id + "Removida" + '\n');
            inscricaoDAO.remover(id);
        }
    }

    public void alterar(Inscricao inscricao){
        inscricaoDAO.alterar(inscricao.getId(), inscricao);
    }

    public Inscricao recuperarPorId(int id){
        if(inscricaoDAO.recuperarPorId(id) == null){
            System.out.println("Inscricao nao existe");
            return null;
        }
        else {
            return inscricaoDAO.recuperarPorId(id);
        }
    }

    public List<Inscricao> recuperarTodos(){
        return inscricaoDAO.recuperarTodos();
    }

}
