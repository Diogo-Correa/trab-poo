package models.clinica.consultas;
import java.util.Date;

import models.clientes.Animal;
import models.clientes.Dono;
import models.clinica.Veterinario;
import models.util.errors.AltaJaFechada;

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
        try{
            this.resultadoDaConsulta.fechar();
            this.dataDaConsultaFechamento = new Date();
        }catch(AltaJaFechada e){
            // Tratar caso a alta já tenha sido fechada
            System.out.println(e); // Temp
        }
    }
}
