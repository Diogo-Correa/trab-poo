package util;
import models.clientes.Animal;
public class Medicamento {
    
    private static int nextId = 0;
    private int id;
    private int animalId;
    private String nome;
    private double dosagem;

    public Medicamento(String nome, double dosagem){//, int animalId) {
        this.id = MedicamentosDatabase.last().id + 1;
        if(AnimaisDatabase.find(animalId)){this.animalId = animalId;}
        this.nome = nome;
        this.dosagem = dosagem;
    }

    public String getNome() {
        return this.nome;
    }

    public double getDosagem() {
        return this.dosagem;
    }

    public int getId() {
        return this.id;
    }

    public Animal getAnimal(){
        // TODO return Animais.find(this.animalId);
        return null;
    }

}
