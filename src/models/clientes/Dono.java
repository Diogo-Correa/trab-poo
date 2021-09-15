package models.clientes;

import java.io.Serializable;

import util.database.DonosDatabase;

public class Dono implements Serializable {
    private int id;
    private int animalId;
    private String nome, tel;
    private int idade;

    /**
     * 
     * @param nome nome do Dono
     * @param tel telefone de contato do Dono
     * @param idade idade do Dono
     * @param animalId Id do Animal do Dono
     */
    public Dono(String nome, String tel, int idade, int animalId) {
        this.nome = nome;
        this.tel = tel;
        this.idade = idade;
        this.id = DonosDatabase.getLastId() + 1;
        this.animalId = animalId;
        DonosDatabase.addRecord(this);
    }

    /**
     * Metodo para obter o id do Dono
     * @return Dono id
     */
    public int getId() { return this.id; }
    
    /**
     * Metodo para obter o id do Animal do Dono
     * @return Animal id
     */
    public int getAnimalId() { return this.animalId; }

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