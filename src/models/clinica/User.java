package models.clinica;

import util.database.Users;
import util.middlewares.auth.Role;

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

    public String getPassword() { return this.password; }

    public Role getRole() { return this.role; }
    
    public int getIdade() { return this.idade; }

}
