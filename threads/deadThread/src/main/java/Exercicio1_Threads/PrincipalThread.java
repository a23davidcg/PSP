package Exercicio1_Threads;

//Create a Java class that implements the Runnable interface.
//
//The run() method of the class must do the following:
//
//Display a welcome message with the name of the current thread.
//Repeat five times:
//Get a random number between 10 and 500 (use java.util.Random).
//Pause the execution of the current thread for the number of miliseconds equal to the random number obtained above.
//Display a goodbye message with the name of the current thread.
//Create a Java executable class to launch two threads created using the previous class.
// Thie main thread waits for the other two threads to finish and then displays a message indicating that it has finished.

import java.util.Random;

public class PrincipalThread {
    public static void main(String[] args) throws InterruptedException {
        Thread fillo1 = new RandomNumbersThread("Fillo 1");
        Thread fillo2 = new RandomNumbersThread("Fillo 2");

        fillo1.start();
        fillo2.start();
        fillo1.join();
        fillo2.join();
        System.out.println("Xa se acabou o programa");










    }

}
