package models.util;

// import java.util.ArrayList;

public class Enfermidade {

    private String nome, gravidade;

    public Enfermidade(String nome, String gravidade) {
        this.nome = nome;
        this.gravidade = gravidade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getGravidade() {
        return this.gravidade;
    }

    

}
