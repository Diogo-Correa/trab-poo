package util;
import models.clientes.Animal;
public class Medicamento {
    
    private static int nextId = 0;
    private int id;
<<<<<<< HEAD
    private int animalId;
=======
>>>>>>> e66456d664e7b52df726e5074cb1298d839c6fed
    private String nome;

<<<<<<< HEAD
    public Medicamento(String nome, double dosagem){//, int animalId) {
        this.id = MedicamentosDatabase.last().id + 1;
        if(AnimaisDatabase.find(animalId)){this.animalId = animalId;}
=======
    public Medicamento(String nome) {
>>>>>>> e66456d664e7b52df726e5074cb1298d839c6fed
        this.nome = nome;
        this.id = nextId++;
    }

    public int getId() { return this.id; }

    public String getNome() {
        return this.nome;
    }

<<<<<<< HEAD
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

=======
>>>>>>> e66456d664e7b52df726e5074cb1298d839c6fed
}
