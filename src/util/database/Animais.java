package util.database;

import java.util.ArrayList;

import models.clientes.Animal;

public class Animais {
    private static ArrayList<Animal> animais = new ArrayList<Animal>();

    public static ArrayList<Animal> getAnimais() {
        return animais;
    }

    public static void addAnimal(Animal animal) {
        animais.add(animal);
    }

    public static void removeAnimal(Animal animal) {
        animais.remove(animal);
    }

    public static Animal find(String dado) {
        for(Animal animal : animais) {
            if(animal.getNome().equals(dado))
                return animal;
        }
        return null;
    }
        
}
