package util.database;

import java.util.ArrayList;

import models.clinica.consultas.Atendimento;
import util.log.Activity;

public class Atendimentos {
    private static ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();

    /**
     * Metodo para buscar todo os Atendimentos
     * @return Atendimentos atendimentos
     */
    public static ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    /**
     * Metodo para adicao de um novo Atendimento
     * @param atendimento Atendimento
     */
    public static void addAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
        new Activity("Atendimento: " + atendimento + " foi adicionado ao sistema por " + atendimento.getEstagiario().getNome() + ".");
    }

    /**
     * Metodo para remocao de um Atendimento
     * @param atendimento Atendimento
     */
    public static void removeAtendimento(Atendimento atendimento) {
        atendimentos.remove(atendimento);
        new Activity("Atendimento: " + atendimento + " foi removido do sistema " + atendimento.getEstagiario().getNome() + ".");
    }

    /**
     * Metodo para achar um Atendimento
     * @param id referente ao Atendimento
     * @return Atendimento ou null
     */
    public static Atendimento find(int id) {
        for(Atendimento atendimento : atendimentos) {
            if(atendimento.getId() == id)
                return atendimento;
        }
        return null;
    }
        
}
