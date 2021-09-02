package models.clientes;

import util.database.Donos;

public class Dono {
    private static int nextId = 0;
    private int id = 0;
    private String nome, tel;
    private int idade;

    public Dono(String nome, String tel, int idade) {
        this.nome = nome;
        this.tel = tel;
        this.idade = idade;
        this.id = nextId++;
        Donos.addDono(this);
    }

    public int getId() { return id; }
    
    public String getNome() {
        return this.nome;
    }

    public String getTel() {
        return this.tel;
    }

    public int getIdade() {
        return this.idade;
    }

}