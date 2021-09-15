package util;
import java.io.Serializable;

import models.clientes.Animal;
import util.database.AnimaisDatabase;
import util.database.MedicamentosDatabase;

public class Medicamento implements Serializable {
    
    private int id;
    private int animalId;
    private String nome;

    public Medicamento(String nome, int animalId) {
        this.id = MedicamentosDatabase.last().id + 1;
        if(AnimaisDatabase.find(animalId) != null){ this.animalId = animalId; }
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }

    public Animal getAnimal(){
        return AnimaisDatabase.find(this.animalId);
    }

}
