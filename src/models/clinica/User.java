package models.clinica;

import controllers.middlewares.auth.Role;
import util.database.Users;

public abstract class User {
    private String name, password;
    private int idade;
    private Role role;
    private static int nextId = 0;
    private int id = 0;

    /**
     * User constructor
     * @param name
     * @param password
     * @param idade
     * @param role
     */
    public User(String name, String password, int idade, Role role) {
        this.name = name;
        this.password = password;
        this.idade = idade;
        this.role = role;
        this.id = nextId++;
        Users.addUser(this);
    }

    /**
     * Metodo para obter o ID do User
     * @return id
     */
    public int getId() { return id; }

    /**
     * Metodo para obter o nome do User
     * @return User nome
     */
    public String getNome() { return this.name; }

    /**
     * Metodo para setar um novo nome ao User
     * @param value novo nome do usuario
     */
    public void setNome(String value) { this.name = value; }

    /**
     * Metodo para obter a senha do usuario
     * @return User password
     */
    public String getPassword() { return this.password; }

    /**
     * Metodo para setar um novo valor de password ao User
     * @param value novo passwod do User
     */
    public void setPassword(String value) { this.password = value; }

    /**
     * Metodo para obter a Role do usuario
     * @return User Role
     */
    public Role getRole() { return this.role; }

    /**
     * Metodo para seter um novo Role para o User
     * @param value novo User Role
     */
    public void setRole(Role value) { this.role = value; }
    
    /**
     * Metodo para obter a idade do User
     * @return User idade
     */
    public int getIdade() { return this.idade; }

    /**
     * Metodo para setar uma nova idade ao User
     * @param value nova idade do User
     */
    public void setIdade(int value) { this.idade = value;}

}
