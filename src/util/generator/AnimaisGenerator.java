package util.generator;

import models.clientes.Animal;
import models.clientes.Dono;

public class AnimaisGenerator implements Generator {
    public static void generate() {
         
        Animal a1 = new Animal(
            "Thor", 
            "Cachorro", 
            "Labrador", 
            "Grande", 
            "Longo", 
            false
            );
        new Dono("Marcelo", "(21) 00000-0000", 26, a1.getId());
         
        Animal a2 = new Animal(
            "Lola", 
            "Cachorro", 
            "SRD", 
            "Grande", 
            "Curto", 
            false
            );
        new Dono("Bruna", "(21) 00000-0000", 35, a2.getId());
         
        Animal a3 = new Animal(
            "Meow", 
            "Gato", 
            "Siames", 
            "Pequeno", 
            "Curto", 
            true
            );
        new Dono("Jesse", "(21) 00000-0000", 33, a3.getId());
         
        Animal a4 = new Animal(
            "Stuart", 
            "Roedor", 
            "Hamster", 
            "Pequeno", 
            "Curto", 
            false
            );
        new Dono("George", "(21) 00000-0000", 16, a4.getId());
    }
}
