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
    private Thread thread;
    private TimerTaskPaccman deadAnimation = new TimerTaskPaccman(3000);

    private PacmanAppRunner() {
        Dimension dimension = new Dimension(GameInit.WIDTH, GameInit.HEIGHT);
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
        frame.setTitle(GameInit.getTITLE());
        frame.setUndecorated(true);
        frame.add(game);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.start();

    }

    public static GameMenu getGameMenu() {
        return gameMenu;
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

            GameInit.getPlayer().tick();



        if (GameInit.getPlayer().isHitByEnemy()) {
            gameInit.sendEnemyToHome();
            GameInit.isNewRound = true;

        }
        if (!GameInit.isPause()) {
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
        GameInit.getPlayer().repaint(g);
        gameInit.getEnemyBlue().paintEnemyBlue(g);
        gameInit.getEnemyRed().paintEnemyRed(g);
        gameInit.getEnemyGreen().paintEnemyGreen(g);
        gameInit.getEnemyPurple().paintEnemyPurple(g);
        GameInit.getScore().paint(g);
        GameInit.getPlayerLives().paintComponent(g);


        if (GameInit.isNewRound) {
            GameInit.getNewRound().paint(g);
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
        double ns = 1000000000 / gameInit.getTargetTick();

        gameInit.getMusic().playWelocmeSound();
        gameInit.getWelcomeTimerMusic().StartTimer();
        gameInit.getRanking().readRanking();

        while (isRunning) {


            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {



                playMusic();
                ifPlayerIsDeadShowEndMenu();

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
            if (deadAnimation.isTimerON()) {

                if (!Player.isAddedToRanking()) {
                    gameInit.getRanking().addToRanking(Player.getUserName());
                    gameInit.getRanking().saveRanking();
                    Player.setAddedToRanking(true);
                }


                gameInit.getRanking().printRankingTop10();
                gameMenu.showMenu();
                GameInit.setPause(true);

            }

        }
    }

    private void playMusic() {
        gameInit.getWelcomeTimerMusic().checkIfTimerIsEnd();
        if (gameInit.getWelcomeTimerMusic().isTimerON()) {
            if (gameInit.getTimerMusic().isTimerON()) {
                gameInit.getTimerMusic().StartTimer();
                if (!GameInit.isPause()) {
                    if (PlayerLives.getLives()>0) {
                        gameInit.getMusic().playBackgroundSound();
                    }

                }

            }
            gameInit.getTimerMusic().checkIfTimerIsEnd();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (Player.isAlive() && !GameInit.isPause()) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                if (GameInit.getPlayer().getMainDirection().equals("LEFT") || GameInit.getPlayer().getMainDirection().equals("STOP")) {
                    GameInit.getPlayer().setMainDirection("RIGHT");
                    GameInit.getPlayer().setNextDirection("STOP");

                } else if (GameInit.getPlayer().getMainDirection().equals("UP") || GameInit.getPlayer().getMainDirection().equals("DOWN")) {
                    GameInit.getPlayer().setNextDirection("RIGHT");

                }

            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (GameInit.getPlayer().getMainDirection().equals("RIGHT") || GameInit.getPlayer().getMainDirection().equals("STOP")) {
                    GameInit.getPlayer().setMainDirection("LEFT");
                    GameInit.getPlayer().setNextDirection("STOP");
                } else if (GameInit.getPlayer().getMainDirection().equals("UP") || GameInit.getPlayer().getMainDirection().equals("DOWN")) {
                    GameInit.getPlayer().setNextDirection("LEFT");

                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (GameInit.getPlayer().getMainDirection().equals("UP") || GameInit.getPlayer().getMainDirection().equals("STOP")) {
                    GameInit.getPlayer().setMainDirection("DOWN");
                    GameInit.getPlayer().setNextDirection("STOP");

                } else if (GameInit.getPlayer().getMainDirection().equals("LEFT") || GameInit.getPlayer().getMainDirection().equals("RIGHT")) {

                    GameInit.getPlayer().setNextDirection("DOWN");
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (GameInit.getPlayer().getMainDirection().equals("DOWN") || GameInit.getPlayer().getMainDirection().equals("STOP")) {
                    GameInit.getPlayer().setMainDirection("UP");
                    GameInit.getPlayer().setNextDirection("STOP");
                } else if (GameInit.getPlayer().getMainDirection().equals("LEFT") || GameInit.getPlayer().getMainDirection().equals("RIGHT")) {
                    GameInit.getPlayer().setNextDirection("UP");
                }
            }
        }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    GameMenu.getPanel().setVisible(!GameMenu.getPanel().isVisible());
                    GameInit.setPause(!GameInit.isPause());
                    GameInit.getPlayer().setMainDirection("STOP");
                    GameInit.getPlayer().setNextDirection("STOP");
            }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}