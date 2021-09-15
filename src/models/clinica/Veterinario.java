package models.clinica;

import controllers.app.VeterinarioController;
import controllers.middlewares.auth.Role;
import util.Enfermidade;
import util.status.VeterinarioStatus;

public class Veterinario extends User {
    private VeterinarioStatus status;
    private Enfermidade especialidade;
    private String crmv;

    /**
     * Veterinario constructor com Especialidade
     * @param nome nome do User
     * @param password senha do User
     * @param role Role do User
     * @param idade idade do User
     * @param crmv crmv do Veterinario
     * @param especialidade Enfermidade de especialidade do Veterinario
     */
    public Veterinario(String nome, String password, Role role, int idade, String crmv, Enfermidade especialidade){
        super(nome, password, idade, role);
        this.crmv = crmv;
        this.especialidade = especialidade;
        this.status = VeterinarioStatus.ATIVO;
        new VeterinarioController().store(this);
    }

    /**
     * Veterinario constructor sem Especialidade
     * @param nome nome do User
     * @param password senha do User
     * @param role Role do User
     * @param idade idade do User
     * @param crmv crmv do Veterinario
     */
    public Veterinario(String nome, String password, Role role, int idade, String crmv){
        super(nome, password, idade, role);
        this.crmv = crmv;
        this.especialidade = null;
        this.status = VeterinarioStatus.ATIVO;
        new VeterinarioController().store(this);
    }

    /**
     * Metodo para obter o CRMV do Veterinario
     * @return Veterinario CRMV
     */
    public String getCRMV() {
        return this.crmv;
    }

    /**
     * Metodo para setar um novo CRMV para o Veterinario
     * @param crmv Veterinario crmv
     */
    public void setCRMV(String crmv) {
        this.crmv = crmv;
    }

    /**
     * Metodo para setar uma nova Especialidade para o Veterinario
     * @param especialidade Enfermidade
     */
    public void setEspecialidade(Enfermidade especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * Metodo para obter a Especialidade do Veterinario
     * @return Enfermidade
     */
    public Enfermidade getEspecialidade() {
        return this.especialidade;
    }

    /**
     * Metodo para obter o Status atual do Veterinario
     * @return VeterinarioStatus
     */
    public VeterinarioStatus getVeterinarioStatus() {
        return this.status;
    }

    /**
     * Metodo para setar um novo valor de Status ao Veterinario
     * @param status VeterinarioStatus
     */
    public void setStatus(VeterinarioStatus status) {
        this.status = status;
    }
}
