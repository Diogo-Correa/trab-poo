package views.estagiario;

import java.util.Scanner;

import controllers.middlewares.auth.Role;
import models.clinica.Estagiario;
import util.auth.Auth;
import util.database.Roles;

public class Create {

    public Create() {
        if(!Auth.getRole().canCreate()) {
            System.out.println("Voce nao tem permissao!");
        } else form();
    }
    
    public static void form() {
        Scanner input = new Scanner(System.in);

        System.out.println("[Formulario de cadastro de estagiarios]");

        System.out.print("Digite o nome do estagiario: ");
        String name = input.next();

        System.out.print("Digite a senha do estagiario: ");
        String password = input.next();

        System.out.print("Escolha o ID nivel de acesso do estagiario: ");
        for(Role role : Roles.getRoles()) System.out.print(role.getId() +": ["+role.getNome()+ "] ");
        Role role = Roles.find(input.nextInt());

        System.out.print("Digite a idade do estagiario: ");
        int idade = input.nextInt();

        System.out.print("Digite as horas semanais do contrato: ");
        int horas = input.nextInt();

        System.out.print("Digite o numero de contrato do estagiario: (usado para localizar no sistema) ");
        String contrato = input.next();

        new Estagiario(name, password, role,  idade, horas, contrato);
    }
}
