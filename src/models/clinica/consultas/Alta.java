package models.clinica.consultas;
import java.util.ArrayList;

import util.Medicamento;
import util.Procedimento;
import util.errors.AltaJaFechada;

public class Alta {
    private Boolean emAberto;
    private ArrayList<Medicamento> medicamento = new ArrayList<Medicamento>();
    private ArrayList<Procedimento> procedimento = new ArrayList<Procedimento>();

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
    
    
    /**
     * Metodo para adicao de Procedimento na Alta
     * @param procedimento (Procedimento)
     * @throws AltaJaFechada
     */
    public void addProcedimento (Procedimento procedimento) throws AltaJaFechada {
        this.tentarMudarAtributo();

        this.procedimento.add(procedimento);
    }

    /**
     * Metodo para remocao de Procedimento na Alta
     * @param procedimento (Procedimento)
     * @throws AltaJaFechada
     */
    public void removeProcedimento (Procedimento procedimento) throws AltaJaFechada {
        this.tentarMudarAtributo();

        this.procedimento.remove(procedimento);
    }
}
