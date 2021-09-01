package util.database;

import java.util.ArrayList;

import models.clinica.Veterinario;
import util.log.Activity;

public class Veterinarios {
    private static ArrayList<Veterinario> veterinarios = new ArrayList<Veterinario>();

    public static ArrayList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public static void addVeterinario(Veterinario veterinario) {
        veterinarios.add(veterinario);
        new Activity("Veterinario: " + veterinario.getNome() + " foi adicionado ao sistema.");
    }

    public static void removeVeterinario(Veterinario veterinario) {
        veterinarios.remove(veterinario);
        new Activity("Veterinario: " + veterinario.getNome() + " foi removido do sistema.");
    }

    public static Veterinario find(String dado) {
        for(Veterinario vet : veterinarios) {
            if(vet.getCRMV().equals(dado))
                return vet;
        }
        return null;
    }
}
