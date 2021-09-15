package util.database;

import java.util.ArrayList;

import models.clientes.Animal;
import util.log.Activity;

public class Animais {
    private static ArrayList<Animal> animais = new ArrayList<Animal>();

    /**
     * Metodo para buscar todo os Animais
     * @return Animais animais
     */
    public static ArrayList<Animal> getAnimais() {
        return animais;
    }

    /**
     * Metodo para adicao de um novo Animal
     * @param animal Animal
     */
    public static void addAnimal(Animal animal) {
        animais.add(animal);
        new Activity("Animal: " + animal.getNome() + " foi adicionado ao sistema.");
    }

    /**
     * Metodo para remocao de um Animal
     * @param animal Animal
     */
    public static void removeAnimal(Animal animal) {
        animais.remove(animal);
        new Activity("Animal: " + animal.getNome() + " foi removido do sistema.");
    }

    /**
     * Metodo para achar um Animal
     * @param id referente ao Animal
     * @return Animal ou null
     */
    public static Animal find(int id) {
        for(Animal animal : animais) {
            if(animal.getId() == id)
                return animal;
        }
        return null;
    }
        
}
