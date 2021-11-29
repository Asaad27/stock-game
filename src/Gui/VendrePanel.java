package Gui;



import Jeu.Main;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;


/**
 * @author Yousra
 */
public class VendrePanel extends JPanel {
    private JDialog parent;
    private MainFrame mainFrame;
    public VendrePanel(JDialog parent, MainFrame mainFrame) {

        initComponents();
        this.parent = parent;
        this.mainFrame = mainFrame;

    }

    private void validerActionPerformed(ActionEvent e) {
        int id = Integer.parseInt(textField_ID.getText());
        int qte = Integer.parseInt(textField_quantite.getText());
        try {
            Main.game.Vendre(id,qte);
        } catch (Exception ee) {
            ee.printStackTrace();
            JOptionPane.showMessageDialog(null, "vous ne possedez pas la quantité entrée");

        }
        mainFrame.mettreAjourPortefeuil();
        //mainFrame.removeAllRowsFromJTable();
        //mainFrame.updateJTablePortfolio();
        mainFrame.mettreAjourTableauPortfolio(Main.game.getTableowned());
        parent.dispose();


    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        valider = new JButton();
        textField_quantite = new JTextField();
        textField_ID = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========

        //---- valider ----
        valider.setText("valider");
        valider.addActionListener(e -> validerActionPerformed(e));

        //---- label1 ----
        label1.setText("ID");

        //---- label2 ----
        label2.setText("Quantit\u00e9");

        //---- label3 ----
        label3.setText("Vendre Action");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(131, 131, 131)
                            .addComponent(label1)
                            .addGap(31, 31, 31))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label3)
                            .addContainerGap(206, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(textField_quantite)
                                .addComponent(textField_ID, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 116, Short.MAX_VALUE)
                                    .addComponent(valider)))
                            .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(label3)
                    .addGap(62, 62, 62)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField_ID, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField_quantite, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                    .addComponent(valider)
                    .addGap(26, 26, 26))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton valider;
    private JTextField textField_quantite;
    private JTextField textField_ID;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
