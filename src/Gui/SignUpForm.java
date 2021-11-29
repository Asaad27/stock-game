package Gui;

import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;

import Jeu.Jeu;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Apr 10 15:47:54 WEST 2021
 */



/**
 * @author yousra
 */
public class SignUpForm extends JPanel {
    private JFrame frame;
    private Jeu game;
    public SignUpForm(JFrame frame, Jeu game) {

        initComponents();

        this.game = game;
        this.frame = frame;
    }

    private void btregisterActionPerformed(ActionEvent e) {
        String email = tfemail.getText();
        if (!isValid(email)){
            JOptionPane.showMessageDialog(null, "entrez une adresse mail valide");
        }
        String password1 = String.valueOf( passwordField1.getPassword());
        String password2 = String.valueOf( passwordField2.getPassword());

        if (!password2.equals(password1)){
            JOptionPane.showMessageDialog(null, "les mots de passes ne correspondent pas");
        }

        if (password2.equals(password1) && isValid(email) ) {
            JOptionPane.showMessageDialog(null, "registred");
            frame.dispose();
        }

        String userID = tfemail.getText();
        String password = String.valueOf(passwordField1.getPassword());


        if (!game.accountExists(userID)){
            game.addAccount(userID, password);
        }
        else{
            JOptionPane.showMessageDialog(null, "account name already exist to choose another one");
        }

    }
    public boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tfemail = new JTextField();
        btregister = new JButton();
        tftelephone = new JTextField();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========

        //---- btregister ----
        btregister.setText("register");
        btregister.addActionListener(e -> btregisterActionPerformed(e));

        //---- label1 ----
        label1.setText("email");

        //---- label2 ----
        label2.setText("telephone");

        //---- label3 ----
        label3.setText("mot de passe");

        //---- label4 ----
        label4.setText("Confirmer mot de passe");

        //---- label5 ----
        label5.setText("Register");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(label1)
                        .addComponent(label3)
                        .addComponent(label4))
                    .addGap(127, 127, 127)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addComponent(tftelephone, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addComponent(tfemail, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addComponent(passwordField2, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addGap(73, 73, 73))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 341, Short.MAX_VALUE)
                    .addComponent(btregister)
                    .addGap(25, 25, 25))
                .addGroup(layout.createSequentialGroup()
                    .addGap(161, 161, 161)
                    .addComponent(label5)
                    .addContainerGap(219, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(label5)
                    .addGap(33, 33, 33)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tfemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tftelephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                    .addComponent(btregister)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField tfemail;
    private JButton btregister;
    private JTextField tftelephone;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
