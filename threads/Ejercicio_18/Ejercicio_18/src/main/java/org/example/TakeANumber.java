package org.example;

public class TakeANumber {
    //(Shared Resource)
    int number = 0;

    public TakeANumber() {
        number++;
    }

    //metodo para coger numeros esperando entre 2000 y 4000ms
    public void takeANumber() {
        try {
            Thread.sleep((int) (Math.random() * 2000 + 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //metodo para atender clientes cada 1000ms
    public void serveCustomer() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
