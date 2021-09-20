package views.animal;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import models.clientes.Animal;
import models.clientes.Dono;
import util.auth.Auth;

public class Create extends JFrame {
    
    private JPanel panel;
    private JLabel nome_txt, especie_txt, pelagem_txt, agressivo_txt, raca_txt, porte_txt, dono_nome_txt, idade_txt, tel_txt, error, br, br2;
    private JTextField nome, especie, raca, porte, pelagem, dono_nome, idade, tel;
    private JRadioButton agressivoTrue, agressivoFalse;
    private ButtonGroup radios = new ButtonGroup(); 
    private JButton adicionar, cancelar;

    public Create() {
        if(Auth.getRole().canCreate()) run();
        else { 
            System.out.println("Voce nao tem permissao");
            dispose();
        }
    }

    public void run() {

        // panel
        this.panel = new JPanel(new GridLayout(12, 12, 12, 12));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // labels
        this.nome_txt = new JLabel("Digite o nome do animal: ");
        this.especie_txt = new JLabel("Digite a especie do animal: ");
        this.raca_txt = new JLabel("Digite a raca do animal: ");
        this.porte_txt = new JLabel("Digite o porte do animal: ");
        this.pelagem_txt = new JLabel("Digite a pelagem do animal: ");
        this.agressivo_txt = new JLabel("O animal e agressivo?: ");
        this.dono_nome_txt = new JLabel("Digite o nome do dono do animal: ");
        this.idade_txt = new JLabel("Digite a idade do dono: ");
        this.tel_txt = new JLabel("Digite o telefone do dono: ");

        // labels errors
        this.error = new JLabel();
        this.br = new JLabel();
        this.br2 = new JLabel();

        // inputs
        this.nome = new JTextField();
        this.especie = new JTextField();
        this.raca = new JTextField();
        this.porte = new JTextField();
        this.pelagem = new JTextField();
        this.dono_nome = new JTextField();
        this.idade = new JTextField();
        this.tel = new JTextField();
        this.agressivoTrue = new JRadioButton("Sim");
        this.agressivoFalse = new JRadioButton("Nao");

        this.adicionar = new JButton("Adicionar");
        this.cancelar = new JButton("Cancelar");
        
        this.panel.add(this.error);
        this.error.setForeground(Color.RED);
        this.panel.add(this.br);

        this.panel.add(this.nome_txt);
        this.panel.add(this.nome);

        this.panel.add(this.especie_txt);
        this.panel.add(this.especie);

        this.panel.add(this.raca_txt);
        this.panel.add(this.raca);

        this.panel.add(this.porte_txt);
        this.panel.add(this.porte);

        this.panel.add(this.pelagem_txt);
        this.panel.add(this.pelagem);

        this.panel.add(this.agressivo_txt);
        this.panel.add(this.br2);

        this.panel.add(this.agressivoTrue);
        this.panel.add(this.agressivoFalse);
        this.agressivoFalse.setSelected(true);
        
        this.radios.add(this.agressivoTrue);
        this.radios.add(this.agressivoFalse);

        this.panel.add(this.dono_nome_txt);
        this.panel.add(this.dono_nome);

        this.panel.add(this.idade_txt);
        this.panel.add(this.idade);

        this.panel.add(this.tel_txt);
        this.panel.add(this.tel);


        this.adicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                create();
            }
        });
        this.panel.add(this.adicionar);
        
        this.panel.add(cancelar);
        this.cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        add(panel, BorderLayout.CENTER);
        //this.adicionar.addActionListener(this);
        //this.cancelar.addActionListener(this);
        setTitle("[VetSystem] POO Project - Novo animal");
        setSize(400, 500);
        setVisible(true);

    }

    public void create() {
        if(!this.nome.getText().trim().equals("") 
        && !this.especie.getText().trim().equals("") 
        && !this.raca.getText().trim().equals("") 
        && !this.porte.getText().trim().equals("") 
        && !this.pelagem.getText().trim().equals("")
        && !this.dono_nome.getText().trim().equals("")
        && (!this.idade.getText().trim().equals("") && this.idade.getText().matches("[0-9]*"))
        && (!this.tel.getText().trim().equals("") && this.tel.getText().matches("[0-9]*"))) {
            Animal newAnimal = new Animal(
                this.nome.getText(), 
                this.especie.getText(),
                this.raca.getText(), 
                this.porte.getText(),
                this.pelagem.getText(),
                this.agressivoTrue.isSelected() ? true : false
            );
            new Dono(
                this.dono_nome.getText(),
                this.tel.getText(), 
                Integer.parseInt(this.idade.getText()),
                newAnimal.getId()
            );
            dispose();
            return;
        } else if(this.nome.getText().trim().equals("")) {
            this.error.setText("O campo nome nao pode ser nulo.");
        } else if(this.porte.getText().trim().equals("")) {
            this.error.setText("O campo porte nao pode ser nulo.");
        } else if(this.especie.getText().trim().equals("")) {
            this.error.setText("O campo especie nao pode ser nulo.");
        } else if(this.raca.getText().trim().equals("")) {
            this.error.setText("O campo raca nao pode ser nulo.");
        } else if(this.pelagem.getText().trim().equals("")) {
            this.error.setText("O campo raca nao pode ser nulo.");
        } else if(!this.agressivoTrue.isSelected() && !this.agressivoFalse.isSelected()) {
            this.error.setText("O campo agressivo nao pode ser nulo.");
        } else if(!this.idade.getText().matches("[0-9]*")) {
            this.error.setText("O campo idade deve ser um inteiro.");
        } else if(!this.tel.getText().matches("[0-9]*")) {
            this.error.setText("O campo telefone deve conter apenas numeros inteiros.");
        } else if(this.dono_nome.getText().trim().equals("")) {
            this.error.setText("O campo dono_nome nao pode ser nulo.");
        } else if(this.tel.getText().trim().equals("")) {
            this.error.setText("O campo dono_tel nao pode ser nulo.");
        }  else if(this.idade.getText().trim().equals("")) {
            this.error.setText("O campo dono_idade nao pode ser nulo.");
        }      
        return;
    }
}
