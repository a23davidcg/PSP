package org.example;

public class Main {
    public static void main(String[] args) {

        //launch both threads to blow and prick ballons at same time

        Thread t1 = new Thread(new BalloonBlower());
        Thread t2 = new Thread(new BalloonPricker());

        t1.start();
        t2.start();





    }
}