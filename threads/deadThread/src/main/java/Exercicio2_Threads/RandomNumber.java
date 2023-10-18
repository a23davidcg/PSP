package Exercicio2_Threads;

import java.util.Random;

public class RandomNumber extends Thread {
    public void run() {
        while (true) {
            int guess = new Random().nextInt(101);
            int result = hiddenNumber.ThreadMain(guess);
            if (result == 1) {
                System.out.println("Thread " + Thread.currentThread().getId() + " guessed the number: " + guess);
                break;
            }


        }
    }
}

