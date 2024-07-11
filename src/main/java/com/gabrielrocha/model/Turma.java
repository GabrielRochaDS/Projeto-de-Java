package com.gabrielrocha.model;

import com.gabrielrocha.PrincipalInscricao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable {
    private static int contador = 0;
    private int id;
    private int ano;
    private int periodo;
    private List<Inscricao> inscricaos;
    private Professor professor;
    private Disciplina disciplina;

    public Turma(int ano, int periodo, Professor professor, Disciplina disciplina){
        this.professor = professor;
        this.disciplina = disciplina;
        this.id = ++contador;
        this.ano = ano;
        this.periodo = periodo;
        this.inscricaos = new ArrayList<>();
    }

    public String toString(){
        return "Numero = " + id + '\n' +
                "Ano = " + ano + '\n' +
                "Periodo = " + periodo;
    }

    public int getAno() {
        return ano;
    }

    public int getId() {
        return id;
    }

    public int getPeriodo() {
        return periodo;
    }

    public List<Inscricao> getInscricaos() {
        return inscricaos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public void setInscricaos(List<Inscricao> inscricaos) {
        this.inscricaos = inscricaos;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
