import java.util.ArrayList;

public class Alta {
    private Integer emAberto;
    private ArrayList<Medicamento> medicamento = new ArrayList();
    private ArrayList<Procedimento> procedimento = new ArrayList();

    public Alta() {
        this.emAberto = 1;
    }

    void fechar() {
        this.emAberto = 0;
    };

    private Boolean tentarMudarAtributo() {
        if (!this.emAberto) {
            throw AltaJaFechada("Essa consulta já foi dada alta e não pode ser modificada");
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
