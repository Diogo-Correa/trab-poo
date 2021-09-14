package controllers.app;

import java.awt.*;

import controllers.Controller;
import models.clinica.Veterinario;
import util.auth.Auth;
import util.database.Users;
import util.database.Veterinarios;
import views.Dashboard;
import views.veterinario.*;

public class VeterinarioController implements Controller {

    /**
     * Metodo para redirecionar para a view index do Veterinario
     */
    public void index() {
        new Index();
    }

    /**
     * Metodo para redirecionar para a view de visualizacao
     * @param id Id referente ao Veterinario
     */
    public void show(int id) {
        new Show(Veterinarios.find(id));
    }

    /**
     * Metodo para redirecionar para a view create do Veterinario
     */
    public void create() {
        new Create(); 
    }

    /**
     * Metodo para salvar os dados de um Veterinario
     * @param obj Objeto referente ao Veterinario
     */
    public <V> void store(V obj) {
        Veterinarios.addVeterinario((Veterinario) obj);
        //Dashboard.setMessage("Veterinario adicionado com sucesso", Color.GREEN);
    }

    /**
     * Metodo para redirecionar para a view de edicao
     * @param id Id referente ao Veterinario
     */
    public void update(int id) {
        new Edit(Veterinarios.find(id)); 
    }


    /**
     * Metodo de exclusao de um Veterinario
     * @param id ID referente ao Veterinario
     */
    public void delete(int id) {
        if(Auth.getRole().canDelete()) {
            Veterinarios.removeVeterinario(Veterinarios.find(id));
            Users.removeUser(Users.find(id));
            Dashboard.setMessage("Veterinario deletado com sucesso", Color.RED); 
        } else {
            System.out.println("Voce nao tem permissao!");
        }
    }
    
}
