package com.gabrielrocha.model;

import java.io.Serializable;

public class Inscricao implements Serializable {
    private static int contador = 0;
    private int id;
    private int nota;
    private String data;
    private Aluno aluno;
    private Turma turma;

    public Inscricao(Aluno aluno, Turma turma, String data){
        this.id = ++contador;
        this.nota = -1;
        this.data = data;
        this.aluno = aluno;
        this.turma = turma;
    }
    public Inscricao(Aluno aluno, Turma turma, String data, int nota){
        this.id = ++contador;
        this.nota = nota;
        this.data = data;
        this.aluno = aluno;
        this.turma = turma;
    }

    public String toString(){
        return "Numero = " + id + '\n' +
                "Nota = " + nota + '\n' +
                "Aluno = " + getAluno().getNome() + '\n' +
                "Turma: " + '\n' + getTurma().toString() + '\n';
    }

    public int getId() {
        return id;
    }

    public int getNota() {
        return nota;
    }

    public String getData() {
        return data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
