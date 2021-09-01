package model.clinica;

import controller.middlewares.auth.Role;
import util.database.Users;

public abstract class User {
    private String name, password;
    private int idade;
    private Role role;

    public User(String name, String password, int idade, Role role) {
        this.name = name;
        this.password = password;
        this.idade = idade;
        this.role = role;
        Users.addUser(this);
    }

    public String getNome() { return this.name; }

    public void setNome(String value) { this.name = value; }

    public String getPassword() { return this.password; }

    public void setPassword(String value) { this.password = value; }

    public Role getRole() { return this.role; }

    public void setRole(Role value) { this.role = value; }
    
    public int getIdade() { return this.idade; }

    public void setIdade(int value) { this.idade = value;}

}
