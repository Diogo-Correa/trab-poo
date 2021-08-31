package models.clinica;

import util.Enfermidade;
import util.database.Veterinarios;
import util.middlewares.auth.Role;
import util.status.VeterinarioStatus;

public class Veterinario extends User {
    private VeterinarioStatus status;
    private Enfermidade especialidade;
    private String crmv;

    public Veterinario(String nome, String password, Role role, int idade, String crmv, Enfermidade especialidade){
        super(nome, password, idade, role);
        this.crmv = crmv;
        this.especialidade = especialidade;
        this.status = VeterinarioStatus.ATIVO;
        Veterinarios.addVeterinario(this);
    }

    public Veterinario(String nome, String password, Role role, int idade, String crmv){
        super(nome, password, idade, role);
        this.crmv = crmv;
        this.especialidade = null;
        this.status = VeterinarioStatus.ATIVO;
        Veterinarios.addVeterinario(this);
    }

    public String getCRMV() {
        return this.crmv;
    }

    public void setEspecialidade(Enfermidade especialidade) {
        this.especialidade = especialidade;
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
