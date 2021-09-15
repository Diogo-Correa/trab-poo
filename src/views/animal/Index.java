package views.animal;

import java.awt.event.*;
import javax.swing.*;

import util.auth.Auth;

public class Index extends JFrame implements ActionListener{

    public Index() {
        if(Auth.getRole().canShow()) run();
        else { 
            System.out.println("Voce nao tem permissao");
        }
    }

    public static void run() {
        System.out.println("Estagiario index.");
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}
