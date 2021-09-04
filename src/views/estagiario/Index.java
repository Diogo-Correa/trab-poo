package views.estagiario;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import models.clinica.Estagiario;
import util.auth.Auth;
import util.database.Estagiarios;

public class Index extends JFrame implements ActionListener {

    private JPanel panel;

    public Index() {
        if(Auth.getRole().canShow()) run();
        else { 
            System.out.println("Voce nao tem permissao");
        }
    }

    public void run() {

        //cancel
        // this.cancel = new JButton("FECHAR");

        // panel
        this.panel = new JPanel(new GridLayout(Estagiarios.getEstagiarios().size(),1));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        
        // this.panel.add(this.cancel);
        for(Estagiario estag : Estagiarios.getEstagiarios()) {
            JLabel estagName = new JLabel();
            JLabel estagId = new JLabel();

            JButton show, edit, delete;
            // submit
            show = new JButton("Show");
            edit = new JButton("Edit");
            delete = new JButton("Del");

            this.panel.add(estagId);
            this.panel.add(estagName);
            if(Auth.getRole().canShow()) this.panel.add(show);
            if(Auth.getRole().canEdit()) this.panel.add(edit);
            if(Auth.getRole().canDelete()) this.panel.add(delete);

            estagId.setText("ID:" + estag.getId());
            estagName.setText(estag.getNome());
        }

        // event listener
        // this.submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("[VetSystem] POO Project - Estagiarios");
        setSize(400, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) { 

    }
}
