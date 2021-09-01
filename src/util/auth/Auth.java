package util.auth;

import app.App;
import controllers.app.EstagiarioController;
import models.clinica.User;
import util.database.Users;
import util.log.Activity;
import views.*;

public class Auth {
    private static int tentativesCount = 3;
    private static User authUser;
    private String name, password;
    private static boolean authenticated;
  
    public Auth(String name, String password) {
      this.name = name;
      this.password = password;
      new Activity("Usuário: " + this.name + " efetuou uma tentativa de login.");
      this.authenticate();
    }
  
    public static User getUser() {
      return authUser;
    }
  
    public static boolean isAuthenticated() {
      return authenticated;
    }
  
    private void authenticate() {
      for(User user : Users.getUsers()) {
        if(this.name.equals(user.getNome()) && this.password.equals(user.getPassword()) && !authenticated) {
          new Activity("Usuário: " + this.name + " login efetuado com sucesso!");
          authenticated = true;
          authUser = user;
          Dashboard.run();

        }
      }
        new Activity("Usuário: " + this.name + " falha no login.");
        System.out.println("Voce possui " + tentativesCount + " tentativas.");
        if(tentativesCount > 0) {
          tentativesCount--;
          App.login();
        }
        else System.exit(0);
    }

    public static void logout() {
      String name = authUser.getNome();
      authenticated = false;
      authUser = null;
      tentativesCount = 3;
      new Activity("Usuário: " + name + " deslogou-se do sistema.");
      App.login();
    }
  }
