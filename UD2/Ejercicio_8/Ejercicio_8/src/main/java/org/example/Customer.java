package org.example;

public class Customer implements Runnable{
    @Override
    public void run() {
        //create a run to wait time above 2000 and 4000 miliseconds to toke a number after entering the bajery
        System.out.println("Customer is entering the bakery");
        try {
            Thread.sleep((long) (Math.random() * 2000 + 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Customer has taken a number");


    }
}
