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
import util.generator.UsersGenerator;
import util.log.Activity;
import views.Dashboard;
import views.Login;

import util.database.AnimaisDatabase;
import models.clientes.Animal;
import util.generator.AnimaisGenerator;
import util.generator.EnfermidadesGenerator;

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
        
        // Animal a1 = new Animal(
        //     "aaaa", 
        //     "Cachorro", 
        //     "Labrador", 
        //     "Grande", 
        //     "Longo", 
        //     false
        // );

        // AnimaisGenerator.generate();
        // System.out.println(AnimaisDatabase.all());

        // Animal dog = AnimaisDatabase.find(3); 
        // System.out.println(dog.getNome());

        // dog.setNome("Toasd");
        // System.out.println(dog.getNome());

        // AnimaisDatabase.updateRecord(dog);

        // System.out.println(AnimaisDatabase.all());
        // dog = AnimaisDatabase.find(3);
        // System.out.println(dog.getNome());
    }

    private static void initialize() {
        EnfermidadesGenerator.generate();
        try {
        UsersGenerator.generate();
        } catch (UserCadastradoException e) {
        e.printStackTrace();
        }
        AnimaisGenerator.generate();
    }
}
