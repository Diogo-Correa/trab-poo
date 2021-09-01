package app;

import java.util.Scanner;

import controllers.app.*;
import util.auth.Auth;
import util.generator.*;
import util.log.Activity;
import views.Dashboard;


public class App {

    private String name;

    App(String name) {
        this.name = name;
        new Activity(this.name+": programa inicializado.");
        initialize();
        login();
    }

    public App() {
        if(Auth.isAuthenticated()) Dashboard.run();
        else login();
    }

    public static void main(String[] args) throws Exception {
        new App("VetSystem");
    }

    public static void login() {
        Scanner input = new Scanner(System.in);

        System.out.println("Selecione uma opcao: ");
        System.out.println("[0] Encerrar");
        System.out.println("[1] Login");
        System.out.println("[2] Cadastro");

        int op = input.nextInt();

        while(op > -1) {
            switch(op) {
                case 0:
                    System.out.println("Programa encerrado.");
                    System.exit(0);
                case 1:
                    System.out.print("Digite o usuario: ");
                    String user = input.next();

                    System.out.print("Digite a senha: ");
                    String password = input.next();

                    new Auth(user, password);
                    break;

                case 2:
                    System.out.println("Selecione uma opcao: ");
                    System.out.println("[0] Voltar");
                    System.out.println("[1] Estagiario");
                    System.out.println("[2] Veterinario");
                    int opUser = input.nextInt();

                    if(opUser == 1) {
                        new EstagiarioController().create();
                    } else if(opUser == 2) {
                        new VeterinarioController().create();
                    } else op = 100;
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

            System.out.println("Selecione uma opcao: ");
            System.out.println("[0] Encerrar");
            System.out.println("[1] Login");
            System.out.println("[2] Cadastro");
    
            op = input.nextInt();
        }
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
