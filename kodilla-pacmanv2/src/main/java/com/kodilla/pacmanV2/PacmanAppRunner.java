package com.kodilla.pacmanV2;

import com.kodilla.pacmanV2.items.Enemy;
import com.kodilla.pacmanV2.items.Player;
import com.kodilla.pacmanV2.pacmanBoard.Music;
import com.kodilla.pacmanV2.pacmanBoard.TimerTaskPaccman;
import com.kodilla.pacmanV2.pacmanBoard.levelFactory.BackgroundLevel1;
import com.kodilla.pacmanV2.pacmanBoard.levelFactory.LevelFactory;
import com.kodilla.pacmanV2.pacmanBoard.levelFactory.Maze;
import com.kodilla.pacmanV2.pacmanBoard.statistic.PlayerLives;
import com.kodilla.pacmanV2.pacmanBoard.statistic.ScoreCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class PacmanAppRunner extends Canvas implements Runnable, KeyListener {


    public static final int WIDTH = 1520, HEIGHT = 960, TILE_SIZE = 40, playerStartingX = PacmanAppRunner.TILE_SIZE, playerStartingY = PacmanAppRunner.TILE_SIZE * 10;
    private static final String TITLE = "PACMAN v.0.0.1";
    public static boolean isRunning = false;
    public static Player player;
    public static ScoreCounter score;
    public static boolean bonus;
    public static PlayerLives playerLives;
    public static LevelFactory level = new LevelFactory();
    private static Enemy enemyGreen, enemyRed, enemyYellow;
    private static BackgroundLevel1 background = new BackgroundLevel1();
    public Music music;
    TimerTaskPaccman timerMusic, welcomeTimerMusic;
    Maze maze;
    private Thread thread;


    public PacmanAppRunner() {

        Dimension dimension = new Dimension(PacmanAppRunner.WIDTH, PacmanAppRunner.HEIGHT);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);
        player = new Player(PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE * 10);
        enemyGreen = new Enemy(PacmanAppRunner.TILE_SIZE * 19, PacmanAppRunner.TILE_SIZE * 10, false);
        enemyRed = new Enemy(PacmanAppRunner.TILE_SIZE * 18, PacmanAppRunner.TILE_SIZE * 10, true);
        score = new ScoreCounter();
        timerMusic = new TimerTaskPaccman(716);
        welcomeTimerMusic = new TimerTaskPaccman(4216);


        playerLives = new PlayerLives();
        music = new Music();
        maze = new Maze();
        addKeyListener(this);


    }

    public static void main(String[] arg) {


        JFrame frame = new JFrame();
        PacmanAppRunner game = new PacmanAppRunner();
        frame.setBounds(0, 0, 1600, 960);
        frame.setTitle(PacmanAppRunner.TITLE);
        frame.setUndecorated(false);
        frame.add(game);
        //frame.setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.start();

    }

    public synchronized void start() {
        if (isRunning) return;
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!isRunning) return;
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void thick() {
        player.tick();
        enemyGreen.EnemyTick();
        enemyRed.EnemyTick();
        maze.tick();
    }

    private void render() {

        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

        g2d.fillRect(0, 0, PacmanAppRunner.WIDTH, PacmanAppRunner.HEIGHT);
        Animation animation = new Animation();
        background.render(g);
        level.render(g);
        player.paintComponent(g);
        enemyGreen.paintComponent(g);
        enemyRed.paintComponentRed(g);
        score.paint(g);
        playerLives.paintComponent(g);

        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        requestFocus();
        int fps = 0;
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double targetTick = 45;
        double delta = 0;
        double ns = 1000000000 / targetTick;

        music.playWelocmeSound();
        welcomeTimerMusic.StartTimer();

        while (isRunning) {


            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {

                welcomeTimerMusic.checkIfTimerIsEnd();
                if (welcomeTimerMusic.isTimerON()) {
                    if (timerMusic.isTimerON()) {
                        timerMusic.StartTimer();
                        music.playBackgroundSound();
                    }
                    timerMusic.checkIfTimerIsEnd();
                }


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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Player.right = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) Player.left = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) Player.down = true;
        if (e.getKeyCode() == KeyEvent.VK_UP) Player.up = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) Player.right = false;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) Player.left = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) Player.down = false;
        if (e.getKeyCode() == KeyEvent.VK_UP) Player.up = false;
    }
}
