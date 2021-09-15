package models.clinica.consultas;

import java.awt.*;

import util.auth.Auth;
import util.database.VeterinariosDatabase;
import util.errors.AltaJaFechada;
import util.status.VeterinarioStatus;
import views.Dashboard;

public class Internacao implements Runnable {

    private Consulta consulta;
    private int time;

    public Internacao(Consulta consulta, int time) {
        this.consulta = consulta;
        this.time = time;
        this.consulta.getVeterinario().setStatus(VeterinarioStatus.ATIVO);
        VeterinariosDatabase.updateRecord(this.consulta.getVeterinario());
    }

    public void run() {
        try {
            Thread.sleep(this.time);
            try {
                this.consulta.terminarConsulta();
                Dashboard.setMessage("O paciente " + this.consulta.getAnimal().getNome() + " teve alta!", Color.CYAN);
            } catch (AltaJaFechada e) {
                //System.out.println(e);
            }
        } catch(InterruptedException e) {

        }
    }
    
}
