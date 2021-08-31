package util.auth;

import app.App;
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
      this.checkAuth();
    }
  
    public static User getUser() {
      return authUser;
    }
  
    public static boolean isAuthenticated() {
      return authenticated;
    }
  
    private void checkAuth() {
      for(User user : Users.getUsers()) {
        if(this.name == user.getNome() && this.password == user.getPassword() && !authenticated) {
          new Activity("Usuário: " + this.name + " login efetuado com sucesso!");
          authenticated = true;
          authUser = user;

          if(user.getRole().getNome() == "admin") {
            VeterinarioView.run();
            return;
          }

          if(user.getRole().getNome() == "mod") {
            EstagiarioView.run();
            return;
          }

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
  }
