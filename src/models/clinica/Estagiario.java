package models.clinica;

import controllers.app.EstagiarioController;
import controllers.middlewares.auth.Role;

public class Estagiario extends User {
    private int horasSemanais;
    private String contrato;

    public Estagiario(String nome, String password, Role role, int idade, int horasSemanais, String contrato) {
        super(nome, password, idade, role);
        this.horasSemanais = horasSemanais;
        this.contrato = contrato;
        new EstagiarioController().store(this);
    }

    public String getContrato() { return this.contrato; }
    public int getHorasSemanais() { return this.horasSemanais; }
    public void setHorasSemanais(int horasSemanais) { this.horasSemanais = horasSemanais; }
}
