public class Alta {
    private Integer emAberto;
    private Medicamento medicamento;
    private Procedimento procedimento;

    public Alta() {
        this.emAberto = 1;
    }

    String fechar() {
        this.emAberto = 0;
    };

    void setMedicamento(Medicamento medicamento){
        if(this.emAberto) {
            this.medicamento = medicamento;
        }else{
            
        }
    };

    void setProcedimento(){
        if(this.emAberto) {
            this.procedimento = procedimento;
        }
    };
}
