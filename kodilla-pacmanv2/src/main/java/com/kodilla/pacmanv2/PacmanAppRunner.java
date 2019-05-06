package com.kodilla.pacmanv2;

import com.kodilla.pacmanv2.items.Player;
import com.kodilla.pacmanv2.pacmanBoard.TimerTaskPaccman;
import com.kodilla.pacmanv2.pacmanBoard.menu.GameMenu;
import com.kodilla.pacmanv2.pacmanBoard.menu.RankingMenu;
import com.kodilla.pacmanv2.pacmanBoard.statistic.PlayerLives;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class PacmanAppRunner extends Canvas implements Runnable, KeyListener {


    private static boolean isRunning = false;



    private static GameInit gameInit;
    private static GameMenu gameMenu;
    private String stop = "STOP";
    private Thread thread;
    private TimerTaskPaccman deadAnimation = new TimerTaskPaccman(3000);

    private PacmanAppRunner() {

        Dimension dimension = new Dimension(gameInit.getConstant().getWIDTH(), gameInit.getConstant().getHEIGHT());
        gameMenu = new GameMenu(gameInit);
        RankingMenu ranking = new RankingMenu(gameInit);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);
        addKeyListener(this);

    }

    public static void main(String[] arg) {
        gameInit = new GameInit();


        PacmanAppRunner game = new PacmanAppRunner();
        JFrame frame = new JFrame();
        frame.setBackground(Color.BLACK);
        frame.setBounds(0, 0, 1600, 960);
        frame.add(GameMenu.getPanel()).setLocation(630, 300);
        frame.add(RankingMenu.getPanel()).setLocation(600,250);
        frame.setTitle(gameInit.getConstant().getTITLE());
        frame.setUndecorated(true);
        frame.add(game);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.start();

    }



    private synchronized void start() {
        if (isRunning) return;
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!isRunning) return;
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void thick()  {

        gameInit.getPlayer().tick();

        if (gameInit.getPlayer().isHitByEnemy()) {
            gameInit.sendEnemyToHome();
            gameInit.getConstant().setNewRound(true);
        }

        if (!gameInit.isPause()) {
        gameInit.getEnemyBlue().enemyTick();
        gameInit.getEnemyPurple().enemyTick();
        gameInit.getEnemyGreen().enemyTick();
        gameInit.getEnemyRed().enemyTick();
        }
    }

    private void render()  {

        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(0, 0, PacmanAppRunner.WIDTH, PacmanAppRunner.HEIGHT);
        gameInit.getBackground().render(g);
        gameInit.getLevel().render(g);
        gameInit.getPlayer().repaint(g);
        gameInit.getEnemyBlue().paintEnemyBlue(g);
        gameInit.getEnemyRed().paintEnemyRed(g);
        gameInit.getEnemyGreen().paintEnemyGreen(g);
        gameInit.getEnemyPurple().paintEnemyPurple(g);
        GameInit.getScore().paint(g);
        GameInit.getPlayerLives().paintComponent(g);

        if (gameInit.getLevel().listOfDots().size() <1) {
            gameInit.getWinner().paint(g);
            gameInit.setPause(true);
            gameMenu.showMenu();
        }
        if (gameInit.getConstant().isNewRound()) {
            gameInit.getNewRound().paint(g);

        }
        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        requestFocus();
        int fps = 0;
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();

        double delta = 0;
        double ns = 1000000000 / gameInit.getConstant().getTargetTick();


        gameInit.getMusic().playWelocmeSound();

        gameInit.getRanking().readRanking();

        while (isRunning) {


            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {



                playMusic();
                ifPlayerIsDeadShowEndMenu();
                ifThereAreNoMoreDotsThenPlayMusicWinner();
                    render();
                    thick();


                fps++;
                delta--;
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println(fps);
                fps = 0;
                timer += 1000;
            }
        }
        stop();
    }

    private void ifPlayerIsDeadShowEndMenu() {
        if (PlayerLives.getLives() == 0) {

            deadAnimation.StartTimer();
            deadAnimation.checkIfTimerIsEnd();
            if (deadAnimation.isTimerOFF()) {

                gameInit.getRanking().RankingTop10ToString();
                gameMenu.showMenu();
                gameInit.setPause(true);
            }
        }
    }


    private void ifThereAreNoMoreDotsThenPlayMusicWinner() {

        if (gameInit.getLevel().listOfDots().size() ==0 ) {
           gameInit.getMusic().playWinnerMusic();
        }
    }


    private void playMusic() {

        gameInit.getMusic().getWelcomeMusicTimer().checkIfTimerIsEnd();
              if (gameInit.getMusic().getWelcomeMusicTimer().isTimerOFF() && !gameInit.isPause() && PlayerLives.getLives()>0) {
                gameInit.getMusic().playBackgroundSound();
              }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (Player.isAlive() && !gameInit.isPause()) {
            String right = "RIGHT";
            String left = "LEFT";
            String up = "UP";
            String down = "DOWN";
            pressKey(e, KeyEvent.VK_RIGHT, left, right, up, down);
            pressKey(e, KeyEvent.VK_LEFT, right, left, up, down);
            pressKey(e, KeyEvent.VK_DOWN, up, down, left, right);
            pressKey(e, KeyEvent.VK_UP, down, up, left, right);
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            GameMenu.getPanel().setVisible(!GameMenu.getPanel().isVisible());
            gameInit.setPause(!gameInit.isPause());
            gameInit.getPlayer().setMainDirection(stop);
            gameInit.getPlayer().setNextDirection(stop);
        }

    }

    private void pressKey(KeyEvent e, int vkCode, String oppositeToVKCodeDirection, String vkDirection, String RotationDirectionBy90Degree, String oppositeRotatedDirection) {
        if (e.getKeyCode() == vkCode) {

            if (gameInit.getPlayer().getMainDirection().equals(oppositeToVKCodeDirection) || gameInit.getPlayer().getMainDirection().equals(stop)) {
                gameInit.getPlayer().setMainDirection(vkDirection);
                gameInit.getPlayer().setNextDirection(stop);

            } else if (gameInit.getPlayer().getMainDirection().equals(RotationDirectionBy90Degree) || gameInit.getPlayer().getMainDirection().equals(oppositeRotatedDirection)) {
                gameInit.getPlayer().setNextDirection(vkDirection);

            }

        }
    }




}