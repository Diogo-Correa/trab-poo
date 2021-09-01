package views;

import util.Enfermidade;
import util.auth.Auth;
import util.database.*;

import java.util.Scanner;

import controllers.app.*;
import models.clientes.*;
import models.clinica.*;
import models.clinica.consultas.Atendimento;
import models.clinica.consultas.Consulta;

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
    
        if(Auth.getUser().getRole().canCreate())
            System.out.println("[2] Cadastrar um novo estagiario");

        if(Auth.getUser().getRole().canEdit())
            System.out.println("[3] Editar um estagiario");

        if(Auth.getUser().getRole().canDelete())
            System.out.println("[4] Deletar um estagiario");

        if(Auth.getUser().getRole().canCreate())
            System.out.println("[5] Cadastrar um novo veterinario");

        if(Auth.getUser().getRole().canEdit())
            System.out.println("[6] Editar um veterinario");

        if(Auth.getUser().getRole().canDelete())
            System.out.println("[7] Deletar um veterinario");

        int op = input.nextInt();

        while(op > -1) {
            switch (op) {
                case 0:
                    Auth.logout();
                    break;
                case 1:
                    // Busca por um animal
                    System.out.println("Animais:");
                    for(Animal animal : Animais.getAnimais()) System.out.print(animal.getNome()+ ", ");
                    System.out.println();
                    System.out.println("Digite o nome de um dos animais listados:");
                    String nomeAnimal = input.next();
                    Animal animal = Animais.find(nomeAnimal);

                    // Busca enfermidade
                    for(Enfermidade enfer : Enfermidades.getEnfermidades()) System.out.print(enfer.getNome()+ ", ");
                    System.out.println();
                    System.out.println("Digite o nome de uma enfermidade listada:");
                    String nomeEnfermidade = input.next();
                    Enfermidade enfermidade = Enfermidades.find(nomeEnfermidade);

                    // Inicia atendimento
                    Atendimento atendimento = new Atendimento(animal);

                    // seta a enfermidade no animal
                    atendimento.setEnfermidade(enfermidade);

                    // busca por um veterinario
                    atendimento.buscaVeterinario();
                    System.out.println("Veterinario selecionado: " + atendimento.getVeterinario().getNome());

                    // Fazendo busca por algum veterinario e setando alguma especialidade para ele.
                    // Apenas testes
                    Veterinario vet = Veterinarios.find("12345");
                    vet.setEspecialidade(enfermidade);
                    // Nova busca por um veterinario especializado na enfermidade informada.
                    atendimento.buscaVeterinario();
                    System.out.println("Veterinario selecionado: " + atendimento.getVeterinario().getNome());
                    System.out.println();

                    // encaminha para a consulta
                    Consulta encaminhado = atendimento.abreConsulta();

                    // Infos da consulta, apos encaminhamento pelo primeiro atendimento.
                    System.out.println("Data de inicio da consulta: " + encaminhado.getDataAbertura());
                    System.out.println("Veterinario responsavel: " + encaminhado.getVeterinario().getNome());
                    System.out.println("Status do veterinario: " + encaminhado.getVeterinario().getVeterinarioStatus());
                    System.out.println("Animal em atendimento: " + encaminhado.getAnimal().getNome());
                    System.out.println("Nome da enfermidade: " + encaminhado.getEnfermidade().getNome());

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
        
            if(Auth.getUser().getRole().canCreate())
                System.out.println("[2] Cadastrar um novo estagiario");
    
            if(Auth.getUser().getRole().canEdit())
                System.out.println("[3] Editar um estagiario");
    
            if(Auth.getUser().getRole().canDelete())
                System.out.println("[4] Deletar um estagiario");
    
            if(Auth.getUser().getRole().canCreate())
                System.out.println("[5] Cadastrar um novo veterinario");
    
            if(Auth.getUser().getRole().canEdit())
                System.out.println("[6] Editar um veterinario");
    
            if(Auth.getUser().getRole().canDelete())
                System.out.println("[7] Deletar um veterinario");

            op = input.nextInt();
        }
    }
}