package views.veterinario;

import java.util.Scanner;

import app.App;
import controllers.middlewares.auth.Role;
import models.clinica.Veterinario;
import util.Enfermidade;
import util.auth.Auth;
import util.database.Enfermidades;
import util.database.Roles;

public class Create {

    public Create() {
        if(!Auth.getRole().canCreate()) {
            System.out.println("Voce nao tem permissao!");
        } else form();
    }
    
    public static void form() {
        Scanner input = new Scanner(System.in);

        System.out.println("[Formulario de cadastro de veterinarios]");

        System.out.print("Digite o nome do veterinario: ");
        String name = input.next();

        System.out.print("Digite a senha do veterinario: ");
        String password = input.next();

        System.out.print("Digite o ID do nivel de acesso do veterinario: ");
        for(Role role : Roles.getRoles()) System.out.print(role.getId() +": ["+role.getNome()+ "] ");
        Role role = Roles.find(input.nextInt());

        System.out.print("Digite o ID da especialidade do veterinario: ");
        for(Enfermidade enfermidade : Enfermidades.getEnfermidades()) System.out.print(enfermidade.getId() +": ["+enfermidade.getNome()+ "] ");
        Enfermidade especialidade = Enfermidades.find(input.nextInt());

        System.out.print("CRMV: ");
        String crmv = input.next();

        System.out.print("Digite a idade do veterinario: ");
        int idade = input.nextInt();

        if(especialidade != null) {
            new Veterinario(name, password, role, idade, crmv, especialidade);
            new App();
        }
        else {
            new Veterinario(name, password, role, idade, crmv);
            new App();
        }
    }
}
