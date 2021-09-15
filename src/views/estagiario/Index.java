package views.estagiario;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controllers.app.EstagiarioController;
import models.clinica.Estagiario;
import util.auth.Auth;
import util.database.EstagiariosDatabase;

public class Index extends JFrame {

    private JPanel panel;

    public Index() {
        if(Auth.getRole().canShow()) run();
        else { 
            System.out.println("Voce nao tem permissao");
        }
    }

    public void run() {

        // panel
        this.panel = new JPanel(new GridLayout(EstagiariosDatabase.all().size(), 10, 10, 10));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // this.panel.add(this.cancel);
        for(Estagiario estag : EstagiariosDatabase.all()) {
            JLabel estagName = new JLabel();
            JLabel estagId = new JLabel();

            JButton show, edit, delete;
            // submit
            show = new JButton("Show");
            edit = new JButton("Edit");
            delete = new JButton("Del");

            this.panel.add(estagId);
            this.panel.add(estagName);

            // Show button
            if(Auth.getRole().canShow()) {
                this.panel.add(show);
                show.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        new EstagiarioController().show(estag.getId());
                    }
                });
            };

            // Edit button
            if(Auth.getRole().canEdit()) {
                this.panel.add(edit);
                edit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        new EstagiarioController().edit(estag.getId());
                    }
                });
            }

            // Delete button
            if(Auth.getRole().canDelete()) {
                this.panel.add(delete);
                delete.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        int res = JOptionPane.showConfirmDialog(panel,
                       "Deseja excluir o estagiario "+ estag.getNome() +"?");

                       if(res == JOptionPane.YES_OPTION) {
                        new EstagiarioController().delete(estag.getId());
                        dispose();
                        new EstagiarioController().index();
                       }
                    }
                });
            }

            estagId.setText("ID:" + estag.getId());
            estagName.setText(estag.getNome());
        }

        // event listener
        // this.submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("[VetSystem] POO Project - Estagiarios");
        setSize(500, EstagiariosDatabase.all().size()*100);
        setVisible(true);
    }
}
