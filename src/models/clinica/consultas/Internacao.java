package models.clinica.consultas;

import util.errors.AltaJaFechada;
import util.status.VeterinarioStatus;

public class Internacao implements Runnable {

    private Consulta consulta;

    public Internacao(Consulta consulta) {
        this.consulta = consulta;
        this.consulta.getVeterinario().setStatus(VeterinarioStatus.ATIVO);
    }

    public void run() {
        try {
            Thread.sleep(10000 * 1);
            try {
                this.consulta.terminarConsulta();
            } catch (AltaJaFechada e) {
                System.out.println(e);
            }
        } catch(InterruptedException e) {

        }
    }
    
}
