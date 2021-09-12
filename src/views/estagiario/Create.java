package views.estagiario;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import controllers.app.EstagiarioController;
import controllers.middlewares.auth.Role;
import models.clinica.Estagiario;
import util.ComboBoxItem;
import util.auth.Auth;
import util.database.Roles;
import views.Dashboard;

public class Create extends JFrame {
    
    private JPanel panel;
    private JLabel nome_txt, senha_txt, role_txt, idade_txt, horas_txt;
    private JTextField nome, idade, horas;
    private JPasswordField senha;
    private JComboBox role;
    private JButton adicionar, cancelar;
    private Vector roles;

    public Create() {
        if(Auth.getRole().canCreate()) run();
        else { 
            System.out.println("Voce nao tem permissao");
            dispose();
        }
    }

    public void run() {

        // vetores
        this.roles = new Vector();

        // panel
        this.panel = new JPanel(new GridLayout(10, 10, 10, 10));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // labels
        this.nome_txt = new JLabel("Digite o nome do usuario: ");
        this.senha_txt = new JLabel("Digite a senha do usuario: ");
        this.idade_txt = new JLabel("Digite a idade: ");
        this.horas_txt = new JLabel("Digite as horas semanais: ");
        this.role_txt = new JLabel("Selecione um nivel de acesso: ");

        // inputs
        this.nome = new JTextField();
        this.senha = new JPasswordField();
        this.idade = new JTextField();
        this.horas = new JTextField();

        for(Role r : Roles.getRoles()) {
            this.roles.addElement(new ComboBoxItem(r.getId(), r.getNome()));
        }
        this.role = new JComboBox(this.roles);


        this.adicionar = new JButton("Adicionar");
        this.cancelar = new JButton("Cancelar");
        
        this.panel.add(this.nome_txt);
        this.panel.add(this.nome);

        this.panel.add(this.senha_txt);
        this.panel.add(this.senha);

        this.panel.add(this.idade_txt);
        this.panel.add(this.idade);

        this.panel.add(this.horas_txt);
        this.panel.add(this.horas);

        this.panel.add(this.role_txt);
        this.panel.add(this.role);

        this.panel.add(this.adicionar);
        this.adicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ComboBoxItem r = (ComboBoxItem) role.getSelectedItem();
                new EstagiarioController().store(new Estagiario(
                    nome.getText(), senha.getText(), 
                    Roles.find(r.getId()), 
                    Integer.parseInt(idade.getText()), 
                    Integer.parseInt(horas.getText())
                    ));
                dispose();
            }
        });
        this.panel.add(cancelar);
        this.cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        add(panel, BorderLayout.CENTER);
        //this.adicionar.addActionListener(this);
        //this.cancelar.addActionListener(this);
        setTitle("[VetSystem] POO Project - Novo atendimento");
        setSize(400, 400);
        setVisible(true);

    }
}
