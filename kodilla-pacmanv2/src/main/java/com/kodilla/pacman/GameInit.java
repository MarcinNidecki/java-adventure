package com.kodilla.pacman;

import com.kodilla.pacman.items.Enemy;
import com.kodilla.pacman.items.ItemPictures;
import com.kodilla.pacman.items.Player;
import com.kodilla.pacman.pacmanBoard.Music;
import com.kodilla.pacman.pacmanBoard.TimerTaskPaccman;
import com.kodilla.pacman.pacmanBoard.levelFactory.BackgroundImageLevel1;
import com.kodilla.pacman.pacmanBoard.levelFactory.LevelFactory;
import com.kodilla.pacman.pacmanBoard.levelFactory.Maze;
import com.kodilla.pacman.pacmanBoard.statistic.PlayerLives;
import com.kodilla.pacman.pacmanBoard.statistic.ScoreCounter;

public class GameInit {

    public static final int WIDTH = 1520, HEIGHT = 960, TILE_SIZE = 40, speed = 4;

    private static final String TITLE = "PACMAN v.0.0.1";
    public static boolean bonus;
    public static double targetTick = 45;
    private static boolean isPause;
    private static Player player;
    private static PlayerLives playerLives;
    private static ScoreCounter score;

    private LevelFactory level = new LevelFactory();
    private Enemy enemyBlue, enemyRed, enemyGreen, enemyPurple;
    private ItemPictures itemPicture;
    private BackgroundImageLevel1 background = new BackgroundImageLevel1();
    private Music music;
    private TimerTaskPaccman timerMusic, welcomeTimerMusic;
    private Maze maze;

    public GameInit() {


        itemPicture = new ItemPictures();
        player = new Player(GameInit.TILE_SIZE, GameInit.TILE_SIZE * 10);
        enemyBlue = new Enemy(GameInit.TILE_SIZE * 19, GameInit.TILE_SIZE * 10, false, "BLUE");
        enemyRed = new Enemy(GameInit.TILE_SIZE * 18, GameInit.TILE_SIZE * 10, true, "RED");
        enemyPurple = new Enemy(GameInit.TILE_SIZE * 18, GameInit.TILE_SIZE * 11, true, "PURPLE");
        enemyGreen = new Enemy(GameInit.TILE_SIZE * 19, GameInit.TILE_SIZE * 11, false, "GREEN");
        score = new ScoreCounter();
        timerMusic = new TimerTaskPaccman(716);
        welcomeTimerMusic = new TimerTaskPaccman(4216);
        playerLives = new PlayerLives();
        music = new Music();
        maze = new Maze();

    }

    public static Player getPlayer() {
        return player;
    }

    public static ScoreCounter getScore() {
        return score;
    }

    static String getTITLE() {
        return TITLE;
    }

    public static PlayerLives getPlayerLives() {
        return playerLives;
    }

    public void sendEnemyToHome() {

        enemyRed.setLocation(enemyRed.getStartingLocationX(), enemyRed.getStartingLocationY());
        enemyBlue.setLocation(enemyBlue.getStartingLocationX(), enemyBlue.getStartingLocationY());
        enemyPurple.setLocation(enemyPurple.getStartingLocationX(), enemyPurple.getStartingLocationY());
        enemyGreen.setLocation(enemyGreen.getStartingLocationX(), enemyGreen.getStartingLocationY());
        enemyRed.waitThenGoOutside(5);
        enemyBlue.waitThenGoOutside(5);
        enemyGreen.waitThenGoOutside(5);
        enemyPurple.waitThenGoOutside(5);
        player.setHitByEnemy(false);


    }

    public void resetGame() {
        playerLives.setLives(3);
        player.sendPlayerToStart();
        music.playWelocmeSound();
        welcomeTimerMusic.StartTimer();
        PacmanAppRunner.getGameMenu().getPanel().setVisible(false);
        isPause = false;
        player.setMainDirection("STOP");
        player.setNextDirection("STOP");
        bonus = false;
        enemyRed.setLocation(enemyRed.getStartingLocationX(), enemyRed.getStartingLocationY());
        enemyBlue.setLocation(enemyBlue.getStartingLocationX(), enemyBlue.getStartingLocationY());
        enemyPurple.setLocation(enemyPurple.getStartingLocationX(), enemyPurple.getStartingLocationY());
        enemyGreen.setLocation(enemyGreen.getStartingLocationX(), enemyGreen.getStartingLocationY());
        LevelFactory.closeDoor();
        level = new LevelFactory();
        score.resetScore();

    }

    double getTargetTick() {
        return targetTick;
    }

    boolean isPause() {
        return isPause;
    }

    public void setPause(boolean pause) {
        isPause = pause;
    }

    public boolean isBonus() {
        return bonus;
    }

    LevelFactory getLevel() {
        return level;
    }

    Enemy getEnemyBlue() {
        return enemyBlue;
    }

    Enemy getEnemyRed() {
        return enemyRed;
    }

    Enemy getEnemyGreen() {
        return enemyGreen;
    }

    Enemy getEnemyPurple() {
        return enemyPurple;
    }


    public ItemPictures getItemPicture() {
        return itemPicture;
    }

    BackgroundImageLevel1 getBackground() {
        return background;
    }

    Music getMusic() {
        return music;
    }

    TimerTaskPaccman getTimerMusic() {
        return timerMusic;
    }

    TimerTaskPaccman getWelcomeTimerMusic() {
        return welcomeTimerMusic;
    }

    public Maze getMaze() {
        return maze;
    }
}
