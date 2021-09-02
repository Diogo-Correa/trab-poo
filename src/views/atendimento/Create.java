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
            return;
        }

        form();
    }

    public static void form() {
        Scanner input = new Scanner(System.in);
        
        // Busca por um animal
        System.out.print("Animais: ");
        for(Animal animal : Animais.getAnimais()) System.out.print("[" + animal.getNome()+ "] ");
        System.out.println();
        System.out.println("Digite o nome de um dos animais listados:");
        Animal animal = Animais.find(input.next());

        // Busca enfermidade
        System.out.print("Enfermidades: ");
        for(Enfermidade enfer : Enfermidades.getEnfermidades()) System.out.print("[" + enfer.getNome()+ "] ");
        System.out.println();
        System.out.println("Digite o nome de uma enfermidade listada:");
        Enfermidade enfermidade = Enfermidades.find(input.next());

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
        System.out.println("Veterinario responsavel: " + encaminhado.getVeterinario().getNome());
        System.out.println("Animal atendido: " + encaminhado.getAnimal().getNome());
        System.out.println("Enfermidade: " + encaminhado.getEnfermidade().getNome());
    }
}
