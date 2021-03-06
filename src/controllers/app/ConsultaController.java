package controllers.app;

import java.awt.*;

import controllers.Controller;
import models.clinica.consultas.Consulta;
import util.auth.Auth;
import util.database.ConsultasDatabase;
import views.Dashboard;
// import views.consulta.*;

public class ConsultaController implements Controller {

    /**
     * Metodo para redirecionar para a view index da Consulta
     */
    public void index() {
        // new Index();
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
      //  new Create(); 
    }

    /**
     * Metodo para salvar os dados de uma Consulta
     * @param obj Objeto referente a Consulta
     */
    public <A> void store(A obj) {
        ConsultasDatabase.addRecord((Consulta) obj);
        Dashboard.setMessage("Consulta adicionada com sucesso", Color.GREEN);
        
    }

    /**
     * Metodo para redirecionar para a view de edicao
     * @param id Id referente ao Consulta
     */
    public void edit(int id) {
        // Edit.form((consulta) consulta); 
        
    }
    
    /**
     * Metodo para atualizar o banco de dados
     */
    public void update(int id) {
        //
    }

    /**
     * Metodo de exclusao de uma Consulta
     * @param id Id referente a Consulta
     */
    public void delete(int id) {
        if(Auth.getRole().canDelete()) {
            ConsultasDatabase.removeRecord(id);
            Dashboard.setMessage("Cosulta deletada com sucesso", Color.RED);
        } else {
            System.out.println("Voce nao tem permissao!");
        }
        
    }
    
}
