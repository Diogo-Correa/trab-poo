import models.clinica.consultas.Atendimento;
import util.Enfermidade;
import util.database.*;
import util.generator.*;
import models.clientes.*;
import models.clinica.*;


public class App {

    App() {
        this.initialize();
    }

    public static void main(String[] args) throws Exception {

        new App();

        Animal animal = Animais.find("Thor");
        Enfermidade enfermidade = Enfermidades.find("Cinomose");

        Atendimento atendimento = new Atendimento(animal);

        atendimento.setEnfermidade(enfermidade);

        atendimento.buscaVeterinario();

        System.out.println("Veterinario responsavel: " + atendimento.getVeterinario().getNome());
        System.out.println("Animal em atendimento: " + atendimento.getAnimal().getNome());
        System.out.println("Nome da enfermidade: " + atendimento.getEnfermidade().getNome());

        atendimento.abreConsulta();
        
        System.out.println("Status do veterinario: " + atendimento.getVeterinario().getVeterinarioStatus());
    
    }

    private void initialize() {
        EnfermidadesGenerator.generate();
        // System.out.println(Enfermidades.getEnfermidades());
        VeterinariosGenerator.generate();
        // System.out.println(Veterinarios.getVeterinarios());
        AnimaisGenerator.generate();
        // System.out.println(Animais.getAnimais());
    }
}
