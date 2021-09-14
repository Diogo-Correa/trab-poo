package util;
public class Medicamento {
    
    private static int nextId = 0;
    private int id;
    private String nome;

    public Medicamento(String nome) {
        this.nome = nome;
        this.id = nextId++;
    }

    public int getId() { return this.id; }

    public String getNome() {
        return this.nome;
    }

}
