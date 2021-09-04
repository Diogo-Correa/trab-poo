package util.auth;

import app.App;
import controllers.middlewares.auth.Role;
import models.clinica.User;
import models.clinica.Veterinario;
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

    /**
     * Auth user
     * @return usuario autenticado
     */
  
    public static User getUser() {
      return authUser;
    }

    /**
     * Auth user get role
     * @return role do usuario autenticado
     */
    public static Role getRole() {
      return authUser.getRole();
    }
  
    
    /** 
     * Verifica se possui um usuario logado no sistema
     * @return boolean 
     */
    public static boolean isAuthenticated() {
      return authenticated;
    }
  
    /** 
     * Metodo de autenticacao de usuarios 
     */
    private void authenticate() {
      for(User user : Users.getUsers()) {
        if(this.name.equals(user.getNome()) && this.password.equals(user.getPassword()) && !authenticated) {
          Login.setMessage("Login efetuado com sucesso!");
          new Activity("Usuário: " + this.name + " login efetuado com sucesso!");
          authenticated = true;
          authUser = user;
          new App();
          return;

        }
      }
        new Activity("Usuário: " + this.name + " falha no login.");
        Login.setMessage("Voce possui " + tentativesCount + " tentativas.");
        if(tentativesCount > 0) {
          tentativesCount--;
        }
        else System.exit(0);
    }

    /** 
     * Metodo de logout de usuarios
     */
    public static void logout() {
      String name = authUser.getNome();
      authenticated = false;
      authUser = null;
      tentativesCount = 3;
      new Activity("Usuário: " + name + " deslogou-se do sistema.");
      new App();
    }
  }
