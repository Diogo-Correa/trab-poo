package models.clientes;

import util.database.DonosDatabase;

public class Dono {
    private static int nextId = 0;
    private int id;
    private int animalId;
    private String nome, tel;
    private int idade;

    public Dono(String nome, String tel, int idade, int animalId) {
        this.nome = nome;
        this.tel = tel;
        this.idade = idade;
        this.id = nextId++;
        this.animalId = animalId;
        DonosDatabase.addRecord(this);
    }

    public int getId() { return this.id; }
    public int getAnimalId() { return this.animalId; }
    
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