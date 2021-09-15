package models.clinica.consultas;

import java.io.Serializable;

import controllers.app.AtendimentoController;
import models.clientes.Animal;
import models.clinica.User;
import models.clinica.Veterinario;
import util.Enfermidade;
import util.database.AtendimentosDatabase;
import util.database.VeterinariosDatabase;
import util.status.VeterinarioStatus;

public class Atendimento  implements Serializable {
    private int id;
    private Animal animal;
    private Enfermidade enfermidade;
    private Veterinario veterinario;
    private User user;

    /**
     * 
     * @param animal (Animal)
     * @param user (User) responsavel pelo atendimento
     */
    public Atendimento(Animal animal, User user) {
        this.animal = animal;
        this.user = user;
        this.id = AtendimentosDatabase.getLastId() + 1;
        new AtendimentoController().store(this);
    }

    /**
     * Metodo para obter o ID do atendimento
     * @return atendimento ID
     */
    public int getId() { return id; }
    
    /**
     * Metodo para obter o Animal do atendimento
     * @return Animal
     */
    public Animal getAnimal() {
        return this.animal;
    }

    /**
     * Metodo para obter a Enfermidade do animal sendo atendido
     * @return Enfermidade
     */
    public Enfermidade getEnfermidade() {
        return this.enfermidade;
    }

    /**
     * Metodo para setar uma Enferminade no atendimento
     * @param enfermidade Enfermidade
     */
    public void setEnfermidade(Enfermidade enfermidade) {
        this.enfermidade = enfermidade;
    }

    /**
     * Metodo para obter o Veterinario a ser encaminhado para consulta
     * @return Veterinario
     */
    public Veterinario getVeterinario() {
        return this.veterinario;
    }

    /**
     * Metodo para obter o Veterinario responsavel pelo atendimento
     * @return User
     */
    public User getEstagiario() {
        return this.user;
    }

    /**
     * Metodo de busca de um Veterinal que sera responsavel pela consulta
     * Busca por algum Veterinario especializado na enfermidade e que esteja com o status VeterinarioStatus.ATIVO
     * Caso nao ache um Veterinario atendendo as condicoes, seta como responsavel um Veterinario com status VeterinarioStatus.ATIVO
     */
    public void buscaVeterinario() {
        for(Veterinario vet : VeterinariosDatabase.all()) {
            if(vet.getEspecialidade() == this.enfermidade && vet.getVeterinarioStatus() == VeterinarioStatus.ATENDENDO) 
                System.out.println("O veterinário " + vet.getNome() +" já está em atendimento.");
            
            if((vet.getEspecialidade() == null || vet.getEspecialidade() != this.enfermidade) && vet.getVeterinarioStatus() == VeterinarioStatus.ATIVO && this.veterinario == null) 
                this.veterinario = vet;

            if(vet.getEspecialidade() == this.enfermidade && vet.getVeterinarioStatus() == VeterinarioStatus.ATIVO) {
                this.veterinario = vet;
                return;
            }
        }

        if(this.veterinario == null) System.out.println("Nenhum veterinário disponivel.");
    }


    /**
     * Metodo para encaminhar o Animal para Consulta
     * @return Consulta gerada
     */
    public Consulta abreConsulta() {

        if(this.enfermidade != null && this.veterinario != null) { 
            
            if(this.veterinario.getVeterinarioStatus() == VeterinarioStatus.ATENDENDO) {
                System.out.println("O veterinário informado já está em atendimento. Realize uma nova busca.");
                return null;
            }
            return new Consulta(this.veterinario, this.animal, this.enfermidade); 
        }
        else System.out.println("Por favor informe um veterinário e a enfermidade do animal.");
        return null;
    }

}
