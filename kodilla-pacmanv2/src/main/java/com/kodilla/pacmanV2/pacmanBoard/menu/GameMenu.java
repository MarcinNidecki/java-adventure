package com.kodilla.pacmanV2.pacmanBoard.menu;

import com.kodilla.pacmanV2.GameInit;
import com.kodilla.pacmanV2.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JComponent {

    ImageIcon exitIcon, startGameIcon;
    ImagePanel panel;
    JButton newGame, exit;

    public GameMenu(GameInit game) {

        java.net.URL imgURL3 = GameInit.class.getResource("/assets/textures/gameMenu.png");
        ImageIcon icon2 = new ImageIcon(imgURL3);
        Image image = icon2.getImage();
        panel = new ImagePanel(image);
        panel.setPreferredSize(new Dimension(261, 226));


        java.net.URL imgURL = GameInit.class.getResource("/assets/textures/exit.png");
        exitIcon = new ImageIcon(imgURL);
        exit = new JButton("", exitIcon);
        exit.addActionListener(e -> System.exit(0));
        exit.setOpaque(false);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setVisible(true);


        java.net.URL imgURL2 = GameInit.class.getResource("/assets/textures/newGame.png");
        startGameIcon = new ImageIcon(imgURL2);
        newGame = new JButton("", startGameIcon);
        newGame.addActionListener(e -> game.resetGame());
        newGame.setOpaque(false);

        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);

        newGame.setVisible(true);
        panel.setLayout(new GridLayout(3, 1));

        panel.add(Box.createRigidArea(new Dimension(0, 0)));
        panel.add(newGame);

        panel.add(exit);
        panel.setVisible(false);
    }

    public ImagePanel getPanel() {
        return panel;
    }

    public void setPanel(ImagePanel panel) {
        this.panel = panel;
    }

    public JButton getB() {
        return newGame;
    }

    public void setB(JButton b) {
        this.newGame = b;
    }

    public void showMenu() {
        panel.setVisible(true);
    }

    public void newGameButton() {

    }

    public void paintComponent(Graphics g) {
        g.drawOval(100, 100, 200, 200);
        g.setColor(Color.YELLOW);

    }


}
