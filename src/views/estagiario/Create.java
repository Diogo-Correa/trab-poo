package views.estagiario;

import java.util.Scanner;

import controllers.middlewares.auth.Role;
import models.clinica.Estagiario;
import util.database.Roles;

public class Create {
    public static void form() {
        Scanner input = new Scanner(System.in);

        System.out.println("[Formulario de cadastro de estagiarios]");

        System.out.print("Digite o nome do estagiario: ");
        String name = input.next();

        System.out.print("Digite a senha do estagiario: ");
        String password = input.next();

        System.out.print("Escolha o nivel de acesso do estagiario: ");
        for(Role role : Roles.getRoles()) System.out.print("["+role.getNome()+ "] ");
        Role role = Roles.find(input.next());

        System.out.print("Digite a idade do estagiario: ");
        int idade = input.nextInt();

        System.out.print("Digite as horas semanais do contrato: ");
        int horas = input.nextInt();

        System.out.print("Digite o numero de contrato do estagiario: (usado para localizar no sistema) ");
        String contrato = input.next();

        new Estagiario(name, password, role,  idade, horas, contrato);
    }
}
