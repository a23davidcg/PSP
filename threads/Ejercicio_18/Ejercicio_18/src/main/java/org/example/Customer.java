package org.example;

public class Customer implements Runnable {

    //metodo para que coja un numero  esperando entre 2000 y 4000ms
    @Override
    public void run() {
        //metodo para que coja un numero  esperando entre 2000 y 4000ms
        try {
            Thread.sleep((int) (Math.random() * 2000 + 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
