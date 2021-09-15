package views.estagiario;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import controllers.middlewares.auth.Role;
import models.clinica.Estagiario;
import util.ComboBoxItem;
import util.auth.Auth;
import util.database.EstagiariosDatabase;
import util.database.RolesDatabase;

public class Edit extends JFrame {

    private Estagiario estagiario;
    
    private JPanel panel;
    private JLabel nome_txt, role_txt, idade_txt, horas_txt, error, br2;
    private JTextField nome, idade, horas;    
    private JComboBox role;
    private JButton atualizar, cancelar;
    private Vector roles;

    public Edit(Estagiario estagiario) {
        if(Auth.getRole().canEdit() && estagiario != null) {
            this.estagiario = estagiario;
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

        // panel
        this.panel = new JPanel(new GridLayout(10, 10, 10, 10));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // labels
        this.nome_txt = new JLabel("Digite o nome do usuario: ");
        this.idade_txt = new JLabel("Digite a idade: ");
        this.horas_txt = new JLabel("Digite as horas semanais: ");
        this.role_txt = new JLabel("Selecione um nivel de acesso: ");
        this.br2 = new JLabel();
        this.error = new JLabel();

        // inputs
        this.nome = new JTextField(this.estagiario.getNome());
        this.idade = new JTextField(Integer.toString(this.estagiario.getIdade()));
        this.horas = new JTextField(Integer.toString(this.estagiario.getHorasSemanais()));

        this.role = new JComboBox(this.roles);
        for(Role r : RolesDatabase.all()) {
            ComboBoxItem rol = new ComboBoxItem(r.getId(), r.getNome());
            this.roles.addElement(rol);
            if(r == this.estagiario.getRole()) this.role.setSelectedItem(rol);
        }

        this.atualizar = new JButton("Atualizar");
        this.cancelar = new JButton("Cancelar");
        
        this.panel.add(this.error);
        this.error.setForeground(Color.RED);
        this.panel.add(this.br2);

        this.panel.add(this.nome_txt);
        this.panel.add(this.nome);

        this.panel.add(this.idade_txt);
        this.panel.add(this.idade);

        this.panel.add(this.horas_txt);
        this.panel.add(this.horas);

        this.panel.add(this.role_txt);
        this.panel.add(this.role);

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
        setTitle("[VetSystem] POO Project - Editar estagiario");
        setSize(400, 400);
        setVisible(true);
    }

    public void update() {
        if(!this.nome.getText().trim().equals("") && !this.idade.getText().trim().equals("") && this.role.getSelectedItem() != null && !this.horas.getText().trim().equals("") && (!this.idade.getText().trim().equals("") && this.idade.getText().matches("[0-9]*"))) {
            ComboBoxItem r = (ComboBoxItem) this.role.getSelectedItem();
            this.estagiario.setNome(this.nome.getText());
            this.estagiario.setRole((Role) RolesDatabase.find(r.getId()));
            this.estagiario.setIdade(Integer.parseInt(this.idade.getText()));
            this.estagiario.setHorasSemanais(Integer.parseInt(this.horas.getText()));
            EstagiariosDatabase.updateRecord(this.estagiario);
            dispose();
            return;
        } else if(this.nome.getText().trim().equals("")) {
            this.error.setText("O campo nome nao pode ser nulo.");
        } else if(this.idade.getText().trim().equals("")) {
            this.error.setText("O campo idade nao pode ser nulo.");
        } else if(this.horas.getText().trim().equals("")) {
            this.error.setText("O campo crmv nao pode ser nulo.");
        } else if(this.role.getSelectedItem() == null) {
            this.error.setText("O campo role nao pode ser nulo.");
        }  else if(!this.idade.getText().matches("[0-9]*")) {
            this.error.setText("O campo idade deve ser um inteiro.");
        } 
        return;
    }
}
