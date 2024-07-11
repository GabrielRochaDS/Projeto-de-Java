package com.gabrielrocha.service;

import com.gabrielrocha.dao.DisciplinaDAO;
import com.gabrielrocha.dao.InscricaoDAO;
import com.gabrielrocha.dao.ProfessorDAO;
import com.gabrielrocha.dao.TurmaDAO;
import com.gabrielrocha.model.Inscricao;
import com.gabrielrocha.model.Turma;
import com.gabrielrocha.util.FabricaDeDaos;

import java.util.List;

public class TurmaService {
    private final TurmaDAO turmaDAO = FabricaDeDaos.getDAO(TurmaDAO.class);
    private final ProfessorDAO professorDAO = FabricaDeDaos.getDAO(ProfessorDAO.class);
    private final DisciplinaDAO disciplinaDAO = FabricaDeDaos.getDAO(DisciplinaDAO.class);
    private final InscricaoDAO inscricaoDAO = FabricaDeDaos.getDAO(InscricaoDAO.class);


    public void incluir(Turma turma){
        turmaDAO.incluir(turma.getId(), turma);
    }
    public void remover(int id){
        Turma turma = turmaDAO.recuperarPorId(id);
        if(turma != null){
            turmaDAO.remover(id);
            professorDAO.remover(turma.getProfessor().getId());
            disciplinaDAO.remover(turma.getDisciplina().getId());
            for(Inscricao inscricao: turma.getInscricaos()){
                inscricao.getAluno().getInscricaos().remove(inscricao);
                inscricaoDAO.remover(inscricao.getId());
            }
        }
        else {
            System.out.println("Turma nao encontrada!" + '\n');
        }
    }

    public Turma recuperarPorId(int id){
        if(turmaDAO.recuperarPorId(id) == null){
            System.out.println("Inscricao nao existe");
            return null;
        }
        else {
            return turmaDAO.recuperarPorId(id);
        }
    }

    public List<Turma> recuperarTodos(){
        return turmaDAO.recuperarTodos();
    }

}
