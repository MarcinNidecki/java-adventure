package com.kodilla.pacmanV2.pacmanBoard.statistic;

import java.awt.*;

public class ScoreCounter {

    public int score = 0, pointForSmallDot = 10, pointForBigDot = 30;


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addPointForSmallDot() {
        this.score = this.score + pointForSmallDot;
    }

    public void addPointForBigDot() {
        this.score = this.score + pointForBigDot;
    }


    public void paint(Graphics g) {
        if (g instanceof Graphics2D) {
            Graphics2D g2d = (Graphics2D) g;
        }
        Font stringFont = new Font("Courier", Font.BOLD, 18);
        String scoreString = String.valueOf(score);
        g.setFont(stringFont);
        g.setColor(Color.YELLOW);
        g.drawString("Score: " + scoreString, 1400, 920);
    }
}
