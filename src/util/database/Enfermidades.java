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
        
}
