package org.example;
public class Clerk {

    //metodo para servir un customer cada 1000ms
    public void serveCustomer() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
