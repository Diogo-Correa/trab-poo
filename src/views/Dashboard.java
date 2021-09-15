package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controllers.app.*;
import models.clientes.Animal;
import models.clinica.Estagiario;
import models.clinica.Veterinario;
import models.clinica.consultas.Consulta;
import models.clinica.consultas.Internacao;
import util.Medicamento;
import util.auth.Auth;
import util.database.*;
import util.errors.AltaJaFechada;
import util.status.VeterinarioStatus;

public class Dashboard extends JFrame implements ActionListener { 
    private JPanel panel;
    private static JLabel message;
    private JLabel emConsulta, enfermidade, dataConsulta, horas_internacao, medicamento_txt;
    private JTextField horas_interna, medicamento;
    private JMenu userMenu, atendMenu, vetMenu, estagMenu, clientesMenu;
    private JMenuItem logout, novoAtend, vetItem, estagItem, novoEstag, novoVet, novoCliente;
    private JMenuBar mainMenu;
    private Container ContentPane;
    private JButton fecharConsulta, abrirFicha, internar, novoMedicamento;
    private Consulta consulta;

    
    // Verifica se o usuario logado eh um veterinario
    private Veterinario vet = VeterinariosDatabase.find(Auth.getUser().getId());

    // Verifica se o usuario logado eh um estagiario
    private Estagiario estag = EstagiariosDatabase.find(Auth.getUser().getId());

    // Pega o animal referente a consulta aberta
    private Animal animal;

