package Exercicio2_Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadMain {

    //We want to create a multithreading application.
    //
    //The main thread must generate a random number (use java.util.Random) between 0 and 100. That main thread must create ten threads whose job is to guess the number generated by the main thread.
    //
    //To perform their tasks all threads must share an object of the HiddenNumber class. The HiddenNumber class must have a method int numberGuess(int num) that has to return the following values:
    //
    //-1 if the game is over because one thread has guessed the number
    //1 if the proposed number (num) is the hidden number
    //0 otherwise
    //Follow the given specifications to create the application.
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        int numero = random.nextInt(0, 101);

        HiddenNumber hiddenNumber = new HiddenNumber(numero);

        List<Thread> listaThreads = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new RandomNumberGuesser(hiddenNumber);
            thread.start();
            listaThreads.add(thread);
        }
        for (Thread thread : listaThreads) {
            thread.join();
        }


        System.out.println("The hidden number is: " + hiddenNumber.numberGuess(0));

        Thread[] guesserThreads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            guesserThreads[i] = new RandomNumberGuesser(hiddenNumber);
            guesserThreads[i].start();
        }

        try {
            for (Thread thread : guesserThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
