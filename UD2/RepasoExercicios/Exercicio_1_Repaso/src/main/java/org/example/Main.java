package org.example;

public class Main {
    public static void main(String[] args)  {

        Thread th1 = new Thread();
        Thread th2 = new Thread();

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("acabouse o thread");





    }
}