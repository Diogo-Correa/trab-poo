import models.clinica.consultas.Alta;
import models.clinica.consultas.Consulta;

import models.clientes.*;
import models.clinica.*;

import models.util.Medicamento;
import models.util.errors.AltaJaFechada;

public class App {
    public static void main(String[] args) throws Exception {
        Dono dono = new Dono("Dono da Silva", "12345", 30);
        Consulta consulta = new Consulta(
                new Veterinario("Fernando", 30, "123"),
                dono,
                new Animal("Thor", "Um spécie", "Labrador", "Grande", "Branca", false, dono)
            );
    
        System.out.println("Hello, World!");
    }
}
