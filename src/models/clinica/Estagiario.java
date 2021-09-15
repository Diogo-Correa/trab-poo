package models.clinica;

import controllers.app.EstagiarioController;
import controllers.middlewares.auth.Role;
import util.errors.UserCadastradoException;

public class Estagiario extends User {
    private int horasSemanais;

    /**
     * @param nome nome do usuario
     * @param password senha do usuario
     * @param role (Role) nivel de acesso do usuario
     * @param email email do usuario
     * @param idade idade do usuario
     * @param horasSemanais horas semanais do estagiario
     * @throws UserCadastradoException
     */
    public Estagiario(String nome, String password, Role role, String email, int idade, int horasSemanais) throws UserCadastradoException {
        super(nome, password, idade, role, email);
        this.horasSemanais = horasSemanais;
        new EstagiarioController().store(this);
    }
    
    /**
     * Metodo para obter as horas semanais de um estagiario
     * @return horas semanais do estagiario
     */
    public int getHorasSemanais() { return this.horasSemanais; }

    /**
     * 
     * @param horasSemanais recebe a nova hora semanal do estagiario
     */
    public void setHorasSemanais(int horasSemanais) { this.horasSemanais = horasSemanais; }
}
