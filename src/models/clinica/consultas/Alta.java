package models.clinica.consultas;
import models.util.Procedimento;
import models.util.Medicamento;
import models.util.errors.AltaJaFechada;
import java.util.ArrayList;

public class Alta {
    private Boolean emAberto;
    private ArrayList<Medicamento> medicamento = new ArrayList<Medicamento>();
    private ArrayList<Procedimento> procedimento = new ArrayList<Procedimento>();

    public Alta() {
        this.emAberto = true;
    }

    void fechar() {
        this.emAberto = false;
    };

    private void tentarMudarAtributo() throws AltaJaFechada{
        if (!this.emAberto) {
            throw new AltaJaFechada("Essa consulta ja foi dada alta e nao pode ser modificada");
        }
    }

    // Modificador do Medicamento
    void addMedicamento (Medicamento medicamento) throws AltaJaFechada{
        tentarMudarAtributo();

        this.medicamento.add(medicamento);
    };
    void removeMedicamento (Medicamento medicamento) throws AltaJaFechada{
        tentarMudarAtributo();

        this.medicamento.remove(medicamento);
    };
    ////////////////////////////////

    // Modificador do Precedimento
    void addProcedimento (Procedimento procedimento) throws AltaJaFechada{
        tentarMudarAtributo();

        this.procedimento.add(procedimento);
    };
    void removeProcedimento (Procedimento procedimento) throws AltaJaFechada{
        tentarMudarAtributo();

        this.procedimento.remove(procedimento);
    };
    ///////////////////////////////

    void setProcedimento(){

    };
}
