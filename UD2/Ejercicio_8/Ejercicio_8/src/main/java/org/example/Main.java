package org.example;

public class Main {
    public static void main(String[] args) {

        //create a program to simulate 100 thread clients and use methods from the class takenumber

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Customer());
            thread.start();
        }

        //serve the clientes by the clerk

        Thread clerk = new Thread(new Clerk());
        clerk.start();

        //when all the clients are served, the program end

        try {
            clerk.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All clients are served");






    }
}