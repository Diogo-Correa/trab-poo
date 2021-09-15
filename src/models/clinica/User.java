package models.clinica;

import java.io.Serializable;

import controllers.middlewares.auth.Role;
import util.database.UsersDatabase;
import util.database.VeterinariosDatabase;
import util.errors.UserCadastradoException;

public abstract class User implements Serializable {
    private String name, password, email;
    private int idade;
    private Role role;
    private int id = 0;

    /**
     * User constructor
     * @param name
     * @param email
     * @param password
     * @param idade
     * @param role
     * @param email
     * @throws UserCadastradoException
     */
    public User(String name, String password, int idade, Role role, String email) throws UserCadastradoException {
        checkUser(email);
        this.name = name;
        this.email = email;
        this.password = password;
        this.idade = idade;
        this.role = role;
        this.id = UsersDatabase.getLastId() + 1;
        UsersDatabase.addRecord(this);
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
     * Metodo para obter o email do User
     * @return User email
     */
    public String getEmail() { return this.email; }

    /**
     * Metodo para setar um novo email ao User
     * @param value novo email do usuario
     */
    public void setEmail(String value) { this.email = value; }

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

    /**
     * Metodo para verificar se ja possui um email cadastrado
     * @param email email do User
     */
    public static boolean checkUser(String email) throws UserCadastradoException {
        for(Veterinario user : VeterinariosDatabase.all()) {
            if(user.getEmail().equals(email)) {
                throw new UserCadastradoException("Email de usuario ja cadastrado");
            }
        }
        return false;
    }
}
