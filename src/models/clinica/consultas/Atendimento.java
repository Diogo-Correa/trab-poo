package models.clinica.consultas;

import controllers.app.AtendimentoController;
import models.clientes.Animal;
import models.clinica.User;
import models.clinica.Veterinario;
import util.Enfermidade;
import util.database.Veterinarios;
import util.status.VeterinarioStatus;

public class Atendimento {
    private static int nextId = 0;
    private int id = 0;
    private Animal animal;
    private Enfermidade enfermidade;
    private Veterinario veterinario;
    private User user;

    public Atendimento(Animal animal, User user) {
        this.animal = animal;
        this.user = user;
        this.id = nextId++;
        new AtendimentoController().store(this);
    }

    public int getId() { return id; }
    
    public Animal getAnimal() {
        return this.animal;
    }

    public Enfermidade getEnfermidade() {
        return this.enfermidade;
    }

    public void setEnfermidade(Enfermidade enfermidade) {
        this.enfermidade = enfermidade;
    }

    public Veterinario getVeterinario() {
        return this.veterinario;
    }

    public User getEstagiario() {
        return this.user;
    }

    public void buscaVeterinario() {
        for(Veterinario vet : Veterinarios.getVeterinarios()) {
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
