package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import util.auth.Auth;

public class Login extends JFrame implements ActionListener {
    
    private JPanel panel;
    private JLabel user_label, password_label;
    private static JLabel message;
    private JTextField userName_text;
    private JPasswordField password_text;
    private JButton submit, cancel;

    public Login() {

        // User label
        this.user_label = new JLabel();
        this.user_label.setText("User: ");
        this.userName_text = new JTextField();

        // Senha
        this.password_label = new JLabel();
        this.password_label.setText("Password: ");
        this.password_text = new JPasswordField();

        // submit
        this.submit = new JButton("ENTRAR");

        //cancel
        // this.cancel = new JButton("FECHAR");

        // panel
        this.panel = new JPanel(new GridLayout(3,1));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.panel.add(this.user_label);
        this.panel.add(this.userName_text);
        this.panel.add(this.password_label);
        this.panel.add(this.password_text);

        // message
        message = new JLabel();
        
        // this.panel.add(this.cancel);
        this.panel.add(message);
        this.panel.add(submit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // event listener
        this.submit.addActionListener(this);
        // this.cancel.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Login Page!");
        setSize(400, 150);
        setVisible(true);
    }

    public static void setMessage(String msg) {
        message.setText(msg);
    }

    public void actionPerformed(ActionEvent e) { 

        if (e.getSource() == this.submit) {
            String user = this.userName_text.getText();
            String password = this.password_text.getText();

            new Auth(user, password);
            if(Auth.isAuthenticated()) {
                this.dispose();

            }
        }

        if (e.getSource() == this.cancel) {
            if(Auth.isAuthenticated()) {
                Auth.logout();
                new Login();
            } else {
                System.exit(0);
            }
        }
    }



}
