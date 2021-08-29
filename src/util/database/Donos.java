package util.database;

import java.util.ArrayList;

import models.clientes.Dono;

public class Donos {
    private static ArrayList<Dono> donos = new ArrayList<Dono>();

    public static ArrayList<Dono> getDonos() {
        return donos;
    }

    public static void addDono(Dono dono) {
        donos.add(dono);
    }

    public static void removeDono(Dono dono) {
        donos.remove(dono);
    }

    public static Dono find(String dado) {
        for(Dono dono : donos) {
            if(dono.getNome().equals(dado))
                return dono;
        }
        return null;
    }
        
}
