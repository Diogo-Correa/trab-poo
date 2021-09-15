package controllers.app;

import java.awt.*;

import controllers.Controller;
import models.clinica.consultas.Atendimento;
import util.auth.Auth;
import util.database.AtendimentosDatabase;
import views.Dashboard;
import views.atendimento.*;

public class AtendimentoController implements Controller {

    /**
     * Metodo para redirecionar para a view index do Atendimento
     */
    public void index() {
        // new Index();
    }

    /**
     * Metodo para redirecionar para a view de visualizacao
     * @param id Id referente ao Atendimento
     */
    public void show(int id) {
        // Edit.form((atendimento) atendimento); 
        
    }

    /**
     * Metodo para redirecionar para a view create do Atendimento
     */
    public void create() {
        new Create(); 
    }

    /**
     * Metodo para salvar os dados de um Atendimento
     * @param obj Objeto referente ao Atendimento
     */
    public <A> void store(A obj) {
        AtendimentosDatabase.addRecord((Atendimento) obj);
        Dashboard.setMessage("Atendimento adicionado com sucesso", Color.GREEN);
        
    }

    /**
     * Metodo para redirecionar para a view de edicao
     * @param id Id referente ao Atendimento
     */
    public void edit(int id) {
        // Edit.form((atendimento) atendimento); 
        
    }
    
    /**
     * Metodo para atualizar o banco de dados
     */
    public void update() {
        //
    }

    /**
     * Metodo de exclusao de um Atendimento
     * @param id Id referente ao Atendimento
     */
    public void delete(int id) {
        if(Auth.getRole().canDelete()) {
            AtendimentosDatabase.removeRecord(id);
            Dashboard.setMessage("Estagiario deletado com sucesso", Color.RED);
        } else {
            System.out.println("Voce nao tem permissao!");
        }
        
    }
    
}
