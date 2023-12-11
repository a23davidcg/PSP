package org.example;

public class Clerk implements Runnable {

    //create a program that takes random time to serve the  clients

    public void run() {
        System.out.println("Clerk is serving the client");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Clerk has served the client");


    }
}


