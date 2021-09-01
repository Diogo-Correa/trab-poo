package util.database;

import java.util.ArrayList;

import model.clinica.User;
import util.log.Activity;

public class Users {
    private static ArrayList<User> users = new ArrayList<User>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
        new Activity("User: " + user.getNome() + " foi adicionada ao sistema.");
    }

    public static void removeUser(User user) {
        users.remove(user);
        new Activity("User: " + user.getNome() + " foi removida do sistema.");
    }

    public static User find(String dado) {
        for(User u : users) {
            if(u.getNome().equals(dado))
                return u;
        }
        return null;
    }
        
}
