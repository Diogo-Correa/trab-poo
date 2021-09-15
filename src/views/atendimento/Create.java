package views.atendimento;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import controllers.app.VeterinarioController;
import models.clientes.Animal;
import models.clinica.consultas.Atendimento;
import util.ComboBoxItem;
import util.Enfermidade;
import util.auth.Auth;
import util.database.AnimaisDatabase;
import util.database.EnfermidadesDatabase;
import util.status.AnimalStatus;
import views.Dashboard;

public class Create extends JFrame implements ActionListener{
    
    private JPanel panel;
    private JLabel animais_text, enfermidades_text, veterinario;
    private JComboBox animais, enfermidades;
    private JButton buscarVet, finalizar;
    private Atendimento atendimento;
    private Vector enfermidadesVec, animaisVec;

    public Create() {
        if(Auth.getRole().canCreate()) run();
        else { 
            System.out.println("Voce nao tem permissao");
            dispose();
        }
    }

    public void run() {

        // vetores
        this.animaisVec = new Vector();
        this.enfermidadesVec = new Vector();

        // panel
        this.panel = new JPanel(new GridLayout(10, 10, 10, 10));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));


        this.animais_text = new JLabel("Selecione um animal: ");
        for(Animal a : AnimaisDatabase.all()) {
            if(a.getStatus() != AnimalStatus.EM_ATENDIMENTO)
                animaisVec.addElement(new ComboBoxItem(a.getId(), a.getNome()));
        }
        this.animais = new JComboBox(animaisVec);


        this.enfermidades_text = new JLabel("Selecione uma enfermidade: ");
        for(Enfermidade e : EnfermidadesDatabase.all()) {
            enfermidadesVec.addElement(new ComboBoxItem(e.getId(), e.getNome()));
        }
        this.enfermidades = new JComboBox(enfermidadesVec);


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
            // abre atendimento
            ComboBoxItem animal = (ComboBoxItem) this.animais.getSelectedItem();
            this.atendimento = new Atendimento(AnimaisDatabase.find(animal.getId()), Auth.getUser());
            
            // seta a enfermidade no animal
            ComboBoxItem enfermidade = (ComboBoxItem) this.enfermidades.getSelectedItem();
            this.atendimento.setEnfermidade(EnfermidadesDatabase.find(enfermidade.getId()));

            // busca por um veterinario
            this.atendimento.buscaVeterinario();

            if(atendimento.getVeterinario().getEspecialidade() == this.enfermidades.getSelectedItem())
                this.veterinario.setText(
                    "Veterinario selecionado: " + 
                    atendimento.getVeterinario().getNome() +
                    " | Especialista: Sim"
                );

            else
                this.veterinario.setText(
                        "Veterinario selecionado: " + 
                        atendimento.getVeterinario().getNome() +
                        " | Especialista: Nao"
                    );

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
