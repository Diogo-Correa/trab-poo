package models.clinica.consultas;

import models.clientes.Animal;
import models.clinica.Veterinario;
import util.Enfermidade;
import util.database.Veterinarios;
import util.status.VeterinarioStatus;

public class Atendimento {
    private Animal animal;
    private Enfermidade enfermidade;
    private Veterinario veterinario;

    public Atendimento(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public Enfermidade getEnfermidade() {
        return this.enfermidade;
    }

    public void setEnfermidade(Enfermidade enfermidade) {
        this.enfermidade = enfermidade;
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

    public Veterinario getVeterinario() {
        return this.veterinario;
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
