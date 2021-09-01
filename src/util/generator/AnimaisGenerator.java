package util.generator;

import model.clientes.Animal;
import model.clientes.Dono;

public class AnimaisGenerator implements Generator {
    public static void generate() {
        new Animal(
            "Thor", 
            "Cachorro", 
            "Labrador", 
            "Grande", 
            "Longo", 
            false, 
            new Dono("Marcelo", "(21) 00000-0000", 26)
            );

        new Animal(
            "Lola", 
            "Cachorro", 
            "SRD", 
            "Grande", 
            "Curto", 
            false, 
            new Dono("Bruna", "(21) 00000-0000", 35)
            );

        new Animal(
            "Meow", 
            "Gato", 
            "Siames", 
            "Pequeno", 
            "Curto", 
            true, 
            new Dono("Jesse", "(21) 00000-0000", 33)
            );

        new Animal(
            "Stuart", 
            "Roedor", 
            "Hamster", 
            "Pequeno", 
            "Curto", 
            false, 
            new Dono("George", "(21) 00000-0000", 16)
            );
    }
}
