package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controllers.app.EstagiarioController;
import util.auth.Auth;

public class Dashboard extends JFrame implements ActionListener { 
    private JMenu userMenu, atendMenu, vetMenu, estagMenu;
    private JMenuItem logout, novoAtend, vet, estag;
    private JMenuBar mainMenu;
    private Container ContentPane;

    public Dashboard() {
        super("[VetSystem] POO Project");

        this.userMenu = new JMenu(Auth.getUser().getNome());
        this.atendMenu = new JMenu("Atendimentos");
        this.vetMenu = new JMenu("Veterinarios");
        this.estagMenu = new JMenu("Estagiarios");

        // User items
        this.logout = new JMenuItem("Logout", new ImageIcon());
        this.userMenu.add(this.logout);

        // Atendimento items
        this.novoAtend = new JMenuItem("Novo", new ImageIcon());
        this.atendMenu.add(this.novoAtend);

        // Veterinarios items
        this.vet = new JMenuItem("Listagem", new ImageIcon());
        this.vetMenu.add(this.vet);

        // Veterinarios items
        this.estag = new JMenuItem("Listagem", new ImageIcon());
        this.estagMenu.add(this.estag);

        this.mainMenu = new JMenuBar();

        this.mainMenu.add(this.userMenu);
        this.mainMenu.add(this.atendMenu);
        this.mainMenu.add(this.vetMenu);
        this.mainMenu.add(this.estagMenu);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.logout.addActionListener(this);
        this.estag.addActionListener(this);
        this.ContentPane = getContentPane();
        this.ContentPane.add(this.mainMenu, BorderLayout.NORTH);
        setSize(600, 600);
        setVisible(true);
    }

    public static void setMessage(String msg) {
        //message.setText(msg);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.logout) {
            Auth.logout();
            this.dispose(); 
        }

        if (e.getSource() == this.estag) {
            new EstagiarioController().index();
        }
    }
}
