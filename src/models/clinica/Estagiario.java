package models.clinica;

import util.database.Estagiarios;
import util.middlewares.auth.Role;

public class Estagiario extends User {
    private int horasSemanais;
    private String contrato;

    public Estagiario(String nome, String password, Role role, int idade, int horasSemanais, String contrato) {
        super(nome, password, idade, role);
        this.horasSemanais = horasSemanais;
        this.contrato = contrato;
        Estagiarios.addEstagiario(this);
    }

    public String getContrato() { return this.contrato; }
    public int getHorasSemanais() { return this.horasSemanais; }
}
