package controllers.app;

import java.awt.*;

import controllers.Controller;
import models.clinica.consultas.Atendimento;
import util.auth.Auth;
import util.database.Atendimentos;
import views.Dashboard;
import views.atendimento.*;

public class AtendimentoController implements Controller {

    /**
     * Metodo para redirecionar para a view index do Atendimento
     */
    public void index() {
        new Index();
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
        Atendimentos.addAtendimento((Atendimento) obj);
        Dashboard.setMessage("Atendimento adicionado com sucesso", Color.GREEN);
        
    }

    /**
     * Metodo para redirecionar para a view de edicao
     * @param id Id referente ao Atendimento
     */
    public void update(int id) {
        // Edit.form((atendimento) atendimento); 
        
    }

    /**
     * Metodo de exclusao de um Atendimento
     * @param id Id referente ao Atendimento
     */
    public void delete(int id) {
        if(Auth.getRole().canDelete()) {
            Atendimentos.removeAtendimento(Atendimentos.find(id));
            Dashboard.setMessage("Estagiario deletado com sucesso", Color.RED);
        } else {
            System.out.println("Voce nao tem permissao!");
        }
        
    }
    
}
