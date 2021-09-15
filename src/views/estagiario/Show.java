package views.estagiario;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import models.clinica.Estagiario;
import util.auth.Auth;

public class Show extends JFrame implements ActionListener{

    private JPanel panel;
    private JLabel nome, role, idade, horasSemanais;
    private Estagiario estagiario;

    public Show(Estagiario estagiario) {
        if(Auth.getRole().canShow()) {
            this.estagiario = estagiario;
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
        this.nome = new JLabel("Nome: " + this.estagiario.getNome());
        this.panel.add(this.nome);

        this.role = new JLabel("Role: " + this.estagiario.getRole().getNome());
        this.panel.add(this.role);
        
        this.idade = new JLabel("Idade: " + this.estagiario.getIdade());
        this.panel.add(this.idade);
        
        this.horasSemanais = new JLabel("Horas semanais: " + this.estagiario.getHorasSemanais());
        this.panel.add(this.horasSemanais);

        // event listener
        // this.medicamentos.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("[VetSystem] POO Project - " + this.estagiario.getNome());
        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}
