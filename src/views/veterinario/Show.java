package views.veterinario;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import models.clinica.Veterinario;
import util.auth.Auth;

public class Show extends JFrame implements ActionListener{

    private JPanel panel;
    private JLabel nome, role, idade, crmv;
    private Veterinario veterinario;

    public Show(Veterinario veterinario) {
        if(Auth.getRole().canShow()) {
            this.veterinario = veterinario;
            run();
        }
        else { 
            System.out.println("Voce nao tem permissao");
            dispose();
        }
    }

    public void run() {
        
        // panel
        this.panel = new JPanel(new GridLayout(10, 10, 10, 10));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // labels
        this.nome = new JLabel("Nome: " + this.veterinario.getNome());
        this.panel.add(this.nome);

        this.role = new JLabel("Role: " + this.veterinario.getRole().getNome());
        this.panel.add(this.role);
        
        this.idade = new JLabel("Idade: " + this.veterinario.getIdade());
        this.panel.add(this.idade);
        
        this.crmv = new JLabel("CRMV: " + this.veterinario.getCRMV());
        this.panel.add(this.crmv);

        // event listener
        // this.medicamentos.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("[VetSystem] POO Project - " + this.veterinario.getNome());
        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}
