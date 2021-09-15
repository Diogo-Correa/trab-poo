package models.clientes;

import java.util.ArrayList;

import util.Medicamento;
import util.database.AnimaisDatabase;
import util.database.MedicamentosDatabase;
import util.database.DonosDatabase;
import java.io.Serializable;

public class Animal implements Serializable {
    private int id;
    private String nome, especie, raca, porte, pelagem;
    private boolean agressivo;
    
    public Animal(String nome, String especie, String raca, String porte, String pelagem, boolean agressivo) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.porte = porte;
        this.pelagem = pelagem;
        this.agressivo = agressivo;
        this.id = AnimaisDatabase.getLastId() + 1;
        AnimaisDatabase.addRecord(this);
    }

    public int getId() { return this.id; }
    public int getDonoId() { 
        Dono d = this.getDono();
        if(d != null){
            return d.getId();
        }return -1;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEspecie() {
        return this.especie;
    }

    public String getRaca() {
        return this.raca;
    }

    public String getPorte() {
        return this.porte;
    }

    public String getPelagem() {
        return this.pelagem;
    }

    public boolean getAgressivo() {
        return this.agressivo;
    }

    public void setAgressivo() {
        this.agressivo = !this.agressivo;
    }

    public Dono getDono() {
        return DonosDatabase.findByAnimal(this.getId());
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return MedicamentosDatabase.findByAnimal(this.id);
    }

    public void showMedicamentos() {
        for(Medicamento medicamento : this.getMedicamentos()) {
            System.out.println(medicamento.getNome() + " " + medicamento.getDosagem());
        }
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ", Id: " + this.id;
    }
    
}
