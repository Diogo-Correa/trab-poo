package util.database;

import java.util.ArrayList;

import models.clinica.Veterinario;

public class Veterinarios {
    private static ArrayList<Veterinario> veterinarios = new ArrayList<Veterinario>();

    public static ArrayList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public static void addVeterinario(Veterinario veterinario) {
        veterinarios.add(veterinario);
    }

    public static void removeVeterinario(Veterinario veterinario) {
        veterinarios.remove(veterinario);
    }

    public static Veterinario find(String dado) {
        for(Veterinario vet : veterinarios) {
            if(vet.getCRMV().equals(dado))
                return vet;
        }
        return null;
    }
}
