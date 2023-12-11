package org.example;

public class TakeNumber {

    //A clerk in a bakery serves customers in the order they took their tickets. Customers take tickets in a random order.
    //
    //The program must simulate that 100 clients want to be served by the clerk. When the clerk finishes serving the clients, the simulation must end.
    //
    //The clerk takes a random time of no more than 1000ms to serve a customer.
    //
    //Each client waits a random time between 20000 and 40000 milliseconds to take a number after entering the bakery.
    //
    //You have to use four classes in this project: Bakery (main), TakeANumber (shared resource), Clerk and Customer.



    //implement the class to take a number

    //Create a method to take a number
    public synchronized void takeNumber() {
        System.out.println("Customer is entering the bakery");
        try {
            Thread.sleep((long) (Math.random() * 2000 + 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Customer has taken a number");
    }

    //Create a method to serve the client
    public synchronized void serveClient() {
        System.out.println("Clerk is serving the client");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Clerk has served the client");
    }



}