    public Dashboard() {
        super("[VetSystem] POO Project");

        this.userMenu = new JMenu(Auth.getUser().getNome());
        this.atendMenu = new JMenu("Atendimentos");
        this.vetMenu = new JMenu("Veterinarios");
        this.estagMenu = new JMenu("Estagiarios");
        this.clientesMenu = new JMenu("Clientes");

        // User items
        this.logout = new JMenuItem("Logout", new ImageIcon());
        this.userMenu.add(this.logout);

        // Atendimento items
        this.novoAtend = new JMenuItem("Novo", new ImageIcon());
        this.atendMenu.add(this.novoAtend);

        // Cliente items
        this.novoCliente = new JMenuItem("Novo", new ImageIcon());
        this.clientesMenu.add(this.novoCliente);

        // Veterinarios items
        this.novoVet = new JMenuItem("Novo", new ImageIcon());
        this.vetMenu.add(this.novoVet);
        this.novoVet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                new VeterinarioController().create();
            }
        });
        this.vetItem = new JMenuItem("Listagem", new ImageIcon());
        this.vetMenu.add(this.vetItem);

        // Veterinarios items
        this.novoEstag = new JMenuItem("Novo", new ImageIcon());
        this.estagMenu.add(this.novoEstag);
        this.novoEstag.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                new EstagiarioController().create();
            }
        });
        this.estagItem = new JMenuItem("Listagem", new ImageIcon());
        this.estagMenu.add(this.estagItem);

        this.mainMenu = new JMenuBar();

        this.mainMenu.add(this.userMenu);
        if(estag != null) this.mainMenu.add(this.atendMenu);
        this.mainMenu.add(this.vetMenu);
        this.mainMenu.add(this.estagMenu);
        this.mainMenu.add(this.clientesMenu);

        // panel vet
        this.panel = new JPanel(new GridLayout(15,15,15,15));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.panel.setBackground(Color.DARK_GRAY);

        message = new JLabel();
        this.panel.add(message);
        
        // Se o veterinario logar e estiver em atendimento, exibe a consulta.
        if(this.vet != null && vet.getVeterinarioStatus() == VeterinarioStatus.ATENDENDO) {

            this.consulta = ConsultasDatabase.findByVet(Auth.getUser().getId());
            this.animal = consulta.getAnimal();

            this.fecharConsulta = new JButton("FECHAR CONSULTA");
            this.abrirFicha = new JButton("ABRIR FICHA");
            this.internar = new JButton("INTERNAR");
            this.novoMedicamento = new JButton("ADICIONAR MEDICAMENTO");
            this.emConsulta = new JLabel();
            this.enfermidade = new JLabel();
            this.dataConsulta = new JLabel();
            this.horas_internacao = new JLabel("Digite o tempo de internacao em ms: ");
            this.horas_interna = new JTextField("10000");
            this.medicamento_txt = new JLabel("Digite o nome do medicamento: ");
            this.medicamento = new JTextField();
            this.emConsulta.setForeground(Color.WHITE);
            this.enfermidade.setForeground(Color.WHITE);
            this.dataConsulta.setForeground(Color.WHITE);
            this.horas_internacao.setForeground(Color.WHITE);
            this.medicamento_txt.setForeground(Color.WHITE);

            this.panel.add(emConsulta);
            this.emConsulta.setText("Voce esta com uma consulta aberta com o pet: " + consulta.getAnimal().getNome());
            this.panel.add(dataConsulta);
            this.dataConsulta.setText("Consulta aberta em: " + consulta.getDataAbertura());
            this.panel.add(enfermidade);
            this.enfermidade.setText("Enfermidade do pet: " + consulta.getEnfermidade().getNome());
            this.panel.add(this.abrirFicha);
            this.panel.add(this.horas_internacao);
            this.panel.add(this.horas_interna);
            this.panel.add(this.medicamento_txt);
            this.panel.add(this.medicamento);
            this.panel.add(this.novoMedicamento);
            this.panel.add(this.internar);
            this.panel.add(this.fecharConsulta);

            this.abrirFicha.addActionListener(this);
            this.internar.addActionListener(this);
            this.fecharConsulta.addActionListener(this);
            this.novoMedicamento.addActionListener(this);
        } 
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.logout.addActionListener(this);
        this.novoAtend.addActionListener(this);
        this.vetItem.addActionListener(this);
        this.estagItem.addActionListener(this);
        this.novoCliente.addActionListener(this);
        this.ContentPane = getContentPane();
        this.ContentPane.add(this.mainMenu, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setSize(800, 800);
        setVisible(true);
    }

    public static void setMessage(String msg, Color color) {
        message.setText(msg);
        message.setBackground(color);
        message.setOpaque(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.logout) {
            Auth.logout();
            this.dispose(); 
        }

        if (e.getSource() == this.novoAtend) {
            new AtendimentoController().create();
        }

        if (e.getSource() == this.novoMedicamento) {
            if(!this.medicamento.getText().trim().equals("")) {
                try {
                    this.consulta.getAlta().addMedicamento(new Medicamento(this.medicamento.getText(), this.consulta.getAnimal().getId()));
                } catch (AltaJaFechada e1) {
                    e1.printStackTrace();
                }
            } else {
                setMessage("O campo medicamento nao pode ser nulo.", Color.RED);
            }
        }

        if (e.getSource() == this.novoCliente) {
            new AnimalController().create();
        }

        if (e.getSource() == this.vetItem) {
            new VeterinarioController().index();
        }

        if (e.getSource() == this.estagItem) {
            new EstagiarioController().index();
        }

        if (e.getSource() == this.abrirFicha) {
            new AnimalController().show(this.animal.getId());
        }

        if (e.getSource() == this.internar) {
            new Thread(new Internacao(this.consulta, Integer.parseInt(this.horas_interna.getText()))).start();
            this.dataConsulta.setText("");
            this.enfermidade.setText("");
            this.emConsulta.setText("");
            this.horas_internacao.setText("");
            this.horas_interna.setVisible(false);
            this.abrirFicha.setVisible(false);
            this.internar.setVisible(false);
            this.fecharConsulta.setVisible(false);
        }

        if (e.getSource() == this.fecharConsulta) {
            try {
                consulta.terminarConsulta();
                this.dataConsulta.setText("");
                this.enfermidade.setText("");
                this.emConsulta.setText("");
                this.horas_internacao.setText("");
                this.horas_interna.setVisible(false);
                this.abrirFicha.setVisible(false);
                this.internar.setVisible(false);
                this.fecharConsulta.setVisible(false);
                setMessage("Consulta finalizada!", Color.RED);
            } catch (AltaJaFechada error) {
                System.out.println(error);
            }
        }
    }
}
