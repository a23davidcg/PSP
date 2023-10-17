package org.example;

public class MultiplicarPor2 implements Runnable {

    private int num;

    public MultiplicarPor2(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(this.num * 2);
    }
}
