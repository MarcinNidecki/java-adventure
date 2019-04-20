package com.kodilla.pacmanV2.pacmanBoard;

public class TimerTaskPaccman {

    private double timer;
    private boolean timerON = false;
    private boolean timerStarted = false;

    public boolean isTimerON() {
        return timerON;
    }

    public boolean isTimerStarted() {
        return timerStarted;
    }

    private int time;



    public TimerTaskPaccman (int time) {
        this.time = time;
    }


    public  void StartTimer() {
        // POWER ON
        if (!timerON) {
            timerON=true;
        }

        // set current time to timer  and mark timerStarted TRUE
        if(!timerStarted){
            timer =System.currentTimeMillis();
            timerStarted = true;
        }
    }

    public  void checkIfTimerIsEnd() {
        if (System.currentTimeMillis() - timer >= time) {
             timerON = false;
             timerStarted =false;

       }
    }
}
