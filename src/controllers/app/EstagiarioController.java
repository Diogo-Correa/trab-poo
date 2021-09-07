package controllers.app;

import controllers.Controller;
import models.clinica.Estagiario;
import util.auth.Auth;
import util.database.Estagiarios;
import util.database.Users;
import views.estagiario.*;

public class EstagiarioController implements Controller {

    /**
     * Metodo para redirecionar para a view index do Estagiario
     */
    public void index() {
        new Index();
    }

    /**
     * Metodo para redirecionar para a view de visualizacao
     * @param id Id referente ao Estagiario
     */
    public void show(int id) {
        new Show(Estagiarios.find(id));
    }

    /**
     * Metodo para redirecionar para a view index do Estagiario
     */
    public void create() {
        new Create(); 
    }

    /**
     * Metodo para salvar os dados de um Estagiario
     * @param obj Objeto referente ao Estagiario
     */
    public <E> void store(E obj) {
        Estagiarios.addEstagiario((Estagiario) obj);
        // new App();
    }

    /**
     * Metodo para redirecionar para a view de edicao
     * @param id Id referente ao Estagiario
     */
    public void update(int id) {
        new Edit(Estagiarios.find(id)); 
    }

    /**
     * Metodo de exclusao de um Estagiario
     * @param id Id referente ao Estagiario
     */
    public void delete(int id) {
        if(Auth.getRole().canDelete()) {
            Estagiarios.removeEstagiario(Estagiarios.find(id));
            Users.removeUser(Users.find(id));
        } else {
            System.out.println("Voce nao tem permissao!");
        }
    }
    
}
