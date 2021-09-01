package view.estagiario;

import java.util.Scanner;

import app.App;
import controller.middlewares.auth.Role;
import model.clinica.Estagiario;
import util.database.Roles;

public class Edit {
    public static void form(Estagiario estagiario) {
        Scanner input = new Scanner(System.in);

        System.out.println("[Formulario de edicao de estagiarios]");
        System.out.println("[Digite o mesmo valor caso nao queira alterar]");

        System.out.print("Digite o nome do estagiario ["+estagiario.getNome()+"]: ");
        String name = input.next();

        System.out.print("Escolha o nivel de acesso do estagiario: ");
        for(Role role : Roles.getRoles()) System.out.print("["+role.getNome()+ "] ");
        Role role = Roles.find(input.next());

        System.out.print("Digite a idade do estagiario ["+estagiario.getIdade()+"]: ");
        int idade = input.nextInt();

        System.out.print("Digite as horas semanais do contrato ["+estagiario.getHorasSemanais()+"]: ");
        int horas = input.nextInt();

        System.out.println("Confirma as alteracoes?");
        System.out.println("[0] Nao");
        System.out.println("[1] Sim");
        int confirma = input.nextInt();

        if(confirma == 0) {
          new App();
        } else {
            estagiario.setNome(name);
            estagiario.setRole(role);
            estagiario.setIdade(idade);
            estagiario.setHorasSemanais(horas);
            new App();
        }


    }
}
