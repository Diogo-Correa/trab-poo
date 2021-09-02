package util.database;

import java.util.*;

import models.clinica.Estagiario;
import util.log.Activity;

public class Estagiarios {
    private static ArrayList<Estagiario> estagiarios = new ArrayList<Estagiario>();

    public static ArrayList<Estagiario> getEstagiarios() {
        return estagiarios;
    }

    public static void addEstagiario(Estagiario estagiario) {
        estagiarios.add(estagiario);
        new Activity("Estagiario: " + estagiario.getNome() + " foi adicionado ao sistema.");
    }

    public static void removeEstagiario(Estagiario estagiario) {
        estagiarios.remove(estagiario);
        new Activity("Estagiario: " + estagiario.getNome() + " foi removido do sistema.");
    }

    public static Estagiario find(int id) {
        for(Estagiario est : estagiarios) {
            if(est.getId() == id)
                return est;
        }
        return null;
    }
    
}
