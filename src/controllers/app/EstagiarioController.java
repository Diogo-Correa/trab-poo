package controllers.app;

import app.App;
import controllers.Controller;
import models.clinica.Estagiario;
import util.auth.Auth;
import util.database.Estagiarios;
import util.database.Users;
import views.estagiario.*;

public class EstagiarioController implements Controller {

    public void index() {
        new Index();
    }

    public void create() {
        new Create(); 
    }

    public <E> void store(E estagiario) {
        Estagiarios.addEstagiario((Estagiario) estagiario);
        // new App();
    }

    public <E> void update(E estagiario) {
        new Edit((Estagiario) estagiario); 
    }

    public <E> void delete(E estagiario) {
        if(Auth.getRole().canDelete()) {
            Estagiarios.removeEstagiario((Estagiario) estagiario);
            Users.removeUser((Estagiario) estagiario);
        } else {
            System.out.println("Voce nao tem permissao!");
        }
    }
    
}
