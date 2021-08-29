package util.database;

import java.util.ArrayList;

import util.Enfermidade;

public class Enfermidades {
    private static ArrayList<Enfermidade> enfermidades = new ArrayList<Enfermidade>();

    public static ArrayList<Enfermidade> getEnfermidades() {
        return enfermidades;
    }

    public static void addEnfermidade(Enfermidade enfermidade) {
        enfermidades.add(enfermidade);
    }

    public static void removeEnfermidade(Enfermidade enfermidade) {
        enfermidades.remove(enfermidade);
    }

    public static Enfermidade find(String dado) {
        for(Enfermidade enf : enfermidades) {
            if(enf.getNome().equals(dado))
                return enf;
        }
        return null;
    }
        
}
