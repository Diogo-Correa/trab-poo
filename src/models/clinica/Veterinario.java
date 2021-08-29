package models.clinica;

import util.Enfermidade;
import util.database.Veterinarios;
import util.status.VeterinarioStatus;

public class Veterinario {
    private VeterinarioStatus status;
    private Enfermidade especialidade;
    private String nome;
    private int idade;
    private String crmv;

    public Veterinario(String nome, int idade, String crmv, Enfermidade especialidade){
        this.nome = nome;
        this.idade = idade;
        this.crmv = crmv;
        this.especialidade = especialidade;
        this.status = VeterinarioStatus.ATIVO;
        Veterinarios.addVeterinario(this);
    }

    public Veterinario(String nome, int idade, String crmv){
        this.nome = nome;
        this.idade = idade;
        this.crmv = crmv;
        this.especialidade = null;
        this.status = VeterinarioStatus.ATIVO;
        Veterinarios.addVeterinario(this);
    }

    public String getNome() {
        return this.nome;
    }

    public Enfermidade getEspecialidade() {
        return this.especialidade;
    }

    public VeterinarioStatus getVeterinarioStatus() {
        return this.status;
    }

    public void setStatus(VeterinarioStatus status) {
        this.status = status;
    }
}
