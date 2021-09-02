package util;

import util.database.Enfermidades;

// import java.util.ArrayList;

public class Enfermidade {

    private static int nextId = 0;
    private int id = 0;
    private String nome, gravidade;

    public Enfermidade(String nome, String gravidade) {
        this.nome = nome;
        this.gravidade = gravidade;
        this.id = nextId++;
        Enfermidades.addEnfermidade(this);
    }

    public int getId() { return id; }

    public String getNome() {
        return this.nome;
    }

    public String getGravidade() {
        return this.gravidade;
    }

    

}
