package dev.thanapoom.tictactoe.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public final class GameGUI extends javax.swing.JFrame {
    Timer timer;
    private final int timeoutGame = 7;
    private String startGame = "X";
    private int XCnt = 0;
    private int OCnt = 0;
    private String playerStatus = "";
    private int second = 0;

    public GameGUI() {

        initComponents();
        statusPanel.setBackground(Color.RED);
        gameTimerRestart();
        gameTimer();
        timer.start();
        playerStatus = "RED";
    }

    public void gameTimerRestart() {

        second = timeoutGame + 1;
    }

    public void gameTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second--;
                gameTime.setText("" + second);

                if (second == 0) {
                    if (playerStatus.equals("BLUE")) {
                        gameTimerRestart();
                        bypassRED();
                        choosePlayer();
                    } else if (playerStatus.equals("RED")) {
                        gameTimerRestart();
                        bypassBLUE();
                        choosePlayer();
                    }
                }
            }

        });
    }

    private void bypassBLUE() {
        OCnt++;
        JOptionPane.showMessageDialog(this, "Player BLUE Win! because Time OUT!", "Tic Tac Toe",
                JOptionPane.INFORMATION_MESSAGE);
        resetGame();
        gameScore();
        scoreCheck();
        resetGame();
    }

    private void bypassRED() {
        XCnt++;
        JOptionPane.showMessageDialog(this, "Player RED Win! because Time OUT!", "Tic Tac Toe",
                JOptionPane.INFORMATION_MESSAGE);
        resetGame();
        gameScore();
        scoreCheck();
        resetGame();
    }

    private void gameScore() {
        XScore.setText(String.valueOf(XCnt));
        OScore.setText(String.valueOf(OCnt));
    }

    private void scoreCheck() {
        if (XCnt == 3 || OCnt == 3) {
            JOptionPane.showMessageDialog(this, "Game Over!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            resultGame();
        }
    }

    private void resultGame() {
        // Result Game
        timer.stop();
        BlueWin bw = new BlueWin();
        RedWin rw = new RedWin();
        // Red Win
        if (XCnt > OCnt) {
            rw.setVisible(true);
            rw.show();
            dispose();
        }
        // Blue Win
        else if (OCnt > XCnt) {
            bw.setVisible(true);
            bw.show();
            dispose();
        }

    }

    private void choosePlayer() {
        // Choose Player Logic
        if (startGame.equalsIgnoreCase("X")) {
            startGame = "O";
            statusPanel.setBackground(Color.BLUE);
            playerStatus = "BLUE";

        } else {
            startGame = "X";
            statusPanel.setBackground(Color.RED);
            playerStatus = "RED";
        }

    }
    // Reset Game
    private void resetGame() {
        gameButton1.setText("");
        gameButton2.setText("");
        gameButton3.setText("");

        gameButton4.setText("");
        gameButton5.setText("");
        gameButton6.setText("");

        gameButton7.setText("");
        gameButton8.setText("");
        gameButton9.setText("");

        gameButton1.setBackground(Color.WHITE);
        gameButton2.setBackground(Color.WHITE);
        gameButton3.setBackground(Color.WHITE);

        gameButton4.setBackground(Color.WHITE);
        gameButton5.setBackground(Color.WHITE);
        gameButton6.setBackground(Color.WHITE);

        gameButton7.setBackground(Color.WHITE);
        gameButton8.setBackground(Color.WHITE);
        gameButton9.setBackground(Color.WHITE);
        second = 7;

    }

    private void gameLogic() {
        String b1 = gameButton1.getText();
        String b2 = gameButton2.getText();
        String b3 = gameButton3.getText();

        String b4 = gameButton4.getText();
        String b5 = gameButton5.getText();
        String b6 = gameButton6.getText();

        String b7 = gameButton7.getText();
        String b8 = gameButton8.getText();
        String b9 = gameButton9.getText();

        // X Player Logic
        // X X X
        // - - -
        // - - -
        if (b1 == ("X") && b2 == ("X") && b3 == ("X")) {

            XCnt++;

            gameButton1.setBackground(Color.RED);
            gameButton2.setBackground(Color.RED);
            gameButton3.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Player RED Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // - - -
        // X X X
        // - - -
        if (b4 == ("X") && b5 == ("X") && b6 == ("X")) {

            XCnt++;

            gameButton4.setBackground(Color.RED);
            gameButton5.setBackground(Color.RED);
            gameButton6.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Player RED Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // - - -
        // - - -
        // X X X
        if (b7 == ("X") && b8 == ("X") && b9 == ("X")) {

            XCnt++;

            gameButton7.setBackground(Color.RED);
            gameButton8.setBackground(Color.RED);
            gameButton9.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Player RED Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // X - -
        // X - -
        // X - -
        if (b1 == ("X") && b4 == ("X") && b7 == ("X")) {

            XCnt++;

            gameButton1.setBackground(Color.RED);
            gameButton4.setBackground(Color.RED);
            gameButton7.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Player RED Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // - X -
        // - X -
        // - X -
        if (b2 == ("X") && b5 == ("X") && b8 == ("X")) {

            XCnt++;

            gameButton2.setBackground(Color.RED);
            gameButton5.setBackground(Color.RED);
            gameButton8.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Player RED Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // - - X
        // - - X
        // - - X
        if (b3 == ("X") && b6 == ("X") && b9 == ("X")) {

            XCnt++;
            ;

            gameButton3.setBackground(Color.RED);
            gameButton6.setBackground(Color.RED);
            gameButton9.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Player RED Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // X - -
        // - X -
        // - - X
        if (b1 == ("X") && b5 == ("X") && b9 == ("X")) {

            XCnt++;

            gameButton1.setBackground(Color.RED);
            gameButton5.setBackground(Color.RED);
            gameButton9.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Player RED Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // - - X
        // - X -
        // X - -
        if (b3 == ("X") && b5 == ("X") && b7 == ("X")) {

            XCnt++;

            gameButton3.setBackground(Color.RED);
            gameButton5.setBackground(Color.RED);
            gameButton7.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Player RED Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // O Player Logic
        // O O O
        // - - -
        // - - -
        if (b1 == ("O") && b2 == ("O") && b3 == ("O")) {

            OCnt++;

            gameButton1.setBackground(Color.BLUE);
            gameButton2.setBackground(Color.BLUE);
            gameButton3.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(this, "Player BLUE Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // - - -
        // O O O
        // - - -
        if (b4 == ("O") && b5 == ("O") && b6 == ("O")) {

            OCnt++;

            gameButton4.setBackground(Color.BLUE);
            gameButton5.setBackground(Color.BLUE);
            gameButton6.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(this, "Player BLUE Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // - - -
        // - - -
        // O O O
        if (b7 == ("O") && b8 == ("O") && b9 == ("O")) {

            OCnt++;

            gameButton7.setBackground(Color.BLUE);
            gameButton8.setBackground(Color.BLUE);
            gameButton9.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(this, "Player BLUE Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // O - -
        // O - -
        // O - -
        if (b1 == ("O") && b4 == ("O") && b7 == ("O")) {

            OCnt++;

            gameButton1.setBackground(Color.BLUE);
            gameButton4.setBackground(Color.BLUE);
            gameButton7.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(this, "Player BLUE Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // - O -
        // - O -
        // - O -
        if (b2 == ("O") && b5 == ("O") && b8 == ("O")) {

            OCnt++;

            gameButton2.setBackground(Color.BLUE);
            gameButton5.setBackground(Color.BLUE);
            gameButton8.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(this, "Player BLUE Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // - - O
        // - - O
        // - - O
        if (b3 == ("O") && b6 == ("O") && b9 == ("O")) {

            OCnt++;

            gameButton3.setBackground(Color.BLUE);
            gameButton6.setBackground(Color.BLUE);
            gameButton9.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(this, "Player BLUE Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // O - -
        // - O -
        // - - O
        if (b1 == ("O") && b5 == ("O") && b9 == ("O")) {

            OCnt++;

            gameButton1.setBackground(Color.BLUE);
            gameButton5.setBackground(Color.BLUE);
            gameButton9.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(this, "Player BLUE Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }
        // - - O
        // - O -
        // O - -
        if (b3 == ("O") && b5 == ("O") && ("O") == b7) {

            OCnt++;

            gameButton3.setBackground(Color.BLUE);
            gameButton5.setBackground(Color.BLUE);
            gameButton7.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(this, "Player BLUE Win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            gameScore();
            scoreCheck();
        }

        // Draw

        // Check if all the boxes are filled
        else if (!b1.equals("") && !b2.equals("") && !b3.equals("") && !b4.equals("") && !b5.equals("")
                && !b5.equals("") && !b6.equals("") && !b7.equals("") && !b8.equals("") && !b9.equals("")) {
            JOptionPane.showMessageDialog(this, "Draw!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            scoreCheck();
        }

    }

    private void initComponents() {

        gameButton7 = new javax.swing.JButton();
        gameButton1 = new javax.swing.JButton();
        gameButton2 = new javax.swing.JButton();
        gameButton5 = new javax.swing.JButton();
        gameButton4 = new javax.swing.JButton();
        gameButton9 = new javax.swing.JButton();
        gameButton6 = new javax.swing.JButton();
        gameButton3 = new javax.swing.JButton();
        gameButton8 = new javax.swing.JButton();
        redPanel = new javax.swing.JPanel();
        Xplayer = new javax.swing.JLabel();
        XScore = new javax.swing.JLabel();
        bluePanel = new javax.swing.JPanel();
        Oplayer = new javax.swing.JLabel();
        OScore = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        gameTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The - Tic Tac Toe");
        setResizable(false);

        gameButton7.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        gameButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButton7ActionPerformed(evt);
            }
        });

        gameButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        gameButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButton1ActionPerformed(evt);
            }
        });

        gameButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        gameButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButton2ActionPerformed(evt);
            }
        });

        gameButton5.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        gameButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButton5ActionPerformed(evt);
            }
        });

        gameButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        gameButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButton4ActionPerformed(evt);
            }
        });

        gameButton9.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        gameButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButton9ActionPerformed(evt);
            }
        });

        gameButton6.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        gameButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButton6ActionPerformed(evt);
            }
        });

        gameButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        gameButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButton3ActionPerformed(evt);
            }
        });

        gameButton8.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        gameButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameButton8ActionPerformed(evt);
            }
        });

        redPanel.setBackground(new java.awt.Color(255, 51, 51));

        Xplayer.setBackground(new java.awt.Color(255, 51, 51));
        Xplayer.setFont(new java.awt.Font("DSN PatPong Extend", 0, 18));
        Xplayer.setForeground(new java.awt.Color(255, 255, 255));
        Xplayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Xplayer.setText("RED : X");

        XScore.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        XScore.setForeground(new java.awt.Color(255, 255, 255));
        XScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XScore.setText("0/3");

        javax.swing.GroupLayout redPanelLayout = new javax.swing.GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
                redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(redPanelLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(redPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Xplayer, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(XScore, javax.swing.GroupLayout.DEFAULT_SIZE, 81,
                                                Short.MAX_VALUE))
                                .addContainerGap(50, Short.MAX_VALUE)));
        redPanelLayout.setVerticalGroup(
                redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(redPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Xplayer)
                                .addGap(50, 50, 50)
                                .addComponent(XScore)
                                .addContainerGap(80, Short.MAX_VALUE)));

        bluePanel.setBackground(new java.awt.Color(0, 153, 255));
        bluePanel.setForeground(new java.awt.Color(255, 255, 255));

        Oplayer.setFont(new java.awt.Font("DSN PatPong Extend", 0, 18));
        Oplayer.setForeground(new java.awt.Color(255, 255, 255));
        Oplayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Oplayer.setText("BLUE : O");

        OScore.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
        OScore.setForeground(new java.awt.Color(255, 255, 255));
        OScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OScore.setText("0/3");

        javax.swing.GroupLayout bluePanelLayout = new javax.swing.GroupLayout(bluePanel);
        bluePanel.setLayout(bluePanelLayout);
        bluePanelLayout.setHorizontalGroup(
                bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bluePanelLayout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addGroup(bluePanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Oplayer, javax.swing.GroupLayout.DEFAULT_SIZE, 81,
                                                Short.MAX_VALUE)
                                        .addComponent(OScore, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)));
        bluePanelLayout.setVerticalGroup(
                bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bluePanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Oplayer)
                                .addGap(50, 50, 50)
                                .addComponent(OScore)
                                .addContainerGap(80, Short.MAX_VALUE)));

        gameTime.setFont(new java.awt.Font("Albertus", 0, 36));
        gameTime.setForeground(new java.awt.Color(255, 255, 255));
        gameTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameTime.setText("0");

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
                statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                                .addContainerGap(168, Short.MAX_VALUE)
                                .addComponent(gameTime, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167)));
        statusPanelLayout.setVerticalGroup(
                statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(statusPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(gameTime)
                                .addContainerGap(10, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(redPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(gameButton7,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(gameButton8,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(gameButton4,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(gameButton5,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(gameButton6,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(gameButton3,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(gameButton9,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(gameButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(gameButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(59, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(gameButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gameButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gameButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(gameButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gameButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gameButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(gameButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gameButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gameButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(redPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(263, Short.MAX_VALUE)));

        pack();
    }

    private void gameButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        gameButton7.setText(startGame);
        if (startGame.equalsIgnoreCase("X")) {
            gameButton7.setForeground(Color.RED);
        } else {
            gameButton7.setForeground(Color.BLUE);
        }
        choosePlayer();
        gameLogic();
        gameTimerRestart();
    }

    private void gameButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        gameButton1.setText(startGame);
        if (startGame.equalsIgnoreCase("X")) {
            gameButton1.setForeground(Color.RED);
        } else {
            gameButton1.setForeground(Color.BLUE);
        }
        choosePlayer();
        gameLogic();
        gameTimerRestart();
    }

    private void gameButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        gameButton2.setText(startGame);
        if (startGame.equalsIgnoreCase("X")) {
            gameButton2.setForeground(Color.RED);
        } else {
            gameButton2.setForeground(Color.BLUE);
        }
        choosePlayer();
        gameLogic();
        gameTimerRestart();
    }

    private void gameButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        gameButton5.setText(startGame);
        if (startGame.equalsIgnoreCase("X")) {
            gameButton5.setForeground(Color.RED);
        } else {
            gameButton5.setForeground(Color.BLUE);
        }
        choosePlayer();
        gameLogic();
        gameTimerRestart();
    }

    private void gameButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        gameButton4.setText(startGame);
        if (startGame.equalsIgnoreCase("X")) {
            gameButton4.setForeground(Color.RED);
        } else {
            gameButton4.setForeground(Color.BLUE);
        }
        choosePlayer();
        gameLogic();
        gameTimerRestart();
    }

    private void gameButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        gameButton9.setText(startGame);
        if (startGame.equalsIgnoreCase("X")) {
            gameButton9.setForeground(Color.RED);
        } else {
            gameButton9.setForeground(Color.BLUE);
        }
        choosePlayer();
        gameLogic();
        gameTimerRestart();
    }

    private void gameButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        gameButton6.setText(startGame);
        if (startGame.equalsIgnoreCase("X")) {
            gameButton6.setForeground(Color.RED);
        } else {
            gameButton6.setForeground(Color.BLUE);
        }
        choosePlayer();
        gameLogic();
        gameTimerRestart();
    }

    private void gameButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        gameButton3.setText(startGame);
        if (startGame.equalsIgnoreCase("X")) {
            gameButton3.setForeground(Color.RED);
        } else {
            gameButton3.setForeground(Color.BLUE);
        }
        choosePlayer();
        gameLogic();
        gameTimerRestart();
    }

    private void gameButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        gameButton8.setText(startGame);
        if (startGame.equalsIgnoreCase("X")) {
            gameButton8.setForeground(Color.RED);
        } else {
            gameButton8.setForeground(Color.BLUE);
        }
        choosePlayer();
        gameLogic();
        gameTimerRestart();
    }

    private javax.swing.JLabel OScore;
    private javax.swing.JLabel Oplayer;
    private javax.swing.JLabel XScore;
    private javax.swing.JLabel Xplayer;
    private javax.swing.JPanel bluePanel;
    private javax.swing.JButton gameButton1;
    private javax.swing.JButton gameButton2;
    private javax.swing.JButton gameButton3;
    private javax.swing.JButton gameButton4;
    private javax.swing.JButton gameButton5;
    private javax.swing.JButton gameButton6;
    private javax.swing.JButton gameButton7;
    private javax.swing.JButton gameButton8;
    private javax.swing.JButton gameButton9;
    private javax.swing.JLabel gameTime;
    private javax.swing.JPanel redPanel;
    private javax.swing.JPanel statusPanel;
}
