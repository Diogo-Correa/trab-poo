package app;

import util.auth.Auth;
import util.generator.*;
import util.log.Activity;


public class App {

    private String name;


    App(String name) {
        this.name = name;
        new Activity(this.name+": programa inicializado.");
        this.initialize();
        login();
    }

    public static void main(String[] args) throws Exception {
        new App("VetSystem");
    }

    public static void login() {
        new Auth("Andressa", "123");
    }

    private void initialize() {
        EnfermidadesGenerator.generate();
        // System.out.println(Enfermidades.getEnfermidades());
        UsersGenerator.generate();
        // System.out.println(Veterinarios.getVeterinarios());
        AnimaisGenerator.generate();
        // System.out.println(Animais.getAnimais());
    }
}
