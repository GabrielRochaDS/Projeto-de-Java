package com.gabrielrocha.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aluno implements Serializable {
    private static int contador = 0;
    private int id;
    private String nome;
    private String email;
    private List<Inscricao> inscricaos;


    public Aluno(String nome, String email){
        this.id = ++contador;
        this.nome = nome;
        this.email = email;
        this.inscricaos = new ArrayList<>();
    }

    public String toString(){
        return "Numero = " + id + '\n'+
                "Nome = " + nome + '\n'+
                "Email = " + email;
    }


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public List<Inscricao> getInscricaos() {
        return inscricaos;
    }

    public void setInscricaos(List<Inscricao> inscricaos) {
        this.inscricaos = inscricaos;
    }


}
