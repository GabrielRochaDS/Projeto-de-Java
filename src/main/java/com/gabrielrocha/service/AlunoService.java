package com.gabrielrocha.service;

import com.gabrielrocha.dao.AlunoDAO;
import com.gabrielrocha.model.Aluno;
import com.gabrielrocha.util.FabricaDeDaos;

import java.util.List;

public class AlunoService {
    private final AlunoDAO alunoDAO = FabricaDeDaos.getDAO(AlunoDAO.class);

    public void incluir(Aluno aluno){
        alunoDAO.incluir(aluno.getId(), aluno);
    }
    public void remover(int id){
        if(!alunoDAO.recuperarPorId(id).getInscricaos().isEmpty()){
            System.out.println("Remoção nao autorizada" + '\n');
        }
        else{
            alunoDAO.remover(id);
        }
    }

    public void alterar(Aluno aluno){
        alunoDAO.alterar(aluno.getId(), aluno);
    }

    public Aluno recuperarPorId(int id){
        if(alunoDAO.recuperarPorId(id) == null){
            System.out.println("Aluno nao existe");
            return null;
        }
        else {
            return alunoDAO.recuperarPorId(id);
        }
    }

    public List<Aluno> recuperarTodos(){
        return alunoDAO.recuperarTodos();
    }


}
