package util.database;

import java.util.ArrayList;

import controllers.middlewares.auth.Role;
import util.log.Activity;

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

    public static Role find(int id) {
        for(Role r : roles) {
            if(r.getId() == id)
                return r;
        }
        return null;
    }
}
