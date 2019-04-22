package com.kodilla.pacmanV2.pacmanBoard;

import com.kodilla.pacmanV2.PacmanAppRunner;

public class BonusMode {

    private final int bonusTime = 10000;
    private TimerTaskPaccman timer = new TimerTaskPaccman(bonusTime);


    public void startBonus() {

        PacmanAppRunner.bonus = true;
        timer.StartTimer();
    }


    public void checkIfBonusIsOn() {

        timer.checkIfTimerIsEnd();

        if (timer.isTimerON()) {
            PacmanAppRunner.bonus = false;
        }


    }
}
