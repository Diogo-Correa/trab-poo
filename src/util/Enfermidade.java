package util;

import util.database.Enfermidades;

// import java.util.ArrayList;

public class Enfermidade {

    private String nome, gravidade;

    public Enfermidade(String nome, String gravidade) {
        this.nome = nome;
        this.gravidade = gravidade;
        Enfermidades.addEnfermidade(this);
    }

    public String getNome() {
        return this.nome;
    }

    public String getGravidade() {
        return this.gravidade;
    }

    

}
