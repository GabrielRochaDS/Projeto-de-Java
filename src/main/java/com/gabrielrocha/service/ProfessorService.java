package com.gabrielrocha.service;

import com.gabrielrocha.dao.ProfessorDAO;
import com.gabrielrocha.model.Inscricao;
import com.gabrielrocha.model.Professor;
import com.gabrielrocha.model.Turma;
import com.gabrielrocha.util.FabricaDeDaos;

import java.util.List;

public class ProfessorService {
    private final ProfessorDAO professorDAO = FabricaDeDaos.getDAO(ProfessorDAO.class);

    public void incluir(Professor professor){
        professorDAO.incluir(professor.getId(), professor);
    }
    public void remover(int id){
        if( professorDAO.recuperarPorId(id).getTurma() != null){
            System.out.println("Remoção nao autorizada" + '\b');
        }
        else{
            System.out.println("Professor " + id + "Removida" + '\n');
            professorDAO.remover(id);
        }
    }

    public Professor recuperarPorId(int id){
        if(professorDAO.recuperarPorId(id) == null){
            System.out.println("Professor nao existe");
            return null;
        }
        else {
            return professorDAO.recuperarPorId(id);
        }
    }

    public List<Professor> recuperarTodos(){
        return professorDAO.recuperarTodos();
    }
}
