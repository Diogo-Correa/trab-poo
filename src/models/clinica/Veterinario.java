package models.clinica;

// import java.util.ArrayList;

public class Veterinario {
    /* private ArrayList<Procedimento> procedimento = new ArrayList<Procedimento>();
        Criar uma lista de procedimentos em Enfermidade e Veterinario
        Para conseguir identificar qual o veterinario mais eficaz para cada consulta.
        Ideia de implementacao.
    */
    private String nome;
    private int idade;
    private String crmv;

    public Veterinario(String nome, int idade, String crmv){
        this.nome = nome;
        this.idade = idade;
        this.crmv = crmv;
    }
}
