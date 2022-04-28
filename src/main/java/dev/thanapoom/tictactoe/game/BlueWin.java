
package dev.thanapoom.tictactoe.game;


public class BlueWin extends javax.swing.JFrame {


    public BlueWin() {
        initComponents();
    }


    private void initComponents() {
        setResizable(false);
        resultTitle = new javax.swing.JLabel();
        restartButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultTitle.setFont(new java.awt.Font("DB Helvethaica X Med", 1, 100));
        resultTitle.setForeground(new java.awt.Color(51, 153, 255));
        resultTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultTitle.setText("BLUE WIN!");
        resultTitle.setToolTipText("");

        restartButton.setFont(new java.awt.Font("PSL BaannarakBook Pro (บรรณารัก", 1, 24));
        restartButton.setText("RESTART");
        restartButton.setAlignmentY(0.0F);
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(resultTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 461,
                                                Short.MAX_VALUE)
                                        .addComponent(restartButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(200, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(resultTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 146,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(214, Short.MAX_VALUE)));

        pack();
    }

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        GameGUI rs = new GameGUI();
        rs.setVisible(true);
        rs.show();
        dispose();
    }


    private javax.swing.JButton restartButton;
    private javax.swing.JButton restartGame;
    private javax.swing.JLabel resultTitle;

}