package util.generator;

import models.clinica.Veterinario;

public class VeterinariosGenerator implements Generator {
    public static void generate() {
        new Veterinario("Eduardo", 32, "123456789");
        new Veterinario("Celso", 42, "12345678");
        new Veterinario("Maria", 31, "1234567");
        new Veterinario("Mauro", 37, "123456");
        new Veterinario("Laura", 52, "12345");
        new Veterinario("Andressa", 28, "1234");
        new Veterinario("Jorge", 32, "123");
        new Veterinario("Gabriel", 41, "987");
        new Veterinario("Lucas", 33, "9876");
        new Veterinario("Helena", 56, "98765");
        new Veterinario("Eduarda", 29, "987654");
        new Veterinario("Otavio", 30, "9876543");
        new Veterinario("Guilherme", 35, "98765432");
        new Veterinario("Julia", 32, "987654321");
    }
}
