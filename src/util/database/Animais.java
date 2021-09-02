package util.database;

import java.util.ArrayList;

import models.clientes.Animal;
import util.log.Activity;

public class Animais {
    private static ArrayList<Animal> animais = new ArrayList<Animal>();

    public static ArrayList<Animal> getAnimais() {
        return animais;
    }

    public static void addAnimal(Animal animal) {
        animais.add(animal);
        new Activity("Animal: " + animal.getNome() + " foi adicionado ao sistema.");
    }

    public static void removeAnimal(Animal animal) {
        animais.remove(animal);
        new Activity("Animal: " + animal.getNome() + " foi removido do sistema.");
    }

    public static Animal find(int id) {
        for(Animal animal : animais) {
            if(animal.getId() == id)
                return animal;
        }
        return null;
    }
        
}
