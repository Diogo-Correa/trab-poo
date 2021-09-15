package views.veterinario;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import controllers.middlewares.auth.Role;
import models.clinica.Veterinario;
import util.ComboBoxItem;
import util.Enfermidade;
import util.auth.Auth;
import util.database.EnfermidadesDatabase;
import util.database.RolesDatabase;
import util.database.VeterinariosDatabase;

public class Edit extends JFrame {

    private Veterinario veterinario;
    
    private JPanel panel;
    private JLabel nome_txt, role_txt, idade_txt, crmv_txt, especialidade_txt, error, br, br2, br3;
    private JTextField nome, idade, crmv;
    private JRadioButton espTrue, espFalse;
    private ButtonGroup radios = new ButtonGroup();      
    private JComboBox role, especialidade;
    private JButton atualizar, cancelar;
    private Vector roles, especialidades;

    public Edit(Veterinario veterinario) {
        if(Auth.getRole().canEdit() && veterinario != null) {
            this.veterinario = veterinario;
            run();
        }
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
        this.panel = new JPanel(new GridLayout(15, 15, 15, 15));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // labels
        this.nome_txt = new JLabel("Digite o nome do usuario: ");
        this.idade_txt = new JLabel("Digite a idade: ");
        this.crmv_txt = new JLabel("Digite as crmv: ");
        this.role_txt = new JLabel("Selecione um nivel de acesso: ");
        this.especialidade_txt = new JLabel("Possui especialidade? ");
        this.br = new JLabel();
        this.br2 = new JLabel();
        this.br3 = new JLabel();
        this.error = new JLabel();

        // inputs
        this.nome = new JTextField(this.veterinario.getNome());
        this.idade = new JTextField(Integer.toString(this.veterinario.getIdade()));
        this.crmv = new JTextField(this.veterinario.getCRMV());
        this.espTrue = new JRadioButton("Sim");
        this.espFalse = new JRadioButton("Nao");

        this.role = new JComboBox(this.roles);
        for(Role r : RolesDatabase.all()) {
            ComboBoxItem rol = new ComboBoxItem(r.getId(), r.getNome());
            this.roles.addElement(rol);
            if(r == this.veterinario.getRole()) this.role.setSelectedItem(rol);
        }

        this.especialidade = new JComboBox(this.especialidades);
        for(Enfermidade enf : EnfermidadesDatabase.all()) {
            ComboBoxItem enfermidade = new ComboBoxItem(enf.getId(), enf.getNome());
            this.especialidades.addElement(enfermidade);
            if(enf == this.veterinario.getEspecialidade()) this.especialidade.setSelectedItem(enfermidade);
        }

        this.atualizar = new JButton("atualizar");
        this.cancelar = new JButton("Cancelar");
        
        this.panel.add(this.error);
        this.error.setForeground(Color.RED);
        this.panel.add(this.br3);

        this.panel.add(this.nome_txt);
        this.panel.add(this.nome);

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

        if(this.veterinario.getEspecialidade() != null) {
            this.espTrue.setSelected(true);
            this.especialidade.setVisible(true);
        } else {
            this.espFalse.setSelected(true);
            this.especialidade.setVisible(false);
        }

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

        this.panel.add(this.atualizar);
        this.atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        this.panel.add(cancelar);
        this.cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        add(panel, BorderLayout.CENTER);
        //this.atualizar.addActionListener(this);
        //this.cancelar.addActionListener(this);
        setTitle("[VetSystem] POO Project - Editar veterinario");
        setSize(400, 400);
        setVisible(true);
    }

    public void update() {
        if(!this.nome.getText().trim().equals("") && !this.idade.getText().trim().equals("") && !this.crmv.getText().trim().equals("") && this.role.getSelectedItem() != null && ((this.espTrue.isSelected() && this.especialidade.getSelectedItem() != null) || this.espFalse.isSelected()) && (!this.idade.getText().trim().equals("") && this.idade.getText().matches("[0-9]*"))) {
            ComboBoxItem r = (ComboBoxItem) this.role.getSelectedItem();
            ComboBoxItem esp = (ComboBoxItem) this.especialidade.getSelectedItem();
            this.veterinario.setNome(this.nome.getText());
            this.veterinario.setRole((Role) RolesDatabase.find(r.getId()));
            this.veterinario.setIdade(Integer.parseInt(this.idade.getText()));
            if(esp != null) this.veterinario.setEspecialidade((Enfermidade) EnfermidadesDatabase.find(esp.getId()));
            if(this.espFalse.isSelected()) this.veterinario.setEspecialidade(null);
            this.veterinario.setCRMV(this.crmv.getText());
            VeterinariosDatabase.updateRecord(this.veterinario);
            dispose();
            return;
        } else if(this.nome.getText().trim().equals("")) {
            this.error.setText("O campo nome nao pode ser nulo.");
        } else if(this.idade.getText().trim().equals("")) {
            this.error.setText("O campo idade nao pode ser nulo.");
        } else if(this.crmv.getText().trim().equals("")) {
            this.error.setText("O campo crmv nao pode ser nulo.");
        } else if(!this.espTrue.isSelected() || !this.espFalse.isSelected()) {
            this.error.setText("O campo especialidade nao pode ser nulo.");
        } else if(this.role.getSelectedItem() == null) {
            this.error.setText("O campo role nao pode ser nulo.");
        }  else if(!this.idade.getText().matches("[0-9]*")) {
            this.error.setText("O campo idade deve ser um inteiro.");
        } 
        return;
    }
}
