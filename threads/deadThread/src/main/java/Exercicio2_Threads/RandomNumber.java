package Exercicio2_Threads;

import java.util.Random;

public class RandomNumber extends Thread {
    private HiddenNumber hiddenNumber;

    public RandomNumber(HiddenNumber hiddenNumber) {
        this.hiddenNumber = hiddenNumber;

    }


    public void run() {
        while (true) {
            int guess = new Random().nextInt(101);
            int result = this.hiddenNumber.numberGuess(guess);
            if (result == 1) {
                System.out.println("Thread " + Thread.currentThread().getId() + " guessed the number: " + guess);
                break;
            }


        }
    }
}

