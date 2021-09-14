package util.database;

import java.util.ArrayList;

import models.clinica.Veterinario;
import util.log.Activity;

public class Veterinarios {
    private static ArrayList<Veterinario> veterinarios = new ArrayList<Veterinario>();

    /**
     * Metodo para obter todos os Veterinarios
     * @return Veterinarios veterinarios
     */
    public static ArrayList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    /**
     * Metodo para adicao de um novo Veterinario
     * @param veterinario Veterinario
     */
    public static void addVeterinario(Veterinario veterinario) {
        veterinarios.add(veterinario);
        new Activity("Veterinario: " + veterinario.getNome() + " foi adicionado ao sistema.");
    }

    /**
     * Metodo para remocao de um Veterinario
     * @param veterinario Veterinario
     */
    public static void removeVeterinario(Veterinario veterinario) {
        veterinarios.remove(veterinario);
        new Activity("Veterinario: " + veterinario.getNome() + " foi removido do sistema.");
    }

    /**
     * Metodo para achar um Veterinario
     * @param id referente ao Veterinario
     * @return Veterinario ou null
     */
    public static Veterinario find(int id) {
        for(Veterinario vet : veterinarios) {
            if(vet.getId() == id)
                return vet;
        }
        return null;
    }
}
