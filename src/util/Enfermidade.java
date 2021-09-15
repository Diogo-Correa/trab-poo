package util;

import util.database.Enfermidades;

// import java.util.ArrayList;

public class Enfermidade {

    private static int nextId = 0;
    private int id = 0;
    private String nome, gravidade;

    /**
     * 
     * @param nome nomde da Enfermidade
     * @param gravidade gravidade da Enfermidade
     */
    public Enfermidade(String nome, String gravidade) {
        this.nome = nome;
        this.gravidade = gravidade;
        this.id = EnfermidadesDatabase.getLastId();
        EnfermidadesDatabase.addRecord(this);
    }

    /**
     * Metodo para obter o ID da Enfermidade
     * @return Enfermidade ID
     */
    public int getId() { return id; }

    /**
     * Metodo para obter o nome da Enfermidade
     * @return Enfermidade nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Metodo para obter a gravidade da Enfermidade
     * @return Enfermidade gravidade
     */
    public String getGravidade() {
        return this.gravidade;
    }

    

}
