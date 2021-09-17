package models.clinica.consultas;
import java.io.Serializable;
import java.util.ArrayList;

import util.Medicamento;
import util.errors.AltaJaFechada;

public class Alta implements Serializable {
    private Boolean emAberto;
    private ArrayList<Medicamento> medicamento = new ArrayList<Medicamento>();

    public Alta() {
        this.emAberto = true;
    }

    /**
     * Metodo para finalizar a Consulta
     * @throws AltaJaFechada
     */
    public void fechar() throws AltaJaFechada {
        if (this.emAberto){
            this.emAberto = false;
            return;
        } throw new AltaJaFechada("A alta ja foi fechada anteriormente.");
    }

    /**
     * Metodo para checagem do status da consulta
     * @throws AltaJaFechada
     */
    private void tentarMudarAtributo() throws AltaJaFechada {
        if (!this.emAberto) {
            throw new AltaJaFechada("Essa consulta ja foi dada alta e nao pode ser modificada.");
        }
    }

    /**
     * Metodo para adicao de medicamento na Alta
     * @param medicamento (Medicamento)
     * @throws AltaJaFechada
     */
    public void addMedicamento (Medicamento medicamento) throws AltaJaFechada {
        this.tentarMudarAtributo();

        this.medicamento.add(medicamento);
    }

    /**
     * Metodo para remocao de medicamento na alta
     * @param medicamento (Medicamento)
     */
    public void removeMedicamento (Medicamento medicamento) throws AltaJaFechada {
        this.tentarMudarAtributo();
        this.medicamento.remove(medicamento);
    }
}
