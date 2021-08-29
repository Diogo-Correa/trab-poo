import models.clinica.consultas.Atendimento;
import util.Enfermidade;
import util.database.Enfermidades;
import util.generator.EnfermidadesGenerator;
import models.clientes.*;
import models.clinica.*;


public class App {
    public static void main(String[] args) throws Exception {

        EnfermidadesGenerator.generate();
        // System.out.println(Enfermidades.getEnfermidades());

        Dono dono = new Dono("Dono da Silva", "12345", 30);
        Enfermidade enfermidade = new Enfermidade("Cinomose", "Grave");

        Veterinario vet1 = new Veterinario("Eduardo", 32, "123456789", enfermidade);
        Veterinario vet2 = new Veterinario("Cristovão", 52, "987654321");

        Animal animal = new Animal("Thor", "Cachorro", "Labrador", "Grande", "Branca", false, dono);

        Atendimento atendimento = new Atendimento(animal);

        atendimento.setEnfermidade(enfermidade);

        atendimento.buscaVeterinario();

        System.out.println(atendimento.getVeterinario().getNome());

        atendimento.abreConsulta();
        
        System.out.println(atendimento.getVeterinario().getVeterinarioStatus());
    
    }
}
