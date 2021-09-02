package views.veterinario;

import java.util.Scanner;

import app.App;
import controllers.middlewares.auth.Role;
import models.clinica.Veterinario;
import util.Enfermidade;
import util.auth.Auth;
import util.database.Enfermidades;
import util.database.Roles;

public class Edit {

    private Veterinario veterinario;

    public Edit(Veterinario veterinario) {
        if(!Auth.getRole().canEdit()) {
            System.out.println("Voce nao tem permissao!");
        } else {
            this.veterinario = veterinario;
            this.form();
        }
    }
    
    public void form() {
        Scanner input = new Scanner(System.in);

        System.out.println("[Formulario de edicao de veterinarios]");
        System.out.println("[Digite o mesmo valor caso nao queira alterar]");

        System.out.print("Digite o nome do veterinario ["+this.veterinario.getNome()+"]: ");
        String name = input.next();

        System.out.print("Escolha o nivel de acesso do veterinario: ");
        for(Role role : Roles.getRoles()) System.out.print("["+role.getNome()+ "] ");
        Role role = Roles.find(input.next());

        System.out.print("Escolha a especialidade do veterinario: ");
        for(Enfermidade enfermidade : Enfermidades.getEnfermidades()) System.out.print("["+enfermidade.getNome()+ "] ");
        Enfermidade especialidade = Enfermidades.find(input.next());

        System.out.print("Digite a idade do veterinario ["+this.veterinario.getIdade()+"]: ");
        int idade = input.nextInt();

        System.out.println("Confirma as alteracoes?");
        System.out.println("[0] Nao");
        System.out.println("[1] Sim");
        int confirma = input.nextInt();

        if(confirma == 0) {
          new App();
        } else {
            veterinario.setNome(name);
            veterinario.setRole(role);
            veterinario.setIdade(idade);
            veterinario.setEspecialidade(especialidade);
            new App();
        }


    }
}
