package util;
public class Medicamento {
    
    private static int nextId = 0;
    private int id;
    private String nome;
    private double dosagem;

    public Medicamento(String nome, double dosagem) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.id = nextId++;
    }

    public int getId() { return this.id; }

    public String getNome() {
        return this.nome;
    }

    public double getDosagem() {
        return this.dosagem;
    }

}
