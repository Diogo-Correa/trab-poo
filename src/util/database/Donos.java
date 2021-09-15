package util.database;

import java.util.ArrayList;

import models.clientes.Dono;
import util.log.Activity;

public class Donos {
    private static ArrayList<Dono> donos = new ArrayList<Dono>();

    /**
     * Metodo para obter todo os Donos
     * @return Donos donos
     */
    public static ArrayList<Dono> getDonos() {
        return donos;
    }

    /**
     * Metodo para adicao de um Dono
     * @param dono Dono
     */
    public static void addDono(Dono dono) {
        donos.add(dono);
        new Activity("Dono: " + dono.getNome() + " foi adicionado ao sistema.");
    }

    /**
     * Metodo para remocao de um Dono
     * @param dono Dono
     */
    public static void removeDono(Dono dono) {
        donos.remove(dono);
        new Activity("Dono: " + dono.getNome() + " foi removido do sistema.");
    }

    /**
     * Metodo para achar um Dono
     * @param id referente ao Dono
     * @return Dono ou null
     */
    public static Dono find(int id) {
        for(Dono dono : donos) {
            if(dono.getId() == id)
                return dono;
        }
        return null;
    }
        
}
