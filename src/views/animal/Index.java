package views.animal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controllers.app.AnimalController;
import models.clientes.Animal;
import util.auth.Auth;
import util.database.AnimaisDatabase;

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
        this.panel = new JPanel(new GridLayout(AnimaisDatabase.all().size(), 10, 10, 10));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        
        // this.panel.add(this.cancel);
        for(Animal animal : AnimaisDatabase.all()) {
            JLabel animalName = new JLabel();
            JLabel animalId = new JLabel();

            JButton show, delete;
            // submit
            show = new JButton("Show");
            delete = new JButton("Del");

            this.panel.add(animalId);
            this.panel.add(animalName);

            // Show button
            if(Auth.getRole().canShow()) {
                this.panel.add(show);
                show.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        new AnimalController().show(animal.getId());
                    }
                });
            };

            // Delete button
            if(Auth.getRole().canDelete()) {
                this.panel.add(delete);
                delete.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        int res = JOptionPane.showConfirmDialog(panel,
                       "Deseja excluir o animal "+ animal.getNome() +"?");

                       if(res == JOptionPane.YES_OPTION) {
                        new AnimalController().delete(animal.getId());
                        dispose();
                        new AnimalController().index();
                       }
                    }
                });
            }

            animalId.setText("ID:" + animal.getId());
            animalName.setText(animal.getNome());
        }

        // event listener
        // this.submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("[animalSystem] POO Project - Animais");
        setSize(500, 400);
        setVisible(true);
    }
}
