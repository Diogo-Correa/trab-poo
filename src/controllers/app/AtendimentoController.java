package controllers.app;

import controllers.Controller;
import models.clinica.consultas.Atendimento;
import util.auth.Auth;
import util.database.Atendimentos;
import views.atendimento.*;

public class AtendimentoController implements Controller {

    public void index() {
        new Index();
    }

    public void create() {
        new Create(); 
    }

    public <A> void store(A atendimento) {
        Atendimentos.addAtendimento((Atendimento) atendimento);
        // new App();
        
    }

    public <A> void update(A atendimento) {
        // Edit.form((atendimento) atendimento); 
        
    }

    public <A> void delete(A atendimento) {
        if(Auth.getRole().canDelete()) {
            Atendimentos.removeAtendimento((Atendimento) atendimento);
        } else {
            System.out.println("Voce nao tem permissao!");
        }
        
    }
    
}
