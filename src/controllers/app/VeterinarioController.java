package controllers.app;

import app.App;
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

    public <V> void store(V veterinario) {
        Veterinarios.addVeterinario((Veterinario) veterinario);
        // new App();
    }

    public <V> void update(V veterinario) {
        new Edit((Veterinario) veterinario); 
    }

    public <V> void delete(V veterinario) {
        if(Auth.getRole().canDelete()) {
            Veterinarios.removeVeterinario((Veterinario) veterinario);
            Users.removeUser((Veterinario) veterinario); 
        } else {
            System.out.println("Voce nao tem permissao!");
        }
    }
    
}
