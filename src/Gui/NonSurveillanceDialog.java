package Gui;

import javax.swing.*;


public class NonSurveillanceDialog extends JDialog {
    private int width = 400;
    private int height = 300;

    public NonSurveillanceDialog(JFrame parentFrame, MainFrame mainFrame) {
        super(parentFrame, "Ne pas Surveiller action", true);
        setSize(width, height);
        setLocationRelativeTo(parentFrame);

        setContentPane(new NePasSurveillerPanel(this, mainFrame));
        setVisible(true);
    }
}
