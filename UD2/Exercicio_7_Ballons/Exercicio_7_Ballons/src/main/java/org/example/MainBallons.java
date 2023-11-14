package org.example;

public class MainBallons {
    public static void main(String[] args) {
        Balloons balloonStorage = new Balloons();
        BalloonBlower[] balloonBlowers = new BalloonBlower[5];
        BalloonPricker[] balloonPrickers = new BalloonPricker[5];

        for (int i = 0; i < 5; i++) {
            balloonBlowers[i] = new BalloonBlower(balloonStorage, i + 1);
            balloonPrickers[i] = new BalloonPricker(balloonStorage, i + 1);
        }

        for (BalloonBlower blower : balloonBlowers) {
            blower.start();
        }

        for (BalloonPricker pricker : balloonPrickers) {
            pricker.start();
        }

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balloonStorage.addBalloon(i);
        }
    }
}
