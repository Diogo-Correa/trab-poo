package util.database;

import java.util.ArrayList;

import util.Enfermidade;
import util.log.Activity;

public class Enfermidades {
    private static ArrayList<Enfermidade> enfermidades = new ArrayList<Enfermidade>();

    /**
     * Metodo para obter todas as Enfermidades
     * @return Enfermidades enfermidades
     */
    public static ArrayList<Enfermidade> getEnfermidades() {
        return enfermidades;
    }

    /**
     * Metodo para adicao de uma nova Enfermidade
     * @param enfermidade Enfermidade
     */
    public static void addEnfermidade(Enfermidade enfermidade) {
        enfermidades.add(enfermidade);
        new Activity("Enfermidade: " + enfermidade.getNome() + " foi adicionada ao sistema.");
    }

    /**
     * Metodo para remocao de uma Enfermidade
     * @param enfermidade Enfermidade
     */
    public static void removeEnfermidade(Enfermidade enfermidade) {
        enfermidades.remove(enfermidade);
        new Activity("Enfermidade: " + enfermidade.getNome() + " foi removida do sistema.");
    }

    /**
     * Metodo para achar uma Enfermidade
     * @param id referente a Enfermidade
     * @return Enfermidade ou null
     */
    public static Enfermidade find(int id) {
        for(Enfermidade enf : enfermidades) {
            if(enf.getId() == id)
                return enf;
        }
        return null;
    }
        
}
