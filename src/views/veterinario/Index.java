package views.veterinario;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controllers.app.VeterinarioController;
import models.clinica.Veterinario;
import util.auth.Auth;
import util.database.VeterinariosDatabase;

public class Index extends JFrame {

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
        this.panel = new JPanel(new GridLayout(VeterinariosDatabase.all().size(), 10, 10, 10));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        
        // this.panel.add(this.cancel);
        for(Veterinario vet : VeterinariosDatabase.all()) {
            JLabel vetName = new JLabel();
            JLabel vetId = new JLabel();

            JButton show, edit, delete;
            // submit
            show = new JButton("Show");
            edit = new JButton("Edit");
            delete = new JButton("Del");

            this.panel.add(vetId);
            this.panel.add(vetName);

            // Show button
            if(Auth.getRole().canShow()) {
                this.panel.add(show);
                show.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        new VeterinarioController().show(vet.getId());
                    }
                });
            };

            // Edit button
            if(Auth.getRole().canEdit()) {
                this.panel.add(edit);
                edit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        new VeterinarioController().update(vet.getId());
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
                       "Deseja excluir o veterinario "+ vet.getNome() +"?");

                       if(res == JOptionPane.YES_OPTION) {
                        new VeterinarioController().delete(vet.getId());
                        dispose();
                        new VeterinarioController().index();
                       }
                    }
                });
            }

            vetId.setText("ID:" + vet.getId());
            vetName.setText(vet.getNome());
        }

        // event listener
        // this.submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("[VetSystem] POO Project - Veterinarios");
        setSize(500, 400);
        setVisible(true);
    }
}
