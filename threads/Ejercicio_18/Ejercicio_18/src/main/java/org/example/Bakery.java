package org.example;



public class Bakery {


    //mototo que lea por consola
    public static void main(String[] args) {

        //iniciar los threads de clerk y customer
        Clerk clerk = new Clerk();
        Customer customer = new Customer();

        //iniciar los threads
        Thread threadClerk = new Thread(clerk);
        Thread threadCustomer = new Thread(customer);

        //iniciar los threads
        threadClerk.start();
        threadCustomer.start();

        //esperar a que terminen los threads
        try {
            threadClerk.join();
            threadCustomer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //mostrar mensaje de finalizacion
        System.out.println("Finalizado");






    }
}