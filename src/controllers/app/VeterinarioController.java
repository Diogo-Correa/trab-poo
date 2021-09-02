package controllers.app;

import controllers.Controller;
import models.clinica.Veterinario;
import util.auth.Auth;
import util.database.Users;
import util.database.Veterinarios;
import views.veterinario.*;

public class VeterinarioController implements Controller {

    public void index() {
       new Index();
    }

    public void create() {
        new Create(); 
    }

    public <V> void store(V obj) {
        Veterinarios.addVeterinario((Veterinario) obj);
        // new App();
    }

    public void update(int id) {
        new Edit(Veterinarios.find(id)); 
    }

    public void delete(int id) {
        if(Auth.getRole().canDelete()) {
            Veterinarios.removeVeterinario(Veterinarios.find(id));
            Users.removeUser(Veterinarios.find(id)); 
        } else {
            System.out.println("Voce nao tem permissao!");
        }
    }
    
}
