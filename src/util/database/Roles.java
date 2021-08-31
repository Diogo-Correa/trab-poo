package util.database;

import java.util.ArrayList;

import util.log.Activity;
import util.middlewares.auth.Role;

public class Roles {
    private static ArrayList<Role> roles = new ArrayList<Role>();

    public static ArrayList<Role> getRoles() {
        return roles;
    }

    public static void addRole(Role role) {
        roles.add(role);
        new Activity("Role: " + role.getNome() + " foi adicionada ao sistema.");
    }

    public static void removeUser(Role role) {
        roles.remove(role);
        new Activity("Role: " + role.getNome() + " foi removida do sistema.");
    }

    public static Role find(String dado) {
        for(Role r : roles) {
            if(r.getNome().equals(dado))
                return r;
        }
        return null;
    }
}
