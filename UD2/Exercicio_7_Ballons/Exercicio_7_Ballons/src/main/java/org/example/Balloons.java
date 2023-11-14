package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Balloons {
    private Map<Integer, Integer> balloons = new HashMap<>();
    private int maxBallons = 10;

    private Lock balloonLock = new ReentrantLock();

    public void addBalloon(int balloonNumber) {
        balloonLock.lock();

        try {
            if (balloons.size() < maxBallons) {
                balloons.put(balloonNumber, 0);
                System.out.println("Balloon" + balloonNumber + " colleuse");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Map.Entry<Integer, Integer> getBalloon() {
        balloonLock.lock();
        try {
            if (!balloons.isEmpty()) {
                Map.Entry<Integer, Integer> entry = balloons.entrySet().iterator().next();
                int balloonNumber = entry.getKey();
                int volume = entry.getValue();
                balloons.remove(balloonNumber);
                System.out.println("Balloon" + balloonNumber);
                return Map.entry(balloonNumber, volume);
            } else {
                return null;
            }
        } finally {
            balloonLock.unlock();
        }
    }

    public void burstBalloon(int balloonNumber) {
        balloonLock.lock();
        try {
            if (balloons.containsKey(balloonNumber)) {
                balloons.remove(balloonNumber);
                System.out.println("Balloon " + balloonNumber + " bursts.");
            }
        } finally {
            balloonLock.unlock();
        }
    }

}
