package com.kodilla.pacmanv2;

import com.kodilla.pacmanv2.items.Enemy;
import com.kodilla.pacmanv2.items.ItemPictures;
import com.kodilla.pacmanv2.items.Player;
import com.kodilla.pacmanv2.pacmanBoard.Music;
import com.kodilla.pacmanv2.pacmanBoard.TimerTaskPaccman;
import com.kodilla.pacmanv2.items.BackgroundImageLevel1;
import com.kodilla.pacmanv2.pacmanBoard.levelFactory.LevelFactory;
import com.kodilla.pacmanv2.pacmanBoard.levelFactory.Maze;
import com.kodilla.pacmanv2.pacmanBoard.menu.GameMenu;
import com.kodilla.pacmanv2.pacmanBoard.menu.NewRound;
import com.kodilla.pacmanv2.pacmanBoard.menu.RankingMenu;
import com.kodilla.pacmanv2.pacmanBoard.menu.Winner;
import com.kodilla.pacmanv2.pacmanBoard.statistic.PlayerLives;
import com.kodilla.pacmanv2.pacmanBoard.statistic.Ranking;
import com.kodilla.pacmanv2.pacmanBoard.statistic.ScoreCounter;

public class GameInit {

    public static boolean bonus, isNewRound = false;

    private boolean isPause;
    private Player player;
    private Winner winner;
    private static PlayerLives playerLives;
    private static ScoreCounter score;
    private NewRound newRound;
    private LevelFactory level = new LevelFactory();
    private Enemy enemyBlue, enemyRed, enemyGreen, enemyPurple;
    private BackgroundImageLevel1 background = new BackgroundImageLevel1();
    private Music music;
    private TimerTaskPaccman timerMusic, welcomeTimerMusic;



    private Constant constant = new Constant();

    private Ranking ranking = new Ranking();

    public GameInit() {


        ItemPictures itemPicture = new ItemPictures();
        player = new Player(constant.getTILE_SIZE(), constant.getTILE_SIZE() * 10,this);
        enemyBlue = new Enemy(constant.getTILE_SIZE() * 19, constant.getTILE_SIZE() * 10, false, "BLUE");
        enemyRed = new Enemy(constant.getTILE_SIZE() * 18, constant.getTILE_SIZE() * 10, true, "RED");
        enemyPurple = new Enemy(constant.getTILE_SIZE() * 18, constant.getTILE_SIZE() * 11, true, "PURPLE");
        enemyGreen = new Enemy(constant.getTILE_SIZE() * 19, constant.getTILE_SIZE() * 11, false, "GREEN");
        score = new ScoreCounter();
        timerMusic = new TimerTaskPaccman(413);
        welcomeTimerMusic = new TimerTaskPaccman(4216);
        playerLives = new PlayerLives();
        music = new Music();
        Maze maze = new Maze();
        newRound = new NewRound(this);
        winner = new Winner();

    }

    void sendEnemyToHome() {

        sendEnemyToStartingLocation();
        enemyBlue.setTick(0);
        enemyGreen.setTick(0);
        enemyPurple.setTick(0);
        enemyRed.setTick(0);
        enemyRed.waitThenGoOutside(3);
        enemyBlue.waitThenGoOutside(3);
        enemyGreen.waitThenGoOutside(3);
        enemyPurple.waitThenGoOutside(3);
        player.setHitByEnemy(false);


    }

    private void sendEnemyToStartingLocation() {
        enemyRed.setLocation(enemyRed.getStartingLocationX(), enemyRed.getStartingLocationY());
        enemyBlue.setLocation(enemyBlue.getStartingLocationX(), enemyBlue.getStartingLocationY());
        enemyPurple.setLocation(enemyPurple.getStartingLocationX(), enemyPurple.getStartingLocationY());
        enemyGreen.setLocation(enemyGreen.getStartingLocationX(), enemyGreen.getStartingLocationY());
    }

    public void resetGame() {
        playerLives.setLives(3);
        player.sendPlayerToStart();
        music.playWelocmeSound();
        Player.setAddedToRanking(false);
        welcomeTimerMusic.StartTimer();
        GameMenu.getPanel().setVisible(false);
        RankingMenu.getPanel().setVisible(false);
        isPause = false;
        player.setMainDirection("STOP");
        player.setNextDirection("STOP");
        bonus = false;
        sendEnemyToStartingLocation();
        LevelFactory.closeDoor();
        level = new LevelFactory();
        score.resetScore();

    }
    Ranking getRanking() {
        return ranking;
    }

    boolean  isPause() {
        return isPause;
    }

    public void setPause(boolean pause) {
        isPause = pause;
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

    BackgroundImageLevel1 getBackground() {
        return background;
    }

    Music getMusic() {
        return music;
    }


    public Player getPlayer() {
        return player;
    }

    public static ScoreCounter getScore() {
        return score;
    }


    public static PlayerLives getPlayerLives() {
        return playerLives;
    }

    NewRound getNewRound() {
        return newRound;
    }

    public Winner getWinner() {
        return winner;
    }

    public Constant getConstant() {
        return constant;
    }
}
