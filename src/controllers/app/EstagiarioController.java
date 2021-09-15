package controllers.app;

import java.awt.*;

import controllers.Controller;
import models.clinica.Estagiario;
import util.auth.Auth;
import util.database.EstagiariosDatabase;
import views.Dashboard;
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
        new Show(EstagiariosDatabase.find(id));
    }

    /**
     * Metodo para redirecionar para a view create do Estagiario
     */
    public void create() {
        new Create(); 
    }

    /**
     * Metodo para salvar os dados de um Estagiario
     * @param obj Objeto referente ao Estagiario
     */
    public <E> void store(E obj) {
        EstagiariosDatabase.addRecord((Estagiario) obj);
        //Dashboard.setMessage("Estagiario adicionado com sucesso", Color.GREEN);
    }

    /**
     * Metodo para redirecionar para a view de edicao
     * @param id Id referente ao Estagiario
     */
    public void update(int id) {
        new Edit(EstagiariosDatabase.find(id)); 
    }

    /**
     * Metodo de exclusao de um Estagiario
     * @param id Id referente ao Estagiario
     */
    public void delete(int id) {
        if(Auth.getRole().canDelete()) {
            EstagiariosDatabase.removeRecord(id);
            // Users.removeUser(Users.find(id));
            Dashboard.setMessage("Estagiario deletado com sucesso", Color.RED);
        } else {
            System.out.println("Voce nao tem permissao!");
        }
    }
    
}
