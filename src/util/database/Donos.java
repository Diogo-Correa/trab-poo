package util.database;

import java.util.ArrayList;

import models.clientes.Dono;
import util.log.Activity;

public class Donos {
    private static ArrayList<Dono> donos = new ArrayList<Dono>();

    public static ArrayList<Dono> getDonos() {
        return donos;
    }

    public static void addDono(Dono dono) {
        donos.add(dono);
        new Activity("Dono: " + dono.getNome() + " foi adicionado ao sistema.");
    }

    public static void removeDono(Dono dono) {
        donos.remove(dono);
        new Activity("Dono: " + dono.getNome() + " foi removido do sistema.");
    }

    public static Dono find(int id) {
        for(Dono dono : donos) {
            if(dono.getId() == id)
                return dono;
        }
        return null;
    }
        
}
