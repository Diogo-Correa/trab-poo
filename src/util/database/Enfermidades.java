package util.database;

import java.util.ArrayList;

import util.Enfermidade;
import util.log.Activity;

public class Enfermidades {
    private static ArrayList<Enfermidade> enfermidades = new ArrayList<Enfermidade>();

    public static ArrayList<Enfermidade> getEnfermidades() {
        return enfermidades;
    }

    public static void addEnfermidade(Enfermidade enfermidade) {
        enfermidades.add(enfermidade);
        new Activity("Enfermidade: " + enfermidade.getNome() + " foi adicionada ao sistema.");
    }

    public static void removeEnfermidade(Enfermidade enfermidade) {
        enfermidades.remove(enfermidade);
        new Activity("Enfermidade: " + enfermidade.getNome() + " foi removida do sistema.");
    }

    public static Enfermidade find(int id) {
        for(Enfermidade enf : enfermidades) {
            if(enf.getId() == id)
                return enf;
        }
        return null;
    }
        
}
