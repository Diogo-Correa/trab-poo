package util.database;

import java.util.ArrayList;

import models.clinica.consultas.Consulta;
import util.auth.Auth;
import util.log.Activity;

public class Consultas {
    private static ArrayList<Consulta> consultas = new ArrayList<Consulta>();

    /**
     * Metodo para buscar todo as Consultas
     * @return Consultas consultas
     */
    public static ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    /**
     * Metodo para adicao de uma nova Consulta
     * @param consulta Consulta
     */
    public static void addConsulta(Consulta consulta) {
        consultas.add(consulta);
        new Activity("Consulta: " + consulta + " foi adicionado ao sistema por " + consulta.getVeterinario().getNome() + ".");
    }

    /**
     * Metodo para remocao de uma Consulta
     * @param consulta Consulta
     */
    public static void removeConsulta(Consulta consulta) {
        consultas.remove(consulta);
        new Activity("Consulta: " + consulta + " foi removido do sistema " + consulta.getVeterinario().getNome() + ".");
    }

    /**
     * Metodo para achar uma Consulta
     * @param id referente a Consulta
     * @return Consulta ou null
     */
    public static Consulta find(int id) {
        for(Consulta consulta : consultas) {
            if(consulta.getId() == id)
                return consulta;
        }
        return null;
    }

    /**
     * Metodo para achar uma Consulta abterta para o Auth User
     * @return Consulta ou null
     */
    public static Consulta findOpenConsulta() {
        for(Consulta consulta : consultas) {
            if(consulta.getVeterinario().getId() == Auth.getUser().getId() && consulta.getDataFechamento() == null)
                return consulta;
        }
        return null;
    }
        
}
