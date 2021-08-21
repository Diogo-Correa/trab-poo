package models.clinica.consultas;

import models.util.Medicamento;
import models.util.Procedimento;

public class Alta {
    private boolean emAberto;
    private Medicamento medicamento;
    private Procedimento procedimento;

    public Alta() {
        this.emAberto = true;
    }

    public boolean fechar() {
        return this.emAberto = false;
    };

    public void setMedicamento(Medicamento medicamento){
        if(this.emAberto) {
            this.medicamento = medicamento;
        }else{
            
        }
    };

    public void setProcedimento(Procedimento procedimento){
        if(this.emAberto) {
            this.procedimento = procedimento;
        }
    };
}
