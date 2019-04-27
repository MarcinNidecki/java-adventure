package com.kodilla.pacman.pacmanBoard;

import com.kodilla.pacman.GameInit;

public class BonusMode {

    private final int bonusTime = 10000;
    private TimerTaskPaccman timer = new TimerTaskPaccman(bonusTime);

    public void startBonus() {

        GameInit.bonus = true;
        timer.StartTimer();
    }


    public void checkIfBonusIsOn() {

        timer.checkIfTimerIsEnd();
        if (timer.isTimerON()) {
            GameInit.bonus = false;
        }
    }
}
