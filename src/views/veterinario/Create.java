package views.veterinario;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import controllers.app.VeterinarioController;
import controllers.middlewares.auth.Role;
import models.clinica.Veterinario;
import util.ComboBoxItem;
import util.Enfermidade;
import util.auth.Auth;
import util.database.Enfermidades;
import util.database.Roles;
import views.Dashboard;

public class Create extends JFrame {
    
    private JPanel panel;
    private JLabel nome_txt, senha_txt, role_txt, idade_txt, crmv_txt, especialidade_txt, error, br, br2, br3;
    private JTextField nome, idade, crmv;
    private JPasswordField senha;
    private JRadioButton espTrue, espFalse;
    private ButtonGroup radios = new ButtonGroup();      
    private JComboBox role, especialidade;
    private JButton adicionar, cancelar;
    private Vector roles, especialidades;

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
        this.especialidades = new Vector();

        // panel
        this.panel = new JPanel(new GridLayout(10, 10, 10, 10));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // labels
        this.nome_txt = new JLabel("Digite o nome do usuario: ");
        this.senha_txt = new JLabel("Digite a senha do usuario: ");
        this.idade_txt = new JLabel("Digite a idade: ");
        this.crmv_txt = new JLabel("Digite as crmv: ");
        this.role_txt = new JLabel("Selecione um nivel de acesso: ");
        this.especialidade_txt = new JLabel("Possui especialidade? ");
        this.br = new JLabel();
        this.br2 = new JLabel();
        this.br3 = new JLabel();
        this.error = new JLabel();

        // inputs
        this.nome = new JTextField();
        this.senha = new JPasswordField();
        this.idade = new JTextField();
        this.crmv = new JTextField();
        this.espTrue = new JRadioButton("Sim");
        this.espFalse = new JRadioButton("Nao");

        for(Role r : Roles.getRoles()) {
            this.roles.addElement(new ComboBoxItem(r.getId(), r.getNome()));
        }
        this.role = new JComboBox(this.roles);

        for(Enfermidade enf : Enfermidades.getEnfermidades()) {
            this.especialidades.addElement(new ComboBoxItem(enf.getId(), enf.getNome()));
        }
        this.especialidade = new JComboBox(this.especialidades);

        this.adicionar = new JButton("Adicionar");
        this.cancelar = new JButton("Cancelar");
        
        this.panel.add(this.error);
        this.error.setForeground(Color.RED);
        this.panel.add(this.br3);

        this.panel.add(this.nome_txt);
        this.panel.add(this.nome);

        this.panel.add(this.senha_txt);
        this.panel.add(this.senha);

        this.panel.add(this.idade_txt);
        this.panel.add(this.idade);

        this.panel.add(this.crmv_txt);
        this.panel.add(this.crmv);

        this.panel.add(this.role_txt);
        this.panel.add(this.role);

        this.panel.add(this.especialidade_txt);
        this.panel.add(this.br);
        this.panel.add(this.espTrue);
        this.panel.add(this.espFalse);
        this.radios.add(this.espTrue);
        this.panel.add(this.especialidade);
        this.especialidade.setVisible(false); 
        this.panel.add(this.br2);
        this.espTrue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                especialidade.setVisible(true); 
            }
        });
        this.radios.add(this.espFalse);
        this.espFalse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                especialidade.setVisible(false); 
             }
        });

        this.panel.add(this.adicionar);
        this.adicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                create();
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

    public void create() {
        if(!this.nome.getText().trim().equals("") && !this.senha.getText().trim().equals("") && !this.idade.getText().trim().equals("") && !this.crmv.getText().trim().equals("") && (this.espTrue.isSelected() || this.espFalse.isSelected())) {
            ComboBoxItem r = (ComboBoxItem) this.role.getSelectedItem();
            ComboBoxItem esp = (ComboBoxItem) this.especialidade.getSelectedItem();
            if(espFalse.isSelected()){ 
                new VeterinarioController().store(new Veterinario(
                    this.nome.getText(), 
                    this.senha.getText(), 
                    Roles.find(r.getId()), 
                    Integer.parseInt(idade.getText()), 
                    this.crmv.getText()
                ));
            } else {
                new VeterinarioController().store(new Veterinario(
                    this.nome.getText(), 
                    this.senha.getText(), 
                    Roles.find(r.getId()), 
                    Integer.parseInt(idade.getText()), 
                    this.crmv.getText(),
                    Enfermidades.find(esp.getId()) 
                ));
            }
            dispose();
            return;
        } else if(this.nome.getText().trim().equals("")) {
            this.error.setText("O campo nome nao pode ser nulo.");
        } else if(this.senha.getText().trim().equals("")) {
            this.error.setText("O campo senha nao pode ser nulo.");
        }  else if(this.idade.getText().trim().equals("")) {
            this.error.setText("O campo idade nao pode ser nulo.");
        } else if(this.crmv.getText().trim().equals("")) {
            this.error.setText("O campo crmv nao pode ser nulo.");
        } else if(!this.espTrue.isSelected() || !this.espFalse.isSelected()) {
            this.error.setText("O campo especialidade nao pode ser nulo.");
        }
        return;
    }
}
