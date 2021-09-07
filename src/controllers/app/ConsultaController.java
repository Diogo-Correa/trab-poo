package controllers.app;

import controllers.Controller;
import models.clinica.consultas.Consulta;
import util.auth.Auth;
import util.database.Consultas;
import views.atendimento.*;

public class ConsultaController implements Controller {

    /**
     * Metodo para redirecionar para a view index da Consulta
     */
    public void index() {
        new Index();
    }

    /**
     * Metodo para redirecionar para a view de visualizacao
     * @param id Id referente ao Consulta
     */
    public void show(int id) {}

    /**
     * Metodo para redirecionar para a view create da Consulta
     */
    public void create() {
        new Create(); 
    }

    /**
     * Metodo para salvar os dados de uma Consulta
     * @param obj Objeto referente a Consulta
     */
    public <A> void store(A obj) {
        Consultas.addConsulta((Consulta) obj);
        // new App();
        
    }

    /**
     * Metodo para redirecionar para a view de edicao
     * @param id Id referente ao Consulta
     */
    public void update(int id) {
        // Edit.form((consulta) consulta); 
        
    }

    /**
     * Metodo de exclusao de uma Consulta
     * @param id Id referente a Consulta
     */
    public void delete(int id) {
        if(Auth.getRole().canDelete()) {
            Consultas.removeConsulta(Consultas.find(id));
        } else {
            System.out.println("Voce nao tem permissao!");
        }
        
    }
    
}
