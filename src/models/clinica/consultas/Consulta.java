package models.clinica.consultas;
import java.util.Date;

import models.clientes.Animal;
import models.clinica.Veterinario;
import util.Enfermidade;
import util.errors.AltaJaFechada;
import util.status.VeterinarioStatus;

public class Consulta {
    private Veterinario veterinario;
    private Animal animal;
    private Date dataDaConsultaAbertura, dataDaConsultaFechamento;
    private Alta resultadoDaConsulta;
    private Enfermidade enfermidade;

    public Consulta(Veterinario veterinario, Animal animal, Enfermidade enfermidade) {
        this.veterinario = veterinario;
        this.veterinario.setStatus(VeterinarioStatus.ATENDENDO);
        this.animal = animal;
        this.enfermidade = enfermidade;
        this.dataDaConsultaAbertura = new Date();
        this.resultadoDaConsulta = new Alta();
    }

    public Veterinario getVeterinario() {
        return this.veterinario;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public Enfermidade getEnfermidade() {
        return this.enfermidade;
    }

    public Date getDataAbertura() {
        return this.dataDaConsultaAbertura;
    }

    public Date getDataFechamento() {
        return this.dataDaConsultaFechamento;
    }

    public void terminarConsulta() throws AltaJaFechada {
        try{
            this.resultadoDaConsulta.fechar();
            this.dataDaConsultaFechamento = new Date();
            this.veterinario.setStatus(VeterinarioStatus.ATIVO);
        }catch(AltaJaFechada e){
            // Tratar caso a alta já tenha sido fechada
            System.out.println(e); // Temp
        }
    }
}
