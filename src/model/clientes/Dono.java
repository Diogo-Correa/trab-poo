package model.clientes;

import util.database.Donos;

public class Dono {
    private String nome, tel;
    private int idade;

    public Dono(String nome, String tel, int idade) {
        this.nome = nome;
        this.tel = tel;
        this.idade = idade;
        Donos.addDono(this);
    }

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