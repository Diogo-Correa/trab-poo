package controllers.app;

import controllers.Controller;
import models.clientes.Animal;
import util.database.AnimaisDatabase;
import views.animal.*;

public class AnimalController implements Controller {

    /**
     * Metodo para redirecionar para a view index do Animal
     */
    public void index() {
        //
    }

    /**
     * Metodo para redirecionar para a view de visualizacao
     * @param id Id referente ao Animal
     */
    public void show(int id) {
        new Show(AnimaisDatabase.find(id));
    }

    /**
     * Metodo para redirecionar para a view create do Animal
     */
    public void create() {
        new Create();
    }

    /**
     * Metodo para salvar os dados de um Animal
     * @param obj Objeto referente ao Animal
     */
    public <O> void store(O obj) {
        AnimaisDatabase.addRecord((Animal) obj);
    }

    /**
     * Metodo para redirecionar para a view de edicao
     * @param id Id referente ao Animal
     */
    public void edit(int id) {
        //
    }
    
    /**
     * Metodo para atualizar o banco de dados
     */
    public void update(int id) {
        AnimaisDatabase.updateRecord(AnimaisDatabase.find(id));
    }

    /**
     * Metodo de exclusao de um Animal
     * @param id ID referente ao Animal
     */
    public void delete(int id) {
        //
    }
    
}
