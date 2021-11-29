package Gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Jeu.*;



/**
 * @author Yousra
 */
public class SurveillerPanel extends JPanel {
    private JDialog parent;
    private MainFrame mainFrame;

    public SurveillerPanel(JDialog parent, MainFrame mainFrame) {
        initComponents();
        this.parent = parent;
        this.mainFrame = mainFrame;
    }

    private void validerActionPerformed(ActionEvent e) {
        int id = 0;
        String sid = "";
        try {
            id = Integer.parseInt(textField_ID.getText());
            sid = textField_ID.getText();
        }
        catch (NullPointerException ee)
        {
            ee.printStackTrace();
            System.out.println(ee.toString());
        }
        if (findRowById(sid)){
            Main.game.addFav(id);
            mainFrame.mettreAjourTableauFavoris(Main.game.getFav());
            parent.dispose();
        }
        else{
            System.out.println("id not found");
            JOptionPane.showMessageDialog(null, "ID invalide");
        }

    }

    public Boolean findRowById(String id){

        if (id == null){
            System.out.println("erreur id");
            return false;
        }

        Object[][] tablesMain = Main.game.getTableAssets();
        for (Object[] objects : tablesMain) {

            if (objects[0].toString().equals(id)) {
                return true;
            }
        }

        System.out.println("id not found");
        return false;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        valider = new JButton();
        textField_ID = new JTextField();
        label1 = new JLabel();
        label3 = new JLabel();

        //======== this ========

        //---- valider ----
        valider.setText("valider");
        valider.addActionListener(e -> validerActionPerformed(e));

        //---- label1 ----
        label1.setText("ID");

        //---- label3 ----
        label3.setText("Surveiller Action");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(131, 131, 131)
                    .addComponent(label1)
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label3)
                            .addContainerGap(155, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(textField_ID, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 133, Short.MAX_VALUE)
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                    .addComponent(valider)
                    .addGap(26, 26, 26))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton valider;
    private JTextField textField_ID;
    private JLabel label1;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
