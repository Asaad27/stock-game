package Gui;

import Jeu.*;

import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class AcheterPanel extends JPanel {
    private JDialog parent;
    private MainFrame mainFrame;
    public AcheterPanel(JDialog parent, MainFrame mainFrame) {

        initComponents();
        this.parent = parent;
        this.mainFrame = mainFrame;

        textField_quantite.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                String id = textField_ID.getText();
                double price = findPriceById(id);
                if (price == -1){
                    price = 0;
                }
                String qte = textField_quantite.getText();
                double total;
                if (qte != null) {
                    total = Double.parseDouble(qte) * price;
                    System.out.println(qte);
                    label4.setText("Prix total : " + total);
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                label4.setText("Prix total : " );
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                String id = textField_ID.getText();
                double price = findPriceById(id);
                if (price == -1){
                    price = 0;
                }
                String qte = textField_quantite.getText();
                double total;
                if (qte != null) {
                    total = Double.parseDouble(qte) * price;
                    System.out.println(qte);
                    label4.setText("Prix total : " + String.valueOf(total));
                }

            }

        });

    }

    public Double findPriceById(String id){   //Retourne -1 en cas  d'erreur
        System.out.println("id : " + id);
        if (id == null)
            return (double) -1;

        Object[][] tablesMain = Main.game.getTableAssets();
        for (Object[] objects : tablesMain) {

            if (objects[0].toString().equals(id)) {
                return Double.valueOf(objects[2].toString());
            }
        }

        return (double) -1;
    }
    private void validerActionPerformed(ActionEvent e) {
        String id = textField_ID.getText();
        String qte = textField_quantite.getText();

        int idd = Integer.parseInt(id);
        int qted = Integer.parseInt(qte);

        try {
            Main.game.Acheter((int) idd,qted);
        } catch (Exception ee) {
            ee.printStackTrace();
            JOptionPane.showMessageDialog(null, "pas assez d'argent");
        }
        mainFrame.mettreAjourPortefeuil();
        mainFrame.mettreAjourTableauPortfolio(Main.game.getTableowned());

        parent.dispose();

    }



    private void textField_quantitePropertyChange(PropertyChangeEvent e) {
        System.out.println(textField_quantite.getText());
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        valider = new JButton();
        textField_quantite = new JTextField();
        textField_ID = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();

        //======== this ========

        //---- valider ----
        valider.setText("valider");
        valider.addActionListener(e -> validerActionPerformed(e));

        //---- textField_quantite ----
        textField_quantite.addPropertyChangeListener(e -> textField_quantitePropertyChange(e));

        //---- label1 ----
        label1.setText("ID");

        //---- label2 ----
        label2.setText("Quantit\u00e9");

        //---- label3 ----
        label3.setText("Acheter Action");

        //---- label4 ----
        label4.setText("prix total");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label3)
                            .addContainerGap(151, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(textField_quantite)
                                .addComponent(textField_ID, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 119, Short.MAX_VALUE)
                                    .addComponent(valider)))
                            .addGap(32, 32, 32))))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(248, Short.MAX_VALUE)
                    .addComponent(label4)
                    .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(label3)
                    .addGap(67, 67, 67)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField_ID, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField_quantite, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label2))
                    .addGap(18, 18, 18)
                    .addComponent(label4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
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
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
