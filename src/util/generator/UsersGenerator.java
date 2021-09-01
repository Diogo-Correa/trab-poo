package util.generator;

import controller.middlewares.auth.Permission;
import controller.middlewares.auth.Role;
import model.clinica.Estagiario;
import model.clinica.Veterinario;

public class UsersGenerator implements Generator {
    public static void generate() {
        
        Role admin = new Role("admin");
        Role mod = new Role("mod");

        admin.addPermission(Permission.CREATE);
        admin.addPermission(Permission.EDIT);
        admin.addPermission(Permission.SHOW);
        admin.addPermission(Permission.DELETE); // success
        admin.addPermission(Permission.DELETE); // fail
    
        mod.addPermission(Permission.EDIT);
        // mod.addPermission(Permission.CREATE);
        mod.addPermission(Permission.SHOW);
        mod.addPermission(Permission.DELETE);
        
        new Veterinario("Eduardo", "123", admin, 32, "123456789");
        new Veterinario("Celso", "123", admin,  42, "12345678");
        new Veterinario("Maria", "123", admin,  31, "1234567");
        new Veterinario("Mauro", "123", admin,  37, "123456");
        new Veterinario("Laura", "123", admin,  52, "12345");
        new Veterinario("Jorge", "123", admin,  32, "123");
        new Veterinario("Lucas", "123", admin,  33, "9876");
        new Veterinario("Eduarda", "123", admin,  29, "987654");
        new Veterinario("Otavio", "123", admin,  30, "9876543");
        new Veterinario("Guilherme", "123", admin,  35, "98765432");
        new Veterinario("Julia", "123", admin,  32, "987654321");


        
        new Estagiario("Helena", "123", mod,  26, 20, "2020.2Z");
        new Estagiario("Andressa", "123", mod,  28, 20, "2021.1A");
        new Estagiario("Gabriel", "123", mod,  24, 20, "2021.2C");
    }
}
