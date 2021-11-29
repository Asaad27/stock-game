package Gui;

import javax.swing.*;

public class AchatDialog extends JDialog {
    private int width = 400;
    private int height = 300;


    public AchatDialog(JFrame parentFrame, MainFrame mainFrame) {

        super(parentFrame, "Achat action", true);
        setSize(width, height);
        setLocationRelativeTo(parentFrame);

        setContentPane(new AcheterPanel(this, mainFrame));
        setVisible(true);
    }

}
