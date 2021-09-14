package util.database;

import java.util.ArrayList;

import models.clinica.User;
import util.log.Activity;

public class Users {
    private static ArrayList<User> users = new ArrayList<User>();

    /**
     * Metodo para obter todo os Users
     * @return Users users
     */
    public static ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Metodo para adicao de um User
     * @param user User
     */
    public static void addUser(User user) {
        users.add(user);
        new Activity("User: " + user.getNome() + " foi adicionada ao sistema.");
    }

    /**
     * Metodo para remocao de um User
     * @param user User
     */
    public static void removeUser(User user) {
        users.remove(user);
        new Activity("User: " + user.getNome() + " foi removida do sistema.");
    }

    /**
     * Metodo para achar um User
     * @param id represent referente ao User
     * @return User ou null
     */
    public static User find(int id) {
        for(User u : users) {
            if(u.getId() == id)
                return u;
        }
        return null;
    }
        
}
