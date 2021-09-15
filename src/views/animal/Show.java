package views.animal;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import models.clientes.Animal;
import util.auth.Auth;

public class Show extends JFrame implements ActionListener{

    private JPanel panel;
    private JLabel nome, especie, raca, porte, pelagem, agressivo, dono, status, semMedicamentos;
    private Animal animal;

    public Show(Animal animal) {
        if(Auth.getRole().canShow()) {
            this.animal = animal;
            run();
        }
        else { 
            System.out.println("Voce nao tem permissao");
        }
    }

    public void run() {
        
        // panel
        this.panel = new JPanel(new GridLayout(10, 10, 10, 10));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // labels
        this.nome = new JLabel("Nome: " + animal.getNome());
        this.especie = new JLabel("Especie: " + animal.getEspecie());
        this.raca = new JLabel("Raca: " + animal.getRaca());
        this.porte = new JLabel("Porte: " + animal.getPorte());
        this.pelagem = new JLabel("Pelagem: " + animal.getPelagem());
        this.agressivo = new JLabel("Agressivo: " + animal.getAgressivo());
        this.status = new JLabel("Status: " + animal.getStatus());
        this.dono = new JLabel("Dono: " + animal.getDono().getNome());

        this.semMedicamentos = new JLabel();
        this.semMedicamentos.setForeground(Color.WHITE);
        this.semMedicamentos.setBackground(Color.BLACK);
        this.semMedicamentos.setOpaque(true);

        this.panel.add(this.nome);
        this.panel.add(this.especie);
        this.panel.add(this.raca);
        this.panel.add(this.porte);
        this.panel.add(this.pelagem);
        this.panel.add(this.agressivo);
        this.panel.add(this.status);
        this.panel.add(this.dono);

        /*
        if(this.animal.getMedicamentos().size() == 0) {
            this.panel.add(this.semMedicamentos);
            this.semMedicamentos.setText("O animal nao faz uso de nenhuma medicacao.");
        } else {
            for(Medicamento m : this.animal.getMedicamentos()) {
                medicamentos.addElement(new ComboBoxItem(m.getId(), m.getNome()));
            }
            JComboBox animais = new JComboBox(medicamentos);
            this.panel.add(animais);
        }
        */

        // event listener
        // this.medicamentos.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("[VetSystem] POO Project - " + animal.getNome());
        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}
