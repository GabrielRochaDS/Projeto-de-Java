package com.gabrielrocha.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor implements Serializable {
    private static int contador = 0;
    private int id;
    private String nome;
    private String email;
    private List<Turma> turma;

    public Professor(String nome, String email){
        this.id = ++contador;
        this.nome = nome;
        this.email = email;
        this.turma = new ArrayList<>();
    }

    public String toString(){
        return "Numero = " + id + '\n' +
                "Nome = " + nome + '\n' +
                "Email =" + email + '\n';
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }
}
