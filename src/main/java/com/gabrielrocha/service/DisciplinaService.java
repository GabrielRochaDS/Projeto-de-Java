package com.gabrielrocha.service;

import com.gabrielrocha.dao.DisciplinaDAO;
import com.gabrielrocha.model.Disciplina;
import com.gabrielrocha.util.FabricaDeDaos;

import java.util.List;

public class DisciplinaService {
    private final DisciplinaDAO disciplinaDAO = FabricaDeDaos.getDAO(DisciplinaDAO.class);

    public void incluir(Disciplina disciplina){
        disciplinaDAO.incluir(disciplina.getId(), disciplina);
    }

    public void remover(int id){
        if( disciplinaDAO.recuperarPorId(id) != null){
            System.out.println("Remoção nao autorizada" + '\b');
        }
        else{
            System.out.println("Disciplina " + id + "Removida" + '\n');
            disciplinaDAO.remover(id);
        }
    }

    public void alterar(Disciplina disciplina){
        disciplinaDAO.alterar(disciplina.getId(), disciplina);
    }

    public Disciplina recuperarPorId(int id){
        if(disciplinaDAO.recuperarPorId(id) == null){
            System.out.println("Inscricao nao existe");
            return null;
        }
        else {
            return disciplinaDAO.recuperarPorId(id);
        }
    }

    public List<Disciplina> recuperarTodos(){
        return disciplinaDAO.recuperarTodos();
    }

}
