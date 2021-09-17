package models.clinica;

import controllers.app.VeterinarioController;
import controllers.middlewares.auth.Role;
import util.Enfermidade;
import util.database.VeterinariosDatabase;
import util.errors.UserCadastradoException;
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
     * @param email email do User
     * @param idade idade do User
     * @param crmv crmv do Veterinario
     * @param especialidade Enfermidade de especialidade do Veterinario
     * @throws UserCadastradoException
     */
    public Veterinario(String nome, String password, Role role, String email, int idade, String crmv, Enfermidade especialidade) throws UserCadastradoException{
        super(nome, password, idade, role, email);
        this.crmv = crmv;
        this.especialidade = especialidade;
        this.status = VeterinarioStatus.ATIVO;
        VeterinariosDatabase.addRecord(this);
    }

    /**
     * Veterinario constructor sem Especialidade
     * @param nome nome do User
     * @param password senha do User
     * @param role Role do User
     * @param email email do User
     * @param idade idade do User
     * @param crmv crmv do Veterinario
     * @throws UserCadastradoException
     */
    public Veterinario(String nome, String password, Role role, String email, int idade, String crmv) throws UserCadastradoException{
        super(nome, password, idade, role, email);
        this.crmv = crmv;
        this.especialidade = null;
        this.status = VeterinarioStatus.ATIVO;
        VeterinariosDatabase.addRecord(this);
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
        VeterinariosDatabase.updateRecord(this);
    }

    /**
     * Metodo para setar uma nova Especialidade para o Veterinario
     * @param especialidade Enfermidade
     */
    public void setEspecialidade(Enfermidade especialidade) {
        this.especialidade = especialidade;
        VeterinariosDatabase.updateRecord(this);
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
        VeterinariosDatabase.updateRecord(this);
    }
}
