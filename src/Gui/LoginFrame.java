package Gui;

import Jeu.Jeu;
import Jeu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame  implements ActionListener {


    private JFrame frame;
    private JButton loginButton, signupButton;
    private JTextField userIDField;
    private JPasswordField userPasswordField;


    public LoginFrame(Jeu game) throws HeadlessException {



        frame = new JFrame();

        loginButton = new JButton("Login");
        signupButton = new JButton("SignUp");
        userIDField = new JTextField();
        userPasswordField = new JPasswordField();
        JLabel userIDLabel = new JLabel("userID:");
        JLabel userPasswordLabel = new JLabel("password:");
        JLabel messageLabel = new JLabel();

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        signupButton.setBounds(225,200,100,25);
        signupButton.setFocusable(false);
        signupButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(signupButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            //CHECK LOGIN INFO
            System.out.println("brkti");
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            //System.out.println(userID + password);

            //verify

            //Juste pour tester
            if (userID.equals("27") && password.equals("27"))
                Main.game.addAccount(userID, password);



            if (Main.game.logIn(userID, password)) {
                Main.game.creatSim(1,50,100);


                new MainFrame(this);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "password is wrong or account doesnt exists");

            }




        }
        if (e.getSource() == signupButton)
        {
            JFrame frame = new JFrame("register");
            frame.setContentPane(new SignUpForm(frame, Main.game));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public JTextField getUserIDField() {
        return userIDField;
    }

    public JPasswordField getUserPasswordField() {
        return userPasswordField;
    }
}
