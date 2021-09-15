package util.generator;

import controllers.middlewares.auth.Permission;
import controllers.middlewares.auth.Role;
import models.clinica.Estagiario;
import models.clinica.Veterinario;
import util.errors.UserCadastradoException;

public class UsersGenerator implements Generator {
    public static void generate() throws UserCadastradoException {
        
        Role admin = new Role("admin");
        Role mod = new Role("mod");

        admin.addPermission(Permission.CREATE);
        admin.addPermission(Permission.EDIT);
        admin.addPermission(Permission.SHOW);
        admin.addPermission(Permission.DELETE); // success
        admin.addPermission(Permission.DELETE); // fail
    
        // mod.addPermission(Permission.EDIT);
        mod.addPermission(Permission.CREATE);
        mod.addPermission(Permission.SHOW);
        mod.addPermission(Permission.EDIT);
        // mod.addPermission(Permission.DELETE);

        // Veterinarios
        new Veterinario("Eduardo", "123", admin, "email1@email.com", 32, "123456789");
        new Veterinario("Celso", "123", admin,  "email2@email.com", 42, "12345678");
        new Veterinario("Maria", "123", admin,  "email3@email.com", 31, "1234567");

        // Estagiarios
        new Estagiario("Helena", "123", mod, "email4@email.com", 26, 20);
        new Estagiario("Andressa", "123", mod, "email5@email.com", 28, 20);
        new Estagiario("Gabriel", "123", mod, "email6@email.com", 24, 20);
    }
}
