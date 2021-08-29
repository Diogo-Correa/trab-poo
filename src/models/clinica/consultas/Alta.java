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

    public void fechar() throws AltaJaFechada {
        if (this.emAberto){
            this.emAberto = false;
            return;
        } throw new AltaJaFechada("A alta ja foi fechada anteriormente.");
    }

    private void tentarMudarAtributo() throws AltaJaFechada {
        if (!this.emAberto) {
            throw new AltaJaFechada("Essa consulta ja foi dada alta e nao pode ser modificada.");
        }
    }

    // Modificador do Medicamento
    public void addMedicamento (Medicamento medicamento) throws AltaJaFechada {
        tentarMudarAtributo();

        this.medicamento.add(medicamento);
    }

    public void removeMedicamento (Medicamento medicamento) throws AltaJaFechada {
        tentarMudarAtributo();

        this.medicamento.remove(medicamento);
    }
    ////////////////////////////////

    // Modificador do Precedimento
    public void addProcedimento (Procedimento procedimento) throws AltaJaFechada {
        tentarMudarAtributo();

        this.procedimento.add(procedimento);
    }

    public void removeProcedimento (Procedimento procedimento) throws AltaJaFechada {
        tentarMudarAtributo();

        this.procedimento.remove(procedimento);
    }
    ///////////////////////////////
}
