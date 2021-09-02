package views.atendimento;

import java.util.Scanner;

import models.clientes.Animal;
import models.clinica.Veterinario;
import models.clinica.consultas.Atendimento;
import models.clinica.consultas.Consulta;
import util.Enfermidade;
import util.auth.Auth;
import util.database.Animais;
import util.database.Enfermidades;
import util.database.Veterinarios;

public class Create {

    public Create() {
        if(!Auth.getRole().canCreate()) {
            System.out.println("Voce nao tem permissao!");
        } else{ 
            form();
        }

    }

    public static void form() {
        Scanner input = new Scanner(System.in);
        
        // Busca por um animal
        System.out.print("Animais: ");
        for(Animal animal : Animais.getAnimais()) System.out.print(animal.getId() +": [" + animal.getNome()+ "] ");
        System.out.println();
        System.out.println("Digite o ID de um dos animais listados:");
        Animal animal = Animais.find(input.nextInt());

        // Busca enfermidade
        System.out.print("Enfermidades: ");
        for(Enfermidade enfer : Enfermidades.getEnfermidades()) System.out.print(enfer.getId() +": [" + enfer.getNome()+ "] ");
        System.out.println();
        System.out.println("Digite o ID de uma enfermidade listada:");
        Enfermidade enfermidade = Enfermidades.find(input.nextInt());

        // Inicia atendimento
        Atendimento atendimento = new Atendimento(animal, Auth.getUser());

        // seta a enfermidade no animal
        atendimento.setEnfermidade(enfermidade);

        // busca por um veterinario
        atendimento.buscaVeterinario();
        System.out.println("Veterinario selecionado: " + atendimento.getVeterinario().getNome());

        // encaminha para a consulta
        Consulta encaminhado = atendimento.abreConsulta();

        // Infos da consulta, apos encaminhamento pelo primeiro atendimento.
        System.out.println("ID: " + atendimento.getId());
        System.out.println("Veterinario responsavel: " + encaminhado.getVeterinario().getNome());
        System.out.println("Animal atendido: " + encaminhado.getAnimal().getNome());
        System.out.println("Enfermidade: " + encaminhado.getEnfermidade().getNome());
    }
}
