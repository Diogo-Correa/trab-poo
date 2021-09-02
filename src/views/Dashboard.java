package views;

import util.auth.Auth;
import util.database.*;

import java.util.Scanner;

import controllers.app.*;
import models.clinica.*;

public class Dashboard {

    public Dashboard() {
        if(Auth.isAuthenticated()) run();
        else { 
            System.out.println("Voce nao tem permissao");
            System.exit(0); 
        }
    }

    public static void run() {


        Scanner input = new Scanner(System.in);

        System.out.println("Ola " + Auth.getUser().getNome());
        System.out.println("O que deseja fazer?");

            
        System.out.println("[0] Logout");
        System.out.println("[1] Iniciar um atendimento");
    
        if(Auth.getRole().canCreate())
            System.out.println("[2] Cadastrar um novo estagiario");

        if(Auth.getRole().canEdit())
            System.out.println("[3] Editar um estagiario");

        if(Auth.getRole().canDelete())
            System.out.println("[4] Deletar um estagiario");

        if(Auth.getRole().canCreate())
            System.out.println("[5] Cadastrar um novo veterinario");

        if(Auth.getRole().canEdit())
            System.out.println("[6] Editar um veterinario");

        if(Auth.getRole().canDelete())
            System.out.println("[7] Deletar um veterinario");

        int op = input.nextInt();

        while(op > -1) {
            switch (op) {
                case 0:
                    Auth.logout();
                    break;
                case 1:
                    new AtendimentoController().create();
                    break;

                case 2:
                    new EstagiarioController().create();
                    break;

                case 3:
                    for(Estagiario estagiario : Estagiarios.getEstagiarios()) System.out.println(estagiario.getNome() + ": " + estagiario.getContrato());
                    System.out.print("Digite o contrato do estagiario que deseja editar: ");
                    new EstagiarioController().update(Estagiarios.find(input.next()));
                    break;

                case 4:
                    for(Estagiario estag : Estagiarios.getEstagiarios()) System.out.println(estag.getNome() + ": " + estag.getContrato());
                    System.out.print("Digite o contrato do estagiario que deseja excluir: ");
                    new EstagiarioController().delete(Estagiarios.find(input.next()));
                    break;

                case 5:
                    new VeterinarioController().create();
                    break;

                case 6:
                    for(Veterinario veterinario : Veterinarios.getVeterinarios()) System.out.println(veterinario.getNome() + ": " + veterinario.getCRMV());
                    System.out.print("Digite o CRMV do veterinario que deseja editar: ");
                    new VeterinarioController().update(Veterinarios.find(input.next()));
                    break;
                    
                case 7:
                    for(Veterinario veterinario : Veterinarios.getVeterinarios()) System.out.println(veterinario.getNome() + ": " + veterinario.getCRMV());
                    System.out.print("Digite o CRMV do veterinario que deseja deletar: ");
                    new VeterinarioController().delete(Veterinarios.find(input.next()));
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        
            System.out.println("Ola " + Auth.getUser().getNome());
            System.out.println("O que deseja fazer?");

            
            System.out.println("[0] Logout");
            System.out.println("[1] Iniciar um atendimento");
        
            if(Auth.getRole().canCreate())
                System.out.println("[2] Cadastrar um novo estagiario");
    
            if(Auth.getRole().canEdit())
                System.out.println("[3] Editar um estagiario");
    
            if(Auth.getRole().canDelete())
                System.out.println("[4] Deletar um estagiario");
    
            if(Auth.getRole().canCreate())
                System.out.println("[5] Cadastrar um novo veterinario");
    
            if(Auth.getRole().canEdit())
                System.out.println("[6] Editar um veterinario");
    
            if(Auth.getRole().canDelete())
                System.out.println("[7] Deletar um veterinario");

            op = input.nextInt();
        }
    }
}
