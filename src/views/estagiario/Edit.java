package views.estagiario;

import java.util.Scanner;

import app.App;
import controllers.middlewares.auth.Role;
import models.clinica.Estagiario;
import util.auth.Auth;
import util.database.Roles;

public class Edit {

    private Estagiario estagiario;

    public Edit(Estagiario estagiario) {
        if(!Auth.getRole().canEdit()) {
            System.out.println("Voce nao tem permissao!");
        } else {
            this.estagiario = estagiario;
            this.form();
        }
    }

    public void form() {
        Scanner input = new Scanner(System.in);

        System.out.println("[Formulario de edicao de estagiarios]");
        System.out.println("[Digite o mesmo valor caso nao queira alterar]");

        System.out.print("Digite o nome do estagiario ["+this.estagiario.getNome()+"]: ");
        String name = input.next();

        System.out.print("Escolha o ID nivel de acesso do estagiario: ");
        for(Role role : Roles.getRoles()) System.out.print(role.getId() +": "+role.getNome()+ "] ");
        Role role = Roles.find(input.nextInt());

        System.out.print("Digite a idade do estagiario ["+this.estagiario.getIdade()+"]: ");
        int idade = input.nextInt();

        System.out.print("Digite as horas semanais do contrato ["+this.estagiario.getHorasSemanais()+"]: ");
        int horas = input.nextInt();

        System.out.println("Confirma as alteracoes?");
        System.out.println("[0] Nao");
        System.out.println("[1] Sim");
        int confirma = input.nextInt();

        input.close();
        
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
