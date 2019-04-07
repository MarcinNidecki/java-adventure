package com.kodilla.pacmanV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class PacmanAppRunner extends Canvas implements Runnable,KeyListener {



    private boolean isRunning = false;
    public static final int WIDTH = 800, HEIGHT =800, TILE_SIZE =40;
    public static final String TITLE = "PACMAN v.0.0.1";

    private  Thread thread;

    public static  Player player;
    public static Level level;
    public static TextureGrid textureGrid;

    public PacmanAppRunner() {
        Dimension dimension = new Dimension(PacmanAppRunner.WIDTH,PacmanAppRunner.HEIGHT);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);
        addKeyListener(this);
        player = new Player(PacmanAppRunner.WIDTH/2,PacmanAppRunner.HEIGHT/2);
        level = new Level("kodilla-pacmanv2\\src\\main\\resources\\assets\\text\\pacman_level.txt");
        textureGrid = new TextureGrid("kodilla-pacmanv2\\src\\main\\resources\\assets\\textures\\grid.png");


    }

    public  synchronized  void start(){
        if(isRunning) return;
        isRunning = true;
        thread = new Thread(this);
        thread.start();

    }

    public  synchronized void stop() {
        if(!isRunning) return;
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void thick() {
        player.tick();


    }
    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);

        g2d.fillRect(0,0,PacmanAppRunner.WIDTH,PacmanAppRunner.HEIGHT);

        g2d.setColor(Color.YELLOW);

        player.paintComponent(g);
        level.render(g);
        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        requestFocus();
        int fps = 0;
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double targetTick = 60.0;
        double delta =0;
        double ns = 1000000000/targetTick;

        while (isRunning) {
            long now = System.nanoTime();
            delta+=(now- lastTime)/ns;
            lastTime = now;

            while (delta>=1) {
                thick();
                render();
                fps++;
                delta--;
            }
            if(System.currentTimeMillis() - timer >= 1000){
                System.out.println(fps);
                fps = 0;
                timer+=1000;
            }
        }
        stop();
    }

    public static void main(String[] arg) {

        PacmanAppRunner game = new PacmanAppRunner();
        JFrame frame = new JFrame();
        frame.setTitle(PacmanAppRunner.TITLE);
        frame.add(game);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        game.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) player.right = true;
        if(e.getKeyCode() == KeyEvent.VK_LEFT) player.left = true;
        if(e.getKeyCode() == KeyEvent.VK_DOWN) player.down = true;
        if(e.getKeyCode() == KeyEvent.VK_UP) player.up = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) player.right = false;
        if(e.getKeyCode() == KeyEvent.VK_LEFT) player.left = false;
        if(e.getKeyCode() == KeyEvent.VK_DOWN) player.down = false;
        if(e.getKeyCode() == KeyEvent.VK_UP) player.up = false;
    }
}
