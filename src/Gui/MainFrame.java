package Gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

import Jeu.*;
import net.miginfocom.swing.*;


/**
 * @author Yousra
 */
public class MainFrame extends JFrame {

    private JDialog achatDialog, venteDialog, surveillanceDialog, nonSurveillanceDialog;
    private Table tableMarche, tablePortfolio, tableFavoris;
    private LoginFrame loginFrame;

    public JPanel historyP = new JPanel();


    JPanel HistPanel;
    JLabel  HistLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton  historyB, backHistB, backpfB;



    public MainFrame(LoginFrame loginFrame) {

        initComponents();

        this.loginFrame = loginFrame;


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        tablePortfolio = new Table(Main.game.getTableColumns(), panelPortfolio);
        tablePortfolio.initJTable(Main.game.getTableowned());

        tableFavoris = new Table(Main.game.getFavColumns(), panelFavoris);
        tableFavoris.initJTable(Main.game.getFav());

        mettreAjourPortefeuil();

    }

    /* utilitaires */

    public  void mettreAjourPortefeuil() {
        String cash = Main.game.getCash();
        if (cash != null)
            this.textfield_portfolio.setText("Cash : " + cash + "$");
    }

    public void mettreAjourTableauPortfolio(Object[][] rowData){
        tablePortfolio.updateJTable(rowData);
    }
    public void mettreAjourTableauMarche(Object[][] rowData){
        tableMarche.updateJTable(rowData);
    }
    public void mettreAjourTableauFavoris(Object[][] rowData){
        tableFavoris.updateJTable(rowData);
    }

