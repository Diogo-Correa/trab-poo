package controllers.app;

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

    public <E> void store(E obj) {
        Estagiarios.addEstagiario((Estagiario) obj);
        // new App();
    }

    public void update(int id) {
        new Edit(Estagiarios.find(id)); 
    }

    public void delete(int id) {
        if(Auth.getRole().canDelete()) {
            Estagiarios.removeEstagiario(Estagiarios.find(id));
            Users.removeUser(Estagiarios.find(id));
        } else {
            System.out.println("Voce nao tem permissao!");
        }
    }
    
}
