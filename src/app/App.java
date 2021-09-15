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
import util.generator.*;
import util.log.Activity;
import views.Dashboard;
import views.Login;

import util.database.AnimaisDatabase;
import models.clientes.Animal;
import models.clientes.Dono;
import java.util.ArrayList;




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
        // new App("[VetSystem] POO Project");

        AnimaisDatabase dogs = new AnimaisDatabase();
        Animal dog = new Animal(
            "Thor", 
            "Cachorro", 
            "Labrador", 
            "Grande", 
            "Longo", 
            false
            );
        Dono dono = new Dono("Marcelo", "(21) 00000-0000", 26, dog.getId());
            
        // ArrayList<Animal> allDogs = new ArrayList<Animal>();
        // allDogs = dogs.all();

        // for(Animal doguinhos : allDogs) {
        //     System.out.println(doguinhos.getNome() + " " + doguinhos.getId());
        // }

        // dog = dogs.find(4);
        // System.out.println(dog.getName() + " " + dog.getId());
    }

    private static void initialize() {
        EnfermidadesGenerator.generate();
        // System.out.println(Enfermidades.getEnfermidades());
        UsersGenerator.generate();
        // System.out.println(Veterinarios.getVeterinarios());
        AnimaisGenerator.generate();
        // System.out.println(Animais.getAnimais());
    }
}
