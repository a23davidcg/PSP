package org.example;

import java.util.Random;

class Thread extends java.lang.Thread {

    public void run() {
        System.out.println("Welcome from thread: " + Thread.currentThread().getName());

        for (int i = 0; i < 5; i++) {
            int randomMillis = new Random().nextInt(491) + 10; // Random number between 10 and 500
            try {
                Thread.sleep(randomMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Goodbye from thread: " + Thread.currentThread().getName());
    }
}
