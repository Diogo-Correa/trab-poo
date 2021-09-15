/**
 * O programa implementa uma aplicacao para
 * gerenciar atendimentos e consultas de uma clinica veterinaria.
 * O sistema conta com autenticacao, niveis de acesso, permissoes e log.
 * 
 * @author Diogo Correa
 * @author Bruno Rodrigues
 * @since 2021-08-20
 */

package app;

import util.auth.Auth;
import util.errors.UserCadastradoException;
import util.generator.*;
import util.log.Activity;
import views.Dashboard;
import views.Login;


public class App {

    private String name;

    App(String name) {
        this.name = name;
        new Activity(this.name+": programa inicializado.");
        initialize();
        new Login();
    }

    public App() {
        if(Auth.isAuthenticated()) new Dashboard();
        else new Login();
    }

    public static void main(String[] args) throws Exception {
        new App("[VetSystem] POO Project");
    }

    private static void initialize() {
        // EnfermidadesGenerator.generate();
        // System.out.println(Enfermidades.getEnfermidades());
        try {
            UsersGenerator.generate();
        } catch (UserCadastradoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // System.out.println(Veterinarios.getVeterinarios());
        // AnimaisGenerator.generate();
        // System.out.println(AnimaisDatabase.all());
    }
}
