package models.clientes;

import java.util.ArrayList;

import util.Medicamento;
import util.database.AnimaisDatabase;
import util.database.MedicamentosDatabase;
import util.database.DonosDatabase;
import java.io.Serializable;
import util.status.AnimalStatus;

public class Animal implements Serializable {
    private int id;
    private AnimalStatus status;
    private String nome, especie, raca, porte, pelagem;
    private boolean agressivo;
    
    /**
     * 
     * @param nome
     * @param especie
     * @param raca
     * @param porte
     * @param pelagem
     * @param agressivo
     * @param dono
     */
    public Animal(String nome, String especie, String raca, String porte, String pelagem, boolean agressivo) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.porte = porte;
        this.pelagem = pelagem;
        this.agressivo = agressivo;
        this.id = AnimaisDatabase.getLastId() + 1;
        this.status = AnimalStatus.ATIVO;
        AnimaisDatabase.addRecord(this);
    }
    
    /**
     * Metodo para obter o id do Animal
     * @return Animal id
     */
    public int getId() { return this.id; }

    /**
     * Metodo para obter o id do Dono do Animal
     * @return Dono id
     */
    public int getDonoId() { 
        Dono d = this.getDono();
        if(d != null){
            return d.getId();
        }return -1;
    }

    /**
     * Metodo para obter o Status atual do Animal
     * @return AnimalStatus
     */
    public AnimalStatus getStatus() { return this.status; }

    /**
     * Metodo para setar um novo valor de Status para o Animal
     * @param status novo valor AnimalStatus
     */
    public void setStatus(AnimalStatus status) { this.status = status; }

    /**
     * Metodo para obter o nome do Animal
     * @return Animal nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Metodo para obter a Especia do Animal
     * @return Animal especie
     */
    public String getEspecie() {
        return this.especie;
    }

    /**
     * Metodo para obter a raca do Animal
     * @return Animal raca
     */
    public String getRaca() {
        return this.raca;
    }

    /**
     * Metodo para obter o porte do Animal
     * @return Animal porte
     */
    public String getPorte() {
        return this.porte;
    }

    /**
     * Metodo para obter a pelagem do Animal
     * @return Animal pelagem
     */
    public String getPelagem() {
        return this.pelagem;
    }

    /**
     * Metodo para obter a agressividade do Animal
     * @return Animal agressivo
     */
    public boolean getAgressivo() {
        return this.agressivo;
    }

    /**
     * Metodo para setar um novo valor de agressividade ao AnimalStatus
     * O metodo nega o valor atual de agressividade
     */
    public void setAgressivo() {
        this.agressivo = !this.agressivo;
    }

    /**
     * Metodo para obter o Dono do Animal
     * @return Animal dono
     */
    public Dono getDono() {
        return DonosDatabase.findByAnimal(this.getId());
    }

    /**
     * Metodo para obter a lista de medicamentos usados pelo Animal
     * @return Animal medicamentos
     */
    public ArrayList<Medicamento> getMedicamentos() {
        return MedicamentosDatabase.findByAnimal(this.id);
    }

    /**
     * Metodo para adicao de um novo medicamento para uso do Animal
     * @param medicamento Medicamento
     */
    public void addMedicamento(Medicamento medicamento) {
        // TODO Create medicamento, add MedicamentosDatabase
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ", Id: " + this.id;
    }
    
}
