package models.clientes;

import java.util.ArrayList;

import util.Medicamento;
import util.database.Animais;
import util.status.AnimalStatus;

public class Animal {
    private static int nextId = 0;
    private int id;
    private AnimalStatus status;
    private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
    private String nome, especie, raca, porte, pelagem;
    private boolean agressivo;
    private Dono dono;
    
    public Animal(String nome, String especie, String raca, String porte, String pelagem, boolean agressivo, Dono dono) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.porte = porte;
        this.pelagem = pelagem;
        this.agressivo = agressivo;
        this.dono = dono;
        this.status = AnimalStatus.ATIVO;
        this.id = nextId++;
        Animais.addAnimal(this);
    }

    public int getId() { return id; }

    public AnimalStatus getStatus() { return this.status; }
    public void setStatus(AnimalStatus status) { this.status = status; }

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
        return this.dono;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return this.medicamentos;
    }

    public void addMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public void showMedicamentos() {
        for(Medicamento medicamento : this.medicamentos) {
            System.out.println(medicamento.getNome() + " " + medicamento.getDosagem());
        }
    }
    
}
