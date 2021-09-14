package util.database;

import java.util.*;

import models.clinica.Estagiario;
import util.log.Activity;

public class Estagiarios {
    private static ArrayList<Estagiario> estagiarios = new ArrayList<Estagiario>();

    /**
     * Metodo para obter todos os Estagiarios
     * @return Estagiarios estagiarios
     */
    public static ArrayList<Estagiario> getEstagiarios() {
        return estagiarios;
    }

    /**
     * Metodo para adicao de um Estagiario
     * @param estagiario Estagiario
     */
    public static void addEstagiario(Estagiario estagiario) {
        estagiarios.add(estagiario);
        new Activity("Estagiario: " + estagiario.getNome() + " foi adicionado ao sistema.");
    }

    /**
     * Metodo para remocao de um Estagiario
     * @param estagiario Estagiario
     */
    public static void removeEstagiario(Estagiario estagiario) {
        estagiarios.remove(estagiario);
        new Activity("Estagiario: " + estagiario.getNome() + " foi removido do sistema.");
    }

    /**
     * Metodo para achar um Estagiario
     * @param id referente ao Estagiario
     * @return Estagiario ou null
     */
    public static Estagiario find(int id) {
        for(Estagiario est : estagiarios) {
            if(est.getId() == id)
                return est;
        }
        return null;
    }
    
}
