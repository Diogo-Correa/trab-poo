package models.clinica;

import controllers.app.EstagiarioController;
import controllers.middlewares.auth.Role;

public class Estagiario extends User {
    private int horasSemanais;

    public Estagiario(String nome, String password, Role role, int idade, int horasSemanais) {
        super(nome, password, idade, role);
        this.horasSemanais = horasSemanais;
        new EstagiarioController().store(this);
    }
    
    public int getHorasSemanais() { return this.horasSemanais; }
    public void setHorasSemanais(int horasSemanais) { this.horasSemanais = horasSemanais; }
}