    private void setHistoryP(){
        /*info*/
        JFrame history = new JFrame();

        HistPanel = new JPanel(new BorderLayout());
        JTable table = new JTable(Main.game.getTableHistory(),Main.game.getHistColumn());
        JScrollPane assetowned = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        HistPanel.setBounds(0, 0, 400, 400);
        HistPanel.add(assetowned);

        history.setContentPane(HistPanel);
        history.pack();
        history.setVisible(true);

        /*buttons*/
        JPanel ButtonchoicePannel = new JPanel();
        ButtonchoicePannel.setBounds(400, 600, 200, 100);
        ButtonchoicePannel.setBackground(Color.black);
        ButtonchoicePannel.setLayout(new BorderLayout());
        ButtonchoicePannel.setVisible(true);

        backHistB = new JButton("Back");
        backHistB.setBackground(Color.black);
        backHistB.setForeground(Color.white);
        backHistB.setFont(normalFont);
        backHistB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                history.dispose();
            }
        });

        ButtonchoicePannel.add(backpfB);
        historyP.add(ButtonchoicePannel);
        historyP.add(HistPanel);


    }

    private void updateHistoryP(){
        historyP.remove(HistPanel);

        HistPanel = new JPanel(new BorderLayout());
        JTable table = new JTable(Main.game.getTableHistory(),Main.game.getHistColumn());
        JScrollPane assetowned = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        HistPanel.setBounds(0, 0, 400, 400);
        HistPanel.add(assetowned);

        historyP.add(HistPanel);
        historyP.repaint();
        historyP.validate();
    }

    /* action listeneres */

    private void acheterActionActionPerformed(ActionEvent e) {   //open acheterDialog
        achatDialog = new AchatDialog(this, this);

    }

    private void vendreActionActionPerformed(ActionEvent e) {
        venteDialog = new VenteDialog(this, this);
    }

    private void surveillerActionActionPerformed(ActionEvent e) {
        surveillanceDialog = new SurveillanceDialog(this, this);

    }

    private void NesPasSurveillerActionActionPerformed(ActionEvent e) {
        nonSurveillanceDialog = new NonSurveillanceDialog(this, this);

    }

    private void voirClassementActionPerformed(ActionEvent e) {

    }


    private void actionsFavorisActionPerformed(ActionEvent e) {

    }


    private void tourSuivantActionPerformed(ActionEvent e) {
        Main.game.nextRound();
        tableMarche.updateJTable(Main.game.getTableAssets());

    }

    private void marcheActionPerformed(ActionEvent e) {

        tableMarche = new Table(Main.game.getTableColumns(), panelMarche);
        tableMarche.initJTable(Main.game.getTableAssets());

        btMarche.setVisible(false);
        repaint();
        revalidate();
    }


    private void logoutActionPerformed(ActionEvent e) {
        Main.game = null;
        Main.main(null);

        dispose();
    }

    private void voirHistoriqueActionPerformed(ActionEvent e) {
        setHistoryP();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        Account = new JMenu();
        logout = new JMenuItem();
        label2 = new JLabel();
        textfield_portfolio = new JTextField();
        label1 = new JLabel();
        panel5 = new JPanel();
        panel8 = new JPanel();
        panelMarche = new JPanel();
        btMarche = new JButton();
        panel2 = new JPanel();
        acheterAction = new JButton();
        vendreAction = new JButton();
        surveillerAction = new JButton();
        NesPasSurveillerAction = new JButton();
        Emprunter = new JButton();
        voirHistorique = new JButton();
        tourSuivant = new JButton();
        panelPortfolio = new JPanel();
        panelFavoris = new JPanel();
        label3 = new JLabel();

        //======== this ========
        setTitle("Jeu Boursiere");
        var contentPane = getContentPane();
        contentPane.setLayout(new CardLayout());

        //======== menuBar1 ========
        {
            menuBar1.setBackground(Color.black);
            menuBar1.setForeground(Color.white);

            //======== Account ========
            {
                Account.setText("Account");
                Account.setBackground(Color.white);
                Account.setForeground(new Color(102, 255, 102));

                //---- logout ----
                logout.setText("Log out");
                logout.addActionListener(e -> logoutActionPerformed(e));
                Account.add(logout);
            }
            menuBar1.add(Account);

            //---- label2 ----
            label2.setIcon(new ImageIcon(getClass().getResource("/ressources/market-analysis (2).png")));
            label2.setBackground(Color.black);
            menuBar1.add(label2);

            //---- textfield_portfolio ----
            textfield_portfolio.setText("Jeu boursiere");
            textfield_portfolio.setEditable(false);
            textfield_portfolio.setHorizontalAlignment(SwingConstants.CENTER);
            textfield_portfolio.setBackground(Color.black);
            textfield_portfolio.setForeground(Color.white);
            menuBar1.add(textfield_portfolio);

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/ressources/portfolio (2).png")));
            label1.setBackground(Color.black);
            menuBar1.add(label1);
        }
        setJMenuBar(menuBar1);

        //======== panel5 ========
        {
            panel5.setMaximumSize(new Dimension(911, 517));

            //======== panel8 ========
            {
                panel8.setLayout(new BorderLayout());
            }

            //======== panelMarche ========
            {
                panelMarche.setBackground(Color.cyan);
                panelMarche.setLayout(new BorderLayout());

                //---- btMarche ----
                btMarche.setText("march\u00e9");
                btMarche.addActionListener(e -> marcheActionPerformed(e));
                panelMarche.add(btMarche, BorderLayout.SOUTH);
            }

            //======== panel2 ========
            {
                panel2.setLayout(new GridLayout(5, 1));

                //---- acheterAction ----
                acheterAction.setText("Acheter action");
                acheterAction.addActionListener(e -> acheterActionActionPerformed(e));
                panel2.add(acheterAction);

                //---- vendreAction ----
                vendreAction.setText("Vendre action");
                vendreAction.addActionListener(e -> vendreActionActionPerformed(e));
                panel2.add(vendreAction);

                //---- surveillerAction ----
                surveillerAction.setText("Surveiller action");
                surveillerAction.addActionListener(e -> surveillerActionActionPerformed(e));
                panel2.add(surveillerAction);

                //---- NesPasSurveillerAction ----
                NesPasSurveillerAction.setText("Ne pas surveiller action");
                NesPasSurveillerAction.addActionListener(e -> NesPasSurveillerActionActionPerformed(e));
                panel2.add(NesPasSurveillerAction);

                //---- Emprunter ----
                Emprunter.setText("Emprunter");
                Emprunter.addActionListener(e -> actionsFavorisActionPerformed(e));
                panel2.add(Emprunter);

                //---- voirHistorique ----
                voirHistorique.setText("Voir historique");
                voirHistorique.addActionListener(e -> voirHistoriqueActionPerformed(e));
                panel2.add(voirHistorique);
            }

            //---- tourSuivant ----
            tourSuivant.setText("tour suivant");
            tourSuivant.addActionListener(e -> tourSuivantActionPerformed(e));

            //======== panelPortfolio ========
            {
                panelPortfolio.setBackground(new Color(204, 204, 0));
                panelPortfolio.setLayout(new BorderLayout());
            }

            //======== panelFavoris ========
            {
                panelFavoris.setBackground(Color.green);
                panelFavoris.setLayout(new BorderLayout());
            }

            //---- label3 ----
            label3.setText("Actions favoris");
            label3.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout panel5Layout = new GroupLayout(panel5);
            panel5.setLayout(panel5Layout);
            panel5Layout.setHorizontalGroup(
                panel5Layout.createParallelGroup()
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addComponent(panelMarche, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel5Layout.createParallelGroup()
                                    .addGroup(panel5Layout.createSequentialGroup()
                                        .addGap(162, 162, 162)
                                        .addComponent(tourSuivant, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(139, 139, 139))
                                    .addGroup(panel5Layout.createSequentialGroup()
                                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panel5Layout.createSequentialGroup()
                                        .addComponent(panelFavoris, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(panelPortfolio, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
            );
            panel5Layout.setVerticalGroup(
                panel5Layout.createParallelGroup()
                    .addComponent(panelMarche, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addComponent(panelPortfolio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelFavoris, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel5Layout.createParallelGroup()
                                    .addComponent(panel8, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tourSuivant, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))))
            );
        }
        contentPane.add(panel5, "card1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu Account;
    private JMenuItem logout;
    private JLabel label2;
    private JTextField textfield_portfolio;
    private JLabel label1;
    private JPanel panel5;
    private JPanel panel8;
    private JPanel panelMarche;
    private JButton btMarche;
    private JPanel panel2;
    private JButton acheterAction;
    private JButton vendreAction;
    private JButton surveillerAction;
    private JButton NesPasSurveillerAction;
    private JButton Emprunter;
    private JButton voirHistorique;
    private JButton tourSuivant;
    private JPanel panelPortfolio;
    private JPanel panelFavoris;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
