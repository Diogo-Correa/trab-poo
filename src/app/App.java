package app;

import java.util.Scanner;

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
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o usuario:");
        String user = input.next();

        System.out.println("Digite a senha:");
        String password = input.next();

        new Auth(user, password);
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
