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

    public <A> void store(A obj) {
        Atendimentos.addAtendimento((Atendimento) obj);
        // new App();
        
    }

    public void update(int id) {
        // Edit.form((atendimento) atendimento); 
        
    }

    public void delete(int id) {
        if(Auth.getRole().canDelete()) {
            Atendimentos.removeAtendimento(Atendimentos.find(id));
        } else {
            System.out.println("Voce nao tem permissao!");
        }
        
    }
    
}
