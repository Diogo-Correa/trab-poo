package models.clientes;

import util.database.Donos;

public class Dono {
    private static int nextId = 0;
    private int id = 0;
    private String nome, tel;
    private int idade;

    /**
     * 
     * @param nome nome do Dono
     * @param tel telefone de contato do Dono
     * @param idade idade do Dono
     */
    public Dono(String nome, String tel, int idade) {
        this.nome = nome;
        this.tel = tel;
        this.idade = idade;
        this.id = nextId++;
        Donos.addDono(this);
    }

    /**
     * Metodo para obter o id do Dono
     * @return Dono id
     */
    public int getId() { return id; }
    
    /**
     * Metodo para obter o nome do Dono
     * @return Dono nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Metodo para obter o telefone de contato do Dono
     * @return telefone do Dono
     */
    public String getTel() {
        return this.tel;
    }

    /**
     * Metodo para obter a idade do Dono
     * @return Dono idade
     */
    public int getIdade() {
        return this.idade;
    }

}