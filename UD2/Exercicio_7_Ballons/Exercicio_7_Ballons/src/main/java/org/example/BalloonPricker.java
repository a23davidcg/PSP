package org.example;

import java.util.Map;
import java.util.Random;

public class BalloonPricker extends Thread {
    private Balloons balloonStorage;
    private int bpNumber;
    private Random random = new Random();

    public BalloonPricker(Balloons balloonStorage, int bpNumber) {
        this.balloonStorage = balloonStorage;
        this.bpNumber = bpNumber;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(10000) + 1000); // Random time between 1 and 10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map.Entry<Integer, Integer> balloonEntry = balloonStorage.getBalloon();
            if (balloonEntry != null) {
                int balloonNumber = balloonEntry.getKey();
                System.out.println("Balloon " + balloonNumber + " pricked by BP" + bpNumber + ".");
            }
        }
    }
}
