package views.estagiario;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import controllers.app.EstagiarioController;
import controllers.middlewares.auth.Role;
import models.clinica.Estagiario;
import models.clinica.User;
import util.ComboBoxItem;
import util.auth.Auth;
import util.database.Roles;
import util.errors.UserCadastradoException;

public class Create extends JFrame {
    
    private JPanel panel;
    private JLabel nome_txt, senha_txt, role_txt, email_txt, idade_txt, horas_txt, error, br;
    private JTextField nome, idade, horas, email;
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
        this.email_txt = new JLabel("Digite o email do usuario: ");

        // labels errors
        this.error = new JLabel();
        this.br = new JLabel();

        // inputs
        this.nome = new JTextField();
        this.senha = new JPasswordField();
        this.idade = new JTextField();
        this.horas = new JTextField();
        this.email = new JTextField();

        for(Role r : Roles.getRoles()) {
            this.roles.addElement(new ComboBoxItem(r.getId(), r.getNome()));
        }
        this.role = new JComboBox(this.roles);


        this.adicionar = new JButton("Adicionar");
        this.cancelar = new JButton("Cancelar");
        
        this.panel.add(this.error);
        this.error.setForeground(Color.RED);
        this.panel.add(this.br);

        this.panel.add(this.nome_txt);
        this.panel.add(this.nome);

        this.panel.add(this.email_txt);
        this.panel.add(this.email);

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
                try {
                    create();
                } catch (NumberFormatException | UserCadastradoException e1) {
                    e1.printStackTrace();
                    error.setText("O email ja esta em uso.");
                }
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

    public void create() throws NumberFormatException, UserCadastradoException {
        if((!this.email.getText().trim().equals("") && !User.checkUser(this.email.getText())) && !this.nome.getText().trim().equals("") && !this.senha.getText().trim().equals("") && (!this.idade.getText().trim().equals("") && this.idade.getText().matches("[0-9]*")) && !this.horas.getText().trim().equals("")) {
            ComboBoxItem r = (ComboBoxItem) this.role.getSelectedItem();
            new EstagiarioController().store(new Estagiario(
                this.nome.getText(), 
                this.senha.getText(), 
                Roles.find(r.getId()), 
                this.email.getText(), 
                Integer.parseInt(this.idade.getText()), 
                Integer.parseInt(this.horas.getText())
                ));
            dispose();
            return;
        } else if(this.nome.getText().trim().equals("")) {
            this.error.setText("O campo nome nao pode ser nulo.");
        } else if(this.email.getText().trim().equals("")) {
            this.error.setText("O campo email nao pode ser nulo.");
        }   else if(this.senha.getText().trim().equals("")) {
            this.error.setText("O campo senha nao pode ser nulo.");
        }  else if(this.idade.getText().trim().equals("")) {
            this.error.setText("O campo idade nao pode ser nulo.");
        }  else if(!this.idade.getText().matches("[0-9]*")) {
            this.error.setText("O campo idade deve ser um inteiro.");
        }  else if(this.horas.getText().trim().equals("")) {
            this.error.setText("O campo horas nao pode ser nulo.");
        }
        return;
    }
}
