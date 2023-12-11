package org.example;

public class BalloonPricker implements Runnable {
    @Override
    public void run() {

        //prike ballons from StorageBalloons using the method prickballoon using syncronized and while (true)

        StorageBalloons storage = new StorageBalloons();
        int balloonNumber = 0;

        if (storage.isBalloonInStorage()) {
            while (true) {
                storage.prickBalloon(balloonNumber);
                System.out.println("Priked balloon " + balloonNumber);
                //whait random time above 1 to 10
                try {
                    Thread.sleep((long) (Math.random() * 10 + 1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balloonNumber++;
            }

        }
    }
}

