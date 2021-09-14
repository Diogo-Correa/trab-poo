package util.database;

import java.util.ArrayList;

import controllers.middlewares.auth.Role;
import util.log.Activity;

public class Roles {
    private static ArrayList<Role> roles = new ArrayList<Role>();

    /**
     * Metodo para obter todos as Roles
     * @return Roles roles
     */
    public static ArrayList<Role> getRoles() {
        return roles;
    }

    /**
     * Metodo para adicao de uma nova Role
     * @param role Role
     */
    public static void addRole(Role role) {
        roles.add(role);
        new Activity("Role: " + role.getNome() + " foi adicionada ao sistema.");
    }

    /**
     * Metodo para remocao de uma Role
     * @param role Role
     */
    public static void removeUser(Role role) {
        roles.remove(role);
        new Activity("Role: " + role.getNome() + " foi removida do sistema.");
    }

    /**
     * Metodo para achar uma Role
     * @param id referente a Role
     * @return Role ou null
     */
    public static Role find(int id) {
        for(Role r : roles) {
            if(r.getId() == id)
                return r;
        }
        return null;
    }
}
