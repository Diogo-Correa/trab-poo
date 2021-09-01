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
        if(Auth.getUser().getRole().canShow()) 
            Index.run();
    }

    public void create() {
        Create.form(); 
    }

    public <E> void store(E estagiario) {
        Estagiarios.addEstagiario((Estagiario) estagiario);
        if(Auth.isAuthenticated())
            Index.run();
        else App.login();
    }

    public <E> void update(E estagiario) {
        Edit.form((Estagiario) estagiario); 
    }

    public <E> void delete(E estagiario) {
        if(Auth.getUser().getRole().canDelete()) {
            Estagiarios.removeEstagiario((Estagiario) estagiario);
            Users.removeUser((Estagiario) estagiario);
        }
    }
    
}
