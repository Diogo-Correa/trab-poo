package views.atendimento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import models.clientes.Animal;
import models.clinica.consultas.Atendimento;
import models.clinica.consultas.Consulta;
import util.Enfermidade;
import util.auth.Auth;
import util.database.Animais;
import util.database.Enfermidades;
import views.Dashboard;

public class Create extends JFrame implements ActionListener{
    
    private JPanel panel;
    private JLabel animais_text, enfermidades_text, veterinario;
    private JComboBox animais, enfermidades;
    private JButton buscarVet, finalizar;
    private Atendimento atendimento;

    public Create() {
        if(Auth.getRole().canCreate()) run();
        else { 
            System.out.println("Voce nao tem permissao");
            dispose();
        }
    }

    public void run() {

        // panel
        this.panel = new JPanel(new GridLayout(10, 10, 10, 10));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.animais = new JComboBox();
        this.animais_text = new JLabel();
        this.animais_text.setText("Selecione um animal: ");

        this.enfermidades = new JComboBox();
        this.enfermidades_text = new JLabel();
        this.enfermidades_text.setText("Selecione uma enfermidade: ");

        for(Animal a : Animais.getAnimais()) {
            this.animais.addItem(a);
        }

        for(Enfermidade e : Enfermidades.getEnfermidades()) {
            this.enfermidades.addItem(e);
        }


        this.buscarVet = new JButton("Buscar veterinario");
        this.finalizar = new JButton("Encaminhar para consulta");


        this.panel.add(animais_text);
        this.panel.add(animais);

        this.panel.add(enfermidades_text);
        this.panel.add(enfermidades);

        this.veterinario = new JLabel();
        this.panel.add(veterinario);
        this.panel.add(buscarVet);


        add(panel, BorderLayout.CENTER);
        this.buscarVet.addActionListener(this);
        this.finalizar.addActionListener(this);
        setTitle("[VetSystem] POO Project - Novo atendimento");
        setSize(400, 400);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscarVet) {
            this.atendimento = new Atendimento((Animal) this.animais.getSelectedItem(), Auth.getUser());
            
            // seta a enfermidade no animal
            this.atendimento.setEnfermidade((Enfermidade) this.enfermidades.getSelectedItem());

            // busca por um veterinario
            this.atendimento.buscaVeterinario();

            this.veterinario.setText(atendimento.getVeterinario().getNome());

            this.panel.add(this.finalizar);
        }

        if (e.getSource() == this.finalizar) {
            // encaminha para a consulta
            this.atendimento.abreConsulta();
            Dashboard.setMessage("Paciente encaminhado!", Color.GREEN);
            this.dispose();
        }
        
    }


}
