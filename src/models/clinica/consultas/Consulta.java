package models.clinica.consultas;
import java.io.Serializable;
import java.util.Date;

import controllers.app.ConsultaController;
import models.clientes.Animal;
import models.clinica.Veterinario;
import util.Enfermidade;
import util.database.AnimaisDatabase;
import util.database.ConsultasDatabase;
import util.database.VeterinariosDatabase;
import util.errors.AltaJaFechada;
import util.status.AnimalStatus;
import util.status.VeterinarioStatus;

public class Consulta implements Serializable {
    private int id;
    private Veterinario veterinario;
    private Animal animal;
    private Date dataDaConsultaAbertura, dataDaConsultaFechamento;
    private Alta resultadoDaConsulta;
    private Enfermidade enfermidade;

    /**
     * 
     * @param veterinario (Veterinario) veterinario responsavel pela consulta
     * @param animal (Animal) animal a ser consultado
     * @param enfermidade (Enfermidade) enfermidade passada pelo atendimento
     */
    public Consulta(Veterinario veterinario, Animal animal, Enfermidade enfermidade) {
        this.veterinario = veterinario;
        this.veterinario.setStatus(VeterinarioStatus.ATENDENDO);
        this.animal = animal;
        this.animal.setStatus(AnimalStatus.EM_ATENDIMENTO);
        this.enfermidade = enfermidade;
        this.id = ConsultasDatabase.getLastId() + 1;
        this.dataDaConsultaAbertura = new Date();
        this.resultadoDaConsulta = new Alta();
        new ConsultaController().store(this);
    }

    /**
     * Metodo para obter o ID da consulta
     * @return consulta id
     */
    public int getId() { return this.id; }

    /**
     * Metodo para obter o responsavel pela consulta
     * @return retorna o Veterinario
     */
    public Veterinario getVeterinario() {
        return this.veterinario;
    }

    /**
     * Metodo para obter o animal consultado
     * @return retorna o Animal
     */
    public Animal getAnimal() {
        return this.animal;
    }

    /**
     * Metodo para obter a enfermidade do Animal
     * @return retorna a Enfermidade
     */
    public Enfermidade getEnfermidade() {
        return this.enfermidade;
    }

    /**
     * Metodo para obter a data de inicio da consulta
     * @return dataDaConsultaAbertura
     */
    public Date getDataAbertura() {
        return this.dataDaConsultaAbertura;
    }

    /**
     * Metodo para obter a data de termino da consulta
     * @return dataDaConsultaFechamento
     */
    public Date getDataFechamento() {
        return this.dataDaConsultaFechamento;
    }

    /**
     * Metodo para obter a Alta referente a consulta
     * @return retorna a Alta
     */
    public Alta getAlta() {
        return this.resultadoDaConsulta;
    }

    /**
     * Metodo para finalizar a consulta
     * @throws AltaJaFechada
     */
    public void terminarConsulta() throws AltaJaFechada {
        try{
            this.resultadoDaConsulta.fechar();
            this.dataDaConsultaFechamento = new Date();
            this.veterinario.setStatus(VeterinarioStatus.ATIVO);
            VeterinariosDatabase.updateRecord(this.veterinario);
            this.animal.setStatus(AnimalStatus.ATIVO);
            AnimaisDatabase.updateRecord(this.animal);
        }catch(AltaJaFechada e){
            // Tratar caso a alta já tenha sido fechada
            System.out.println(e); // Temp
        }
    }
}
