package models.clientes;

public class Dono {
    private String name, tel;
    private int age;

    public Dono(String name, String tel, int age) {
        this.name = name;
        this.tel = tel;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getTel() {
        return this.tel;
    }

    public int getAge() {
        return this.age;
    }

}