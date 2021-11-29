package Gui;

import javax.swing.*;

public class SurveillanceDialog extends JDialog {
    private int width = 400;
    private int height = 300;

    public SurveillanceDialog(JFrame parentFrame, MainFrame mainFrame) {
        super(parentFrame, "Surveiller action", true);
        setSize(width, height);
        setLocationRelativeTo(parentFrame);

        setContentPane(new SurveillerPanel(this, mainFrame));
        setVisible(true);
    }
}
