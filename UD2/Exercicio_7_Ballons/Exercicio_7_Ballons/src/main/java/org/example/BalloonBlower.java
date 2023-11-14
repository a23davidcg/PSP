package org.example;

import java.util.Map;

public class BalloonBlower extends Thread {
    private Balloons balloonStorage;
    private int bbNumber;

    public BalloonBlower(Balloons balloonStorage, int bbNumber){
        this.balloonStorage = balloonStorage;
        this.bbNumber = bbNumber;
    }

    public void run(){
        while (true) {
            Map.Entry<Integer, Integer> balloonEntry = balloonStorage.getBalloon();
            if (balloonEntry != null) {
                blowBalloon(balloonEntry.getKey(), balloonEntry.getValue());
            }
        }
    }
    private void blowBalloon(int balloonNumber, int volume) {
        while (volume <= 5) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            volume++;
            System.out.println("Balloon " + balloonNumber + " gets volume " + volume + ".");

            if (volume == 5) {
                balloonStorage.burstBalloon(balloonNumber);
                Map.Entry<Integer, Integer> balloonEntry = balloonStorage.getBalloon();
                if (balloonEntry != null) {
                    balloonNumber = balloonEntry.getKey();
                    volume = balloonEntry.getValue();
                }
            }
        }
    }
}
