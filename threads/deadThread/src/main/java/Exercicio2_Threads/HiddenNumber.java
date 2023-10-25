package Exercicio2_Threads;

import java.util.concurrent.atomic.AtomicBoolean;

public class HiddenNumber{ //SOLO SON FIOS AQUELAS CLASES QUE ESTEN DESTINADAS A AEJECUTAR UN CODIGO EN PARALELO
    private int hiddenNumber;

    private AtomicBoolean gameEnded;

    public HiddenNumber(int number) {
        this.hiddenNumber = number;
        this.gameEnded= new AtomicBoolean(false); //Evitar condicions de carrer
    }


    public int numberGuess (int num){

        if (gameEnded.get()) {
            return -1; // Game is already over
        }
        if (num == hiddenNumber) {
            gameEnded.set(true);
            return 1; // Guessed correctly
        }
        return 0; // Guess is incorrect
    }
}

























//import java.util.Random;
//
//class HiddenNumber {
//    private int hiddenNumber;
//    private volatile boolean gameEnded = false;
//
//    public HiddenNumber() {
//        Random random = new Random();
//        hiddenNumber = random.nextInt(101); // Generate a random number between 0 and 100
//    }
//
//    public int numberGuess(int num) {
//        if (gameEnded) {
//            return -1; // Game is already over
//        }
//
//        if (num == hiddenNumber) {
//            gameEnded = true;
//            return 1; // Guessed correctly
//        }
//
//        return 0; // Guess is incorrect
//    }
//}
//
//class GuesserThread extends Thread {
//    private HiddenNumber hiddenNumber;
//
//    public GuesserThread(HiddenNumber hiddenNumber) {
//        this.hiddenNumber = hiddenNumber;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            int guess = new Random().nextInt(101);
//            int result = hiddenNumber.numberGuess(guess);
//            if (result == 1) {
//                System.out.println("Thread " + Thread.currentThread().getId() + " guessed the number: " + guess);
//                break;
//            }
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        HiddenNumber hiddenNumber = new HiddenNumber();
//
//        System.out.println("The hidden number is: " + hiddenNumber.numberGuess(0));
//
//        Thread[] guesserThreads = new Thread[10];
//        for (int i = 0; i < 10; i++) {
//            guesserThreads[i] = new GuesserThread(hiddenNumber);
//            guesserThreads[i].start();
//        }
//
//        try {
//            for (Thread thread : guesserThreads) {
//                thread.join();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
