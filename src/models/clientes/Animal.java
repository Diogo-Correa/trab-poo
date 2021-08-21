package models.clientes;

public class Animal {
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
        return this.dono;
    }
    

}
