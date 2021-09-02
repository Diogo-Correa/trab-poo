package util.database;

import java.util.ArrayList;

import models.clinica.consultas.Atendimento;
import util.log.Activity;

public class Atendimentos {
    private static ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();

    public static ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public static void addAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
        new Activity("Atendimento: " + atendimento + " foi adicionado ao sistema.");
    }

    public static void removeAtendimento(Atendimento atendimento) {
        atendimentos.remove(atendimento);
        new Activity("Atendimento: " + atendimento + " foi removido do sistema.");
    }

    public static Atendimento find(int dado) {
        for(Atendimento atendimento : atendimentos) {
            if(atendimento.getId() == dado)
                return atendimento;
        }
        return null;
    }
        
}
