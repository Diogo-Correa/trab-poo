package models.clinica.consultas;
import java.util.Date;

import models.clientes.Animal;
import models.clientes.Dono;
import models.clinica.Veterinario;

public class Consulta {
    private Veterinario veterinario;
    private Dono dono;
    private Animal animal;
    private Date dataDaConsultaAbertura;
    private Date dataDaConsultaFechamento;
    private Alta resultadoDaConsulta;

    public Consulta(Veterinario veterinario, Dono dono, Animal animal) {
        this.veterinario = veterinario;
        this.dono = dono;
        this.animal = animal;
        this.dataDaConsultaAbertura = new Date();
        this.resultadoDaConsulta = new Alta();
    }

    public void terminarConsulta() throws AltaJaFechada {
        resultadoDaConsulta.fechar();
    }
}
