package Jeu;

import Gui.LoginFrame;
import Jeu.Jeu;

import javax.swing.*;

public class Main {

    public static Jeu game;

    public static void main(String[] args) {

        game = new Jeu();
        LoginFrame loginFrame = new LoginFrame(game);

        /*JFrame frame = new JFrame();
        frame.setVisible(true);
        new AchatDialog(frame);*/

    }
}
