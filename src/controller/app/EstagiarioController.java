package controller.app;

import app.App;
import controller.Controller;
import model.clinica.Estagiario;
import util.auth.Auth;
import util.database.Estagiarios;
import view.estagiario.*;

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
        if(Auth.getUser().getRole().canDelete()) 
            Estagiarios.removeEstagiario((Estagiario) estagiario);
    }
    
}
