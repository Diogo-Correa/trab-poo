package util.database;

import java.util.ArrayList;

import models.clinica.consultas.Consulta;
import util.auth.Auth;
import util.log.Activity;
import util.status.VeterinarioStatus;

public class Consultas {
    private static ArrayList<Consulta> consultas = new ArrayList<Consulta>();

    public static ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public static void addConsulta(Consulta consulta) {
        consultas.add(consulta);
        new Activity("Consulta: " + consulta + " foi adicionado ao sistema por " + consulta.getVeterinario().getNome() + ".");
    }

    public static void removeConsulta(Consulta consulta) {
        consultas.remove(consulta);
        new Activity("Consulta: " + consulta + " foi removido do sistema " + consulta.getVeterinario().getNome() + ".");
    }

    public static Consulta find(int id) {
        for(Consulta consulta : consultas) {
            if(consulta.getId() == id)
                return consulta;
        }
        return null;
    }

    public static Consulta findOpenConsulta() {
        for(Consulta consulta : consultas) {
            if(consulta.getVeterinario().getId() == Auth.getUser().getId() && consulta.getDataFechamento() == null)
                return consulta;
        }
        return null;
    }
        
}
