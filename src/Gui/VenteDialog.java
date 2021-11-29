package Gui;

import javax.swing.*;

public class VenteDialog extends JDialog {
    private int width = 400;
    private int height = 300;
    public VenteDialog(JFrame parentFrame, MainFrame mainFrame) {

        super(parentFrame, "vente action", true);
        setSize(width, height);
        setLocationRelativeTo(parentFrame);

        setContentPane(new VendrePanel(this, mainFrame));
        setVisible(true);
    }
}
