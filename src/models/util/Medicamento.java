package models.util;
public class Medicamento {
    
    private String nome;
    private double dosagem;

    public Medicamento(String nome, double dosagem) {
        this.nome = nome;
        this.dosagem = dosagem;
    }

    public String getNome() {
        return this.nome;
    }

    public double getDosagem() {
        return this.dosagem;
    }

}
